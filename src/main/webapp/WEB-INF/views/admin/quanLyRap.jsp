<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <div class="templatemo-content col-1 black-bg"> 
        <div class="templatemo-content-container">
          <h3 style="font-size: 35px; margin: 10px 10px 10px 5px;">QUẢN LÝ RẠP</h3>`
          <div class="row">
            
            <div class="col-lg-3 col-md-6">
              
            </div>
            <div class="col-lg-3 col-md-6">
              
            </div>
            <div class="col-lg-3 col-md-6">
              
            </div>
            <div class="col-lg-3 col-md-6">
              <a class="btn" href="${pageContext.request.contextPath}/admin/addRap">Thêm rạp mới</a>
            </div>
          </div>
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Mã rạp <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Tên rạp <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Thành phố <span class="caret"></span></a></td>
                    <td>Sửa</td>                   
                    <td>Xóa</td>
                  </tr>
                </thead>
                <tbody>

					<c:forEach items="${rapList}" var="item" varStatus="status">
						<tr>
							<td class="text-center">${status.count}</td>
							<td>${item.theaterId}</td>
							<td>${item.theaterName}</td>
							<td>${item.city}</td>							
							<td><a
								href="${pageContext.request.contextPath}/admin/${item.theaterId}">
									<button class="btn btn-outline-secondary color-icon">
										<i class="fa-solid fa-pen-to-square"></i>
									</button>
							</a></td>
							<td>
								<button type="button" class="btn btn-outline-secondary"
									data-bs-toggle="modal" data-bs-target="#exampleModal"
									onclick="showModalDelete('${item.theaterId}', '${item.theaterName}')">
									<i class="fa-solid fa-trash"></i>
								</button>
							</td>
						</tr>
					</c:forEach>
                  
                </tbody>
              </table>    
            </div>                          
          </div> 
        </div>
      </div>