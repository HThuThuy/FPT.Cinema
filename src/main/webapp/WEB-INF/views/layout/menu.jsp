<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<link href="<c:url value="/resources/css/menu1.css" />" rel="stylesheet">


<style>
.dropdown:hover .dropdown-menu {
	display: block;
	display: block;
}
</style>
<!-- ***** Preloader Start ***** -->
<div id="js-preloader" class="js-preloader">
	<div class="preloader-inner">
		<span class="dot"></span>
		<div class="dots">
			<span></span> <span></span> <span></span>
		</div>
	</div>
</div>
<!-- ***** Preloader End ***** -->

<!-- ***** Header Area Start ***** -->
<header class="site-navbar" role="banner">
	<div class="container row-top">
		<div class="row ">

			<div class="col-2 col-md-2">
				<h1 class="mb-0 site-logo">
					<a href="/FPT-Cinema" class="logo1"> <img
						src="${pageContext.request.contextPath}/resources/img/logo.png"
						alt="">
					</a>
				</h1>
			</div>
			<div class="col-4">
				<!-- ***** Search start ***** -->
				<div class="search-input">
					<form id="search" action="#">
						<input type="text" placeholder="Tìm tên phim, diễn viên"
							id='searchText' name="searchKeyword" onkeypress="handle" /> <i
							class="fa fa-search"></i>
					</form>
				</div>
				<!-- ***** Search End ***** -->
			</div>
			<div class="col-6 d-flex">
				<nav class="site-navigation position-relative text-right"
					role="navigation">
					<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
						<!-- <li class="active"><a href="index.html"><span>TRANG CHỦ</span></a></li> -->
						<li class="has-children"><a href="about.html"><span>PHIM</span></a>
							<ul class="dropdown">
								<li><a href="#">Menu One</a></li>
								<li><a href="#">Menu Two</a></li>
								<li><a href="#">Menu Three</a></li>
							</ul></li>
						<li><a href="about.html"><span>KHUYẾN MÃI</span></a></li>
						<li><a href="${pageContext.request.contextPath}/login"><span>HỖ
									TRỢ</span></a></li>
						<c:choose>
							<c:when test="${empty sessionScope.customerName}">
								<li class="has-children" id="login"><a href="#"
									id="member-tab">ĐĂNG NHẬP </a></li>
							</c:when>
							<c:otherwise>
								<li class="dropdown"><a
									href="${pageContext.request.contextPath}/customer/history"
									class="dropdown-toggle" id="member-tab" data-toggle="dropdown">

										Chào mừng ${sessionScope.customerName} ! </a>
									<div class="dropdown-menu" aria-labelledby="member-tab">
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/customer/history">Tài
											khoản</a> <a class="dropdown-item"
											href="${pageContext.request.contextPath}/logout">Thoát</a>
									</div></li>
							</c:otherwise>
						</c:choose>
				</nav>
			</div>

			<div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3"
				style="position: relative; top: 3px;">
				<a href="#" class="site-menu-toggle js-menu-toggle text-white"><span
					class="icon-menu h3"></span></a>
			</div>

		</div>
	</div>
</header>


<script>
	 function loginSuccess(customerName) {
		    // Remove the login link
		    $('#login').remove();

		    // Add the dropdown menu for the logged in user
		    var dropdownMenu = `
		      <li class="dropdown">
		        <a href="${pageContext.request.contextPath}/customer/history" class="dropdown-toggle" id="member-tab">
		          Chào mừng ${customerName} !
		        </a>
		        <div class="dropdown-menu" aria-labelledby="member-tab">
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/customer/history">Tài khoản</a>
		          <a class="dropdown-item" href="#" onclick="logout(); return false;">Thoát</a>
		        </div>
		      </li>
		    `;
		    $('.site-menu').append(dropdownMenu);
		  }
		
</script>
<!-- ***** Header Area End ***** -->

