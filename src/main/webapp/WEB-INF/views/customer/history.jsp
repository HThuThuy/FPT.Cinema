<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="templatemo-content col-1 black-bg">
	<div class="templatemo-content-container">
		<h3 style="font-size: 35px; margin: 10px 10px 30px 5px;">LỊCH SỬ GIAO DỊCH</h3>
		<div class="row ml-1"
			style="display: flex; justify-content: center; align-items: center;">

			<div class="col-lg-3 col-md-3 mb-3">
			    <label for="startDate">
			        <h3 style="display: flex; justify-content: center; align-items: center; font-size: 20px; margin: 10px 10px 10px 5px;">Từ</h3>
			        <input type="date" id="startDate" name="startDate">
			    </label>
			</div>
			
			<div class="col-lg-3 col-md-3 mb-3">
			    <label for="endDate">
			        <h3 style="font-size: 20px; margin: 10px 10px 10px 5px;">Đến</h3>
			        <input type="date" id="endDate" name="endDate">
			    </label>
			</div>



			<div class="col-lg-3 col-md-6"></div>
		</div>
		<div class="templatemo-content-widget no-padding">
			<div class="panel panel-default table-responsive">
				<table 
					class="table table-light table-striped table-bordered text-center">
					<thead>
						<tr>
							<th style="background-color: #e75e8d; color: white;">#</th>							
							<th style="background-color: #e75e8d; color: white;">Ngày</th>							
							<th style="background-color: #e75e8d; color: white;">Số giao dịch</th>
							<th style="background-color: #e75e8d; color: white;">Mã Vé</th>
							<th style="background-color: #e75e8d; color: white;">Rạp</th>
							<th style="background-color: #e75e8d; color: white;">Tên phim</th>
							<th style="background-color: #e75e8d; color: white;">Giá trị</th>
							<th style="background-color: #e75e8d; color: white;">QR code</th>							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${historyList}" var="item" varStatus="status">
							<tr style="font-size: 15px" class="align-middle">
								<td class="text-center">${status.count}</td>
								<td>${item.orderDate}</td>								
								<td>${item.orderId}</td>								
								<td>${item.ticketId}</td>
								<td>${item.theaterName}</td>
								<td>${item.movieName}</td>
								<td>${item.totalPrice}</td>
								<td>${item.QRCode}</td>
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

