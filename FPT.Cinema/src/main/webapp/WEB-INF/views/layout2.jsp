<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%-- <%@ page errorPage="errorPage.jsp"%> --%>

<!DOCTYPE html>
<html>
<head>
<title>FPT-Cinema</title>
<!-- Head Insert -->
<tiles:insertAttribute name="head2" />
</head>

<body>
	<div class="templatemo-flex-row">
		<!-- Menu2 Insert -->
		<tiles:insertAttribute name="menu2" />
		<!-- Body	2 Insert -->
		<tiles:insertAttribute name="body2" />
	</div>
	
	
    
	<!-- Footer2 Insert -->
	<tiles:insertAttribute name="footer2" />
	
	
</body>
</html>