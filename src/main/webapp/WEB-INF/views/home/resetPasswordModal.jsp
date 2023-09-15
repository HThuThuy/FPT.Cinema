<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>


<div class="modal fade" id="resetPasswordModal" tabindex="-1"
	aria-labelledby="resetPasswordModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<li class="nav-item" role="presentation"><a class="nav-link"
						id="register-tab" data-bs-toggle="tab" href="#register" role="tab"
						aria-controls="register" aria-selected="false"
						style="color: #ec6090;"><h4>ĐẶT LẠI MẬT KHẨU</h4></a></li>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form id="resetPasswordForm">
					<div class="mb-3">
						<label for="new-password" class="form-label"></label> <input
							type="password" class="form-control" id="new-password"
							placeholder="Mật khẩu mới">
					</div>
					<div class="mb-5">
						<label for="confirm-password" class="form-label"></label> <input
							type="password" class="form-control" id="confirm-password"
							placeholder="Xác nhận mật khẩu mới">
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