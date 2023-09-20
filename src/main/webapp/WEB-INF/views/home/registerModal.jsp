<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form id="registerForm" action="${pageContext.request.contextPath}/register"
	modelAttribute="registerForm" method="post"
	onsubmit="return validateForm()">
	<div class="mb-3">
		<!--  <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Họ và tên <span class="text-danger">(*)</span></label> -->
		<input type="text" class="form-control" id="customerName"
			placeholder="Họ tên"> <span id="customerName-error"
			style="color: red;"></span>
	</div>

	<div class="mb-3"
		style="display: flex; justify-content: space-between;">
		<div class="col-6" style="padding-right: 2%;">
			<!--   <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Số điện thoại <span class="text-danger">(*)</span></label> -->
			<input type="tel" class="form-control" id="phone"
				placeholder="Số điện thoại"> <span id="phone-error"
				style="color: red;"></span>
		</div>

		<div class="col-6" style="padding-left: 2%;">
			<!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Giới tính <span class="text-danger">(*)</span></label> -->
			<select class="form-select" id="gender" aria-placeholder="Giới tính">
				<option selected>Chọn giới tính</option>
				<option value="male">Nam</option>
				<option value="female">Nữ</option>
				<option value="other">Khác</option>
			</select> <span id="gender-error" style="color: red;"></span>
		</div>

	</div>

	<div class="mb-3">
		<!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Email <span class="text-danger">(*)</span></label> -->
		<input type="text" class="form-control" id="cccd"
			placeholder="Căn cước công dân"> <span id="cccd-error"
			style="color: red;"></span>
	</div>

	<div class="mb-3">
		<!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Email <span class="text-danger">(*)</span></label> -->
		<input type="email" class="form-control" id="email"
			placeholder="Email"> <span id="email-error"
			style="color: red;"></span>
	</div>

	<div class="mb-3">
		<!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Tên đăng nhập <span class="text-danger">(*)</span></label> -->
		<input type="text" class="form-control" id="account"
			placeholder="Tên đăng nhập"> <span id="account-error"
			style="color: red;"></span>
	</div>

	<div class="mb-3"
		style="display: flex; justify-content: space-between;">

		<div class="col-6" style="padding-right: 2%;">
			<!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Mật khẩu <span class="text-danger">(*)</span></label> -->
			<input type="password" class="form-control" id="password"
				placeholder="Mật khẩu"> <span id="password-error"
				style="color: red;"></span>
		</div>
		<div class="col-6" style="padding-left: 2%;">
			<!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Xác nhận mật khẩu <span class="text-danger">(*)</span></label> -->
			<input type="password" class="form-control" id="repassword"
				placeholder="Xác nhận mật khẩu"> <span id="repassword-error"
				style="color: red;"></span>
		</div>
	</div>
	<div class="mb-2">
		<!-- <label for="disabledTextInput" class="form-label font-weight-bold" style="color: black;">Ngày sinh <span class="text-danger">(*)</span></label> -->
		<input type="text" class="form-control" id="birthDate"
			placeholder="Chọn ngày sinh"> <span id="birthDate-error"
			style="color: red;"></span>
	</div>

	<div class="modal-footer"
		style="display: flex; justify-content: center;">
		<button type="submit" class="btn"
			style="background-color: pink; border-color: pink; color: black;">ĐĂNG
			KÝ</button>
	</div>
</form:form>

<script>
document.getElementById('registerForm').addEventListener('submit', function(e) {
    // Ngăn chặn hành vi mặc định của form
    e.preventDefault();

    // Thu thập dữ liệu từ form
    var customerName = document.getElementById('customerName').value;
    var phone = document.getElementById('phone').value;
    var gender = document.getElementById('gender').value;
    var cccd = document.getElementById('cccd').value;
    var email = document.getElementById('email').value;
    var account = document.getElementById('account').value;
    var password = document.getElementById('password').value;
    var repassword = document.getElementById('repassword').value;
    var birthDate = document.getElementById('birthDate').value;

    // Tạo một đối tượng để chứa dữ liệu
    var formData = {
        customerName: customerName,
        phone: phone,
        gender: gender,
        cccd: cccd,
        email: email,
        account: account,
        password: password,
        repassword: repassword,
        birthDate: birthDate
    };

    // Gửi yêu cầu POST đến server bằng Axios
    axios.post('${pageContext.request.contextPath}/register', formData)
        .then(function (response) {
        	window.location.href = "${pageContext.request.contextPath}/"; 
            console.log(response);
        })
        .catch(function (error) {
            // Xử lý khi yêu cầu thất bại
            console.error(error);
        });
});
</script>