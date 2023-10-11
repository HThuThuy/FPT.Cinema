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
		
		// Validate cccd
		var cccd = $('#cccd').val();
		var cccdRegex = /^[0-9]{12}$/;
		if (cccd == "") {
		  $('#cccd-error').text('Vui lòng nhập căn cước công dân');
		  isValid = false;
		} else if (!cccdRegex.test(cccd)) {
		  $('#cccd-error').text('CCCD Sai Định Dạng !');
		  isValid = false;
		} else {
		  $('#cccd-error').text('');
		}
		
		// Validate giới tính
		var gender = $('#gender').val();
		if (gender == "") {
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
		var password = $('#passwordRegister').val();
		if (password == "") {
		  $('#passwordRegister-error').text('Vui lòng nhập Mật khẩu');
		  isValid = false;
		} else {
		  $('#passwordRegister-error').text('');
		}
	
		// Validate repassword
		var password = $('#passwordRegister').val();
		var repasswordRegister = $('#repasswordRegister').val();
		if (repasswordRegister == "") {
		  $('#repasswordRegister-error').text('Vui lòng nhập lại mật khẩu');
		  isValid = false;
		} else if (repasswordRegister != password) {
		  $('#repasswordRegister-error').text('Mật Khẩu Phải Trùng Với Mật Khẩu Bạn Đã Nhập !');
		  isValid = false;
		} else {
		  $('#repasswordRegister-error').text('');
		}

		// Validate birth date
		var birthDate = new Date($('#birthDate').val());
		var today = new Date();
		
		if (isNaN(birthDate.getTime())) {
		    $('#birthDate-error').text('Vui lòng nhập Ngày sinh');
		    isValid = false;
		} else if (birthDate >= today) {
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