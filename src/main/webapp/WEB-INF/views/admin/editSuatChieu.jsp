<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="templatemo-content col-1 light-gray-bg">
	<div class="templatemo-content-container">
		<div class="templatemo-content-widget white-bg">
			<h3 class="margin-bottom-10">Thay đổi suất chiếu</h3>

			
			<form:form action="${pageContext.request.contextPath}/admin/${suatChieu.showtimeId}" method="post" modelAttribute="suatChieu" class="templatemo-login-form">
				<div class="row form-group">
					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputmasuatchieu">Mã suất chiếu</label> 
						<form:input path="showtimeId" type="text" class="form-control"/>
						<form:errors path="showtimeId" cssClass="text-danger" />
					</div>
					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputmasuatchieu">Mã phim</label> 
						<form:input path="movieId" type="text" class="form-control"/>
						<form:errors path="movieId" cssClass="text-danger" />
					</div>

					<div class="col-lg-12 col-md-12 form-group">
						<label class="control-label templatemo-block"> Chọn rạp</label> 
						<form:select path="theaterId" class="form-control">
							<c:forEach items="${theaters}" var="item">
								<option value="${item.theaterId}" ${item.theaterId == suatChieu.theaterId ? 'selected' : ''}>${item.theaterName}</option>
							</c:forEach>
						</form:select>
						<form:errors path="theaterId" cssClass="text-danger" />
					</div>

					<div class="col-lg-12 col-md-12 form-group">
						<label class="control-label templatemo-block"> Chọn phòng</label>
						<form:select path="roomId" class="form-control">
							<option value="R001">Nhỏ</option>
							<option value="R002">Vừa</option>
							<option value="R003">Lớn</option>
						</form:select>
						<form:errors path="roomId" cssClass="text-danger" />
					</div>

					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputsoghedat">Chọn ngày chiếu</label>
						<form:input path="startDate" type="date" class="form-control"/>
						<form:errors path="startDate" cssClass="text-danger" />
					</div>

					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputsoghedat">Chọn giờ chiếu</label> 
						<form:input path="startTime" type="time" class="form-control"/>
						<form:errors path="startTime" cssClass="text-danger" />
					</div>

					<div class="form-group text-right">
						<button type="submit" class="templatemo-blue-button">Thay đổi</button>
						<button type="reset" class="templatemo-white-button">Tạo lại</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>