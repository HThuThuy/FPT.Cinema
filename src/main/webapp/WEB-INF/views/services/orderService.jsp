
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Order Service</title>
<style>
#payment-info {
    text-align: center;
}
table{
    background: transparent;
    width: 100%;


}
#img-movie{
    width: 100%;
    height: 100%;
}

#infor{
    border-bottom: 1px solid rgb(145, 145, 145) ;
    border-style: dashed;
}
th,td{
    color: white;
    text-align: center;

}

tr {
    border-bottom: 1px solid white;
}



button{
    background: none;
    border: none;
}

input{
    width: 50px;
    height: 30px;
    text-align: center;   
}

h2{
color:white;
}

h3{
color: white;
}

span{
color: white;
}

</style>
</head>
<body>

    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="page-content">
                    <!-- ***** Details Service ***** -->
                    <div class="game-details">
                        <div class="row">
                            <div class="col-lg-12">
                                <h2>SERVICE ORDER</h2>
                            </div>
                            <div class="col-lg-12">
                                <div class="content">
                                <h2>${sr.getServiceName()}</h2>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <table>
                                                <thead>
                                                    <tr>
                                                        <th width="20%">Combo</th>
                                                        <th width="20%">serviceDescription</th>
                                                        <th width="40%">Quantity</th>
                                                        <th width="20%">Price</th>
                                                        <th width="20%">Total Price</th>
                                                    </tr>
                                                </thead>
												<tbody>
													<c:forEach var="sr" items="${lists}">
														<tr class="align-middle">
															<td>${sr.getServiceName()}</td>
															<td>${sr.serviceDescription}</td>
															<td>
																<button type="button" class="minus">
																	<i class="fas fa-minus-circle fa-lg"
																		style="color: #ffffff;"></i>
																</button> <input type="number" value="0" id="combo1Quantity"
																class="combo-quantity">
																<button type="button" class="plus">
																	<i class="fas fa-plus-circle fa-lg"
																		style="color: #ffffff;"></i>
																</button>
															</td>
															<td>${sr.servicePrice}</td>
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
                        </div>
                                    <div class="content mt-4">
                                          <div class="row">
                                    <div class="col-lg-5">
                                      <img src="${pageContext.request.contextPath}/resources/img/movie2.avif">
                                    </div>

                                    <div class="col-lg-7">
                                      <div class="row"><h3>STAR WARS: ROGUE ONE</h3></div>
                                      <div id="infor" class="row p-2 mt-4"><span>Rạp: FPT Cinema Đà Nẵng | RẠP 2</span></div>
                                      <div id="infor" class="row p-2"><span>Suất chiếu: 19:30 | Thứ 2, 15/09/2023</span></div>
                                      <div id="infor" class="row p-2"><span>Ghế: G2, G3</span></div>
                                      <div id="infor" class="row p-2 d-flex flex-row">
                                        <span class="col-2">Combo:</span> 
                                        <span class="col-10" id="combo"></span>
                                      </div>
                                      <div id="infor" class="row p-2 d-flex flex-row">
                                        <span class="col-2">Tổng:</span> 
                                        <span class="col-10" id="total" >0</span>
                                      </div>




                                    </div>

                                  </div>

                                </div>
                             <div class="col-lg-12">
                                    <div class="main-border-button">
                                      <a href="ticket.html">Thanh toán!</a>
                                    </div>
                                </div>

                    </div>
                    
                </div>
               
            </div>
        </div>
    </div>
</body>

 <script>

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

	  
	   

	    combos.forEach(function(combo) {
	        var quantity = parseInt(combo.value);
	        if (quantity > 0) {
	            var comboName = combo.parentElement.parentElement.querySelector('td:first-child').textContent.trim();
	            var comboPrice = parseInt(combo.parentElement.nextElementSibling.textContent.replace(',', ''));
	            var totalComboPrice = quantity * comboPrice;

	            comboDetails.push({name: comboName, quantity: quantity});  // Thêm thông tin combo vào mảng
	            totalAmount += totalComboPrice;
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
    </script>
    <script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
</html>