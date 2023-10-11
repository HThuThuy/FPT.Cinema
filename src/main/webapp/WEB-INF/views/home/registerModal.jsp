<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form id="registerForm"
	action="${pageContext.request.contextPath}/register"
	modelAttribute="registerForm" method="post"
	onsubmit="return validateForm()">
	<div class="mb-3">
		<input type="text" class="form-control" id="customerName"
			placeholder="Họ tên"> <span id="customerName-error"
			style="color: red;"></span>
	</div>

	<div class="mb-3"
		style="display: flex; justify-content: space-between;">
		<div class="col-6" style="padding-right: 2%;">
			<input type="tel" class="form-control" id="phone"
				placeholder="Số điện thoại"> <span id="phone-error"
				style="color: red;"></span>
		</div>

		<div class="col-6" style="padding-left: 2%;">
			<select class="form-select" id="gender" aria-placeholder="Giới tính">
				<option value="">Chọn giới tính</option>
				<option value="Nam">Nam</option>
				<option value="Nữ">Nữ</option>
				<option value="Khác">Khác</option>
			</select> <span id="gender-error" style="color: red;"></span>
		</div>

	</div>

	<div class="mb-3">
		<input type="text" class="form-control" id="cccd"
			placeholder="Căn cước công dân"> <span id="cccd-error"
			style="color: red;"></span>
	</div>

	<div class="mb-3">
		<input type="text" class="form-control" id="email" placeholder="Email">
		<span id="email-error" style="color: red;"></span>
	</div>

	<div class="mb-3">
		<input type="text" class="form-control" id="account"
			placeholder="Tên đăng nhập"> <span id="account-error"
			style="color: red;"></span>
	</div>

	<div class="mb-3"
		style="display: flex; justify-content: space-between;">

		<div class="col-6" style="padding-right: 2%;">
			<input type="password" class="form-control" id="passwordRegister"
				placeholder="Mật khẩu"> <span id="passwordRegister-error"
				style="color: red;"></span>
		</div>
		<div class="col-6" style="padding-left: 2%;">
			<input type="password" class="form-control" id="repasswordRegister"
				placeholder="Xác nhận mật khẩu"> <span
				id="repasswordRegister-error" style="color: red;"></span>
		</div>
	</div>
	<div class="mb-2">
		<input type="date" class="form-control" id="birthDate"
			placeholder="Chọn ngày sinh"> <span id="birthDate-error"
			style="color: red;"></span>
	</div>

	<div class="modal-footer"
		style="display: flex; justify-content: center;">
		<button type="submit" class="btn"
			style="background-color: pink; border-color: pink; color: black;"
			onclick="checkRegister();">ĐĂNG KÝ</button>
	</div>
</form:form>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<script>
function checkRegister(event) { // add event argument here
    var phone = document.getElementById("phone").value;
    var cccd = document.getElementById("cccd").value;
    var email = document.getElementById("email").value;
    var accountRegister = document.getElementById("account").value;
    event.preventDefault();
    
    axios.get("${pageContext.request.contextPath}/api/checkRegister", {
        params: {
            phone: phone,
            email: email,
            cccd: cccd,
            account: accountRegister
        }
    }).then(function(response) {
        if (response.status === 200) {
            var fields = response.data;
            if (fields.email) {
                var email = document.getElementById("email-error");
                email.innerText = "Email đã tồn tại vui lòng chọn email khác!";
            }
            if (fields.phone) {
                var phone = document.getElementById("phone-error");
                phone.innerText = "Số điện thoại đã tồn tại vui lòng chọn số điện thoại khác!";
            }
            if (fields.cccd) {
                var cccd = document.getElementById("cccd-error");
                cccd.innerText = "Số CCCD đã tồn tại vui lòng chọn số CCCD khác!";
            }
            if (fields.account) {
                var accountRegister = document.getElementById("account-error");
                accountRegister.innerText = "Tên đăng nhập đã tồn tại vui lòng chọn tên đăng nhập khác!";
            }
        } else {
            console.log("Error when calling API");
        }
    }).catch(function(error) {
        console.log("Error when calling API: " + error);
    });
} // add closing bracket here

document.getElementById('registerForm').addEventListener('submit', function(e) {
    // Prevent the form's default behavior
    e.preventDefault();

    // Gather data from the form
    var customerName = document.getElementById('customerName').value;
    var phone = document.getElementById('phone').value;
    var gender = document.getElementById('gender').value;
    var cccd = document.getElementById('cccd').value;
    var email = document.getElementById('email').value;
    var account = document.getElementById('account').value;
    var passwordRegister = document.getElementById('passwordRegister').value;
    var repasswordRegister = document.getElementById('repasswordRegister').value;
    var birthDate = document.getElementById('birthDate').value;

    // Create an object to hold the data
    var formData = {
        customerName: customerName,
        phone: phone,
        gender: gender,
        cccd: cccd,
        email: email,
        account: account,
        passwordRegister: passwordRegister,
        repasswordRegister: repasswordRegister,
        birthDate: birthDate
    };

    // Call checkRegister function
    checkRegister(e);

}); // add closing bracket here
</script>