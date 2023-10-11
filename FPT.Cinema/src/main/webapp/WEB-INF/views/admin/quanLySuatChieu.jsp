<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="templatemo-content col-1 black-bg">
	<div class="templatemo-content-container">
		<h3 style="font-size: 35px; margin: 10px 10px 30px 5px;">QUẢN LÝ SUẤT CHIẾU</h3>
		<div class="row ml-1"
			style="display: flex; justify-content: center; align-items: center;">

			<div class="col-lg-6 col-md-6">
				
			</div>

			<div class="col-lg-3 col-md-6"></div>
			<div class="col-lg-3 col-md-6">
				<a class="btn  "
					href="${pageContext.request.contextPath}/admin/addSuatChieu">Thêm suất chiếu mới</a>
			</div>
		</div>
		<div class="templatemo-content-widget no-padding">
			<div class="panel panel-default table-responsive">
				<table 
					class="table table-light table-striped table-bordered text-center">
					<thead>
						<tr class="align-middle">
							<th style="background-color: #e75e8d; color: white;">#</th>							
							<th class="d-none" style="background-color: #e75e8d; color: white;">Mã suất chiếu</th>							
							<th style="background-color: #e75e8d; color: white;">Tên rạp</th>
							<th style="background-color: #e75e8d; color: white;">Tên phòng</th>
							<th style="background-color: #e75e8d; color: white;">Giờ chiếu</th>
							<th style="background-color: #e75e8d; color: white;">Tên phim</th>
							<th style="background-color: #e75e8d; color: white;">Ngày khởi chiếu</th>
							<th style="background-color: #e75e8d; color: white;">Ngày kết thúc</th>							
							<th style="background-color: #e75e8d; color: white;">Sửa</th>
							<th style="background-color: #e75e8d; color: white;">Trạng thái</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${suatchieuList}" var="item" varStatus="status">
							<tr style="font-size: 15px" class="align-middle">
								<td class="text-center">${status.count+(currentPage-1)*5}</td>
								<td class="d-none">${item.showtimeId}</td>								
								<td>${item.room.theater.theaterName}</td>								
								<td>${item.room.roomName}</td>
								<td>${item.startTime}</td>
								<td>${item.movie.movieName}</td>
								<td>${item.movie.startDate}</td>
								<td>${item.movie.endDate}</td>
								
								<td><a
									href="${pageContext.request.contextPath}/admin/${item.showtimeId}">
										<button class="btn btn-outline-secondary color-icon">
											<i class="fa-solid fa-pen-to-square"></i>
										</button>
									</a>
								</td>
								<td>
									<button type="button" class="btn btn-outline-secondary"
										data-bs-toggle="modal" data-bs-target="#exampleModal"
										onclick="showModalDelete('${item.showtimeId}','${item.movie.movieName}','${item.showtimeState}')">
										<c:if test="${item.showtimeState.equals('1')}">
											<i class="fa-solid fa-unlock"></i>
										</c:if>
										<c:if test="${!item.showtimeState.equals('1')}">
											<i class="fa-solid fa-lock"></i>
										</c:if>
									</button>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
		
		<!--Pagination-->
		<c:if test="${suatchieuList.size() !=0}">
			<div class="pagination-wrap">
				<ul class="pagination">
					<li>
						<c:if test="${currentPage!=1}">
							<a href="?page=${currentPage - 1}&searchName=${searchName}"><span aria-hidden="true"><i class="fa-solid fa-caret-left"></i></span></a>
						</c:if> 
						<c:if test="${currentPage==1}">
							<a ><span aria-hidden="true"><i class="fa-solid fa-caret-left"></i></span></a>
						</c:if>
					</li>

					<c:forEach begin="1" end="${noOfPages}" var="i">
						<c:choose>
							<c:when test="${currentPage eq i}">								
								<li class="active"><a >${i}<span class="sr-only"></span></a></li>
							</c:when>
							<c:otherwise>								
								<li><a href="?page=${i}&searchName=${searchName}"><span aria-hidden="true">${i}</span></a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<li>
						<c:if test="${currentPage!=noOfPages}">
							<a href="?page=${currentPage + 1}&searchName=${searchName}"><span aria-hidden="true"><i class="fa-solid fa-caret-right"></i></span></a>
						</c:if> 
						<c:if test="${currentPage==noOfPages}">
							<a ><span aria-hidden="true"><i class="fa-solid fa-caret-right"></i></span></a>
						</c:if>
					</li>
				</ul>
			</div>
		</c:if>
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
						Chắn chắc <span id="delete_modal2" style="color: red;"></span> suất chiếu của phim <span id="delete_modal"></span> <span>?</span>
						<input hidden="true" id="sendId" name="showtimeId">
						<input hidden="true" id="sendId2" name="showtimeState">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
						<button type="submit" class="btn btn-danger" data-bs-dismiss="modal">Xác nhận</button>
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
		function showModalDelete(a,b,c) {
			/* alert("Ha ha "+a) */
			document.getElementById("delete_modal").innerText = b;
			
			if(c=="1") document.getElementById("delete_modal2").innerText = 'khóa';
			else document.getElementById("delete_modal2").innerText = 'mở khóa';
			
			document.getElementById("sendId").value = a; 
			document.getElementById("sendId2").value = c;
		}
	</script>