<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <%@ include file="include/linkinclude.jsp" %> 
    </head>
    <body class="index">
        <div class="login_box">
        <form action="${pageContext.request.contextPath }/admin/AdminLoginAction.do" method="post" id="myform">
             <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input name="adminLog" type="text" class="width150" value="admin" /></td>
                    <td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input name="adminPsw" type="password" class="width150" value="123" /></td>
                    <td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
                </tr>
                <!-- <tr>
                    <td class="login_info">验证码：</td>
                    <td class="width70"><input name="" type="text" class="width70" /></td>
                    <td><img src="images/valicode.jpg" alt="验证码" title="点击更换" /></td>  
                    <td class="login_error_info"><span class="required">验证码错误</span></td>              
                </tr>   -->        
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                        <a href="javascript:document:myform.submit()"><img src="../images/login_btn.png" /></a>
                    </td> 
                </tr>
                <tr>
                	<td>
                	<c:choose>            
	                    <c:when test="${error }">
	                    <td class="login_error_info"><span style="color:red" >用户名或密码错误</span></td>                
	                	</c:when>
	                	<c:otherwise>
	                	</c:otherwise>
                	</c:choose> 
                	</td>
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>
