<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="modal fade" id="forgotPasswordModal" tabindex="-1"
	aria-labelledby="forgotPasswordModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="forgotPassword-tab" data-bs-toggle="tab" href="#forgotPassword"
					role="tab" aria-controls="forgotPassword" aria-selected="false"
					style="color: #ec6090;">
						<h4>QUÊN MẬT KHẨU</h4>
				</a></li>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form:form id="forgotPasswordForm"
					action="${pageContext.request.contextPath}/forgotPassword"
					modelAttribute="forgotPasswordForm" method="post">
					<div class="mb-2">
						<h6 style="color: rgb(155, 155, 155);">Vui lòng cung cấp
							email đăng nhập, chúng tôi sẽ gửi mã OTP kích hoạt về email cho
							bạn.</h6>
					</div>

					<div class="mb-2">
						<label for="emailForgot" class="form-label"></label> <input
							type="email" class="form-control" id="emailForgot"
							placeholder="Email" required> <span
							id="emailForgot-error" style="color: red;"></span>
					</div>

					<div class="mb-5">
						<label for="otp" class="form-label"></label> <input type="text"
							class="form-control" id="otp" placeholder="OTP nhận từ email"
							disabled required>
					</div>

					<div id="countdown" style="display: none; color: red;">
						Thời gian còn lại: <span id="countdownValue"></span> giây
					</div>


					<div class="modal-footer"
						style="display: flex; justify-content: center;">
						<button type="button" class="btn btn-primary" id="sendEmailButton"
							style="background-color: pink; border-color: pink; color: black;"
							onclick="if (checkExistEmail()) sendEmail();">Gửi email</button>

						<button type="button" class="btn btn-primary"
							data-bs-toggle="modal" data-bs-target="#resetPasswordModal"
							style="background-color: pink; border-color: pink; color: black;">Xác
							nhận đổi mật khẩu</button>
					</div>

					<div id="errorAlert" class="alert alert-danger" role="alert"
						style="display: none;">Lỗi xảy ra. Vui lòng thử lại sau.</div>

					<div id="successAlert" class="alert alert-success" role="alert"
						style="display: none;">Mã OTP đã được gửi đến email của bạn.
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>


<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<script>
// Hàm kiểm tra định dạng email
function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function checkExistEmail() {
    var emailForgot = document.getElementById("emailForgot").value;
    var emailForgotError = document.getElementById("emailForgot-error");

    console.log("emailForgot"+emailForgot)
    // Kiểm tra email có giá trị không
    if (!emailForgot.trim()) {
        emailForgotError.innerText = "Vui lòng nhập địa chỉ email.";
        return false;
    }

    // Kiểm tra email có hợp lệ không
    if (!validateEmail(emailForgot)) {
        emailForgotError.innerText = "Vui lòng nhập địa chỉ email hợp lệ.";
        return false;
    }

    // Thực hiện kiểm tra thông tin đăng nhập
    axios.get("${pageContext.request.contextPath}/api/checkExistEmail", {
        params: {
            emailForgot: emailForgot,
        }
    }).then(function(response) {
        if (response.status === 200) {
            var list = response.data;
            if (list === false) {
                emailForgotError.innerText = "Email không tồn tại, vui lòng kiểm tra lại!";
            } else {
                // Email tồn tại, gửi yêu cầu GET đến /sendOTP
                axios.get("${pageContext.request.contextPath}/sendOTP", {
                    params: {
                        emailForgot: emailForgot
                    }
                }).then(function(response) {
                    console.log(response);
                    // Xử lý kết quả từ máy chủ nếu cần
                }).catch(function(error) {
                    console.log("Lỗi khi gọi API: " + error);
                });
            }
        } else {
            console.log("Lỗi khi gọi API");
        }
    }).catch(function(error) {
        console.log("Lỗi khi gọi API: " + error);
    });
}



// Gán sự kiện onclick cho nút "Gửi email"
document.getElementById("sendEmailButton").onclick = function() {
    checkExistEmail();
};


</script>



