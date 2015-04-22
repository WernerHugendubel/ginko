<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>

   <a href='${pageContext.request.contextPath}'>Home</a>

	<p>Details for Patient:</p>
	<p>Patient ID: ${requestScope.newPatient.patientId}</p>
	<p>name: ${requestScope.newPatient.name}</p>
	<p>Bed nr: ${requestScope.newPatient.bednr}</p>

	</div>


</body>
</html>
