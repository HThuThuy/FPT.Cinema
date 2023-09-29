<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.text.DecimalFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

  <div class="templatemo-content col-1 black-bg"> 
        <div class="templatemo-content-container">
          <h3 style="font-size: 35px; margin: 10px 10px 10px 5px;">THỐNG KÊ RẠP</h3>`
          <div class="row">
            
            <div class="col-lg-3 col-md-6">
              
            </div>
            <div class="col-lg-3 col-md-6">
              
            </div>
            <div class="col-lg-3 col-md-6">
              
            </div>
            <div class="col-lg-3 col-md-6">
              
            </div>
          </div>
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
							<td>${item.theaterName}</td>
							<td>${item.city}</td>
							<td>${item.address}</td>
							<td>${item.phone}</td>	
							<td><fmt:formatNumber value="${item.doanhThu}" pattern="###,###"/></td>							
						</tr>
					</c:forEach>
                  
                </tbody>
              </table>    
            </div>                          
          </div> 
        </div>
      </div>