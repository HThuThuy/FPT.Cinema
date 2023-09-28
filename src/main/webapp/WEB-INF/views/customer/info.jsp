<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="templatemo-content col-1 black-bg">
	<div class="templatemo-content-container">
		<div class="templatemo-content-widget white-bg">
			<h3 class="margin-bottom-10">Thay đổi suất chiếu</h3>
			
			<form:form action="${pageContext.request.contextPath}/customer/info" method="post" modelAttribute="suatChieu" class="templatemo-login-form">
				<div class="row form-group">
					<div class="col-lg-12 col-md-12 form-group d-none">						
						<form:input path="showtimeId" type="text" class="form-control" readonly="true"/>						
					</div>					
					
					<div class="col-lg-12 col-md-12 form-group">
						<input value="${theaterName}" type="text" class="form-control" readonly="true">
						<form:input path="theaterId" type="text" class="form-control d-none"/>						
					</div>	

					<div class="col-lg-12 col-md-12 form-group">
						<input value="${roomName}" type="text" class="form-control" readonly="true">
						<form:input path="roomId" type="text" class="form-control d-none"/>						
					</div>
					
					<div class="col-lg-12 col-md-12 form-group">
						<input value="${startTime}" type="text" class="form-control" readonly="true">
						<form:input path="startTime" type="text" class="form-control d-none"/>						
					</div>
					
					<div class="col-lg-12 col-md-12 form-group">
						<label for="inputmasuatchieu">Chọn phim</label> 
						<form:select path="movieId" class="form-control">
							<option value="">Mời chọn phim</option>
							<c:forEach items="${movies}" var="item">
								<option value="${item.movieId}" ${item.movieId == record.movieId ? 'selected' : ''}>${item.movieName}</option>
							</c:forEach>
						</form:select>
						<form:errors path="movieId" cssClass="text-danger" />
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


