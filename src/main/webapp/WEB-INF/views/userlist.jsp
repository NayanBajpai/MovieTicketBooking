<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User-List</title>
</head>
<body>
<h3><a href = "${pageContext.request.contextPath}/">Go Home</a></h3>
<h2>User List</h2>
<h5><a href="add">Create User</a></h5>
<table border="1" cellspacing="0" cellpadding="10">
<tr>
<th>Email ID</th><th>Name</th><th>Gender</th><th>Role</th><th></th>

</tr>
<!--  data row -->
<c:forEach var="user" items="${users}">
<tr>
<td>${user.email}</td>
<td>${user.name}</td>
<td>${user.gender}</td>
<td>${user.role.role}</td>


<td>
<a href="edituser?email=${user.email}"> Edit</a> || 
<a href="deleteuser?email=${user.email}">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>