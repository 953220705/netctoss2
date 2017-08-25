<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
       	<%@ include file="../include/linkinclude.jsp" %>
      <script type="text/javascript">
            //保存成功的提示信息
           function showResult(updateFlag) {
            	if(updateFlag==true){
	                showResultDiv(true);
	                window.setTimeout("showResultDiv(false);", 3000);
            	}else if(updateFlag==false){
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
            			url:'${pageContext.request.contextPath }/admin/UpdateAdminPswAction.do',
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
    <body >
        <%@ include file="../include/listinclude.jsp" %>
        <div id="main">      
            <!--保存操作后的提示信息：成功或者失败-->      
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，旧密码错误！-->
            <div id="save_fail_info" class="save_fail">保存失败！</div><!--保存失败，旧密码错误！-->           
            <form id="myform" class="main_form">
                <div class="text_info clearfix"><span>旧密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200" name="oldPsw"  /><span class="required">*</span>
                    <div class="validate_msg_medium">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>新密码：</span></div>
                <div class="input_info">
                    <input type="password"  class="width200" name="newPsw" /><span class="required">*</span>
                    <div class="validate_msg_medium">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>重复新密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200" name="rePsw"  /><span class="required">*</span>
                    <div class="validate_msg_medium">两次新密码必须相同</div>
                </div>
                <div class="button_info clearfix">
                    <!-- <input type="submit" value="保存" class="btn_save" /> -->
                    <input id="savebtn" type="button" value="保存" class="btn_save">
                    <input type="reset" value="重置" class="btn_save" />
                </div>
                <input type="hidden" name="adminID" value="${sessionScope.admin.adminID }"   />
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
