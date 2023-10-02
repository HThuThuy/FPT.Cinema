<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <div class="templatemo-content col-1 light-gray-bg">
      
      <div class="templatemo-content-container">
        <div class="templatemo-content-widget white-bg">
          <h3 class="margin-bottom-10">${text} phim</h3>

          <form:form action="${pageContext.request.contextPath}/admin/addPhim" class="templatemo-login-form" method="post" modelAttribute="phim">
            <div class="row form-group">

				<div class="col-lg-12 col-md-12 form-group d-none">
					<label for="inputmasuatchieu">Mã phim</label>
					<form:input path="movieId" type="text" class="form-control"
						  />
					<form:errors path="movieId" cssClass="text-danger" />
				</div>
				
				<div class="col-lg-12 col-md-12 form-group">
					<label for="inputmasuatchieu">Tên phim</label>
					<form:input path="movieName" type="text" class="form-control"/>
					<form:errors path="movieName" cssClass="text-danger" />
				</div>
				
				<div class="col-lg-12 col-md-12 form-group">
					<label for="inputmasuatchieu">Đạo diễn</label>
					<form:input path="director" type="text" class="form-control"/>
					<form:errors path="director" cssClass="text-danger" />
				</div>

				<div class="col-lg-12 col-md-12 form-group">
					<label for="inputmasuatchieu">Thời lượng</label>
					<form:input path="duration" type="time" class="form-control" id="without_ampm"/>
					<form:errors path="duration" cssClass="text-danger" />
				</div>	
				
				<div class="col-lg-12 col-md-12 form-group">
					<label for="inputmasuatchieu">Mô tả</label>
					<form:textarea path="movieDescription" type="time" class="form-control" rows="3"/>
					<form:errors path="movieDescription" cssClass="text-danger" />
				</div>	
              
              <div class="col-lg-12 col-md-12 form-group">
					<label for="inputmasuatchieu">Ngày khởi chiếu</label>
					<form:input path="startDate" type="date" class="form-control"/>
					<form:errors path="startDate" cssClass="text-danger" />
				</div>	
				
				<div class="col-lg-12 col-md-12 form-group">
					<label for="inputmasuatchieu">Ngày kết thúc</label>
					<form:input path="endDate" type="date" class="form-control"/>
					<form:errors path="endDate" cssClass="text-danger" />
				</div> 
				
				<div class="col-lg-12 col-md-12 form-group">
					<label for="inputmasuatchieu">Poster Url</label>
					<form:input path="posterUrl" type="text" class="form-control"/>
					<form:errors path="posterUrl" cssClass="text-danger" />
				</div>              
              
            </div>

				<div class="form-group text-right">
					<button type="submit" class="templatemo-blue-button">${text2}</button>
					<button type="reset" class="templatemo-white-button">Tạo
						lại</button>
				</div>
			</form:form>
        </div>
      </div>
    </div>

	<script>
    
	
    
    </script>
