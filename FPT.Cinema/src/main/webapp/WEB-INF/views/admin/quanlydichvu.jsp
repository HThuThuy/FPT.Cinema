
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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
              <a class="btn  " href="addsuatchieu.html">Thêm dịch vụ mới</a>
            </div>
          </div>
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
					<thead>
						<tr>
							<th width="40%">Combo</th>
							<th width="40%">serviceDescription</th>
							<th width="20%">Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sr" items="${lists}">
							<tr class="align-middle">
								<td>${sr.getServiceName()}</td>
								<td>${sr.serviceDescription}</td>
								<td>${sr.servicePrice}</td>
							</tr>
						</c:forEach>
			 	</tbody>
              </table>    
            </div>                          
          </div>        
          
        
          <div class="pagination-wrap">
            <ul class="pagination">
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li><a href="#">3</a></li>
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