<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<form action="${pageContext.request.contextPath}/login" method="post">
	<div>
		<h6 style="color: rgb(155, 155, 155);">Vui lòng đăng nhập trước
			khi mua vé để tích lũy điểm, cơ hội nhận thêm nhiều ưu đãi từ chương
			trình thành viên FPT Cinema</h6>
	</div>

	<div class="mb-1">
		<input type="text" class="form-control" id="account" name="account" placeholder="Tên đăng nhập">
		<span id="account-error" style="color: red;"></span>
	</div>
	<div class="mb-4">
		<input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu">
		<span id="password-error" style="color: red;"></span>
	</div>
	<div class="mb-3">
		<a href="#" data-bs-toggle="modal"
			data-bs-target="#forgotPasswordModal"
			style="color: rgb(155, 155, 155);">Quên mật khẩu?</a>
	</div>

	<div class="modal-footer"
		style="display: flex; justify-content: center;">
		<button type="submit" class="btn"
			style="background-color: pink; border-color: pink; color: black;">ĐĂNG
			NHẬP</button>
	</div>
</form>