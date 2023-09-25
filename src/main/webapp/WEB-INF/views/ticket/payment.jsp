<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
#payment-info {
	text-align: center;
}

table {
	background: transparent;
	width: 100%;
	border-spacing: 10px;
}

#img-movie {
	width: 100%;
	height: 100%;
}

#infor {
	border-bottom: 1px solid rgb(145, 145, 145);
	border-style: dashed;
}

th, td {
	color: white;
	text-align: center;
	padding: 10px;
}

thead {
	background-color: #ec6090;
	margin-top: -50px;
}

table {
	margin-top: -50px;
}

tr {
	border-bottom: 1px solid white;
}

button {
	background: none;
	border: none;
}

input {
	width: 50px;
	height: 30px;
	text-align: center;
}

h2 {
	color: white;
}

h3 {
	color: white;
}

.main-border-button {
	width: 250px;
}

.col-lg-12.btn-tieptheo {
	display: flex;
	justify-content: center;
}

span {
	color: white;
}

.combo-quantity {
	width: 60px; /* Đặt chiều rộng tùy ý */
	height: 40px; /* Đặt chiều cao tùy ý */
	text-align: center; /* Căn giữa nội dung */
}
</style>
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
								<div class="col-lg-12 btn-tieptheo">
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
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="page-content">
							<div class="game-details">
								<div class="row">
									<div class="col-lg-12"></div>
									<div class="col-lg-12">
										<div class="content">
											<h2>${sr.getServiceName()}</h2>
											<div class="row">
												<div class="col-lg-12">
													<table>
														<thead>
															<tr>
																<th width="20%">Combo</th>
																<th width="35%"></th>
																<th width="17%">Số lượng</th>
																<th width="15%">Giá (VNĐ)</th>
																<th width="13%">Tổng (VNĐ)</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach var="sr" items="${lists}">
																<tr class="align-middle">
																	<td><img src="${sr.url}" width="100"></td>
																	<td style="text-align: left;"><b>${sr.serviceName}</b>
																		<br> ${sr.serviceDescription}</td>
																	<td>
																		<button type="button" class="minus">
																			<i class="fas fa-minus-circle fa-lg"
																				style="color: #ffffff;"></i>
																		</button> <input type="number" value="0" id="combo1Quantity"
																		class="combo-quantity" min="0" max="999">
																		<button type="button" class="plus">
																			<i class="fas fa-plus-circle fa-lg"
																				style="color: #ffffff;"></i>
																		</button>
																	</td>
																	<td data-combo-price="${sr.servicePrice}">${sr.servicePrice}</td>
																	<td>
																		<div class="total-price">
																			<span id="price">0</span>
																		</div>
																	</td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>


									<div class="content mt-4">
										<div class="row">
											<div class="col-lg-5">
												<img
													src="https://imagizer.imageshack.com/img922/9552/zAIqdi.jpg">
											</div>
											<div class="col-lg-7">
												<div class="row">
													<h3>STAR WARS: ROGUE ONE</h3>
												</div>
												<div id="infor" class="row p-2 mt-4">
													<span>Rạp: FPT Cinema Đà Nẵng | RẠP 2</span>
												</div>
												<div id="infor" class="row p-2">
													<span>Suất chiếu: 19:30 | Thứ 2, 15/09/2023</span>
												</div>
												<div id="infor" class="row p-2">
													<span id="selectedSeatsForm">Ghế đã chọn: </span>
												</div>
												<div id="infor" class="row p-2 d-flex flex-row">
													<span class="col-2">Combo:</span> <span class="col-10"
														id="combo"></span>
												</div>
												<div id="infor" class="row p-2 d-flex flex-row">
													<span class="col-2">Tổng:</span> <span class="col-10"
														id="total">0</span>
												</div>
												<div id="infor" class="row p-2 d-flex flex-row">
												    <span class="col-2">Mã giảm giá:</span>
												    <div class="col-8">
												        <input type="text" id="discountCode" class="form-control" placeholder="Nhập mã giảm giá">
												    </div>
												    <div class="col-2">
												        <button class="btn btn-primary" id="applyDiscount">Áp dụng</button>
												    </div>
												</div>
												
											</div>
										</div>
									</div>


									<div class="col-lg-12 btn-tieptheo">
										<div class="main-border-button">
											<a id="datVeButton"
												>Thanh
												Toán</a>
										</div>
									</div>
								</div>


							</div>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
</div>
<script>
		// giảm giá
		
		document.getElementById('applyDiscount').addEventListener('click', function() {
    var discountCode = document.getElementById('discountCode').value;

    // Kiểm tra mã giảm giá có hợp lệ hay không
    if (discountCode === 'MAGIAMGIA123') {
        // Nếu mã hợp lệ, giảm giá và cập nhật tổng tiền
        var totalElement = document.getElementById('total');
        var totalPrice = parseFloat(totalElement.textContent);
        var discountAmount = 15; // Số tiền giảm giá (đây là ví dụ, bạn có thể thay đổi)

        var newTotalPrice = totalPrice -  (totalPrice*(discountAmount/100));
        totalElement.textContent = newTotalPrice;

        alert('Mã giảm giá đã được áp dụng!');
    } else {
        alert('Mã giảm giá không hợp lệ. Vui lòng kiểm tra lại!');
    }
});
		




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
    const selectedSeatsFormElement = document.getElementById('selectedSeatsForm');
    const selectedSeatsText = selectedSeats.map((seat) => seat.querySelector('.layout__seat__name').textContent).join(', ');

    selectedSeatsElement.textContent = selectedSeatsText;
    selectedSeatsFormElement.textContent = 'Ghế đã chọn: ' + selectedSeatsText;
    
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


//Code Trà viết



 document.addEventListener("DOMContentLoaded", function () {
	  var comboQuantities = document.querySelectorAll('.combo-quantity');

	  comboQuantities.forEach(function (input) {
	    input.addEventListener('input', function () {
	      updateTotalPrice(input);
	      updatePaymentInfo(); 

	    });
	  });

	  var minusButtons = document.querySelectorAll('.minus');
	  var plusButtons = document.querySelectorAll('.plus');

	  minusButtons.forEach(function (button) {
	    button.addEventListener('click', function () {
	      var input = button.nextElementSibling;
	      var value = parseInt(input.value);
	      if (value > 0) {
	        input.value = value - 1;
	        updateTotalPrice(input);
	        updatePaymentInfo(); 

	      }
	    });
	  });

	  plusButtons.forEach(function (button) {
	    button.addEventListener('click', function () {
	      var input = button.previousElementSibling;
	      var value = parseInt(input.value);
	      input.value = value + 1;
	      updateTotalPrice(input);
	      updatePaymentInfo(); 

	    });
	  });

	  function updateTotalPrice(input) {
		  var quantity = parseInt(input.value);
		  var priceElement = input.parentElement.nextElementSibling;
		  var price = parseInt(priceElement.textContent.replace(',', ''));
		  var total = quantity * price;
		  var totalPriceElement = input.parentElement.nextElementSibling.nextElementSibling;
		  totalPriceElement.textContent = total;
		}

	  function updatePaymentInfo() {
		    var combos = document.querySelectorAll('.combo-quantity');
		    var comboDetails = [];  // Mảng chứa thông tin combo (tên và số lượng)
		    var totalAmount = 0;
		    var totalElement = document.getElementById('total');
		 /*    var totalSeatPrice = document.getElementById('totalPrice');
		    var totalPriceValue = parseFloat(totalSeatPrice.innerHTML); */
		    /* var totalSeatPrice = totalPriceElement; */

		    combos.forEach(function(combo) {
		        var quantity = parseInt(combo.value);
		        if (quantity > 0) {	
		        	var comboNameElement = combo.parentElement.parentElement.querySelector('td:nth-child(1)');
		        	var comboNameText = comboNameElement.textContent.trim();


		            var comboPrice = parseInt(combo.parentElement.nextElementSibling.textContent.replace(',', ''));
		            var totalComboPrice = quantity * comboPrice;
					
					
		            comboDetails.push({name: comboNameText, quantity: quantity});  // Thêm thông tin combo vào mảng
		            totalAmount += totalComboPrice + totalPrice;
		        }
		    });

		    var comboElement = document.getElementById('combo');

		    // Hiển thị tên combo và số lượng
		    comboElement.innerHTML = comboDetails.map(function(combo) {
		        return combo.name + ' (' + combo.quantity + ')';
		    }).join(', ');  // Các combo cách nhau bởi dấu phẩy
		 
		    totalElement.textContent = totalAmount.toLocaleString();  // Format tổng tiền
		}

		}); 


//Phần thanh toán
  let paymentInfo = {
  ticketId: 0,
  status: '',
  showtimeTicket: '',
  customer: '',
  order:''
};
  let totalPrices = 100000;
document.getElementById('datVeButton').addEventListener('click', () => {
	let currentDate = new Date();
	let localDate = currentDate.toLocaleDateString();
	let localTime = currentDate.toLocaleTimeString();

	paymentInfo.ticketId = 1;
	paymentInfo.status = 'Booked';
	paymentInfo.showtimeTicket = '1';
	paymentInfo.customer = '111111111111';
	paymentInfo.order = '1';
    console.log(paymentInfo);
    var jsonString = JSON.stringify(paymentInfo);
    console.log(jsonString);
	var url = 'http://localhost:6001/FPT-Cinema/payment/create?param1=' + encodeURIComponent(totalPrices) + '&param2=' + encodeURIComponent(jsonString);
	console.log(url)
	  // Redirect đến URL
	window.location.href = url;
    });
  </script>