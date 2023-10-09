<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<div class="templatemo-sidebar">
	<header class="templatemo-site-header">
		<a href="index.html" class="logo"> <img
			src="${pageContext.request.contextPath}/resources/img/logo.png"
			width="300" height="80" alt="logo">
		</a>
	</header>
	<div class="profile-photo-container">

		<div class="profile-photo-overlay"></div>
	</div>

	<div class="mobile-menu-icon">
		<i class="fa fa-bars"></i>
	</div>
	<nav class="templatemo-left-nav">
		<ul>
			<li><a style="text-decoration: none"
				href="${pageContext.request.contextPath}/customer/history"><i
					class="fa fa-database fa-fw"></i>Lịch sử giao dịch</a></li>
			<li><a style="text-decoration: none"
				href="${pageContext.request.contextPath}/customer/info"><i
					class="fa fa-solid fa-person"></i>Thông tin khách hàng</a></li>
			<li><a style="text-decoration: none"
				href="${pageContext.request.contextPath}/customer/faq"><i
					class="fa fa-solid fa-gem"></i>Chính sách/ FAQ</a></li>
			<li><a style="text-decoration: none" 
				href="${pageContext.request.contextPath}/logout"><i
					class="fa fa-eject fa-fw"></i>Sign Out</a></li>
		</ul>
	</nav>
</div>
