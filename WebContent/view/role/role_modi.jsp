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
            	//var updateFlag = ${request.saveflag}
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
                var divResult = $("#save_fail_info");
                if (flag)
                    divResult.show();
                else
                    divResult.hide();
            }
            $(function(){
            	$("#savebtn").click(function(){
            		$.post({
            			url:"${pageContext.request.contextPath }/role/UpdateRoleAction.do",
            			data:$("#myfrom").serialize(),
            			success:function(data){
            				var flag = eval(data);
            				showResult(flag)
            			}
            		})
            	});
            })
            
        </script>
    </head>
    <body>
   	
        <%@ include file="../include/listinclude.jsp" %>
        <!--主要区域开始-->
        <div id="main">          
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">保存成功！</div>
             <div id="save_fail_info" class="save_fail">保存失败！</div>
            <form id="myfrom" class="main_form">
                <div class="text_info clearfix"><span>角色名称：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name="roleName" value="${role.roleName }" />
                    <span class="required">*</span>
                    <div class="validate_msg_medium error_msg">不能为空，且为20长度的字母、数字和汉字的组合</div>
                </div>                    
                <div class="text_info clearfix"><span>设置权限：</span></div>
                <div class="input_info_high">
                    <div class="input_info_scroll">
                        <ul>
                       		<li><input type="checkbox" value="1" name="permission" ${check1} />角色管理</li>
                            <li><input type="checkbox" value="2" name="permission" ${check2} />管理员管理</li>
                            <li><input type="checkbox" value="3" name="permission" ${check3} />资费管理</li>
                            <li><input type="checkbox" value="4" name="permission" ${check4} />账务账号</li>
                            <li><input type="checkbox" value="5" name="permission" ${check5} />业务账号</li>
                            <li><input type="checkbox" value="6" name="permission" ${check6} />账单</li>
                            <li><input type="checkbox" value="7" name="permission" ${check7} />报表</li>
                        </ul>
                    </div>
                    <span class="required">*</span>
                    <div class="validate_msg_tiny">至少选择一个权限</div>
                </div>
                <input type="hidden" name="roleID" value="${role.roleID }"  />
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
