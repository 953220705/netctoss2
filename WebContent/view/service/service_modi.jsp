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
            //保存成功的提示信息
           $(function(){
            	$("#savebtn").click(function(){
            		$.post({
            			url:"${pageContext.request.contextPath }/services/UpdateSerAction.do",
            			data:$("#myform").serialize(),
            			success:function(data){
            				var flag = eval(data);
            				showResult(flag)
            			}
            		})
            	})
            })
        	//保存结果的提示
            function showResult(flag) {
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
                    divResult.hede();
            }
            function showFailDiv(flag) {
                var divResult = $("#save_fail_info");
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
            <!--保存操作的提示信息-->
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，数据并发错误！-->
             <div id="save_fail_info" class="save_fail">保存失败！</div><!--保存失败，数据并发错误！-->
            <form id="myform" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>业务账号ID：</span></div>
                <div class="input_info">
                    <input type="text" name="sid" value="${serInfo.ser_id }" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>OS 账号：</span></div>
                <div class="input_info">
                    <input type="text" value="${serInfo.ser_oslog }" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info">
                    <input type="text" value="${serInfo.ser_ip }" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                    <select name="feeid" class="width150">
                    <c:forEach items="${allFee}" var="fee">
                    <c:set var="fid" value="${fee.feeID }"></c:set>
                        <option value="${fee.feeID}" ${fselect[fid]}>${fee.feeName}</option>
                    </c:forEach>
                    </select>
                    <div class="validate_msg_long">请修改资费类型，或者取消修改操作。</div>                      
                </div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input id="savebtn" type="button" value="保存" class="btn_save" />
                    <input type="button" value="取消" class="btn_save" />
                </div>

                
                <p>业务说明：<br />
                1、修改资费后，点击保存，并未真正修改数据库中的数据；<br />
                2、提交操作到消息队列；<br />
                3、每月月底由程序自动完成业务所关联的资费；</p>
                
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
