<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="templatemo-content col-1 black-bg">

	<div class="templatemo-content-container">
		<h3 style="font-size: 35px; margin: 10px 10px 30px 5px;">QUẢN LÝ PHIM</h3>
		<div class="row"
			style="display: flex; justify-content: center; align-items: center;">

			<div class="col-lg-6 col-md-6">
				<form:form class="row"
					action="${pageContext.request.contextPath}/admin/searchPhim"
					method="get">
					
					<div class="col-lg-1 col-md-1">
						
					</div>

					<div class="col-lg-6 col-md-6">
						<input type="hidden" name="page" value="${1}" /> <input
							id="nameCustomer" type="text" name="searchName"
							class="form-control ml-1" value="${searchName}"
							placeholder="Nhập tên phim">
					</div>

					<div class="col-lg-3 col-md-3">
						<button type="submit" class="btn">Search</button>
					</div>

				</form:form>
			</div>			
			
			<div class="col-lg-3 col-md-6"></div>
			<div class="col-lg-3 col-md-6">
				<a class="btn " href="${pageContext.request.contextPath}/admin/addPhim">Thêm phim mới</a>
			</div>
		</div>
		<div class="templatemo-content-widget no-padding">
			<div class="panel panel-default table-responsive">
				<table
					class="table table-light table-striped table-bordered text-center">
					<thead>
						<tr>
							<th style="background-color: #e75e8d; color: white;">#</th>							
							<th style="background-color: #e75e8d; color: white;">Mã phim</th>
							<th style="background-color: #e75e8d; color: white;">Tên phim</th>
							<th style="background-color: #e75e8d; color: white;">Mô tả</th>
							<th style="background-color: #e75e8d; color: white;">Đạo diễn</th>
							<th style="background-color: #e75e8d; color: white;">Ngày bắt đầu</th>
							<th style="background-color: #e75e8d; color: white;">Ngày kết thúc</th>
							<th style="background-color: #e75e8d; color: white;">Thời lượng</th>
							<th style="background-color: #e75e8d; color: white;">Poster</th>
							<th style="background-color: #e75e8d; color: white;">Sửa</th>
							<th style="background-color: #e75e8d; color: white;">Xóa</th>
						</tr>						
					</thead>
					<tbody>

						<c:forEach items="${phimList}" var="item" varStatus="status">
							<tr>
								<td class="text-center">${status.count}</td>
								<td>${item.movieId}</td>
								<td>${item.movieName}</td>
								<td>${item.movieDescription}</td>
								<td>${item.director}</td>
								<td>${item.startDate}</td>
								<td>${item.endDate}</td>
								<td>${item.duration}</td>
								<td>${item.posterUrl}</td>
								<td>
									<a href="${pageContext.request.contextPath}/admin/${item.movieId}">
										<button class="btn btn-outline-secondary color-icon">
											<i class="fa-solid fa-pen-to-square"></i>
										</button>
									</a>
								</td>
								<td>
									<button type="button" class="btn btn-outline-secondary"
										data-bs-toggle="modal" data-bs-target="#exampleModal"
										onclick="showModalDelete('${item.movieId}', '${item.movieName}')">
										<i class="fa-solid fa-trash"></i>
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


		<!--Pagination-->
		<c:if test="${phimList.size() !=0}">
			<div class="pagination-wrap">
				<ul class="pagination">
					<li>
						<c:if test="${currentPage!=1}">
							<a href="?page=${currentPage - 1}&searchName=${searchName}"><span aria-hidden="true"><i class="fa-solid fa-caret-left"></i></span></a>
						</c:if> <c:if test="${currentPage==1}">
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
