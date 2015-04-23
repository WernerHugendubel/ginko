<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>
        Add a new patient
    </title>
</head>
<body>

   <a href='${pageContext.request.contextPath}'>Home</a> <br />
   <h3>Add new patient</h3>
	<form name="patientform" action="patientAdd" method="post">
		Patient name: <input name="patientName" type="text" placeholder="patientname" />
		<br />	
		Bed number: <input name="bedNr" type="text" placeholder="bednr" />
		<br />	
		<input type="submit" name="submit" value="Add..." class="button" />
		<br />	
        <a href='${pageContext.request.contextPath}'>cancel</a> <br />
	</form>
</body>
</html>
