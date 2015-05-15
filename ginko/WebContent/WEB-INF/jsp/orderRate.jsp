<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Orders for patient</title>
</head>
<body>

	<a href='${pageContext.request.contextPath}'>Home</a>
	<h3>Rate Order for patient</h3>
	id:${requestScope.patient.patientId} <br>
	name:${requestScope.patient.name}<br> 
    bednr:${requestScope.patient.bednr}<br>
	<hr>
	<h4>Restrictions:</h4>
	<c:forEach items="${requestScope.patient.restrictions}" var="restriction">
	    ${restriction.restrictionId} - ${restriction.name}<br>
	</c:forEach>
	<hr>
	<h3>Orders</h3>
	<c:forEach items="${requestScope.orders}" var="order">
	    <c:if test="${order.hasRatings()==true}">
	      <p style="background:yellow">
	   </c:if>
	    ${order.orderId} - ${order.orderDate} 	<a href='${pageContext.request.contextPath}/rateDishes?orderId=${order.orderId}'>rate dishes...</a> <p>
	</c:forEach>
	<hr>
</body>
</html>
