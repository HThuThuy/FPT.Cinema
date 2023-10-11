<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>

input#startDate, input#endDate {
    width: 320px;
}

button.btn.btn-primary {
	width: 100px;
	height: 40px;
	border-radius: 8px;
}

.pagination a {
	margin: 10px 5px;
	text-decoration: none;
	color: black;
}

.pagination a.active {
	color: red;
}

nav.pagination.ml-4 {
    margin-left: 10px;
}

form {
    display: flex;
    justify-content: start;
    align-items: center;
    margin-left: 10px;
}

button.btn.btn-primary {
    margin-top: 45px;
}

</style>


<div class="templatemo-content col-1 black-bg">
	<div class="templatemo-content-container">
		<h3 class="text-center display-4 mb-4" style="font-size: 35px;">LỊCH
			SỬ GIAO DỊCH</h3>

		<div class="row">

			<form style="display: flex;" action="/FPT-Cinema/customer/history"
				method="get">
				<div class="col-3">
					<label for="startDate">
						<h3 style="font-size: 25px;">Từ</h3> 
						<input type="date" id="startDate" name="startDate" class="form-control mt-3"	style="font-size: 15px;">
					</label>
				</div>

				<div class="col-3">
					<label for="endDate">
						<h3 style="font-size: 25px;">Đến</h3> 
						<input type="date"	id="endDate" name="endDate" class="form-control mt-3"	style="font-size: 15px;">
					</label>
				</div>
				<button type="submit" class="btn btn-primary">Tìm kiếm</button>
			</form>




		</div>


		<div class="templatemo-content-widget no-padding mt-4">
			<div class="panel panel-default table-responsive">
				<table
					class="table table-light table-striped table-bordered text-center">
					<thead>
						<tr>
							<th style="background-color: #e75e8d; color: white;">#</th>
							<th style="background-color: #e75e8d; color: white;">Ngày</th>
							<th style="background-color: #e75e8d; color: white;">Số giao
								dịch</th>
							<th style="background-color: #e75e8d; color: white;">Mã Vé</th>
							<th style="background-color: #e75e8d; color: white;">Rạp</th>
							<th style="background-color: #e75e8d; color: white;">Tên
								phim</th>
							<th style="background-color: #e75e8d; color: white;">Giá trị</th>
							<th style="background-color: #e75e8d; color: white;">QR code</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty historyList}">
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
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="8" class="text-center">Vui lòng bấm tìm kiếm để hiển thị thông tin về lịch sử mua.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>

		<!--Pagination-->
		<nav aria-label="Page navigation" class="pagination ml-4">
			<ul class="pagination">
				<c:if test="${currentPage > 1}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/customer/history?page=${currentPage - 1}&startDate=${startDate}&endDate=${endDate}"
						aria-label="Previous" style="background-color: #e75e8d;"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>

				<c:forEach var="i" begin="1" end="${noOfPages}">
					<c:choose>
						<c:when test="${i == currentPage}">
							<li class="page-item active"><a class="page-link"
								href="${pageContext.request.contextPath}/customer/history?page=${i}&startDate=${startDate}&endDate=${endDate}"
								style="background-color: #e75e8d;">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${pageContext.request.contextPath}/customer/history?page=${i}&startDate=${startDate}&endDate=${endDate}"
								style="background-color: #e75e8d;">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${currentPage < noOfPages}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/customer/history?page=${currentPage + 1}&startDate=${startDate}&endDate=${endDate}"
						aria-label="Next" style="background-color: #e75e8d;"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</ul>
		</nav>
		<!--End Pagination-->

	</div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	document.addEventListener('DOMContentLoaded', function() {
		const startDateInput = document.getElementById('startDate');
		const endDateInput = document.getElementById('endDate');
		const searchButton = document.getElementById('searchButton');
		const searchForm = document.getElementById('searchForm');

		const defaultStartDate = '2023-01-01';
        const defaultEndDate = new Date().toISOString().split('T')[0]; // Lấy ngày hiện tại

        startDateInput.value = defaultStartDate;
        endDateInput.value = defaultEndDate;

        
        // Tự động gửi form khi trang được tải
        searchForm.submit();

    	
	});

   
</script>

