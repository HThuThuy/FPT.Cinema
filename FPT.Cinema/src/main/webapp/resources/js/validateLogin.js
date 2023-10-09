$(document).ready(function() {
    $('form').on('submit', function(event) {
      var isValid = true;

      // Validate fullname
     	var customerName = $('#customerName').val();
		var customerNameRegex = /^[A-Za-z\s]+$/;
		
		// Kiểm tra xem họ tên có được nhập hay không
		if (customerName == "") {
		    $('#customerName-error').text('Vui lòng nhập Họ và tên');
		    isValid = false;
		} 
		// Kiểm tra định dạng của họ tên
		else if (!customerNameRegex.test(customerName) || customerNameRegex.length < 6 || customerNameRegex.length > 50) {
		    $('#customerName-error').text('Họ Tên Sai Định Dạng !');
		    isValid = false;
		} 
		else {
		    $('#customerName-error').text('');
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
		var account = $('#account').val();
		var accountRegex = /^[a-zA-Z0-9]{6,20}$/;
		if (account == "") {
		  $('#account-error').text('Vui lòng nhập Tên đăng nhập');
		  isValid = false;
		/* } else if (!usernameRegex.test(username)) {
		  $('#username-error').text('UserName Có Độ Dài Từ 6-20 Ký Tự Và Không Được Chứa Kí Tự Đặc Biệt !');
		  isValid = false; */
		} else {
		  $('#account-error').text('');
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
		var repassword = $('#repassword').val();
		if (repassword == "") {
		  $('#repassword-error').text('Vui lòng nhập lại mật khẩu');
		  isValid = false;
		} else if (password != confirmPassword) {
		  $('#repassword-error').text('Mật Khẩu Phải Trùng Với Mật Khẩu Bạn Đã Nhập !');
		  isValid = false;
		} else {
		  $('#repassword-error').text('');
		}

		// Validate birth date
		var birthDate = new Date($('#birthDate').val());
		var today = new Date();

		if (birthdate == "") {
		    $('#birthDate-error').text('Vui lòng nhập Ngày sinh');
		    isValid = false;
		} else if (birthdate >= today) {
		    $('#birthDate-error').text('Ngày sinh phải nhỏ hơn ngày hiện tại');
		    isValid = false;
		} else {
		    $('#birthDate-error').text('');
		}

      // Prevent form submission if validation failed
      if (!isValid) {
        event.preventDefault();
      }
    });
});