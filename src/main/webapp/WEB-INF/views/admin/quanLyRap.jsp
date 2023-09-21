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
              <table class="table table-light table-striped table-bordered text-center">
                <thead>
                	<tr>
						<th style="background-color: #e75e8d; color: white;">#</th>							
						<th style="background-color: #e75e8d; color: white;">Mã rạp</th>
						<th style="background-color: #e75e8d; color: white;">Têp rạp</th>
						<th style="background-color: #e75e8d; color: white;">Thành phố</th>
						<th style="background-color: #e75e8d; color: white;">Sửa</th>
						<th style="background-color: #e75e8d; color: white;">Xóa</th>
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
      
      <!--thong bao truoc khi delete -->
	<input value="${message}" id="message" hidden="true">
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<form action="${pageContext.request.contextPath}/admin/delete" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>						
					</div>
					<div class="modal-body container-fluid">
						Chắn chắc xóa suất chiếu mã <span id="delete_modal"></span> 
						<input hidden="true" id="sendId" name="customerId"><span>?</span>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
						<button type="submit" class="btn btn-danger" data-bs-dismiss="modal">Xóa</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!--thong bao sau khi delete -->
	<div class="modal fade" id="modalAlert" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div>
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Alert</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body container-fluid">
						<p id="modalAlertMes"></p>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary"
							data-bs-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		window.onload = function() {
			if ($('#message').val() != null && $('#message').val() != "") {
				$("#modalAlertMes").html($('#message').val());
				$(document).ready(function() {
					$('#modalAlert').modal("show")
				})
			}
		}
	</script>

	<script>
		function showModalDelete(a) {
			/* alert("Ha ha "+a) */
			document.getElementById("delete_modal").innerText = a;
			document.getElementById("sendId").value = a; 
		}
	</script>