<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="templatemo-content col-1 light-gray-bg">
	<div class="templatemo-content-container">
		<div class="templatemo-content-widget white-bg">
			<h3 class="margin-bottom-10">Thêm rạp mới</h3>

			<form:form action="${pageContext.request.contextPath}/admin/addRap"  class="templatemo-login-form" method="post"
				modelAttribute="rap" enctype="multipart/form-data">
				<div class="row form-group">
					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputtheaterName">Mã rạp</label> <input type="text"
							class="form-control" id="inputtheaterName"
							placeholder="theaterName">
					</div>
					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputdiachi">Tên rạp </label> <input type="text"
							class="form-control" id="inputdiachi" placeholder="địa chỉ">
					</div>
					<div class="col-lg-12 col-md-12 form-group">
						<label class="control-label templatemo-block"> Thành phố</label> <select
							class="form-control">
							<option value="hanoi">Hà Nội</option>
							<option value="danang">Đà Nẵng</option>
							<option value="tpHCM">TP Hồ Chí Minh</option>
						</select>
					</div>
				</div>

				<div class="form-group text-right updaterap">
					<button type="submit" class="templatemo-blue-button">Thêm
						mới</button>
					<button type="reset" class="templatemo-white-button">Tạo
						lại</button>
				</div>
			</form:form>
		</div>

	</div>
</div>