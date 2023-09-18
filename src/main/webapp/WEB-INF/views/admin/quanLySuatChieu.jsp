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
				<form:form class="row"
					action="${pageContext.request.contextPath}/admin/searchSuatChieu"
					method="get">
					
					<div class="col-lg-1 col-md-1">
						
					</div>

					<div class="col-lg-6 col-md-6">
						<input type="hidden" name="page" value="${1}" />
						<input
							id="nameCustomer" type="text" name="searchName"
							class="form-control ml-1" value="${searchName}"
							placeholder="Nhập tên suất chiếu">
					</div>

					<div class="col-lg-3 col-md-3">
						<button type="submit" class="btn">Search</button>
					</div>

				</form:form>
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
					class="table table-striped table-bordered templatemo-user-table">
					<thead>
						<tr>
							<td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
							<td><a href="" class="white-text templatemo-sort-by">Mã suất chiếu <span class="caret"></span></a></td>
							<td><a href="" class="white-text templatemo-sort-by">Tên phim <span class="caret"></span></a></td>
							<td><a href="" class="white-text templatemo-sort-by">Têp rạp <span class="caret"></span></a></td>
							<td><a href="" class="white-text templatemo-sort-by">Bắt đầu <span class="caret"></span></a></td>
							<td><a href="" class="white-text templatemo-sort-by">Kết thúc <span class="caret"></span></a></td>
							<td>Sửa</td>
							<td>Xóa</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${suatchieuList}" var="item" varStatus="status">
							<tr>
								<td class="text-center">${status.count}</td>
								<td>${item.showtimeId}</td>
								<td>${item.movie.movieName}</td>
								<td>${item.theater.theaterName}</td>
								<td>${item.startTime}</td>
								<td>${item.endTime}</td>
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
										onclick="showModalDelete('${item.showtimeId}')">
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
		<c:if test="${suatchieuList.size() !=0}">
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