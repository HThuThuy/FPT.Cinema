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
								placeholder="Nhập tên suất chiếu">
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
					class="table table-striped table-bordered templatemo-user-table">
					<thead>
						<tr>
							<td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
							<td><a href="" class="white-text templatemo-sort-by">Mã suất chiếu <span class="caret"></span></a></td>
							<td><a href="" class="white-text templatemo-sort-by">Tên phim <span class="caret"></span></a></td>
							<td><a href="" class="white-text templatemo-sort-by">Tên rạp <span class="caret"></span></a></td>
							<td><a href="" class="white-text templatemo-sort-by">Bắt đầu <span class="caret"></span></a></td>
							<td><a href="" class="white-text templatemo-sort-by">Kết thúc <span class="caret"></span></a></td>							
							<td><a href="" class="white-text templatemo-sort-by">Số ghế đặt <span class="caret"></span></a></td>
							<td><a href="" class="white-text templatemo-sort-by">Số ghế trống <span class="caret"></span></a></td>
							<td><a href="" class="white-text templatemo-sort-by">Doanh thu <span class="caret"></span>
							</a></td>
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
		<div class="pagination-wrap">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li class="active"><a href="#">3 <span class="sr-only">(current)</span></a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true"><i class="fa fa-play"></i></span></a></li>
			</ul>
		</div>
	</div>
</div>