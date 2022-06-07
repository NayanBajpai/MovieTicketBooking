<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h1>Role</h1>
<form:form action="${pageContext.request.contextPath}/role/saverole" modelAttribute="role">
<table border="1" cellpadding="10" cellspacing="0">
<tr>
<th>Role name</th><td><form:input path="role"/>
<form:hidden path="roleid"/>
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Submit">
</td>
</tr>
</table>
</form:form>
</body>
</html>