<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container2">
	<div class="row">
		<div class="col-lg-12">
			<div class="page-content">



				<!-- ***** Details Start ***** -->
				<div class="game-details">
					<div class="row">
						<div class="col-lg-12">
							<h2>TICKETS ORDER</h2>
						</div>
						<div class="col-lg-12">
							<div class="content">
								<div class="row">
									<div class="col-lg-12">
										<div class="main-profile ">
											<div class="row">
												<div class="col-lg-4 align-self-center">
													<img src="assets/images/profile.jpg" alt=""
														style="border-radius: 23px;">
												</div>
												<div class="col-lg-4 align-self-center">
													<div class="main-info header-text">
														<h4>Kẻ ẩn danh</h4>
														<p>
															Đạo diễn: Trần Trọng Dần <br> Thể loại: Hài, Gia
															Đình, Hành Động <br> Diễn viên: Kiều Minh Tuấn, Quốc
															Trường, Vân Trang, Mạc Văn Khoa <br> Quốc gia: Việt
															Nam <br> Ngày khởi chiếu: 25/8/2023
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
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12">
									<div
										class="d-flex justify-content-center align-items-center mt-4">
										<h4>Danh sách ghế ngồi</h4>
									</div>
									<div class="left-info">
										
										<div class="layout" data-reactid="91">
											<ul class="layout__grid" data-reactid="92">
												<c:forEach var="se" items="${listSeat}" varStatus="status">
													<c:if test="${status.index % 10 == 0}">
														<li class="layout__row" tabindex="0" aria-expanded="false"
															data-reactid="93">
															<ul class="layout__row__columns" data-reactid="97">
													</c:if>
													<c:choose>

														<c:when test="${se.seatStatus == 'Da dat'}">
															<li class="layout__column" data-reactid="98">
																<div
																	aria-label="Row 1, Seat ${status.index + 1} - Love seat left."
																	aria-checked="false" aria-hidden="true"
																	class="layout__seat layout__seat--love-seat-left"
																	role="checkbox" tabindex="-1" data-reactid="99"
																	style="background: #aaa; color: black;">
																	<span aria-hidden="false" class="layout__seat__name"
																		data-reactid="100"> ${se.seatPositon} </span>
																</div>
															</li>
														</c:when>
															<c:when test="${se.seatType == 'VIP'}">
															<li class="layout__column" data-reactid="98">
																<div
																	aria-label="Row 1, Seat ${status.index + 1} - Love seat left."
																	aria-checked="false" aria-hidden="true"
																	class="layout__seat layout__seat--love-seat-left"
																	role="checkbox" tabindex="-1" data-reactid="99"
																	style="background: rgb(93, 57, 164); color: black;">
																	<span aria-hidden="false" class="layout__seat__name"
																		data-reactid="100"> ${se.seatPositon} </span>
																</div>
															</li>
														</c:when>
														<c:otherwise>
															<li class="layout__column" data-reactid="98">

																<div
																	aria-label="Row 1, Seat ${status.index + 1} - Love seat left."
																	aria-checked="false" aria-hidden="true"
																	class="layout__seat layout__seat--love-seat-left"
																	role="checkbox" tabindex="-1" data-reactid="99">
																	<span aria-hidden="false" class="layout__seat__name"
																		data-reactid="100"> ${se.seatPositon} </span>
																</div>


															</li>
														</c:otherwise>

													</c:choose>
													
													<c:if test="${(status.index + 1) % 10 == 0 or status.last}">
											</ul>
											</li>
											</c:if>
											</c:forEach>
											</ul>


										</div>


									</div>
								</div>
								<div class="background_outside">
									<div class="background_inside">
										<!-- Hiển thị thông tin ghế đã chọn -->
										<div>
											Ghế đã chọn: <span id="selectedSeats"></span>
										</div>

										<!-- Hiển thị tổng số ghế đã chọn -->
										<div style="display: flex;">
											<div style="width: 40%;">
												Tổng ghế đã chọn: <span id="totalSelectedSeats"></span>
											</div>
											<div style="width: 60%; display: flex;">
												Ghế bạn chọn:
												<div
													style="width: 20px; height: 20px; background: red; margin: 0px 20px;"></div>
												Ghế đã có người chọn:
												<div
													style="width: 20px; height: 20px; background: #aaa; margin: 0px 20px;"></div>
												Ghế trống:
												<div
													style="width: 20px; height: 20px; background: white; margin: 0px 20px;">
												</div>
												Ghế VIP:
												<div
													style="width: 20px; height: 20px; background: rgb(93, 57, 164); margin: 0px 20px;">
												</div>
											</div>
										</div>

										<!-- Hiển thị tổng số tiền -->
										<div>
											Tổng tiền: <span id="totalPrice"></span>
										</div>
									</div>
								</div>
								<div class="col-lg-12">
									<div class="main-border-button">
										<a href="${pageContext.request.contextPath}/ticket/bill">Tiếp
											theo!</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- ***** Details End ***** -->
			<div class="row"></div>


		</div>
	</div>
</div>

<script>

    // Lấy tất cả các phần tử ghế trong danh sách
    const seats = document.querySelectorAll('.layout__seat');

    // Khởi tạo các biến để lưu trữ thông tin ghế đã chọn
    let selectedSeats = [];
    let totalPrice = 0;
    
    // Lặp qua từng phần tử ghế và gắn sự kiện click
    seats.forEach((seat) => {
      seat.addEventListener('click', () => {
        seat.classList.toggle('layout__seat--selected');
        // Kiểm tra xem ghế đã được chọn hay chưa
        if (!selectedSeats.includes(seat)) {
          // Thêm ghế vào danh sách đã chọn
          selectedSeats.push(seat);
          // Tăng tổng số tiền
          totalPrice += calculateSeatPrice(seat); // Hãy sửa hàm tính giá ghế tương ứng với logic của bạn
          // Thêm class hoặc hiệu ứng để đánh dấu ghế đã chọn
          seat.classList.add('selected');
        } else {
          // Xóa ghế khỏi danh sách đã chọn
          selectedSeats = selectedSeats.filter((selectedSeat) => selectedSeat !== seat);
          // Giảm tổng số tiền
          totalPrice -= calculateSeatPrice(seat); // Hãy sửa hàm tính giá ghế tương ứng với logic của bạn
          // Xóa class hoặc hiệu ứng đánh dấu ghế đã chọn
          seat.classList.remove('selected');
        }

        // Cập nhật thông tin ghế đã chọn, tổng số ghế và tổng số tiền trên giao diện
        updateSelectedSeatsInfo();
        updateTotalPrice();
      });
    });

    // Hàm tính giá ghế tương ứng với logic của bạn
    function calculateSeatPrice(seat) {
      // Lấy giá ghế dựa trên vị trí của ghế
      // Ví dụ: ghế ở giữa có giá 90000, còn lại có giá 80000
      const isMiddleSeat = seat.classList.contains('middle-seat');
      const price = isMiddleSeat ? 90000 : 80000;
      return price;
    }

    // Hàm cập nhật thông tin ghế đã chọn trên giao diện
    function updateSelectedSeatsInfo() {
      const selectedSeatsElement = document.getElementById('selectedSeats');
      selectedSeatsElement.textContent = selectedSeats.map((seat) => seat.querySelector('.layout__seat__name').textContent).join(', ');

      // Cập nhật tổng số ghế đã chọn
      const totalSelectedSeatsElement = document.getElementById('totalSelectedSeats');
      totalSelectedSeatsElement.textContent = selectedSeats.length;
    }

    // Hàm cập nhật tổng số tiền trên giao diện
    function updateTotalPrice() {
      const totalPriceElement = document.getElementById('totalPrice');
      totalPriceElement.textContent = totalPrice.toFixed(2); // Hiển thị tổng số tiền với hai chữ số thập phân
    }

// Hàm định dạng số thành dạng "80.000"
function formatNumber(number) {
  // Sử dụng hàm toLocaleString() để định dạng số và chuyển đổi thành chuỗi
  const formattedNumber = number.toLocaleString('vi-VN');
  return formattedNumber;
}

// Hàm cập nhật tổng số tiền trên giao diện
function updateTotalPrice() {
  const totalPriceElement = document.getElementById('totalPrice');
  totalPriceElement.textContent = formatNumber(totalPrice) + ' VND';
}
  </script>