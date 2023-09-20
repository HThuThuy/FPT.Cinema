<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <div class="templatemo-content col-1 light-gray-bg">
      
      <div class="templatemo-content-container">
        <div class="templatemo-content-widget white-bg">
          <h3 class="margin-bottom-10">Thêm phim mới</h3>

          <form:form action="${pageContext.request.contextPath}/admin/addPhim" class="templatemo-login-form" method="post" modelAttribute="phim" enctype="multipart/form-data">
            <div class="row form-group">
              <div class="col-lg-12 col-md-12 form-group">
                <label for="inputmovieId">Mã phim</label>
                <input type="text" class="form-control" id="inputmovieId">
              </div>
              <div class="col-lg-12 col-md-12 form-group">
                <label for="inputmovieName">Tên phim</label>
                <input type="text" class="form-control" id="inputmovieName">
              </div>
              <div class="col-lg-12 col-md-12 form-group">
                <label for="inputdaodien">Đạo diễn</label>
                <input type="text" class="form-control" id="inputdaodien">
              </div>
              <div class="col-lg-12 col-md-12 form-group">
                <label for="inputgenre">Thời lượng</label>
                <input type="text" class="form-control" id="inputgenre">
              </div>
              <div class="col-lg-12 form-group">
                <label class="control-label" for="inputDescription">Mô tả</label>
                <textarea class="form-control" id="inputDescription" rows="3"></textarea>
              </div>
              <div class="col-lg-12 col-md-12 form-group">
                <label for="inputreleaseDate">Ngày bắt đầu</label>
                <input type="date" class="form-control" id="inputreleaseDate" placeholder="releaseDate">
              </div>
              <div class="col-lg-12 col-md-12 form-group">
                <label for="inputreleaseDate">Ngày kết thúc</label>
                <input type="date" class="form-control" id="inputreleaseDate" placeholder="releaseDate">
              </div>
              <div class="col-lg-12">
                <label class="control-label templatemo-block">Poster Url</label>
                <!-- <input type="file" name="fileToUpload" id="fileToUpload" class="margin-bottom-10"> -->
                <input type="file" name="fileToUpload" id="fileToUpload" class="filestyle" data-buttonName="btn-primary"
                  data-buttonBefore="true" data-icon="false">
                <p>Maximum upload size is 5 MB.</p>
              </div>
            </div>

            <div class="form-group text-right">
              <button type="submit" class="templatemo-blue-button">Thêm mới</button>
              <button type="reset" class="templatemo-white-button">Tạo lại</button>
            </div>
          </form:form>
        </div>
      </div>
    </div>
