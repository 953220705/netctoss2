 <!--Logo区域开始-->
        <div id="header">
            <img src="${pageContext.request.contextPath }/images/logo.png" alt="logo" class="left"/>
            <span>${sessionScope.admin.adminName}</span>
            <a href="${pageContext.request.contextPath }/admin/ExitAction.do">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">                        
            <ul id="menu">
	             <li><a href="${pageContext.request.contextPath }/view/index.jsp" class="index_on"></a></li>
	             <c:forEach items="${sessionScope.admin.lpe}" var="per">
	            	<li><a href="${pageContext.request.contextPath }${per.perurl}" class="${per.percss}"></a></li>
	             </c:forEach>
	             <li><a href="${pageContext.request.contextPath }/view/user/user_info.jsp" class="information_off"></a></li>
	             <li><a href="${pageContext.request.contextPath }/view/user/user_modi_pwd.jsp" class="password_off"></a></li>
       		</ul>           
        </div>
        <!--导航区域结束-->