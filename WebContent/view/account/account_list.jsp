<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <%@include file="../include/linkinclude.jsp" %> 
        <script language="javascript" type="text/javascript">
            //删除
            function deleteAccount(id) {
                var r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
                if(r==true){
                	$.post({
                		url:'${pageContext.request.contextPath}/accounts/UpdateAccStateAction.do?accid='+id,
                		success:function(data){
                			var flag = eval(data);
                			if(flag){
                				$("#operate_result_info").show();
                				$("#"+id+"td_md").remove();
                			}
                		}
                	})
                }
            }
            //开通或暂停
            function setState(id,st) {
            	var r;
                if(st.className=="btn_pause")
            		r = window.confirm("确定要暂停此账务账号吗？");
                if(st.className=="btn_start")
                	r = window.confirm("确定要开通此账务账号吗？");
                if(r==true){
                	$.post({
                		url:'${pageContext.request.contextPath}/accounts/UpdateAccStateAction.do?accid='+id+"&class="+st.className,
                		success:function(data){
                			var flag= eval(data);
                			if(flag){
                				if(st.className=="btn_pause"){
                					alert("ss");
                					$("#"+id+"state").text("暂停");
                                	st.className="btn_start";
                                	st.value="开通"
                				}else if(st.className=="btn_start"){
                                	$("#"+id+"state").text("开通");
                                	st.className="btn_pause";
                                	st.value="暂停"
                                }
                			}
                		}
                	})
                }
            }
        </script>
    </head>
    <body>
        <%@include file="../include/listinclude.jsp" %>
        <!--主要区域开始-->
        <div id="main">
           
                <!--查询-->
                <div class="search_add">                        
                    <form action="${pageContext.request.contextPath}/accounts/SelAccountsAction.do" method="post">
                    <div>身份证：<input type="text" name="idcard" class="text_search" /></div>                            
                    <div>姓名：<input type="text" class="width70 text_search" name="name" /></div>
                    <div>登录名：<input type="text"  name="log" class="text_search"" /></div>
                    <div>
                        状态：
                        <select class="select_search" name="state">
                            <option value="-1">全部</option>
                            <option value="1">开通</option>
                            <option value="0">暂停</option>
                            <option value="2">删除</option>
                        </select>
                    </div>
                    <div><input type="submit" value="搜索" class="btn_search"  /></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/view/account/account_add.jsp';" />
                    </form>
                </div>  
                <!--删除等的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功，且已删除其下属的业务账号！
                </div>   
                 <form action="" method="">
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th>账号ID</th>
                        <th>姓名</th>
                        <th class="width150">身份证</th>
                        <th>登录名</th>
                        <th>状态</th>
                        <th class="width100">创建日期</th>
                        <th class="width150">上次登录时间</th>                                                        
                        <th class="width200"></th>
                    </tr>
                    <c:forEach items="${lac }" var="acc">
	                    <tr>
	                    	
	                        <td>${acc.acc_id }</td>
	                        <td><a href="${pageContext.request.contextPath }/accounts/ShowAccountsAction.do?accID=${acc.acc_id }&page=s">${acc.acc_name }</a></td>
	                        <td>${acc.acc_idcard }</td>
	                        <td>${acc.acc_log }</td>
	                        <td id="${acc.acc_id }state">${acc.acc_state }</td>
	                        <td><fmt:formatDate value="${acc.acc_cretime }" pattern="yyyy/MM/dd"/></td>
	                        <td><fmt:formatDate value="${acc.acc_lastlogin }" pattern="yyyy/MM/dd HH:mm:ss"/></td>                            
		                    <c:choose>
		                    	<c:when test="${acc.acc_state!='删除'}">
		                        <td id="${acc.acc_id }td_md" class="td_modi">
		                        	<c:choose>
		                        		<c:when test="${acc.acc_state=='暂停' }">
		                            	<input type="button" id="stabtn" value="开通" class="btn_start" onclick="setState(${acc.acc_id},this);" />
		                            	</c:when>
		                            	<c:when test="${acc.acc_state=='开通' }">
		                            	<input type="button" id="stabtn" value="暂停" class="btn_pause" onclick="setState(${acc.acc_id},this);" />
		                            	</c:when>
		                            </c:choose>
		                            <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath }/accounts/ShowAccountsAction.do?accID=${acc.acc_id }&page=u';" />
		                            <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${acc.acc_id })" />
		                        </td>
		                        </c:when>
		                    </c:choose>
	                    </tr>    
	                 </c:forEach>   
                </table>
                <p>业务说明：<br />
                1、创建则开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、暂停账务账号，同时暂停下属的所有业务账号；<br />                
                6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
                7、删除账务账号，同时删除下属的所有业务账号。</p>
                </div>                   
                <!--分页-->
                <div id="pages">
                    <a href="#">首页</a>
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                    <a href="#">末页</a>
                </div>                    
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
        </div>
    </body>
</html>
