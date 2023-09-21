<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="templatemo-content col-1 black-bg">
	<div class="templatemo-content-container">
		<h3 style="font-size: 35px; margin: 10px 10px 30px 5px;">THỐNG KÊ RẠP</h3>			
		
		<!-- TABLE -->
		<!-- TABLE THỐNG KÊ THEO RẠP-->
		<div class="templatemo-content-widget no-padding">
			<div class="panel panel-default table-responsive">
				<table
					class="table table-light table-striped table-bordered text-center">
					<thead>
						<tr>
							<th style="background-color: #e75e8d; color: white;">#</th>							
							<th style="background-color: #e75e8d; color: white;">Mã rạp</th>
							<th style="background-color: #e75e8d; color: white;">Têp rạp</th>
							<th style="background-color: #e75e8d; color: white;">Thành phố</th>
							<th style="background-color: #e75e8d; color: white;">Doanh thu</th>
						</tr>						
					</thead>
					<tbody>

						<c:forEach items="${theaterList}" var="item" varStatus="status">
							<tr>
								<td class="text-center">${status.count}</td>
								<td>${item.theaterId}</td>
								<td>${item.theaterName}</td>
								<td>${item.city}</td>
								<td>${item.doanhThu}</td>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>		
		<!-- TABLE -->

	</div>
</div>