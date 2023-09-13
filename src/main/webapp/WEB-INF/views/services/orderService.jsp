<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <table>
                                                <thead>
                                                    <tr>
                                                        <th width="20%">Combo</th>
                                                        <th width="40%">Quantity</th>
                                                        <th width="20%">Price</th>
                                                        <th width="20%"">Total Price</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td> <img src="assets/images/combo1.webp" alt=""
                                                                class="templatemo-item"> combo1</td>
                                                        <td>
                                                            <button type="button" class="minus"><i
                                                                    class="fas fa-minus-circle fa-lg"
                                                                    style="color: #ffffff;"></i></button>
                                                            <input type="number" value="0" id="combo1Quantity"
                                                                class="combo-quantity" data-price="10000">
                                                            <button type="button" class="plus"><i
                                                                    class="fas fa-plus-circle fa-lg"
                                                                    style="color: #ffffff;"></i></button>

                                                        </td>
                                                        <td>10,000</td>
                                                        <td>
                                                            <div class="total-price">
                                                                <span id="price">0</span>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td> <img src="assets/images/combo1.webp" alt=""
                                                                class="templatemo-item"> combo2</td>
                                                        <td>
                                                            <button type="button" class="minus"><i
                                                                    class="fas fa-minus-circle fa-lg"
                                                                    style="color: #ffffff;"></i></button>
                                                            <input type="number" value="0" id="combo1Quantity"
                                                                class="combo-quantity" data-price="15000">
                                                            <button type="button" class="plus"><i
                                                                    class="fas fa-plus-circle fa-lg"
                                                                    style="color: #ffffff;"></i></button>

                                                        </td>
                                                        <td>15,000</td>
                                                        <td>
                                                            <div class="total-price">
                                                                <span id="price">0</span>
                                                            </div>
                                                        </td>
                                                    </tr>

                                                </tbody>
                                            </table>


                                        </div>

                      
                                    </div>
                                </div>

                            </div>
                        </div>
                                    <div class="content mt-4">
                                    <div id="payment-info">
                                        <h3>Phiếu Thanh Toán</h3>
                                        <table>
                                            <thead>
                                                <tr>
                                                    <th scope="col">Combo</th>
                                                    <th scope="col">Số Lượng</th>
                                                    <th scope="col">Tổng Tiền</th>
                                                </tr>
                                            </thead>
                                            <tbody id="payment-details">
                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <td colspan="2"><strong>Tổng Tiền:</strong></td>
                                                    <td id="total-amount">0</td>
                                                </tr>
                                            </tfoot>
                                        </table>
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
    var price = parseInt(input.dataset.price);
    var total = quantity * price;
    var totalPriceElement = input.parentElement.nextElementSibling.nextElementSibling;
    totalPriceElement.textContent = total;
  }

  function updatePaymentInfo() {
	    var paymentDetails = document.getElementById('payment-details');
	    var totalAmountElement = document.getElementById('total-amount');
	    var combos = document.querySelectorAll('.combo-quantity');

	    paymentDetails.innerHTML = '';

	    var totalAmount = 0;

	    combos.forEach(function(combo) {
	        var quantity = parseInt(combo.value);
	        if (quantity > 0) {
	            var comboName = combo.parentElement.parentElement.querySelector('td:first-child').textContent.trim();
	            var comboPrice = parseInt(combo.parentElement.nextElementSibling.textContent.replace(',', ''));
	            var totalComboPrice = quantity * comboPrice;
	            totalAmount += totalComboPrice;

	            var row = document.createElement('tr');
	            var td1 = document.createElement('td');
	            var td2 = document.createElement('td');
	            var td3 = document.createElement('td');

	            td1.textContent = comboName;
	            td2.textContent = quantity;
	            td3.textContent = totalComboPrice.toLocaleString();

	            row.appendChild(td1);
	            row.appendChild(td2);
	            row.appendChild(td3);

	            paymentDetails.appendChild(row);
	        }
	    });

	    totalAmountElement.textContent = totalAmount.toLocaleString();
	}
});

    </script>
    <script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
</html>