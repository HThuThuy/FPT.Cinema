<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

  <div class="templatemo-content col-1 light-gray-bg">   
        <div class="templatemo-content-container">
          <h3 style="font-size: 35px; margin: 20px 0 30px;">QUẢN LÝ SUẤT CHIẾU</h3>
          <div class="row ml-1" style="display: flex; justify-content: center; align-items: center;">
            
            <div class="col-lg-3 col-md-6">
              <input type="text" id="divSearch" class="form-control ml-1" placeholder="Nhập tên suất chiếu" />
            </div>
            <div class="col-lg-3 col-md-6">
              <a class="btn  " href="MovieAdminInsertServlet?action=Show">Search</a>
            </div>
            <div class="col-lg-3 col-md-6">
              
            </div>
            <div class="col-lg-3 col-md-6">
              <a class="btn  " href="addsuatchieu.html">Thêm suất chiếu mới</a>
            </div>
          </div>
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Mã suất chiếu <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Tên phim <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Têp rạp <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Tên phòng <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Ngày chiếu <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Giờ chiếu <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Số ghế đặt <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Số ghế trống <span class="caret"></span></a></td>
                    <td>Sửa</td>                   
                    <td>Xóa</td>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1.</td>
                    <td>MV1</td>
                    <td>Smith</td>
                    <td>tom</td>
                    <td>tep</td>
                    <td>khong co gi</td>
                    <td>19/02/1999</td>
                    <td>15</td>
                    <td>15</td>
                    <td><a href="" class="templatemo-edit-btn">Edit</a></td>
                    <td><a href="" class="templatemo-link">Delete</a></td>
                  </tr>
                  <tr>
                    <td>2.</td>
                    <td>MV1</td>
                    <td>Smith</td>
                    <td>tom</td>
                    <td>tep</td>
                    <td>khong co gi</td>
                    <td>19/02/1999</td>
                    <td>15</td>
                    <td>15</td>
                    <td><a href="" class="templatemo-edit-btn">Edit</a></td>
                    <td><a href="" class="templatemo-link">Delete</a></td>
                  </tr>
                  <tr>
                    <td>3.</td>
                    <td>MV1</td>
                    <td>Smith</td>
                    <td>tom</td>
                    <td>tep</td>
                    <td>khong co gi</td>
                    <td>19/02/1999</td>
                    <td>15</td>
                    <td>15</td>
                    <td><a href="" class="templatemo-edit-btn">Edit</a></td>
                    <td><a href="" class="templatemo-link">Delete</a></td>
                  </tr>
                  <tr>
                    <td>4.</td>
                    <td>MV1</td>
                    <td>Smith</td>
                    <td>tom</td>
                    <td>tep</td>
                    <td>khong co gi</td>
                    <td>19/02/1999</td>
                    <td>15</td>
                    <td>15</td>
                    <td><a href="" class="templatemo-edit-btn">Edit</a></td>
                    <td><a href="" class="templatemo-link">Delete</a></td>
                  </tr>
                  <tr>
                    <td>5.</td>
                    <td>MV1</td>
                    <td>Smith</td>
                    <td>tom</td>
                    <td>tep</td>
                    <td>khong co gi</td>
                    <td>19/02/1999</td>
                    <td>15</td>
                    <td>15</td>
                    <td><a href="" class="templatemo-edit-btn">Edit</a></td>
                    <td><a href="" class="templatemo-link">Delete</a></td>
                  </tr>  
                   <tr>
                    <td>6.</td>
                    <td>MV1</td>
                    <td>Smith</td>
                    <td>tom</td>
                    <td>tep</td>
                    <td>khong co gi</td>
                    <td>19/02/1999</td>
                    <td>15</td>
                    <td>15</td>
                    <td><a href="" class="templatemo-edit-btn">Edit</a></td>
                    <td><a href="" class="templatemo-link">Delete</a></td>
                  </tr>  
                   <tr>
                    <td>7.</td>
                    <td>MV1</td>
                    <td>Smith</td>
                    <td>tom</td>
                    <td>tep</td>
                    <td>khong co gi</td>
                    <td>19/02/1999</td>
                    <td>15</td>
                    <td>15</td>
                    <td><a href="" class="templatemo-edit-btn">Edit</a></td>
                    <td><a href="" class="templatemo-link">Delete</a></td>
                  </tr>  
                 
                </tbody>
              </table>    
            </div>                          
          </div>        
          
        
          <div class="pagination-wrap">
            <ul class="pagination">
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li class="active"><a href="#">3 <span class="sr-only">(current)</span></a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li>
                <a href="#" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-play"></i></span>
                </a>
              </li>
            </ul>
          </div>          
        </div>
      </div>