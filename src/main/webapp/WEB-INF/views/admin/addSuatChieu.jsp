<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="templatemo-content col-1 light-gray-bg">
	<div class="templatemo-content-container">
		<div class="templatemo-content-widget white-bg">
			<h3 class="margin-bottom-10">Thêm suất chiếu</h3>

			
			<form:form action="${pageContext.request.contextPath}/admin/addSuatChieu" class="templatemo-login-form" method="post" modelAttribute="suatChieu" enctype="multipart/form-data">
				<div class="row form-group">
					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputmasuatchieu">Mã suất chiếu</label> <input
							type="text" class="form-control" id="inputmasuatchieu">
					</div>
					<div class="col-lg-12 col-md-12 form-group">
						<label class="control-label templatemo-block"> Chọn phim</label> <select
							class="form-control">
							<option value="phim1">Phim1</option>
							<option value="phim2">Phim2</option>
							<option value="phim3">Phim3</option>
						</select>
					</div>

					<div class="col-lg-12 col-md-12 form-group">
						<label class="control-label templatemo-block"> Chọn rạp</label> <select
							class="form-control">
							<option value="theater1">Rạp A</option>
							<option value="theater2">Rạp B</option>
							<option value="theater3">Rạp C</option>
						</select>
					</div>

					<div class="col-lg-12 col-md-12 form-group">
						<label class="control-label templatemo-block"> Chọn phòng</label>
						<select class="form-control">
							<option value="room1">Nhỏ</option>
							<option value="room2">Vừa</option>
							<option value="room3">Lớn</option>
						</select>
					</div>

					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputsoghedat">Chọn ngày chiếu</label> <input
							type="date" class="form-control" id="inputsoghedat">
					</div>

					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputsoghedat">Chọn giờ chiếu</label> <input
							type="time" class="form-control" id="inputsoghedat">
					</div>

					<div class="form-group text-right">
						<button type="submit" class="templatemo-blue-button">Thêm
							mới</button>
						<button type="reset" class="templatemo-white-button">Tạo
							lại</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>