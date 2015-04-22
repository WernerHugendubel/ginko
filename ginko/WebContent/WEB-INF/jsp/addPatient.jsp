<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>
        Add a new patient
    </title>
</head>
<body>

<div id='cssmenu'>
<ul>
   <li class=''><a href='${pageContext.request.contextPath}'>Home</a></li>
</ul>
</div>
	<form name="patientform" action="addPatientCheck" method="post">
		<input name="patientid" type="text" placeholder="patientid" />
		<br />
		<input name="patientname" type="text" placeholder="patientname" />
		<br />	
		<input name="bednr" type="text" placeholder="bednr" />
		<br />	
			
		<input type="submit" name="submit" value="Add..." class="button" />
		
	</form>
</body>
</html>
