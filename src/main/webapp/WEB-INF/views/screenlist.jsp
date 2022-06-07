<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Screen-List</title>
</head>
<body>
<h2>Screen List</h2>
<h3><a href = "${pageContext.request.contextPath}/screen/showform">Add Screen</a></h3>
<h3><a href = "${pageContext.request.contextPath}/">Go Home</a></h3>
<table border="1" cellspacing="0" cellpadding="10">
<tr>
<th>ID</th><th>Title</th><th>No Of Seats Available</th><th>Overview</th><th>Action</th>

</tr>
<!--  data row -->
<c:forEach var="screen" items="${screen}">
<tr>
<td>${screen.id}</td>
<td>${screen.title}</td>
<td>${screen.seats}</td>
<td><img class="img-rounded"  height="150" width="150" src="${screen.filename}" /></td>
<td>
<a href="editscreen/${screen.id}"> Edit</a> || 
<a href="deletescreen/${screen.id}">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>