<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="templatemo-content col-1 black-bg">
	<div class="templatemo-content-container">
		<h3 style="font-size: 35px; margin: 10px 10px 30px 5px;">THỐNG KÊ SUẤT CHIẾU</h3>
			<div class="row ml-1"
				style="display: flex; justify-content: center; align-items: center;">
	
				<div class="col-lg-6 col-md-6">
					<form:form class="row"
						action="${pageContext.request.contextPath}/admin/searchSuatChieu"
						method="get">
						
						<div class="col-lg-1 col-md-1">
						
						</div>
	
						<div class="col-lg-6 col-md-6">
							<input type="hidden" name="page" value="${1}" /> <input
								id="nameCustomer" type="text" name="searchName"
								class="form-control ml-1" value="${searchName}"
								placeholder="Nhập mã suất chiếu">
						</div>
	
						<div class="col-lg-3 col-md-3">
							<button type="submit" class="btn">Search</button>
						</div>
	
					</form:form>
				</div>
	
				<div class="col-lg-3 col-md-6"></div>
				<div class="col-lg-3 col-md-6"></div>
			</div>		

		<!-- TABLE THỐNG KÊ THEO SUẤT CHIẾU-->
		<div class="templatemo-content-widget no-padding">
			<div class="panel panel-default table-responsive">
				<table
					class="table table-light table-striped table-bordered text-center">
					<thead>					
						<tr>
							<th style="background-color: #e75e8d; color: white;">#</th>							
							<th style="background-color: #e75e8d; color: white;">Mã suất chiếu</th>
							<th style="background-color: #e75e8d; color: white;">Tên phim</th>
							<th style="background-color: #e75e8d; color: white;">Têp rạp</th>
							<th style="background-color: #e75e8d; color: white;">Bắt đầu</th>
							<th style="background-color: #e75e8d; color: white;">Kết thúc</th>							
							<th style="background-color: #e75e8d; color: white;">Số ghế đặt</th>
							<th style="background-color: #e75e8d; color: white;">Số ghế trống</th>
							<th style="background-color: #e75e8d; color: white;">Doanh thu</th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach items="${suatchieuList}" var="item" varStatus="status">
							<tr>
								<td class="text-center">${status.count}</td>
								<td>${item.showtimeId}</td>
								<td>${item.movieName}</td>
								<td>${item.theaterName}</td>
								<td>${item.startTime}</td>
								<td>${item.endTime}</td>								
								<td>${item.soGheDat}</td>
								<td>${item.soGheTrong}</td>
								<td>${item.doanhThu}</td>								
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