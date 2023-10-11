<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.templatemo-blue-button {
    margin-right: 25px;
}

label {
    margin-bottom: 5px;
    font-size: 15px;
    font-weight: bold;
}
</style>

<div class="templatemo-content col-1 black-bg">
	<div class="templatemo-content-container">
	<h3 class="text-center display-4 mb-4" style="font-size: 35px;">CẬP NHẬT THÔNG TIN THÀNH VIÊN</h3>
		<div class="templatemo-content-widget white-bg">

			<form:form action="${pageContext.request.contextPath}/customer/update" onsubmit="return checkSubmit();" 
			method="post" modelAttribute="customerForm" 
			class="templatemo-login-form" >
				<div class="row form-group">
				
					<div class="col-lg-12 col-md-12 form-group d-none">
						<form:input path="cccd" type="text" class="form-control" readonly="true"/>
					</div>

					<div class="col-lg-12 col-md-12 form-group mb-4">
						<label for="inputFullName">Họ và Tên</label>
						<form:input path="customerName" type="text" class="form-control" readonly="true"/>
					</div>

					<div class="col-lg-12 col-md-12 form-group mb-4">
						<label for="inputDateOfBirth">Ngày sinh</label>
						<form:input path="birthDate" type="text" class="form-control" readonly="true"/>
					</div>

					<div class="col-lg-12 col-md-12 form-group mb-4 mt-2">
						<label for="inputGender">Giới tính</label>
						<form:input path="gender" type="text" class="form-control" readonly="true"/>
					</div>

					<div class="col-lg-12 col-md-12 form-group mb-3 mt-1">
					    <label for="inputPhoneNumber">Số điện thoại</label>
					    <form:input path="phone" type="text" class="form-control"/>
					    <form:errors path="phone" cssClass="error text-danger" />
						<p id="phone-error" class="text-danger"></p>
					</div>
					
						<div class="col-lg-12 col-md-12 form-group mb-3 mt-1">
					    <label for="inputAddress">Địa chỉ</label>
					    <form:input path="address" type="text" class="form-control"/>
					    <form:errors path="address" cssClass="error text-danger" />
						<p id="address-error" class="text-danger"></p>
					</div>
					
					<div class="col-lg-12 col-md-12 form-group mb-3 mt-1">
					    <label for="inputEmail">Email</label>
					    <form:input path="email" type="text" class="form-control"/>
					     <form:errors path="email" cssClass="error text-danger" />
						<p id="email-error" class="text-danger"></p>
					</div>


					<div class="form-group text-right">
						<form action="${pageContext.request.contextPath}/customer/update" method="get">
						    <button type="submit" class="templatemo-blue-button">Lưu thông tin</button>
						</form>
						<button type="reset" class="templatemo-blue-button ml-4">Tạo lại</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>


<script>
function checkSubmit() {
    var resultCheck = true;

    $("#phone-error").html("");
    $("#email-error").html("");

    var phoneValue = $("[name='phone']").val().trim();
    var emailValue = $("[name='email']").val().trim();

    // Check if phone is empty
    if (!phoneValue) {
        $("#phone-error").html("Bạn cần nhập dữ liệu cho trường này");
        resultCheck = false;
    } else {
        // Validate phone number
        var phoneRegex = /^[0-9]{10}$/;
        if (!phoneRegex.test(phoneValue)) {
            $("#phone-error").html("Số điện thoại không hợp lệ");
            resultCheck = false;
        }
    }

    // Check if email is empty
    if (!emailValue) {
        $("#email-error").html("Bạn cần nhập dữ liệu cho trường này");
        resultCheck = false;
    } else {
        // Validate email
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(emailValue)) {
            $("#email-error").html("Email không hợp lệ");
            resultCheck = false;
        }
    }

    return resultCheck;
}


</script>

