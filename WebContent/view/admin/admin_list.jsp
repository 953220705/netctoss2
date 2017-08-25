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
            //显示角色详细信息
            function showDetail(flag, a) {
                var detailDiv = a.parentNode.getElementsByTagName("div")[0];
                if (flag) {
                    detailDiv.style.display = "block";
                }
                else
                    detailDiv.style.display = "none";
            }
            //重置密码
            $(function(){
            	$("#rebtn").click(function(){
            		$.post({
            			url:"${pageContext.request.contextPath }/admin/ResetAdminPswAction.do",
            			data:$("#reform").serialize(),
            			success:function(data){
            				var flag = eval(data)
            				if(flag){
            					showReResultDiv(true);
                           		window.setTimeout("showResultDiv(false);", 3000);
            				}
            			}
            		})
            	})
            })
            //删除
            function deleteAdmin(id) {
                var r = window.confirm("确定要删除此管理员吗？");
                if(r==true){
                	$.post({
                		url:"${pageContext.request.contextPath }/admin/DelAdminAction.do?adminID="+id,
                		success:function(data){
                			var flag = eval(data);
                			showResult(flag);
                			if(flag){
                				$("#"+id+"del").hide();
                			}
                		}
                	})
                }
            }
            function showResult(flag) {
            	//var updateFlag=${requestScope.delflag};
	            if(flag==true){
          			showResultDiv(true);
               		window.setTimeout("showResultDiv(false);", 3000);
	            }else{
	            	showFailDiv(true);
	                window.setTimeout("showFailDiv(false);", 3000);
	            }
            }
            function showResultDiv(flag) {
                var divResult = $("#operate_result_info");
                if (flag)
                    divResult.show();
                else
                    divResult.hide();
            }
            function showFailDiv(flag) {
                var divResult = $("#operate_fail_info");
                if (flag)
                    divResult.show();
                else
                    divResult.hide();
            }
            function showReResultDiv(flag) {
                var divResult = $("#operate_reresult_info");
                if (flag)
                    divResult.show();
                else
                    divResult.hide();
            }
            //全选
            function selectAdmins(inputObj) {
                var inputArray = document.getElementById("datalist").getElementsByTagName("input");
                for (var i = 1; i < inputArray.length; i++) {
                    if (inputArray[i].type == "checkbox") {
                        inputArray[i].checked = inputObj.checked;
                    }
                }
            }
        </script>       
    </head>
    <body>
        <%@include file="../include/listinclude.jsp" %>
        <!--主要区域开始-->
        <div id="main">
            <form action="${pageContext.request.contextPath }/admin/SelAdminAction.do" method="post">
                <!--查询-->
                
                <div class="search_add">
                    <div>
                        模块：
                        <select name="perID" id="selModules" class="select_search">
                            <option value="0">全部</option>
                        <c:forEach items="${sessionScope.allPer }" var="per">
                        	 <option value="${per.perID }">${per.perName}</option>
                        </c:forEach>
                        </select>
                    </div>
                    <div>角色：<input type="text" class="text_search width200" name="roleName" /></div>
                    <div><input type="submit" value="搜索" class="btn_search"  /></div>
             </form>
              <form id="reform" >
                    <input id="rebtn" type="button" value="密码重置" class="btn_add"/>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/view/admin/admin_add.jsp';" />
                </div>
                <!--删除和密码重置的操作提示-->
                <div id="operate_reresult_info" class="operate_success" style="width: 400px;
    line-height: 70px;
    padding-left: 40px;
    font-size: 16px;
    display: none;
    position: absolute;
    z-index: 100;
    top: 90px;
    left: 30%;">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    <span>重置成功！</span><!--密码重置失败！数据并发错误。-->
                </div>
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    <span>删除成功！</span><!--密码重置失败！数据并发错误。-->
                </div> 
                <div id="operate_fail_info" class="operate_fail">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    <span>删除失败！数据并发错误。</span><!--密码重置失败！数据并发错误。-->
                </div>
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th class="th_select_all">
                                <input type="checkbox" onclick="selectAdmins(this);" />
                                <span>全选</span>
                            </th>
                            <th>管理员ID</th>
                            <th>姓名</th>
                            <th>登录名</th>
                            <th>电话</th>
                            <th>电子邮件</th>
                            <th>授权日期</th>
                            <th class="width100">拥有角色</th>
                            <th></th>
                        </tr>
                           
                        <c:forEach items="${adminList }" var="admin">                  
	                        <tr id="${admin.adminID }del"+>
	                            <td><input type="checkbox" name="reAdminID" value="${admin.adminID }" /></td>
	                            <td>${admin.adminID }</td>
	                            <td>${admin.adminName }</td>
	                            <td>${admin.adminLog }</td>
	                            <td>${admin.adminPhone }</td>
	                            <td>${admin.adminEmail }</td>
	                            <td><fmt:formatDate value="${admin.powerTime }" pattern="yyyy-MM-dd "/></td>
	                            <td>
	                                <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${admin.oneRole }...</a>
	                                <!--浮动的详细信息-->
	                                <div class="detail_info">
	                                    ${admin.role }
	                                </div>
	                            </td>
	                            <td class="td_modi">
	                                <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath }/admin/ShowAdminInfoAction.do?adminID=${admin.adminID }';" />
	                                <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin(${admin.adminID});" />
	                            </td>
	                        </tr>
	                   	</c:forEach>
	            </form>
                    </table>
                </div>
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                </div>                    
           
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
