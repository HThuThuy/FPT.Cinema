<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
label {
    margin-bottom: 5px;
    font-size: 15px;
    font-weight: bold;
}
</style>


<div class="templatemo-content col-1 black-bg">
	<div class="templatemo-content-container">
	<h3 class="text-center display-4 mb-4" style="font-size: 35px;">THÔNG TIN THÀNH VIÊN</h3>
		<div class="templatemo-content-widget white-bg">

			<div class="templatemo-login-form">
				<div class="row form-group">
					<div class="col-lg-12 col-md-12 form-group mb-4">
						<label for="inputFullName">Họ và Tên</label>
						<input value="${customer.customerName}" type="text" class="form-control" readonly="true">
					</div>

					<div class="col-lg-12 col-md-12 form-group mb-4">
						<label for="inputDateOfBirth">Ngày sinh</label>
						<input value="${customer.birthDate}" type="text" class="form-control" readonly="true">
					</div>

					<div class="col-lg-12 col-md-12 form-group mb-4 mt-2">
						<label for="inputGender">Giới tính</label>
						<input value="${customer.gender}" type="text" class="form-control" readonly="true">
					</div>

					<div class="col-lg-12 col-md-12 form-group mb-4 mt-1">
					    <label for="inputPhoneNumber">Số điện thoại</label>
					    <input value="${customer.phone}" name="phone" type="text" class="form-control" readonly="true">
					</div>


					<div class="col-lg-12 col-md-12 form-group mb-4 mt-1">
						<label for="inputAddress">Địa chỉ</label>
						<input value="${customer.address}" name="address" type="text" class="form-control" readonly="true">
					</div>

					<div class="col-lg-12 col-md-12 form-group mb-4 mt-1">
						<label for="inputEmail">Email</label>
						<input value="${customer.email}" name="email" type="text" class="form-control" readonly="true">
					</div>

					<div class="form-group text-right">
					<a	href="${pageContext.request.contextPath}/customer/update">
										<button class="templatemo-blue-button">
											Cập nhật
										</button>
									</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
