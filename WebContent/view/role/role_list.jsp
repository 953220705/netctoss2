<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <%@ include file="../include/linkinclude.jsp" %>
        <script language="javascript" type="text/javascript">
            function deleteRole(roleID) {
                if(window.confirm("确定要删除此角色吗？")==true){
                	$.post({
                		url:"${pageContext.request.contextPath}/role/DelRoleAction.do?rid="+roleID,
                		success:function(data){
                			var flag = eval(data);
                			showResult(flag);
                			if(flag){
                				$("#"+roleID+"del").hide();
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
                var divResult = $("#save_result_info");
                if (flag)
                    divResult.show();
                else
                    divResult.hide();
            }
            function showFailDiv(flag) {
                var divResult = ("#save_fail_info");
                if (flag)
                    divResult.show();
                else
                    divResult.hide();
            }
        </script>
    </head>
    <body>
        <%@include file="../include/listinclude.jsp" %>
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/view/role/role_add.jsp';" />
                </div>  
                <!--删除的操作提示-->
                <div id="save_result_info" class="save_success">删除成功！</div><!--保存失败，数据并发错误！-->
             	<div id="save_fail_info" class="save_fail">删除失败，该角色已被占用！</div><!--保存失败，数据并发错误！-->   	
                <!--数据区域：用表格展示数据-->     
                <div id="data">                      
                    <table id="datalist">
                        <tr>                            
                            <th>角色 ID</th>
                            <th>角色名称</th>
                            <th class="width600">拥有的权限</th>
                            <th class="td_modi"></th>
                        </tr>  
                        <c:forEach items="${content }" var="role">                    
	                        <tr id="${role.roleID }del">
	                            <td>${role.roleID }</td>
	                            <td>${role.roleName }</td>
	                            <td>${role.per }</td> 
	                            <td>
	                                <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/role/UpdateShowAction.do?roleID=${role.roleID}'"/>
	                                <input type="button" value="删除" class="btn_delete" onclick="deleteRole(${role.roleID});" />
	                            </td>
	                        </tr>
                        </c:forEach>
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
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
