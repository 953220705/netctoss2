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
            //保存成功的提示消息
            function showResult(flag) {
	              if(flag){
	            	showResultDiv(true);
		            window.setTimeout("showResultDiv(false);", 3000);
	              } 
            }
            function showResultDiv(flag) {
                var divResult = $("#save_result_info");
                if (flag)
                    divResult.show();
                else
                    divResult.hide();
            }
            function showFailtDiv(flag) {
                var divResult = $("#save_result_info");
                if (flag)
                    divResult.show();
                else
                    divResult.hide();
            }
            $(function(){
            	$("#savebtn").click(function(){
            		$.post({
            			url:"${pageContext.request.contextPath }/role/AddRoleAction.do",
            			data:$("#myform").serialize(),
            			success:function(data){
            				var flag = eval(data);
            				showResult(flag);
            			}
            		});
            	});
            	
            	$("#roleName").blur(function(){
            		$.post({
            			url:"${pageContext.request.contextPath }/role/Validation.do",
            			data:{"roleName":$("#roleName").val()},
            			success:function(data){
            				var nameFlag = eval(data);
            				if(nameFlag==true){
            					showFailDiv(true);
            	                window.setTimeout("showFailDiv(false);", 3000);
            					//showResultDiv(true);
            		           // window.setTimeout("showResultDiv(false);", 3000);
            				}
            			}
            		});
            	});
            })
        </script>
    </head>
    <body onload="showResult()">
        <%@include file="../include/listinclude.jsp" %>
        <!--主要区域开始-->
        <div id="main">            
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，角色名称重复！-->
            <div id="save_result_info" class="save_success">角色名已被占用</div><!--保存失败，角色名称重复！-->
            <form id="myform" class="main_form">
                <div class="text_info clearfix"><span>角色名称：</span></div>
                <div class="input_info">
                    <input id="roleName" type="text" class="width200" name="roleName" />
                    <span class="required">*</span>
                    <div class="validate_msg_medium">不能为空，且为20长度的字母、数字和汉字的组合</div>
                </div>                    
                <div class="text_info clearfix"><span>设置权限：</span></div>
                <div class="input_info_high">
                    <div class="input_info_scroll">
                        <ul>
                            <li><input type="checkbox" name="permission" value="1" />管理员管理</li>
                            <li><input type="checkbox" name="permission" value="2" />角色管理</li>
                            <li><input type="checkbox" name="permission" value="3" />资费管理</li>
                            <li><input type="checkbox" name="permission" value="4" />账务账号</li>
                            <li><input type="checkbox" name="permission" value="5" />业务账号</li>
                            <li><input type="checkbox" name="permission" value="6" />账单</li>
                            <li><input type="checkbox" name="permission" value="7" />报表</li>
                        </ul>
                    </div>
                    <span class="required">*</span>
                    <div class="validate_msg_tiny">至少选择一个权限</div>
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
