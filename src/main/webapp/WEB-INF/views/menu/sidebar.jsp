<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value ='/lib/css/bootstrap5.min.css'/>">
<link rel="stylesheet"
	href="<c:url value ='/lib/css/fontawesome.min.css'/>">
<link rel="stylesheet" href="<c:url value ='/lib/css/all.min.css'/>">
<link rel="stylesheet" href="<c:url value ='/lib/css/all.css'/>">
<link rel="stylesheet" href="<c:url value ='/lib/css/makecolor.css'/>">
<%-- <link rel="stylesheet" href="<c:url value ='/lib/css/home.css'/>"> --%>
<link rel="stylesheet"
	href="<c:url value ='/lib/icon/unpkg.com_boxicons@2.1.4_css_boxicons.min.css'/>">
<script
	src="<c:url value="/lib/js/code.jquery.com_jquery-3.7.0.min.js" />"></script>
<script src="<c:url value="/lib/js/main.js" />"></script>
<script src="<c:url value="/lib/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<body>
	<nav class="sidebar locked">
		<div class="logo_items flex">
			<span class="nav_image"> <img src="${pageContext.request.contextPath}/lib/picture/logoWater.jpg"
				alt="logo_img" />
			</span><a href="/ThuThuy/" style="text-decoration: none;"><span
				class="logo_name">Menu</span></a>
		</div>
		<div class="menu_container">
			<div class="menu_items">
				<ul class="menu_item">
					<div class="menu_title flex">
						<span class="title">DashBoard</span> <span class="line"></span>
					</div>
					<li class="item"><a
						href="${pageContext.request.contextPath}/person/register"
						class="link flex"><i class="fa-solid fa-house"></i><span>Person</span>
					</a></li>
					<li class="item"><a
						href="${pageContext.request.contextPath}/person/list"
						class="link flex"><i class="fa-solid fa-wand-magic-sparkles"></i>
							<span>Đăng ký tiêm</span> </a></li>
					
				</ul>

			
			</div>
			<div class="sidebar_profile flex">
				<span class="nav_image">  <img src="${pageContext.request.contextPath}/lib/picture/logoWater.jpg"
					alt="logo_img" />
				</span>
				<div class="data_text">
					<span class="name">Hoang Thi Thu Thuy</span> <span class="email">ThuyHtt14@fpt.com</span>
				</div>
			</div>
		</div>
	</nav>
</body>

</html>