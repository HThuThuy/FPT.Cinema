<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<div class="modal fade" id="forgotPasswordModal" tabindex="-1"
	aria-labelledby="forgotPasswordModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="register-tab" data-bs-toggle="tab" href="#register" role="tab"
					aria-controls="register" aria-selected="false"
					style="color: #ec6090;"><h4>QUÊN MẬT KHẨU</h4></a></li>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form id="forgotPasswordForm">
					<div class="mb-2">
						<h6 style="color: rgb(155, 155, 155);">Vui cung cấp email
							đăng nhập, chúng tôi sẽ gởi mã OPT kích hoạt về email cho bạn.</h6>
					</div>

					<div class="mb-2">
						<label for="email" class="form-label"></label> <input type="email"
							class="form-control" id="email" placeholder="Email">
					</div>
					<div class="mb-5">
						<label for="otp" class="form-label"></label> <input type="text"
							class="form-control" id="otp" placeholder="OTP nhận từ email">
					</div>
					<div class="modal-footer"
						style="display: flex; justify-content: center;">
						<button type="submit" class="btn btn-primary"
							style="background-color: pink; border-color: pink; color: black;">Xác
							nhận</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>