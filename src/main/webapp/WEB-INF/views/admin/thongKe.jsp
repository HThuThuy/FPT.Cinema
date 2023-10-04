<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.text.DecimalFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="templatemo-content col-1 black-bg">
	<div class="templatemo-content-container">
		<h3 style="font-size: 35px; margin: 10px 10px 30px 5px;">THỐNG KÊ SUẤT CHIẾU</h3>
		<div class="row ml-1"
			style="display: flex; justify-content: center; align-items: center;">

			<div class="col-lg-6 col-md-6"></div>
			<div class="col-lg-3 col-md-6"></div>
			<div class="col-lg-3 col-md-6">
				
			</div>
		</div>
		<div class="templatemo-content-widget no-padding">
			<div class="panel panel-default table-responsive">
				<table 
					class="table table-light table-striped table-bordered text-center">
					<thead>
						<tr class="align-middle">
							<th style="background-color: #e75e8d; color: white;">#</th>	
							<th style="background-color: #e75e8d; color: white;">Tên rạp</th>
							<th style="background-color: #e75e8d; color: white;">Tên phòng</th>
							<th style="background-color: #e75e8d; color: white;">Giờ chiếu</th>
							<th style="background-color: #e75e8d; color: white;">Tên phim</th>
							<th style="background-color: #e75e8d; color: white;">Ngày khởi chiếu</th>
							<th style="background-color: #e75e8d; color: white;">Ngày kết thúc</th>							
							<th style="background-color: #e75e8d; color: white;">Doanh thu</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${suatchieuList}" var="item" varStatus="status">
							<tr style="font-size: 15px" class="align-middle">
								<td class="text-center">${status.count+(currentPage-1)*5}</td>							
								<td>${item.theaterName}</td>								
								<td>${item.roomName}</td>
								<td>${item.startTime}</td>
								<td>${item.movieName}</td>
								<td>${item.startDate}</td>
								<td>${item.endDate}</td>
								<td>
									<%-- ${item.doanhThu} --%>
									<fmt:formatNumber value="${item.doanhThu}" pattern="###,###"/>
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