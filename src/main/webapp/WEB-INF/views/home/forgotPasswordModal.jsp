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
						<label for="email" class="form-label"></label> <input type="email"
							class="form-control" id="email" placeholder="Email" required>
					</div>

					<div class="mb-5">
						<label for="otp" class="form-label"></label> <input type="text"
							class="form-control" id="otp" placeholder="OTP nhận từ email"
							disabled required>
					</div>

					<div class="mb-3" id="countdown"
						style="display: none; color: black">
						<span>Thời gian còn lại: <span id="countdownValue">60</span>
							giây
						</span>
					</div>

					<div class="modal-footer"
						style="display: flex; justify-content: center;">
						<button type="button" class="btn btn-primary"
							style="background-color: pink; border-color: pink; color: black;"
							id="sendEmailButton">Gửi email</button>
						<button type="submit" class="btn btn-primary" disabled
							style="background-color: pink; border-color: pink; color: black;"
							id="confirmButton">Xác nhận</button>
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

<script>
function sendEmail() {
    // Disable the send email button
    document.getElementById('sendEmailButton').disabled = true;

    // Show the OTP input and change text to "Xác nhận"
    document.getElementById('otp').disabled = false;
    document.getElementById('confirmButton').disabled = false;

    // Show the countdown and start the timer
    document.getElementById('countdown').style.display = 'block';
    var countdownValue = 60;
    var countdownElement = document.getElementById('countdownValue');

    var countdownInterval = setInterval(function() {
        countdownValue--;
        countdownElement.textContent = countdownValue;
        if (countdownValue <= 0) {
            clearInterval(countdownInterval);
            document.getElementById('countdown').style.display = 'none';
            document.getElementById('sendEmailButton').disabled = false;
            document.getElementById('sendEmailButton').textContent = "Gửi lại email";
        }
    }, 1000);

    // Lấy giá trị của email từ trường nhập liệu
    var email = document.getElementById('email').value;

    // Gửi dữ liệu đến máy chủ
    axios.post('${pageContext.request.contextPath}/forgotPassword', {
        email: email

    })
    .then(function (response) {
        // Xử lý kết quả từ máy chủ nếu cần
        console.log(response);
    })
    .catch(function (error) {
        // Xử lý lỗi nếu có
        console.error(error);
    });
}

function resetForm() {
    document.getElementById('forgotPasswordForm').reset(); // Reset form inputs
    document.getElementById('otp').disabled = true; // Disable OTP input
    document.getElementById('confirmButton').disabled = true; // Disable confirm button
    document.getElementById('countdown').style.display = 'none'; // Hide countdown
    document.getElementById('sendEmailButton').textContent = "Gửi email"; // Reset send email button text
    document.getElementById('sendEmailButton').disabled = false; // Enable send email button
    document.getElementById('successAlert').style.display = 'none'; // Hide success alert
    document.getElementById('errorAlert').style.display = 'none'; // Hide error alert
}

//Thêm sự kiện nhấp chuột cho nút "Gửi email"
document.getElementById('sendEmailButton').addEventListener('click', sendEmail);

// Thêm sự kiện khi modal ẩn để reset form
$('#forgotPasswordModal').on('hidden.bs.modal', resetForm);

</script>