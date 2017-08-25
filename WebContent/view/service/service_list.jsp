<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <%@include file="../include/linkinclude.jsp" %> 
        <script language="javascript" type="text/javascript">
            //显示角色详细信息
            function showDetail(flag, a) {
                var detailDiv = a.parentNode.getElementsByTagName("div")[0];
                if (flag) {
                    detailDiv.style.display = "block";
                }
                else
                    detailDiv.style.display = "none";
            }
            //删除
            function deleteAccount(id) {
                var r = window.confirm("确定要删除此业务账号吗？删除后将不能恢复。");
                if(r==true){
                	$.post({
                		url:'${pageContext.request.contextPath}/services/UpdateSerStateAction.do?serid='+id,
                		success:function(data){
                			var flag= eval(data);
                			if(flag){
                				$("#"+id+"state").text("删除");
                   				$("#operate_result_info").show();
                   				$("#"+id+"td_md").remove();
                			}
                		}
                	})
                }
                
            }
            //开通或暂停
            function setState(id,st) {
            	var r = false;
                if(st.className=="btn_pause"){
            		r = window.confirm("确定要暂停此业务账号吗？");
                }
                if(st.className=="btn_start"){
                	r = window.confirm("确定要开通此业务账号吗？");
                }
                if(r==true){
                	$.post({
                		url:'${pageContext.request.contextPath}/services/UpdateSerStateAction.do?serid='+id+"&class="+st.className,
                		success:function(data){
                			var flag= eval(data);
                			if(flag){
                				if(st.className=="btn_pause"){
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
            <form action="${pageContext.request.contextPath}/services/SelSerAction.do" method="post">
                <!--查询-->
                <div class="search_add">                        
                    <div>OS 账号：<input type="text" name="oslog" value="" class="width100 text_search" /></div>                            
                    <div>服务器 IP：<input type="text" name="ip" value="" class="width100 text_search" /></div>
                    <div>身份证：<input type="text" name="idcard" value="" class="text_search" /></div>
                    <div>状态：
                        <select name="state" class="select_search">
                            <option value="-1">全部</option>
                            <option value="1">开通</option>
                            <option value="0">暂停</option>
                            <option value="2">删除</option>
                        </select>
                    </div>
                    <div><input type="submit" value="搜索" class="btn_search" /></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/view/service/service_add.jsp';" />
                </div>  
                </form>
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>   
                <!--数据区域：用表格展示数据--> 
            <form action="" method="">    
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th class="width50">业务ID</th>
                        <th class="width70">账务账号ID</th>
                        <th class="width150">身份证</th>
                        <th class="width70">姓名</th>
                        <th>OS 账号</th>
                        <th class="width50">状态</th>
                        <th class="width100">服务器 IP</th>
                        <th class="width100">资费</th>                                                        
                        <th class="width200"></th>
                    </tr>
                    <c:forEach items="${lser }" var="ser">
	                    <tr>
	                        <td><a href="${pageContext.request.contextPath}/services/ShowSerInfoAction.do?serid=${ser.ser_id}&page=s" title="查看明细">${ser.ser_id}</a></td>
	                        <td>${ser.acc.acc_id }</td>
	                        <td>${ser.acc.acc_idcard }</td>
	                        <td>${ser.acc.acc_name }</td>
	                        <td>${ser.ser_oslog }</td>
	                        <td id="${ser.ser_id}state">${ser.ser_state }</td>
	                        <td>${ser.ser_ip }</td>
	                        <td>
	                            <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${ser.fee.feeName }</a>
	                            <!--浮动的详细信息-->
	                            <div class="detail_info">
	                                ${ser.fee.instructions }
	                            </div>
	                        </td>    
	                        <c:choose> 
	                        	<c:when test="${ser.ser_state!='删除' }">                      
		                        <td id="${ser.ser_id}td_md" class="td_modi">
		                        	<c:choose>
		                        		<c:when test="${ser.ser_state=='开通' }">
		                            	<input type="button" value="暂停" class="btn_pause" onclick="setState(${ser.ser_id},this);" />
		                            	</c:when>
		                            	<c:when test="${ser.ser_state=='暂停' }">
		                            	<input type="button" value="开通" class="btn_start" onclick="setState(${ser.ser_id},this);" />
		                            	</c:when>
		                            </c:choose>
		                            <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath }/services/ShowSerInfoAction.do?serid=${ser.ser_id }&page=u';" />
		                            <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${ser.ser_id});" />
		                        </td>
		                        </c:when>
		                    </c:choose> 
	                    </tr> 
	                 </c:forEach>                                                             
                </table>                
                <p>业务说明：<br />
                1、创建即开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
                6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
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
