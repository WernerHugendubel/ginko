<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add a new patient</title>
</head>
<body>

	<a href='${pageContext.request.contextPath}'>Home</a>
	<h3>Update patient</h3>
	<form name="patientform" action="patientUpdate" method="post">
		Patient Id: ${requestScope.patient.patientId}<input name="patientId"
			type="hidden" value="${requestScope.patient.patientId}" /> <br />
		Patient Name: <input name="patientName" type="text"
			value="${requestScope.patient.name}" /> <br /> Bed number:<input
			name="bedNr" type="text" value="${requestScope.patient.bednr}" /> <br />
		<input type="submit" name="submit" value="Update..." class="button" />
		<a href='${pageContext.request.contextPath}'>cancel</a>
	</form>
</body>
</html>
