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
            $(function(){
            	$("#savebtn").click(function(){
            		$.post({
            			url:"${pageContext.request.contextPath }/fee/SaveUpdateFeeAction.do",
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

            //切换资费类型
            function feeTypeChange(type) {
                var inputArray = document.getElementById("main").getElementsByTagName("input");
                if (type == 1) {
                    inputArray[5].disabled = true;
                    inputArray[5].value = "";
                    inputArray[5].className += " readonly";
                    inputArray[6].disabled = false;
                    inputArray[6].className = "width100";
                    inputArray[7].disabled = true;
                    inputArray[7].className += " readonly";
                    inputArray[7].value = "";
                }
                else if (type == 2) {
                    inputArray[5].disabled = false;
                    inputArray[5].className = "width100";
                    inputArray[6].disabled = false;
                    inputArray[6].className = "width100";
                    inputArray[7].disabled = false;
                    inputArray[7].className = "width100";
                }
                else if (type == 3) {
                    inputArray[5].disabled = true;
                    inputArray[5].value = "";
                    inputArray[5].className += " readonly";
                    inputArray[6].disabled = true;
                    inputArray[6].value = "";
                    inputArray[6].className += " readonly";
                    inputArray[7].disabled = false;
                    inputArray[7].className = "width100";
                }
            }
        </script>
    </head>
    <body >
       <%@include file="../include/listinclude.jsp" %>
        <!--主要区域开始-->
        <div id="main">            
           <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，数据并发错误！-->
             <div id="save_fail_info" class="save_fail">保存失败！</div><!--保存失败，数据并发错误！-->
            <form id="myform" class="main_form">
                <div class="text_info clearfix"><span>资费ID：</span></div>
                <div class="input_info"><input type="text" name="feeID" class="readonly" readonly value="${content.feeID }" /></div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info">
                    <input type="text" class="width300" name="feeName" value="${content.feeName }"/>
                    <span class="required">*</span>
                    <div class="validate_msg_short">50长度的字母、数字、汉字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type">
                    <input type="radio" name="radFeeType" value="1" ${check1} id="monthly" onclick="feeTypeChange(1);" />
                    <label for="monthly">包月</label>
                    <input type="radio" name="radFeeType" value="2" ${check2 } id="package" onclick="feeTypeChange(2);" />
                    <label for="package">套餐</label>
                    <input type="radio" name="radFeeType" value="3" ${check3 } id="timeBased" onclick="feeTypeChange(3);" />
                    <label for="timeBased">计时</label>
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <input type="text" name="basicTime" value="${content.basicTime }" class="width100" />
                    <span class="info">小时</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long">1-600之间的整数</div>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                    <input type="text" name="basicFee" value="${content.basicFee }" class="width100" />
                    <span class="info">元</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long">0-99999.99之间的数值</div>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <input type="text" name="unitCost" value="${content.unitCost }" class="width100" />
                    <span class="info">元/小时</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long">0-99999.99之间的数值</div>
                </div>   
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70" name="instructions">${content.instructions }
                    </textarea>
                    <div class="validate_msg_short">100长度的字母、数字、汉字和下划线的组合</div>
                </div>                    
                <div class="button_info clearfix">
                    <input id="savebtn" type="button" value="保存" class="btn_save" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
        </div>
    </body>
</html>
