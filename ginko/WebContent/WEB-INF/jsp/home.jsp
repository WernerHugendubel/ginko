<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
   <li><a href='${pageContext.request.contextPath}'>Home</a></li>
   <li><a href='${pageContext.request.contextPath}/addPatient'>Add Patient</a></li>
</ul>

<h3>Patients</h3>
<p>patientid, name, bednr </p>
<c:forEach items="${patientlist}" var="patient">
    ${patient.patientId}, ${patient.name}, ${patient.bednr}, <a href='${pageContext.request.contextPath}/addOrder'>order... question: how to pass the patientid to addOrde Page</a>
    <br>
</c:forEach>

</body>
</html>