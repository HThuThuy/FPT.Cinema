<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.text.DecimalFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

  <div class="templatemo-content col-1 black-bg"> 
  
        <div class="templatemo-content-container">
          <h3 style="font-size: 35px; margin: 10px 10px 10px 5px;">THỐNG KÊ RẠP</h3>       
          <div class="row"
			style="display: flex; justify-content: center; align-items: center;">

			<div class="col ml-1">
				<form class="row" 
					style="display: flex; justify-content: center; align-items: flex-end;"
					action="${pageContext.request.contextPath}/admin/thongKe3/search" method="get">
					
					<!-- <div class="col-lg-1 col-md-1">
						
					</div> -->

					<div class="col-lg-4 col-md-6">
						<%-- <input type="hidden" name="page" value="${1}" />  --%>
						<label style="font-weight:bold; font-size:18px; color: #e75e8d;">Ngày bắt đầu</label>
						<input
							id="nameCustomer" type="date" name="searchDate"
							class="form-control ml-1" value="${searchDate}">
					</div>					
										
					<div class="col-lg-4 col-md-6">
						<input type="hidden" name="page" value="${1}" /> 
						<label style="font-weight:bold; font-size:18px; color: #e75e8d;">Ngày kết thúc</label>
						<input
							id="nameCustomer" type="date" name="searchDate2"
							class="form-control ml-1" value="${searchDate2}">
					</div>

					<div class="col-lg-3 col-md-3">
						<button type="submit" class="btn">Search</button>
					</div>

				</form>
			</div>			
			
		</div>
		
		<input value="${rapList.size()}" id="size" hidden="true">
          
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-light table-striped table-bordered text-center">
                <thead>
                	<tr>
						<th style="background-color: #e75e8d; color: white;">#</th>							
						<th style="background-color: #e75e8d; color: white;">Têp rạp</th>
						<th style="background-color: #e75e8d; color: white;">Thành phố</th>
						<th style="background-color: #e75e8d; color: white;">Địa chỉ</th>
						<th style="background-color: #e75e8d; color: white;">Hotline</th>
						<th style="background-color: #e75e8d; color: white;">Doanh thu</th>
					</tr>                  
                </thead>
                <tbody>
					<c:forEach items="${rapList}" var="item" varStatus="status">
						<tr class="align-middle">
							<td class="text-center">${status.count}</td>
							<td id="name${status.count}">${item.theaterName}</td>
							<td>${item.city}</td>
							<td>${item.address}</td>
							<td>${item.phone}</td>	
							<%-- <td id="doanhthu${status.count}">${item.doanhThu}</td> --%>
							<td id="doanhthu${status.count}"><fmt:formatNumber value="${item.doanhThu}" pattern="###,###"/></td>	 						
						</tr>
					</c:forEach>
                  
                </tbody>
              </table>    
            </div>                          
          </div>

		<div>

			<!-- Website Traffic -->
			<div class="card">
				<div class="card-body pb-0">
					<div id="trafficChart" style="min-height: 400px;" class="echart"></div>						
				</div>
			</div>
			<!-- End Website Traffic -->			
			
		</div>


	</div>
      </div>

<script>							
    document.addEventListener("DOMContentLoaded", () => { 
    	
    	/* var series2='[{"value": 100, "name": "bar"}, {"value": 200, "name":"bar2"}]' */
    	
    	var series2='['
    	
    	for (var i = 1; i <= $('#size').val(); i++) {
            var nameId = "name" + i;
            var doanhthuId = "doanhthu" + i;

            var nameValue = document.getElementById(nameId).textContent;
            var doanhthuValue = document.getElementById(doanhthuId).textContent.replace(/\./g, '');

            console.log("Giá trị của " + nameId + ": " + nameValue);
            console.log("Giá trị của " + doanhthuId + ": " + doanhthuValue);
            
            if(i == $('#size').val()) 
            	 series2+='{"value": '+doanhthuValue+', "name": "'+nameValue+'"}]'
    		else series2+='{"value": '+doanhthuValue+', "name": "'+nameValue+'"},'  
        }   	
    	
    	
        echarts.init(document.querySelector("#trafficChart")).setOption({
            tooltip: {
                trigger: 'item'
            },
            legend: {
                show: true,
                top: '5%',
                left: 'center'
            },
            series: [{
                name: 'Doanh Thu',
                type: 'pie',
                radius: ['40%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    label: {
                        show: true,
                        fontSize: '18',
                        fontWeight: 'bold'
                    }
                },
                labelLine: {
                    show: false
                },
                data: JSON.parse(series2)                
            }]
        });
    });
</script>