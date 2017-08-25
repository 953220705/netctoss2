<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
       	<%@include file="../include/linkinclude.jsp" %>
        <script language="javascript" type="text/javascript">
            //保存成功的提示消息
            function showResult(flag) {
            	//var updateFlag=${requestScope.delflag};
	            if(flag){
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
                var divResult = $("#save_fail_info");
                if (flag)
                    divResult.show();
                else
                    divResult.hide();
            }
            $(function(){
            	$("#savebtn").click(function(){
            		$.post({
            			url:"${pageContext.request.contextPath }/admin/ManageAdminInfoAction.do",
            			data:$("#myform").serialize(),
            			success:function(data){
            				var flag = eval(data);
            				showResult(flag);
            			}
            		})
            	});
            })
        </script>
    </head>
    <body>
       <%@include file="../include/listinclude.jsp" %>
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success">保存成功！</div>
             <div id="save_fail_info" class="save_fail">保存失败！</div>
            <form id="myform" class="main_form">
                    <input type="hidden" name="adminID" value="${adminInfo.adminID }" />
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" name="adminName" value="${adminInfo.adminName }" />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">20长度以内的汉字、字母、数字的组合</div>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info"><input type="text" name="adminLog" readonly="readonly" class="readonly" value="${adminInfo.adminLog }"  /></div>
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" name="adminPhone" value="${adminInfo.adminPhone }"  />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">正确的电话号码格式：手机或固话</div>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" name="adminEmail" class="width200" value="${adminInfo.adminEmail }"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium error_msg">50长度以内，正确的 email 格式</div>
                    </div>
                    <div class="text_info clearfix"><span>角色：</span></div>
                    <div class="input_info_high">
                        <div class="input_info_scroll">
                            <ul>
                            	<c:forEach items="${sessionScope.allRole }" var="allRole">
                            		<c:forEach items="${requestScope.adminInfo.lro }" var="role">
                            		<c:choose>
                            			<c:when test="${allRole.roleID == role.roleID }">
                            			<li><input type="checkbox" name="roleID" value="${allRole.roleID}" checked />${allRole.roleName }</li>
                            			</c:when>
                            			<c:otherwise>
                            			<li><input type="checkbox" name="roleID" value="${allRole.roleID}" />${allRole.roleName }</li>
                            			</c:otherwise>
                            		</c:choose>
                            		</c:forEach>
                            	</c:forEach>
                            </ul>
                        </div>
                        <span class="required">*</span>
                        <div class="validate_msg_tiny error_msg">至少选择一个</div>
                    </div>
                    <div class="button_info clearfix">
                        <input id="savebtn" type="button" value="保存" class="btn_save" />
                        <input type="reset" value="取消" class="btn_save" />
                    </div>
                </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
