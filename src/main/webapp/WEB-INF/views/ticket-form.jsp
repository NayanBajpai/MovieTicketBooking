<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Process</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a href="javascript:history.go(-1)" class="btn btn-info">Go Back</a><br/>
<div align="center">
	<h1>Register a New Show</h1>
<table border="1" cellspacing="1" cellpadding="10">
<tr>
<th>Show Id</th><th> Movie</th><th>Inox</th><th>Screen</th><th>Timing</th>
</tr>

<tr>

<td>${show.showId}</td>
<td>${show.movie.title}</td>
<td>${show.inox.title}</td>
<td>${show.screen.title}</td>
<td>${show.time}</td>

</tr>

</table>
<br/>


	<h1>Select seats</h1>
	<form:form action="${contextPath}/ticket/save" modelAttribute="ticket" method="post" >
	
<form:checkbox path="seats" value="1"/>A0
<form:checkbox path="seats" value="2"/>A1
<form:checkbox path="seats" value="3"/>A2
<form:checkbox path="seats" value="4"/>A3
<form:checkbox path="seats" value="5"/>A4
<form:checkbox path="seats" value="6"/>A5
<form:checkbox path="seats" value="7"/>A6
<form:checkbox path="seats" value="8"/>A7
<form:checkbox path="seats" value="9"/>A8
<form:checkbox path="seats" value="10"/>A9<br/><br/>
<form:checkbox path="seats" value="20"/>B0
<form:checkbox path="seats" value="11"/>B1
<form:checkbox path="seats" value="12"/>B2
<form:checkbox path="seats" value="13"/>B3
<form:checkbox path="seats" value="14"/>B4
<form:checkbox path="seats" value="15"/>B5
<form:checkbox path="seats" value="16"/>B6
<form:checkbox path="seats" value="17"/>B7
<form:checkbox path="seats" value="18"/>B8
<form:checkbox path="seats" value="19"/>B9<br/><br/>
<form:checkbox path="seats" value="21"/>C0
<form:checkbox path="seats" value="21"/>C1
<form:checkbox path="seats" value="23"/>C2
<form:checkbox path="seats" value="24"/>C3
<form:checkbox path="seats" value="25"/>C4
<form:checkbox path="seats" value="26"/>C5
<form:checkbox path="seats" value="27"/>C6
<form:checkbox path="seats" value="28"/>C7
<form:checkbox path="seats" value="29"/>C8
<form:checkbox path="seats" value="30"/>C9<br/><br/>
</td>
</tr>

<td colspan="2"><input type="Submit" value="Submit"></td>
		</table>
	

	
	

	</form:form>
	</div>
</body>
</html>