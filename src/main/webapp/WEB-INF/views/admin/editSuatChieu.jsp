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
			
			<form:form action="${pageContext.request.contextPath}/admin/addSuatChieu" method="post" modelAttribute="suatChieu" class="templatemo-login-form">
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
							<!-- <option value="">Mời chọn phim</option> -->
							<c:forEach items="${movies}" var="item">
								<option value="${item.movieId}" ${item.movieId == selectedMovie ? 'selected' : ''}>${item.movieName}</option>
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

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<script>
	function getA() {
		console.log('abc');
		var selectedTheater = document.getElementById("theaterId").value; // Lấy giá trị được chọn từ dropdown

		// Gửi giá trị đến controller bằng Axios
		axios.get("${pageContext.request.contextPath}/admin/theater", {
		    params: {
		        theater: selectedTheater
		    }
		}).then(function(response) {
    			if (response.status === 200) {
    				console.log('eeeeeeeeee');
			        var list = response.data;
			        let result = '<option value="">Mời chọn phòng</option>';
			        for (let i = 0; i < list.length; i++) {
			        	result += '<option value="' + list[i].roomId + '">' + list[i].roomName + '</option>';
			        }
			        document.getElementById('roomId').innerHTML = result;
			        console.log(list);
			    } else {
			        // Xử lý lỗi trạng thái phản hồi
			        console.log("Lỗi khi gọi API");
			    }
		}).catch(function(error) {
	    // Xử lý lỗi
	    console.log("Lỗi khi gọi API: " + error);
		});
	}
	
	function getA2() {
		console.log('abc');
		var selectedRoom = document.getElementById("roomId").value; // Lấy giá trị được chọn từ dropdown

		// Gửi giá trị đến controller bằng Axios
		axios.get("${pageContext.request.contextPath}/admin/room", {
		    params: {
		        room: selectedRoom
		    }
		}).then(function(response) {
    			if (response.status === 200) {
    				console.log('hhhhhhhhhhh');
			        var list = response.data;
			        let result = '<option value="">Mời chọn giờ chiếu</option>';
			        for (let i = 0; i < list.length; i++) {
			        	result += '<option value="' + list[i] + '">' + list[i] + '</option>';
			        }
			        document.getElementById('startTime').innerHTML = result;
			        console.log(list);
			    } else {
			        // Xử lý lỗi trạng thái phản hồi
			        console.log("Lỗi khi gọi API");
			    }
		}).catch(function(error) {
	    // Xử lý lỗi
	    console.log("Lỗi khi gọi API: " + error);
		});
	}
</script>