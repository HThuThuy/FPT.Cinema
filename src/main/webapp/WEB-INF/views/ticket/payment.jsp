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

button#applyDiscount {
	width: 137px;
}

input#discountCode {
	width: 200px;
}
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
																		data-reactid="100"> ${se.seatPosition} </span>

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
																		data-reactid="100"> ${se.seatPosition} </span> <input
																		type="hidden" name="seatId"
																		value="${se.seatId.seatId}" />
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
																		data-reactid="100"> ${se.seatPosition} </span> <input
																		type="hidden" name="seatId"
																		value="${se.seatId.seatId}" />
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
										<a href="#chonDichVu">Tiếp theo!</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- ***** Details End ***** -->
			<div class="container-fluid" id="chonDichVu">
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
																	<input type="hidden" class="serviceId" value="${sr.serviceId}">
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
												<div id="infor" class="row p-2 d-flex align-items-center">
													<span class="col-2">Mã giảm giá:</span>
													<div class="col">
														<input type="text" id="discountCode" class="form-control"
															placeholder="Nhập mã giảm giá">
													</div>
													<div class="col">
														<button class="btn btn-primary" id="applyDiscount">Áp
															dụng</button>
													</div>
												</div>
												<div id="discountMessage"></div>

											</div>
										</div>
									</div>


									<div class="col-lg-12 btn-tieptheo">
										<div class="main-border-button">
											<a id="datVeButton">Thanh Toán</a>
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

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>

$(document).ready(function() {
    // Phần chọn và tính tiền ghế 
    const seats = $('.layout__seat');
    let selectedSeats = [];
    let totalSeatPrice = 0;

    seats.on('click', function() {
        $(this).toggleClass('layout__seat--selected');

        if (!selectedSeats.includes(this)) {
            selectedSeats.push(this);
            totalSeatPrice += calculateSeatPrice(this);
            $(this).addClass('selected');
        } else {
            selectedSeats = selectedSeats.filter(selectedSeat => selectedSeat !== this);
            totalSeatPrice -= calculateSeatPrice(this);
            $(this).removeClass('selected');
        }

        updateSelectedSeatsInfo();
        updateTotalPrice();
        updatePaymentInfo();
    });

    function calculateSeatPrice(seat) {
        const isMiddleSeat = $(seat).hasClass('middle-seat');
        const price = isMiddleSeat ? 90000 : 80000;
        return price;
    }

    function updateSelectedSeatsInfo() {
        const selectedSeatsElement = $('#selectedSeats');
        const selectedSeatsFormElement = $('#selectedSeatsForm');
        const selectedSeatsText = selectedSeats.map(seat => $(seat).find('.layout__seat__name').text()).join(', ');

        selectedSeatsElement.text(selectedSeatsText);
        selectedSeatsFormElement.text('Ghế đã chọn: ' + selectedSeatsText);

        const totalSelectedSeatsElement = $('#totalSelectedSeats');
        totalSelectedSeatsElement.text(selectedSeats.length);
    }

    function updateTotalPrice() {
        const totalPriceElement = $('#totalPrice');
        totalPriceElement.text(formatNumber(totalSeatPrice) + ' VND');
        updatePaymentInfo();
    }

    // Cập nhật giá khi thay đổi số lượng combo
    var comboQuantities = $('.combo-quantity');
    comboQuantities.on('input', function() {
        updateComboTotal(this);
        updatePaymentInfo();
        updateTotalPrice();
    });

    // Giảm số lượng combo
    var minusButtons = $('.minus');
    minusButtons.on('click', function() {
        var quantityInput = $(this).next();
        var quantityValue = parseInt(quantityInput.val());
        if (quantityValue > 0) {
            quantityInput.val(quantityValue - 1);
            updateComboTotal(quantityInput);
            updatePaymentInfo();
        }
    });

    // Tăng số lượng combo
    var plusButtons = $('.plus');
    plusButtons.on('click', function() {
        var quantityInput = $(this).prev();
        var quantityValue = parseInt(quantityInput.val());
        quantityInput.val(quantityValue + 1);
        updateComboTotal(quantityInput);
        updatePaymentInfo();
    });

    // Cập nhật tổng tiền của combo
    function updateComboTotal(input) {
        var quantity = parseInt($(input).val());
        var priceElement = $(input).parent().next();
        var price = parseInt(priceElement.text().replace(',', ''));
        var total = quantity * price;
        var totalPriceElement = $(input).parent().next().next();
        totalPriceElement.text(total);
    }

    // Cập nhật thông tin thanh toán
   function updatePaymentInfo() {
    var comboQuantities = $('.combo-quantity');
    var comboDetails = [];
    var totalAmount = totalSeatPrice; // Initialize with total seat price

    comboQuantities.each(function() {
        var quantity = parseInt($(this).val());
        if (quantity > 0) {
        	var comboNameElement = $(this).parent().parent().find('td:nth-child(2)'); // Lấy cột thứ 2
        	var comboNameText = comboNameElement.find('b').text().trim(); // Lấy nội dung của thẻ <b>

            var comboPrice = parseInt($(this).parent().next().text().replace(',', ''));
            var totalComboPrice = quantity * comboPrice;

        	comboDetails.push({ name: comboNameText, quantity: quantity });
            totalAmount += totalComboPrice;
        }
    });

    var totalElement = $('#total');
    var comboElement = $('#combo');

    comboElement.html(comboDetails.map(combo => combo.name + ' x ' + combo.quantity).join(', '));

    totalElement.text(formatNumber(totalAmount) + ' VND');
}


    // Hàm định dạng số thành dạng "80.000"
    function formatNumber(number) {
        const formattedNumber = number.toLocaleString('vi-VN');
        return formattedNumber;
    }
});

$(document).ready(function() {
    $('#applyDiscount').on('click', function() {
        var discountCode = $('#discountCode').val();

        if (discountCode === 'MAGIAMGIA123') {
            var totalElement = $('#total');
            var totalPriceText = totalElement.text();
            var totalPrice = parseFloat(totalPriceText.replace(' VND', '').replace(/\./g, '').replace(',', '.'));

            var discountAmount = 15; // Phần trăm giảm giá
            var newTotalPrice = totalPrice - (totalPrice * (discountAmount / 100));

            // Định dạng lại số với dấu chấm phân cách phần nghìn
           newTotalPrice = newTotalPrice.toLocaleString('vi-VN') + ' VND';


            totalElement.text(newTotalPrice);

            // Hiển thị thông báo
            $('#discountMessage').text('Mã giảm giá đã được áp dụng!');
        } else {
            // Hiển thị thông báo
            $('#discountMessage').text('Mã giảm giá không hợp lệ. Vui lòng kiểm tra lại!');
        }
    });
});


//Phần thanh toán
let paymentInfo = {

status: '',
service:[],
seat: []
};
//Lấy ghế
const seatElements = document.querySelectorAll('.layout__seat');
seatElements.forEach((divElement) => {
  divElement.addEventListener('click', function() {
    const seatId = this.querySelector('input[name="seatId"]').value;
    const seatIndex = paymentInfo.seat.indexOf(seatId);

    if (seatIndex === -1) {
      paymentInfo.seat.push(seatId);
      console.log(paymentInfo.seat);
    } else {
      paymentInfo.seat.splice(seatIndex, 1);
      console.log(paymentInfo.seat);
    }
  });
});
	

//Lấy serviceId khi dấu + chỗ combo được click

var plusButtons = $('.plus');
plusButtons.on('click', function() {
  var quantityInput = $(this).prev();
  var quantityValue = parseInt(quantityInput.val());

  if (quantityValue >= 0) {
    var serviceId = $(this).closest('tr').find('.serviceId').val();

    if (!paymentInfo.service.includes(serviceId)) {
      paymentInfo.service.push(serviceId);
      console.log(paymentInfo.service);
    }
  }
});

var minusButtons = $('.minus');
minusButtons.on('click', function() {
  var quantityInput = $(this).next();
  var quantityValue = parseInt(quantityInput.val());

  if (quantityValue < 1) {
    var serviceId = $(this).closest('tr').find('.serviceId').val();
    paymentInfo.service = paymentInfo.service.filter(id => id !== serviceId);
    console.log(paymentInfo.service);
  }
});


//Thanh toán
let totalPrices = 100000; 
document.getElementById('datVeButton').addEventListener('click', () => {
	let currentDate = new Date();
	let localDate = currentDate.toLocaleDateString();
	let localTime = currentDate.toLocaleTimeString();

	
	paymentInfo.status = 'Booked';
  console.log(paymentInfo);
  var jsonString = JSON.stringify(paymentInfo);
  console.log(jsonString);
	var url = 'http://localhost:6001/FPT-Cinema/payment/create?param1=' + encodeURIComponent(totalPrices) + '&param2=' + encodeURIComponent(jsonString);
	console.log(url)
	  // Redirect đến URL
	window.location.href = url;
  });
  
</script>


