<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<!-- ***** Login Start ***** -->
<jsp:include page="loginAndRegisterModal.jsp" />
<!-- ***** Login End ***** -->

<!-- ***** Forgot Password Start ***** -->
<jsp:include page="forgotPasswordModal.jsp" />
<!-- ***** Forgot Password End ***** -->

<!-- ***** New Password Start ***** -->
<jsp:include page="resetPasswordModal.jsp" />
<!-- ***** New Password End ***** -->


<div class="row filmhot">
	<div class="col-lg-12 ">
		<div class="page-content">

			<!-- ***** Banner Start ***** -->
			<div class="row">
				<div class="col-lg-12">
					<div class="heading-section">
						<h4>PHIM HOT TRONG THÁNG</h4>
					</div>
				</div>

				<main class="main-content">
					<section class="slideshow">
						<div class="slideshow-inner">
							<div class="slides">
								<div class="slide is-active ">
									<div class="slide-content">
										<div class="caption">
											<div class="title">Slide title 1</div>
											<div class="text">
												<p>Slide description 1</p>
											</div>
											<a href="#" class="btn"> <span class="btn-inner">ĐẶT
													VÉ</span>
											</a>
										</div>
									</div>
									<div class="image-container">
										<img
											src="${pageContext.request.contextPath}/resources/img/phimhot1.jpg"
											alt="" class="image">
									</div>
								</div>
								<div class="slide">
									<div class="slide-content">
										<div class="caption">
											<div class="title">Slide title 2</div>
											<div class="text">
												<p>Slide description 2</p>
											</div>
											<a href="#" class="btn"> <span class="btn-inner">ĐẶT
													VÉ</span>
											</a>
										</div>
									</div>
									<div class="image-container">
										<img
											src="${pageContext.request.contextPath}/resources/img/phimhot2.jpg"
											alt="" class="image">
									</div>
								</div>
								<div class="slide">
									<div class="slide-content">
										<div class="caption">
											<div class="title">Slide title 3</div>
											<div class="text">
												<p>Slide description 3</p>
											</div>
											<a
												href="${pageContext.request.contextPath}/admin/quanLySuatChieu"
												class="btn"> <span class="btn-inner">ĐẶT VÉ</span>
											</a>
										</div>
									</div>
									<div class="image-container">
										<img
											src="${pageContext.request.contextPath}/resources/img/phimhot3.jpg"
											alt="" class="image">
									</div>
								</div>
								<div class="slide">
									<div class="slide-content">
										<div class="caption">
											<div class="title">Slide title 4</div>
											<div class="text">
												<p>Slide description 4</p>
											</div>
											<a href="${pageContext.request.contextPath}/ticket/showtime"
												class="btn"> <span class="btn-inner">ĐẶT VÉ</span>
											</a>
										</div>
									</div>
									<div class="image-container">
										<img
											src="${pageContext.request.contextPath}/resources/img/phimhot4.jpg"
											alt="" class="image">
									</div>
								</div>
							</div>
							<div class="pagination">
								<div class="item is-active">
									<span class="icon">1</span>
								</div>
								<div class="item">
									<span class="icon">2</span>
								</div>
								<div class="item">
									<span class="icon">3</span>
								</div>
								<div class="item">
									<span class="icon">4</span>
								</div>
							</div>
							<div class="arrows">
								<div class="arrow prev">
									<span class="svg svg-arrow-left"> <svg version="1.1"
											id="svg4-Layer_1" xmlns="http://www.w3.org/2000/svg"
											xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
											width="14px" height="26px" viewBox="0 0 14 26"
											enable-background="new 0 0 14 26" xml:space="preserve"> <path
												d="M13,26c-0.256,0-0.512-0.098-0.707-0.293l-12-12c-0.391-0.391-0.391-1.023,0-1.414l12-12c0.391-0.391,1.023-0.391,1.414,0s0.391,1.023,0,1.414L2.414,13l11.293,11.293c0.391,0.391,0.391,1.023,0,1.414C13.512,25.902,13.256,26,13,26z" /> </svg>
										<span class="alt sr-only"></span>
									</span>
								</div>
								<div class="arrow next">
									<span class="svg svg-arrow-right"> <svg version="1.1"
											id="svg5-Layer_1" xmlns="http://www.w3.org/2000/svg"
											xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
											width="14px" height="26px" viewBox="0 0 14 26"
											enable-background="new 0 0 14 26" xml:space="preserve"> <path
												d="M1,0c0.256,0,0.512,0.098,0.707,0.293l12,12c0.391,0.391,0.391,1.023,0,1.414l-12,12c-0.391,0.391-1.023,0.391-1.414,0s-0.391-1.023,0-1.414L11.586,13L0.293,1.707c-0.391-0.391-0.391-1.023,0-1.414C0.488,0.098,0.744,0,1,0z" /> </svg>
										<span class="alt sr-only"></span>
									</span>
								</div>
							</div>
						</div>
					</section>
				</main>


			</div>

		</div>
	</div>
</div>
<div class="container">

	<!-- ***** Banner End ***** -->

	<!-- ***** Most Popular Start ***** -->
	<div class="most-popular">
		<div class="row">
			<div class="col-lg-12">
				<div class="heading-section mb-5">
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item" style="margin-right: 20px;"
							role="presentation"><a class="nav-link active" id="home-tab"
							data-bs-toggle="tab" href="#tab-1" role="tab"
							aria-controls="home" aria-selected="true">
								<h4>PHIM ĐANG CHIẾU</h4>
						</a></li>
						<li class="nav-item" role="presentation"><a class="nav-link"
							id="profile-tab" data-bs-toggle="tab" href="#tab-2" role="tab"
							aria-controls="profile" aria-selected="false">
								<h4>PHIM SẮP CHIẾU</h4>
						</a></li>
					</ul>
				</div>

				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="tab-1" role="tabpanel"
						aria-labelledby="home-tab">
						<div class="row">

							<div
								class="col-lg-3 col-sm-6 d-flex flex-column align-items-center">
								<div class="item movie-card">
									<div class="movie-poster">
										<img
											src="${pageContext.request.contextPath}/resources/img/Treanding1.jpeg"
											alt="">
									</div>
									<div class="movie-details">
										<h3 class="movie-title">Demon Slayer: Kimetsu no Yaiba</h3>
										<div class="sml">
											<p class="movie-genre" style="color: rgb(255, 255, 255);">
												<i class="fa fa-clock-o" aria-hidden="true"></i>Thời lượng:
												115 phút
											</p>
										</div>
										<div class="sml">
											<p class="movie-rating" style="color: rgb(255, 255, 255);">
												<i class="fa fa-star" aria-hidden="true"></i> 7.2/10
											</p>
										</div>
										<a href="" class="watch-Q">Đặt vé</a>
									</div>
								</div>
							</div>


							<div
								class="col-lg-3 col-sm-6 d-flex flex-column align-items-center">
								<div class="item movie-card">
									<div class="movie-poster">
										<img
											src="${pageContext.request.contextPath}/resources/img/Treanding2.jpeg"
											alt="">
									</div>
									<div class="movie-details">
										<h3 class="movie-title">Demon Slayer: Kimetsu no Yaiba</h3>
										<div class="sml">
											<p class="movie-genre" style="color: rgb(255, 255, 255);">
												<i class="fa fa-clock-o" aria-hidden="true"></i>Thời lượng:
												115 phút
											</p>
										</div>
										<div class="sml">
											<p class="movie-rating" style="color: rgb(255, 255, 255);">
												<i class="fa fa-star" aria-hidden="true"></i> 7.2/10
											</p>
										</div>
										<a href="" class="watch-Q">Đặt vé</a>
									</div>
								</div>
							</div>

							<div
								class="col-lg-3 col-sm-6 d-flex flex-column align-items-center">
								<div class="item movie-card">
									<div class="movie-poster">
										<img
											src="${pageContext.request.contextPath}/resources/img/Treanding3.jpeg"
											alt="">
									</div>
									<div class="movie-details">
										<h3 class="movie-title">Demon Slayer: Kimetsu no Yaiba</h3>
										<div class="sml">
											<p class="movie-genre" style="color: rgb(255, 255, 255);">
												<i class="fa fa-clock-o" aria-hidden="true"></i>Thời lượng:
												115 phút
											</p>
										</div>
										<div class="sml">
											<p class="movie-rating" style="color: rgb(255, 255, 255);">
												<i class="fa fa-star" aria-hidden="true"></i> 7.2/10
											</p>
										</div>
										<a href="" class="watch-Q">Đặt vé</a>
									</div>
								</div>
							</div>

							<div
								class="col-lg-3 col-sm-6 d-flex flex-column align-items-center">
								<div class="item movie-card">
									<div class="movie-poster">
										<img
											src="${pageContext.request.contextPath}/resources/img/Treanding4.jpeg"
											alt="">
									</div>
									<div class="movie-details">
										<h3 class="movie-title">Demon Slayer: Kimetsu no Yaiba</h3>
										<div class="sml">
											<p class="movie-genre" style="color: rgb(255, 255, 255);">
												<i class="fa fa-clock-o" aria-hidden="true"></i>Thời lượng:
												115 phút
											</p>
										</div>
										<div class="sml">
											<p class="movie-rating" style="color: rgb(255, 255, 255);">
												<i class="fa fa-star" aria-hidden="true"></i> 7.2/10
											</p>
										</div>
										<a href="" class="watch-Q">Đặt vé</a>
									</div>
								</div>
							</div>

						</div>
					</div>



					<!-- ***** Phim sắp chiếu ***** -->

					<div class="tab-pane fade" id="tab-2" role="tabpanel"
						aria-labelledby="profile-tab">
						<div class="row justify-content-center">


							<div
								class="col-lg-3 col-sm-6 d-flex flex-column align-items-center">
								<div class="item movie-card">
									<div class="movie-poster">
										<img
											src="${pageContext.request.contextPath}/resources/img/Treanding1.jpeg"
											alt="">
									</div>
									<div class="movie-details">
										<h3 class="movie-title">Demon Slayer: Kimetsu no Yaiba</h3>
										<div class="sml">
											<p class="movie-genre" style="color: rgb(255, 255, 255);">
												<i class="fa fa-clock-o" aria-hidden="true"></i>Thời lượng:
												115 phút
											</p>
										</div>
										<div class="sml">
											<p class="movie-rating" style="color: rgb(255, 255, 255);">
												<i class="fa fa-star" aria-hidden="true"></i> 7.2/10
											</p>
										</div>
										<a href="" class="watch-Q">Đặt vé</a>
									</div>
								</div>
							</div>


							<div
								class="col-lg-3 col-sm-6 d-flex flex-column align-items-center">
								<div class="item movie-card">
									<div class="movie-poster">
										<img
											src="${pageContext.request.contextPath}/resources/img/Treanding2.jpeg"
											alt="">
									</div>
									<div class="movie-details">
										<h3 class="movie-title">Demon Slayer: Kimetsu no Yaiba</h3>
										<div class="sml">
											<p class="movie-genre" style="color: rgb(255, 255, 255);">
												<i class="fa fa-clock-o" aria-hidden="true"></i>Thời lượng:
												115 phút
											</p>
										</div>
										<div class="sml">
											<p class="movie-rating" style="color: rgb(255, 255, 255);">
												<i class="fa fa-star" aria-hidden="true"></i> 7.2/10
											</p>
										</div>
										<a href="" class="watch-Q">Đặt vé</a>
									</div>
								</div>
							</div>

							<div
								class="col-lg-3 col-sm-6 d-flex flex-column align-items-center">
								<div class="item movie-card">
									<div class="movie-poster">
										<img
											src="${pageContext.request.contextPath}/resources/img/Treanding3.jpeg"
											alt="">
									</div>
									<div class="movie-details">
										<h3 class="movie-title">Demon Slayer: Kimetsu no Yaiba</h3>
										<div class="sml">
											<p class="movie-genre" style="color: rgb(255, 255, 255);">
												<i class="fa fa-clock-o" aria-hidden="true"></i>Thời lượng:
												115 phút
											</p>
										</div>
										<div class="sml">
											<p class="movie-rating" style="color: rgb(255, 255, 255);">
												<i class="fa fa-star" aria-hidden="true"></i> 7.2/10
											</p>
										</div>
										<a href="" class="watch-Q">Đặt vé</a>
									</div>
								</div>
							</div>

							<div
								class="col-lg-3 col-sm-6 d-flex flex-column align-items-center">
								<div class="item movie-card">
									<div class="movie-poster">
										<img
											src="${pageContext.request.contextPath}/resources/img/Treanding4.jpeg"
											alt="">
									</div>
									<div class="movie-details">
										<h3 class="movie-title">Demon Slayer: Kimetsu no Yaiba</h3>
										<div class="sml">
											<p class="movie-genre" style="color: rgb(255, 255, 255);">
												<i class="fa fa-clock-o" aria-hidden="true"></i>Thời lượng:
												115 phút
											</p>
										</div>
										<div class="sml">
											<p class="movie-rating" style="color: rgb(255, 255, 255);">
												<i class="fa fa-star" aria-hidden="true"></i> 7.2/10
											</p>
										</div>
										<a href="" class="watch-Q">Đặt vé</a>
									</div>
								</div>
							</div>

						</div>
					</div>


				</div>
			</div>
		</div>
	</div>
	<!-- ***** Most Popular End ***** -->

	<!-- ***** Promotion Start ***** -->
	<div class="most-popular">
		<div class="row">
			<div class="col-lg-12">
				<div class="heading-section promotion">
					<h4>KHUYẾN MÃI TRONG THÁNG</h4>
				</div>

				<div class="row tab-pane" id="tab-1">
					<div class="col-lg-3 col-sm-6">
						<div class="item movie-card">
							<div class="movie-poster">
								<img
									src="${pageContext.request.contextPath}/resources/img/promotion2.png"
									alt="">
							</div>
							<div class="movie-details">
								<div class="sml">
									<p class="movie-genre">
										<i class="fa fa-clock-o" aria-hidden="true"></i>Ngày Bắt đầu
									</p>
									<p class="movie-rating">
										<i class="fa fa-clock-o" aria-hidden="true"> </i>Ngày kết thúc
									</p>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-3 col-sm-6">
						<div class="item movie-card">
							<div class="movie-poster">
								<img
									src="${pageContext.request.contextPath}/resources/img/promotion2.png"
									alt="">
							</div>
							<div class="movie-details">
								<div class="sml">
									<p class="movie-genre">
										<i class="fa fa-clock-o" aria-hidden="true"></i>Ngày Bắt đầu
									</p>
									<p class="movie-rating">
										<i class="fa fa-clock-o" aria-hidden="true"> </i>Ngày kết thúc
									</p>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-3 col-sm-6">
						<div class="item movie-card">
							<div class="movie-poster">
								<img
									src="${pageContext.request.contextPath}/resources/img/promotion3.png"
									alt="">
							</div>
							<div class="movie-details">
								<div class="sml">
									<p class="movie-genre">
										<i class="fa fa-clock-o" aria-hidden="true"></i>Ngày Bắt đầu
									</p>
									<p class="movie-rating">
										<i class="fa fa-clock-o" aria-hidden="true"> </i>Ngày kết thúc
									</p>
								</div>
							</div>
						</div>

					</div>
					<div class="col-lg-3 col-sm-6">
						<div class="item movie-card">
							<div class="movie-poster">
								<img
									src="${pageContext.request.contextPath}/resources/img/promotion3.png"
									alt="">
							</div>
							<div class="movie-details">
								<div class="sml">
									<p class="movie-genre">
										<i class="fa fa-clock-o" aria-hidden="true"></i>Ngày Bắt đầu
									</p>
									<p class="movie-rating">
										<i class="fa fa-clock-o" aria-hidden="true"> </i>Ngày kết thúc
									</p>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>