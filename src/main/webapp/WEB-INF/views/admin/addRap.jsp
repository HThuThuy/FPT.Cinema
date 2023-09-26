<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="templatemo-content col-1 black-bg">
	<div class="templatemo-content-container">
		<div class="templatemo-content-widget white-bg">
			<h3 class="margin-bottom-10">${text} rạp</h3>

			<form:form action="${pageContext.request.contextPath}/admin/addRap"  class="templatemo-login-form" method="post"
				modelAttribute="rap">
				<div class="row form-group">

					<div class="col-lg-12 col-md-12 form-group d-none">
						<label for="inputmasuatchieu">Mã rạp</label>
						<form:input path="theaterId" type="text" class="form-control" />
						<form:errors path="theaterId" cssClass="text-danger" />
					</div>
					
					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputmasuatchieu">Tên rạp</label>
						<form:input path="theaterName" type="text" class="form-control" />
						<form:errors path="theaterName" cssClass="text-danger" />
					</div>
					
					<div class="col-lg-12 col-md-12 form-group">
						<label class="control-label templatemo-block"> Chọn thành phố</label> 
						<form:select path="city" id="startTime"  class="form-control">
							<option value="Hà Nội">Hà Nội</option>
							<option value="Đà Nẵng">Đà Nẵng</option>
							<option value="Hồ Chí Minh">Hồ Chí Minh</option>
						</form:select>
						<form:errors path="city" cssClass="text-danger" />
					</div>
					
					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputmasuatchieu">Địa chỉ</label>
						<form:input path="address" type="text" class="form-control" />
						<form:errors path="address" cssClass="text-danger" />
					</div>
					
					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputmasuatchieu">Hotline</label>
						<form:input path="phone" type="text" class="form-control" />
						<form:errors path="phone" cssClass="text-danger" />
					</div>

					<div class="form-group text-right">
						<button type="submit" class="templatemo-blue-button">${text}</button>
						<button type="reset" class="templatemo-white-button">Tạo lại</button>
					</div>

				</div>				
			</form:form>
		</div>

	</div>
</div>