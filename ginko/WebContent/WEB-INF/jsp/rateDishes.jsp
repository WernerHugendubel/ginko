<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Order details</title>
</head>
<body>

	<a href='${pageContext.request.contextPath}'>Home</a>
	<h3>Order details</h3>
	id:${requestScope.patient.patientId} <br>
	name:${requestScope.patient.name}<br> 
    bednr:${requestScope.patient.bednr}<br>
	<c:forEach items="${requestScope.patient.restrictions}" var="restriction">
		<p>Restriction: ${restriction.restrictionId} - ${restriction.name}</p>
	</c:forEach>
	<hr>
	<c:if test="${order.hasRatings()==true}">
	   <h3 style="background:red">Ratings are given, modification is disabled</h3>
	   <hr>
	</c:if>
	<h4>Seleted dishes:</h4>
	<c:forEach items="${order.dishRatings}" var="dishRating">
	    ${dishRating.dish.dishId} - ${dishRating.dish.name}: 
		 <table><form action="/ginko/rateDishes?dishId=${dishRating.dish.dishId}?rate=1" method="post"> <input type="submit" value="rate 1"></form></table>
	</c:forEach>
	<hr>
	<c:if test="${error  != null}">
   		<p>Error is: <c:out value="${error}"/></p>
   	</c:if>
</body>
</html>
