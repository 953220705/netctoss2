<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <%@include file="../include/linkinclude.jsp" %>
        <script language="javascript" type="text/javascript">
            //排序按钮的点击事件
            function sort(btnObj) {
                if (btnObj.className == "sort_desc"){
                    btnObj.className = "sort_asc";
                    location.href = "${pageContext.request.contextPath}/fee/FeeRankAction.do?rank="+btnObj.name+"&order=asc";
                }else{
                	btnObj.className = "sort_desc";
                	location.href = "${pageContext.request.contextPath}/fee/FeeRankAction.do?rank="+btnObj.name+"&order=desc";
                }
            }

            //启用
            function startFee(feeID) {
                if(window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。")==true){
                	//location.href="${pageContext.request.contextPath}/fee/OpenFeeAction.do?feeID="+feeID;
                	$.post({
                		url:'${pageContext.request.contextPath}/fee/OpenFeeAction.do?feeID='+feeID,
                		success:function(data){
                			var flag = eval(data);
                			if(flag==true){
                				$("#"+feeID+"state").text("开通");
                				$("#"+feeID+"open ").remove();      
                			}
                		}
                	})
                }
            }
            //删除
            function deleteFee(feeID) {
                if(window.confirm("确定要删除此资费吗？")==true){
                	location.href="${pageContext.request.contextPath}/fee/DelFeeAction.do?feeID="+feeID;
                }
            }
            function showResult(flag) {
            	//var updateFlag=${requestScope.delflag};
	            if(falg==true){
          				showResultDiv(true);
               		window.setTimeout("showResultDiv(false);", 3000);
	            }else{
	            	showFailDiv(true);
	                window.setTimeout("showFailDiv(false);", 3000);
	            }
            	
            }
        </script>        
    </head>
    <body>
        <%@include file="../include/listinclude.jsp" %>
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--排序-->
                <div class="search_add">
                    <div>
                        <input type="button" name="unit_cost" value="单价" class="${classunit_cost }" onclick="sort(this);" />
                        <input type="button" name="basic_fee" value="基费" class="${classbasic_fee }" onclick="sort(this);" />
                        <input type="button" name="basic_time" value="时长" class="${classbasic_time }" onclick="sort(this);" />
                    </div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/view/fee/fee_add.jsp';" />
                </div> 
                <!--启用操作的操作提示-->
                <div id="save_result_info" class="save_success">删除成功！</div><!--保存失败，数据并发错误！-->
             	<div id="save_fail_info" class="save_fail">删除失败！</div><!--保存失败，数据并发错误！-->    
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th>资费ID</th>
                            <th class="width100">资费名称</th>
                            <th>基本时长</th>
                            <th>基本费用</th>
                            <th>单位费用</th>
                            <th>创建时间</th>
                            <th>开通时间</th>
                            <th class="width50">状态</th>
                            <th class="width200"></th>
                        </tr>
                  <c:forEach items="${requestScope.feeList }" var="fee">                      
                        <tr id="${fee.feeID }del">
                            <td>${fee.feeID }</td>
                            <td><a href="${pageContext.request.contextPath }/fee/ShowFeeAction.do?feeID=${fee.feeID }">${fee.feeName }</a></td>
                            <td>${fee.basicTime }</td>
                            <td>${fee.basicFee }元</td>
                            <td>${fee.unitCost } 元/小时</td>
                            <td><fmt:formatDate value="${fee.creTime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
                            <td><fmt:formatDate value="${fee.startTime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
                            <td id="${fee.feeID }state">${fee.feeState }</td>
                            <td id="${fee.feeID }open">   
                             <c:choose>
                            	<c:when test="${fee.feeState=='暂停' }">                             
                                <input type="button" value="启用" class="btn_start" onclick="startFee(${fee.feeID});" />
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/fee/UpdateFeeAction.do?feeID=${fee.feeID }';" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteFee(${fee.feeID});" />
	                            </c:when>
	                        </c:choose>
	                        </td>
                        </tr>
    				</c:forEach>
                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
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
