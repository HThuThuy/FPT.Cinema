<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<form action="${pageContext.request.contextPath}/login" method="post"
	id="login-form">
	<div>
		<h6 style="color: rgb(155, 155, 155);">Vui lòng đăng nhập trước
			khi mua vé để tích lũy điểm, cơ hội nhận thêm nhiều ưu đãi từ chương
			trình thành viên FPT Cinema</h6>
	</div>
	<span id="accountLogin-error" style="color: red;"></span>
	<div class="mb-1">
		<input type="text" class="form-control" id="account-login"
			name="account" placeholder="Tên đăng nhập"> <span
			id="accountLogin2-error" style="color: red;"></span>

	</div>
	<div class="mb-4">
		<input type="password" class="form-control" id="password-login"
			name="password" placeholder="Mật khẩu"> <span
			id="passwordLogin-error" style="color: red;"></span>
	</div>
	<div class="mb-3">
		<a href="#" data-bs-toggle="modal"
			data-bs-target="#forgotPasswordModal"
			style="color: rgb(155, 155, 155);">Quên mật khẩu?</a>
	</div>

	<div class="modal-footer"
		style="display: flex; justify-content: center;">
		<button type="submit" class="btn"
			style="background-color: pink; border-color: pink; color: black;"
			onclick="if (validateLoginForm()) checkLogin();">ĐĂNG NHẬP</button>
	</div>
</form>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>


<script>
function checkLogin() {
    var accountLogin = document.getElementById("account-login").value;
    var passwordLogin = document.getElementById("password-login").value;
    event.preventDefault();
    // Thực hiện kiểm tra thông tin đăng nhập
    axios.get("${pageContext.request.contextPath}/api/checkAccount", {
        params: {
            accountLogin: accountLogin,
            passwordLogin: passwordLogin
        }
    }).then(function(response) {
        if (response.status === 200) {
            var list = response.data;
            if (list === false) {
                var accLogin = document.getElementById("accountLogin-error");
                accLogin.innerText = "Tên đăng nhập hoặc mật khẩu không đúng, Vui lòng kiểm tra lại!";
            } else {
                // Nếu thông tin đăng nhập hợp lệ, submit form
                document.getElementById("login-form").submit();
            }
        } else {
            console.log("Lỗi khi gọi API");
        }
    }).catch(function(error) {
        console.log("Lỗi khi gọi API: " + error);
    });
}

function validateRegisterForm() {
    var isValid = true;

    // Validate account
    var accountLogin = $('#account-login').val();
    if (accountLogin.trim() === '') {
        $('#accountLogin2-error').text('Vui lòng nhập Tài khoản đăng nhập');
        isValid = false;
    } else {
        $('#accountLogin2-error').text(''); // Xóa thông báo lỗi khi hợp lệ
    }

    // Validate password
    var passwordLogin = $('#password-login').val();
    if (passwordLogin.trim() === '') {
        $('#passwordLogin-error').text('Vui lòng nhập mật khẩu');
        isValid = false;
    } else {
        $('#passwordLogin-error').text(''); // Xóa thông báo lỗi khi hợp lệ
    }

    return isValid;
}

document.getElementById("login-form").addEventListener("submit", function(event) {
    if (!validateRegisterForm()||!checkLogin()) {
        event.preventDefault(); // Ngăn chặn form submit
    }
});
</script>