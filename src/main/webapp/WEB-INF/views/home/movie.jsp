<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>


<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
					<div class="heading-section"></div>
				</div>

				<main class="main-content">
					<section class="slideshow">
						<div class="slideshow-inner">
							<div class="slides">
								<c:forEach items="${listMovieDangChieu}" var="dc">
									<div class="slide">
										<div class="slide-content">
											<div class="caption">
												<div class="title">${dc.movieName}</div>
												<div class="text">
													<p>Phim hot đang chiếu</p>
												</div>
												<a href="${dc.trailerUrl}" target="_blank"
													class="btn-trailer"> <span class="btn-inner">TRAILER</span>
												</a>
											</div>
										</div>
										<div class="image-container">
											<img src="${dc.posterUrl}" alt="" class="image">
										</div>
									</div>
								</c:forEach>
							</div>
							<div class="pagination">
								<!-- Pagination code here -->
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
								<!-- Arrows code here -->
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




			</div>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="tab-1" role="tabpanel"
					aria-labelledby="home-tab">
					<div class="row justify-content-center" id="Phim-dang-chieu">
						<c:forEach items="${listMovieDangChieu}" var="dc">
							<div
								class="col-lg-3 col-sm-6 d-flex flex-column align-items-center">
								<div class="item movie-card">
									<div class="movie-poster">
										<img src="${dc.posterUrl}" alt="">
									</div>
									<div class="movie-details">
										<h3 class="movie-title">${dc.movieName}</h3>
										<div class="sml">
											<p class="movie-genre" style="color: rgb(255, 255, 255);">
												<i class="fa fa-clock-o" aria-hidden="true"></i>Thời lượng:
												${dc.duration}
											</p>
										</div>
										<div class="sml">
											<p class="movie-rating" style="color: rgb(255, 255, 255);">
												<i class="fa fa-star" aria-hidden="true"></i> 7.2/10
											</p>
										</div>
										<input type="hidden" name="movieID" value="${dc.movieId}">
										<a
											href="${pageContext.request.contextPath}/ticket/showtime/${dc.movieId}">Đặt
											vé</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

				<div class="tab-pane fade" id="tab-2" role="tabpanel"
					aria-labelledby="profile-tab">
					<div class="row justify-content-center" id="Phim-sap-chieu">

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
					<c:forEach items="${listPromotion}" var="pr">
						<div class="col-lg-3 col-sm-6">
							<div class="item movie-card">
								<div class="movie-poster">
									<img src="${pr.url}" alt="">
								</div>
								<div class="movie-details">
									<div class="sml">
										<p class="movie-genre">
											<i class="fa fa-clock-o" aria-hidden="true"></i>${pr.startDate}
										</p>
										<p class="movie-rating">
											<i class="fa fa-clock-o" aria-hidden="true"> </i>${pr.endDate}
										</p>
									</div>
								</div>
							</div>
						</div>

					</c:forEach>

				</div>
			</div>
		</div>
	</div>
	<%-- <c:if test="${not empty seatOrder}">
		<script>
    var seatOrder = "${seatOrder}";
    alert(seatOrder);
    </script>
	</c:if> --%>
	<%
	String seatOrder = request.getParameter("seatOrder");
	%>
</div>
<script>


document.addEventListener('DOMContentLoaded', function() {
	var seatOrder = '<%= seatOrder %>';
	
	 if (seatOrder && seatOrder !== 'null') {
		    alert(seatOrder);
		  }
      var sapChieuDiv = document.getElementById('Phim-sap-chieu');
      sapChieuDiv.innerHTML = `
         <c:forEach items="${listMovieSapChieu}" var="sc">
          <div class="col-lg-3 col-sm-6 d-flex flex-column align-items-center">
            <div class="item movie-card">
              <div class="movie-poster">
                <img src="${sc.posterUrl}" alt="">
              </div>
              <div class="movie-details">
                <h3 class="movie-title">${sc.movieName}</h3>
                <div class="sml">
                  <p class="movie-genre" style="color: rgb(255, 255, 255);">
                    <i class="fa fa-clock-o" aria-hidden="true"></i>Thời lượng: ${sc.duration}
                  </p>
                </div>
                <div class="sml">
                  <p class="movie-rating" style="color: rgb(255, 255, 255);">
                    <i class="fa fa-star" aria-hidden="true"></i> 7.2/10
                  </p>
                </div>
                <input type="hidden" name="movieID" value="${sc.movieId}">
                <a href="${pageContext.request.contextPath}/ticket/showtime/${sc.movieId}">Đặt vé</a>
              </div>
            </div>
          </div>
         </c:forEach> 
      `;
      
      
    /*   var dangChieuDiv = document.getElementById('Phim-dang-chieu');
      
      dangChieuDiv.innerHTML = `
          <c:forEach items="${listMovieDangChieu}" var="dc">
            <div
                class="col-lg-3 col-sm-6 d-flex flex-column align-items-center">
                <div class="item movie-card">
                    <div class="movie-poster">
                        <img src="${dc.posterUrl}" alt="">
                    </div>
                    <div class="movie-details">
                        <h3 class="movie-title">${dc.movieName}</h3>
                        <div class="sml">
                            <p class="movie-genre" style="color: rgb(255, 255, 255);">
                                <i class="fa fa-clock-o" aria-hidden="true"></i>Thời lượng:
                                ${dc.duration}
                            </p>
                        </div>
                        <div class="sml">
                            <p class="movie-rating" style="color: rgb(255, 255, 255);">
                                <i class="fa fa-star" aria-hidden="true"></i> 7.2/10
                            </p>
                        </div>
                        <input type="hidden" name="movieID" value="${dc.movieId}">
                        <a
                            href="${pageContext.request.contextPath}/ticket/showtime/${dc.movieId}">Đặt
                            vé</a>
                    </div>
                </div>
            </div>
        </c:forEach> 
          `; */
    });
    
<%-- //Lấy giá trị từ model.addAttribute
var seatOrder = '<%= request.getAttribute("seatOrder") %>';

// Kiểm tra nếu giá trị không rỗng thì hiển thị thông báo
if (seatOrder !== null && seatOrder !== '') {
    alert(seatOrder);
} --%>


</script>