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
                                <h4>PHIM TÌM KIẾM</h4>
                        </a></li>
                    </ul>
                </div>




            </div>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="tab-1" role="tabpanel"
                    aria-labelledby="home-tab">
                    <div class="row justify-content-center" id="Phim-tim-kiem">
                        <c:forEach items="${movieChoose}" var="dc">
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

                
            </div>
        </div>
    </div>
    
</div>