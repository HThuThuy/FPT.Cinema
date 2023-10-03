<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%
String error = (String) request.getSession().getAttribute("error");
%>

<style>
div#loginModal {
	margin-top: 115px;
}
</style>

<div class="modal fade" id="loginModal" tabindex="-1"
	aria-labelledby="loginModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="login-tab" data-bs-toggle="tab"
						href="#login" role="tab" aria-controls="login"
						aria-selected="true" style="color: #ec6090;"><h4>ĐĂNG
								NHẬP</h4></a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="register-tab" data-bs-toggle="tab" href="#register" role="tab"
						aria-controls="register" aria-selected="false"
						style="color: #ec6090;"><h4>ĐĂNG KÝ</h4></a></li>
				</ul>
			</div>
			<div class="modal-body">
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="login" role="tabpanel"
						aria-labelledby="login-tab">
						<!-- Login form -->
						<form action="${pageContext.request.contextPath}/login"
							method="post" id="login-form">
							<div>
								<h6 style="color: rgb(155, 155, 155);">Vui lòng đăng nhập
									trước khi mua vé để tích lũy điểm, cơ hội nhận thêm nhiều ưu
									đãi từ chương trình thành viên FPT Cinema</h6>
							</div>
							<span
									id="account-error" style="color: red;"></span>
							<div class="mb-1">
								<input type="text" class="form-control" id="account-login"
									name="account" placeholder="Tên đăng nhập"> 
									
							</div>
							<div class="mb-4">
								<input type="password" class="form-control" id="password-login"
									name="password" placeholder="Mật khẩu"> <span
									id="password-error" style="color: red;"></span>
							</div>
							<div class="mb-3">
								<a href="#" data-bs-toggle="modal"
									data-bs-target="#forgotPasswordModal"
									style="color: rgb(155, 155, 155);">Quên mật khẩu?</a>
							</div>

							<div class="modal-footer"
								style="display: flex; justify-content: center;">
								style="display: flex; justify-content:
								<button type="submit" class="btn"
									style="background-color: pink; border-color: pink; color: black;"
									onclick="checkAccount()">ĐĂNG NHẬP</button>
							</div>
						</form>
					</div>
					<div class="tab-pane fade" id="register" role="tabpanel"
						aria-labelledby="register-tab">
						<!-- Register form -->
						<jsp:include page="registerModal.jsp" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<script>
// Thêm sự kiện submit cho form
document.getElementById("login-form").addEventListener("submit", function(event) {
    var accountLogin = document.getElementById("account-login").value;
    var passwordLogin = document.getElementById("password-login").value;
    
    // Ngăn chặn submit form ngay lập tức
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
                var accLogin = document.getElementById("account-error");
                accLogin.innerText = "Tên đăng nhập hoặc mật khẩu không đúng, Vui lòng kiểm tra lại!";
            } else {
                // Nếu thông tin đăng nhập hợp lệ, submit form
                event.target.submit();
            }
        } else {
            console.log("Lỗi khi gọi API");
        }
    }).catch(function(error) {
        console.log("Lỗi khi gọi API: " + error);
    });
});
</script>
