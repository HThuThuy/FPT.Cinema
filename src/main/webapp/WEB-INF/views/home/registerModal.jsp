<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<form action="/FPT-Cinema/register" method="post" onsubmit="return validateForm()">
	<div class="mb-3">
	   <!--  <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Họ và tên <span class="text-danger">(*)</span></label> -->
		<input type="text" class="form-control" id="fullname" placeholder="Họ tên">
	    <span id="fullname-error" style="color: red;"></span>
	</div>
	
	<div class="mb-3" style="display: flex; justify-content: space-between;">
		<div class="col-6" style="padding-right: 2%;">
			<!--   <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Số điện thoại <span class="text-danger">(*)</span></label> -->
			<input type="tel" class="form-control" id="phone" placeholder="Số điện thoại">
			 <span id="phone-error" style="color: red;"></span>
		</div>
		
		<div class="col-6" style="padding-left: 2%;">
			  <!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Giới tính <span class="text-danger">(*)</span></label> -->
			<select
				class="form-select" id="gender" aria-placeholder="Giới tính">
				<option selected>Chọn giới tính</option>
				<option value="male">Nam</option>
				<option value="female">Nữ</option>
				<option value="other">Khác</option>
			</select>
			<span id="gender-error" style="color: red;"></span>
		</div>
		
	</div>

	<div class="mb-3">
		<!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Email <span class="text-danger">(*)</span></label> -->
		<input type="email" class="form-control" id="email" placeholder="Email">
		<span id="email-error" style="color: red;"></span>
	</div>
	
	<div class="mb-3">
		<!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Tên đăng nhập <span class="text-danger">(*)</span></label> -->
		<input type="text" class="form-control" id="username" placeholder="Tên đăng nhập">
		<span id="username-error" style="color: red;"></span>
	</div>
	
	<div class="mb-3"
		style="display: flex; justify-content: space-between;">

		<div class="col-6" style="padding-right: 2%;">
			<!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Mật khẩu <span class="text-danger">(*)</span></label> -->
			<input type="password" class="form-control" id="register-password" placeholder="Mật khẩu">
			<span id="password-error" style="color: red;"></span>
		</div>
		<div class="col-6" style="padding-left: 2%;">
			<!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Xác nhận mật khẩu <span class="text-danger">(*)</span></label> -->
			<input type="password" class="form-control" id="confirm-password" placeholder="Xác nhận mật khẩu">
			<span id="confirm-password-error" style="color: red;"></span>
		</div>
	</div>
	<div class="mb-2">
		<!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Ngày sinh <span class="text-danger">(*)</span></label> -->
		<input type="text" class="form-control" id="birthdate" placeholder="Chọn ngày sinh">
		<span id="birthdate-error" style="color: red;"></span>
	</div>

	<div class="modal-footer"
		style="display: flex; justify-content: center;">
		<button type="submit" class="btn"
			style="background-color: pink; border-color: pink; color: black;">ĐĂNG
			KÝ</button>
	</div>
</form>

<script>
$(document).ready(function() {
    $('form').on('submit', function(event) {
      var isValid = true;

      // Validate fullname
     	var fullname = $('#fullname').val();
		var fullnameRegex = /^[A-Za-z\s]+$/;
		
		// Kiểm tra xem họ tên có được nhập hay không
		if (fullname == "") {
		    $('#fullname-error').text('Vui lòng nhập Họ và tên');
		    isValid = false;
		} 
		// Kiểm tra định dạng của họ tên
		else if (!fullnameRegex.test(fullname) || fullname.length < 6 || fullname.length > 50) {
		    $('#fullname-error').text('Họ Tên Sai Định Dạng !');
		    isValid = false;
		} 
		else {
		    $('#fullname-error').text('');
		}

		// Validate phone
		var phone = $('#phone').val();
		var phoneRegex = /^0[0-9]{9}$/;
		if (phone == "") {
		  $('#phone-error').text('Vui lòng nhập số điện thoại');
		  isValid = false;
		} else if (!phoneRegex.test(phone)) {
		  $('#phone-error').text('SĐT Sai Định Dạng !');
		  isValid = false;
		} else {
		  $('#phone-error').text('');
		}
		
		// Validate giới tính
		  var gender = $('#gender').val();
	        if (gender == "Chọn giới tính") {
	            $('#gender-error').text('Vui lòng chọn giới tính');
	            isValid = false;
	        } else {
	            $('#gender-error').text('');
	        }
	        
		// Validate email
		var email = $('#email').val();
		var emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
		if (email == "") {
		  $('#email-error').text('Vui lòng nhập Email');
		  isValid = false;
		} else if (!emailRegex.test(email)) {
		  $('#email-error').text('Email Sai Định Dạng !');
		  isValid = false;
		} else {
		  $('#email-error').text('');
		}

		// Validate username
		var username = $('#username').val();
		var usernameRegex = /^[a-zA-Z0-9]{6,20}$/;
		if (username == "") {
		  $('#username-error').text('Vui lòng nhập Tên đăng nhập');
		  isValid = false;
		/* } else if (!usernameRegex.test(username)) {
		  $('#username-error').text('UserName Có Độ Dài Từ 6-20 Ký Tự Và Không Được Chứa Kí Tự Đặc Biệt !');
		  isValid = false; */
		} else {
		  $('#username-error').text('');
		}

		// Validate password
		var password = $('#register-password').val();
		var passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,20}$/;
		if (password == "") {
		  $('#password-error').text('Vui lòng nhập Mật khẩu');
		  isValid = false;
		/* } else if (!passwordRegex.test(password)) {
		  $('#password-error').text('Mật Khẩu Phải Bao Gồm 1 Kí Tự Viết Hoa, Viết Thường Và 1 Ký Tự Đặc Biệt !');
		  isValid = false; */
		} else {
		  $('#password-error').text('');
		}

		
		// Validate confirm password
		var confirmPassword = $('#confirm-password').val();
		if (confirmPassword == "") {
		  $('#confirm-password-error').text('Vui lòng nhập lại mật khẩu');
		  isValid = false;
		} else if (password != confirmPassword) {
		  $('#confirm-password-error').text('Mật Khẩu Phải Trùng Với Mật Khẩu Bạn Đã Nhập !');
		  isValid = false;
		} else {
		  $('#confirm-password-error').text('');
		}

		// Validate birth date
		var birthdate = new Date($('#birthdate').val());
		var today = new Date();

		if (birthdate == "") {
		    $('#birthdate-error').text('Vui lòng nhập Ngày sinh');
		    isValid = false;
		} else if (birthdate >= today) {
		    $('#birthdate-error').text('Ngày sinh phải nhỏ hơn ngày hiện tại');
		    isValid = false;
		} else {
		    $('#birthdate-error').text('');
		}

      // Prevent form submission if validation failed
      if (!isValid) {
        event.preventDefault();
      }
    });
});
</script>