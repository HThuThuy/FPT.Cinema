<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

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
<header class="header-area header-sticky">
	<div class="container">
		<div class="row">
			<div class="col-12 menu">
				<nav class="main-nav">
					<!-- ***** Logo Start ***** -->
					<a href="index.html" class="logo"> <img
						src="${pageContext.request.contextPath}/resources/img/logo.png"
						alt="">
					</a>
					<!-- ***** Logo End ***** -->
					<!-- ***** Search End ***** -->
					<div class="search-input">
						<form id="search" action="#">
							<input type="text" placeholder="Tìm tên phim, diễn viên"
								id='searchText' name="searchKeyword" onkeypress="handle" /> <i
								class="fa fa-search"></i>
						</form>
					</div>
					<!-- ***** Search End ***** -->
					<!-- ***** Menu Start ***** -->
					<ul class="nav d-flex justify-content-center">
						<li><a href="index.html" class="active">MUA VÉ</a></li>
						<li><a href="browse.html">PHIM</a></li>
						<li><a href="booking.html">RẠP/GIÁ VÉ</a></li>
						<li><a href="streams.html">KHUYẾN MÃI</a></li>
						<li><a href="#" id="member-tab">THÀNH VIÊN <img
								src="${pageContext.request.contextPath}/resources/img/profile-header.jpg"
								alt="">
						</a></li>
					</ul>



					<!-- ***** Menu End ***** -->
				</nav>
			</div>
		</div>
	</div>
</header>
<!-- ***** Header Area End ***** -->