<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <%@ include file="../include/linkinclude.jsp" %>
        <script language="javascript" type="text/javascript">
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
            			url:"${pageContext.request.contextPath }/admin/UpdateAdminInfoAction.do",
            			data:$("#myform").serialize(),
            			success:function(data){
            				var flag = eval(data)
            				showResult(flag)
            			}
            		})
            	});
            })
        </script>
    </head>
    <body onload="showResult()">
       <%@ include file="../include/listinclude.jsp" %>
        <!--主要区域开始-->
        <div id="main">            
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，数据并发错误！-->
             <div id="save_fail_info" class="save_fail">保存失败！</div><!--保存失败，数据并发错误！-->
            <form id="myform" class="main_form">
                <div class="text_info clearfix"><span>管理员账号：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${admin.adminLog }" name="adminLog" /></div>
                <div class="text_info clearfix"><span>角色：</span></div>
                <div class="input_info">
                    <input type="text" readonly="readonly" class="readonly width400" value="${admin.role }" />
                </div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" value="${admin.adminName }" name="name" />
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">20长度以内的汉字、字母的组合</div>
                </div>
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" value="${admin.adminPhone }" name="phone" />
                    <div class="validate_msg_medium">电话号码格式：手机或固话</div>
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" value="${admin.adminEmail}" name="email" />
                    <div class="validate_msg_medium">50长度以内，符合 email 格式</div>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="<fmt:formatDate value="${admin.creTime}" pattern="yyyy/MM/dd HH:mm:ss"/>"/></div>
                <div class="button_info clearfix">
                    <input id="savebtn" type="button" value="保存" class="btn_save"  />
                    <input type="reset" value="重置" class="btn_save" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
