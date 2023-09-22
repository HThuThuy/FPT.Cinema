<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- ***** Preloader Start ***** -->
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<div class="page-content">

				<!-- ***** Banner Start ***** -->
				<div class="row">
					<div class="col-lg-12">
						<div class="main-profile ">
							<div class="row">
							
									<div class="col-lg-4 align-self-center">
										<img
											src="${movieChoose.posterUrl}"
											alt="" class="image">
									</div>
									<div class="col-lg-4 align-self-center">
										<div class="main-info header-text">
											<span>Đang chiếu</span>
											<h4>${movieChoose.movieName}</h4>
										    <input type="hidden" id="movieIDSelect" value="${movieChoose.movieId}">
											<p>
												Đạo diễn: ${movieChoose.director} <br> Thể loại: Hài, Gia Đình,
												Hành Động <br> Diễn viên: Kiều Minh Tuấn, Quốc Trường,
												Vân Trang, Mạc Văn Khoa <br> Quốc gia: Việt Nam <br>
												Ngày khởi chiếu: 25/8/2023

											</p>

										</div>
									</div>
									<div class="col-lg-4 align-self-center">
										<ul>
											<li>Lượt xem <span>3</span></li>
											<li>Điểm đánh giá <span>4.2</span></li>
											<li>Chi nhánh <span>Đà Nẵng</span></li>
											<li>Trailer <span>29</span></li>
										</ul>
									</div>
							
							</div>
							<div class="row">
								<div class="col-lg-12">
									<div class="clips">
										<div class="row">
											<div class="col-lg-12">
												<div class="heading-section">
													<h4>
														<em>NỘI DUNG PHIM</em> Movie Details
													</h4>
												</div>
											</div>

											<p>${movieChoose.movieDescription}</p>

											
											<h4 class="mt-4">
												<em>LỊCH CHIẾU</em>
											</h4>
											<div class="row mt-3 mb-3">
												<div class="col-4">

													<div class="form-group">

														<select class="form-control" id="theaterCity"
															name="theaterCity" onchange="getSelectedCity()">
															<option value="all">Cả nước</option>
															<c:set var="citySet" value="" />
															<c:forEach items="${listTheater}" var="theater">
																<c:if test="${!citySet.contains(theater.city)}">
																	<c:set var="citySet" value="${citySet},${theater.city}" />
																	<option value="${theater.city}">${theater.city}</option>
																</c:if>
															</c:forEach>
														</select>
													</div>

												</div>

												<div class="col-4">
													<div class="form-group">

														<input type="date" class="form-control" id="usr">
													</div>

												</div>

												<div class="col-4">

													<div class="form-group">
														<select class="form-control" id="branch" name="branch" onchange="getSelectedTheater()" >
															<%-- <option value="all">Tất cả rạp</option>
															<c:forEach items="${listCity}" var="th">
																<option value="${th.theaterName}">${th.theaterName}</option>
															</c:forEach> --%>
														</select>
													</div>

												</div>
											</div>

										</div>
										<div class="row">
											<h4 class="mt-4">
												<em>FPT Cinema 1</em>
											</h4>
											<div class="row show-time mt-3">
												<div class="col-3 title">

													<h5>2D- Phụ đề</h5>
												</div>
												<div class="col-9 content" id="showtime">
													<%-- <a class="show_time_boder"
														href="${pageContext.request.contextPath}/ticket/booking">10:00</a>

													<a class="show_time_boder" href="booking.html">11:00</a> <a
														class="show_time_boder" href="booking.html">12:00</a> <a
														class="show_time_boder" href="booking.html">13:45</a> <a
														class="show_time_boder" href="booking.html">15:30</a> <a
														class="show_time_boder" href="booking.html">16:00</a> <a
														class="show_time_boder" href="booking.html">17:45</a> <a
														class="show_time_boder" href="booking.html">18:30</a> --%>

												</div>
											</div>

											<div class="row show-time mt-3">
												<div class="col-3 title">

													<h5>3D- Phụ đề</h5>
												</div>
												<div class="col-9 content">
													<a class="show_time_boder" href="booking.html">10:00</a> <a
														class="show_time_boder" href="booking.html">11:00</a> <a
														class="show_time_boder" href="booking.html">12:00</a> <a
														class="show_time_boder" href="booking.html">13:45</a> <a
														class="show_time_boder" href="booking.html">15:30</a> <a
														class="show_time_boder" href="booking.html">16:00</a> <a
														class="show_time_boder" href="booking.html">17:45</a> <a
														class="show_time_boder" href="booking.html">18:30</a>

												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- ***** Banner End ***** -->


			</div>
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<script>
	function getSelectedCity() {
		console.log('abc');
		var selectedCity = document.getElementById("theaterCity").value; // Lấy giá trị được chọn từ dropdown

		// Gửi giá trị đến controller bằng Axios
		axios.get("${pageContext.request.contextPath}/api/city", {
		    params: {
		        city: selectedCity
		    }
		}).then(function(response) {
    			if (response.status === 200) {
			        var list = response.data;
			        let result = '<option value="all">Tất cả rạp</option>';
			        for (let i = 0; i < list.length; i++) {
			        	result += '<option value="' + list[i].theaterId + '">' + list[i].theaterName + '</option>';
			        }
			        document.getElementById('branch').innerHTML = result;
			        console.log(list);
			    } else {
			        // Xử lý lỗi trạng thái phản hồi
			        console.log("Lỗi khi gọi API");
			    }
		}).catch(function(error) {
	    // Xử lý lỗi
	    console.log("Lỗi khi gọi API: " + error);
		});
	}
	//
	 function getSelectedTheater() {
		console.log('abc');
		var selectedTheater = document.getElementById("branch").value; // Lấy giá trị được chọn từ dropdown
		var selectedMovieId = document.getElementById("movieIDSelect").value;
		// Gửi giá trị đến controller bằng Axios
		axios.get("${pageContext.request.contextPath}/ticket/theaterId", {
		    params: {
		    	theaterId: selectedTheater,
		    	movieId: selectedMovieId
		
		    }
		}).then(function(response) {
    			if (response.status === 200) {
			        var list = response.data;
			        let result = '';
			        for (let i = 0; i < list.length; i++) {
			        	result += '<option value="' + list[i].showtimeId + '">' + list[i].startTime + '</option>';
			        }
			        document.getElementById('showtime').innerHTML = result;
			        console.log(list);
			    } else {
			        // Xử lý lỗi trạng thái phản hồi
			        console.log("Lỗi khi gọi API");
			    }
		}).catch(function(error) {
	    // Xử lý lỗi
	    console.log("Lỗi khi gọi API: " + error);
		});
	}
	
</script>