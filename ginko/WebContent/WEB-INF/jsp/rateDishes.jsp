<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Rating dishes</title>
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
	    ${dishRating.dish.dishId} - ${dishRating.dish.name}: rating: ${dishRating.rating} 
		 <table><tr>
		 <td><form action="/ginko/rateDishes?orderId=${order.orderId}&dishId=${dishRating.dish.dishId}&rating=1" method="post"> <input type="submit" value="rate 1"></form></td>
		 <td><form action="/ginko/rateDishes?orderId=${order.orderId}&dishId=${dishRating.dish.dishId}&rating=2" method="post"> <input type="submit" value="rate 2"></form></td>
		 <td><form action="/ginko/rateDishes?orderId=${order.orderId}&dishId=${dishRating.dish.dishId}&rating=3" method="post"> <input type="submit" value="rate 3"></form></td>
		 <td><form action="/ginko/rateDishes?orderId=${order.orderId}&dishId=${dishRating.dish.dishId}&rating=4" method="post"> <input type="submit" value="rate 4"></form></td>
		 <td><form action="/ginko/rateDishes?orderId=${order.orderId}&dishId=${dishRating.dish.dishId}&rating=5" method="post"> <input type="submit" value="rate 5"></form></td>
	</tr>
	</table>
	</c:forEach>
	<hr>
	<c:if test="${error  != null}">
   		<p>Error is: <c:out value="${error}"/></p>
   	</c:if>
</body>
</html>
