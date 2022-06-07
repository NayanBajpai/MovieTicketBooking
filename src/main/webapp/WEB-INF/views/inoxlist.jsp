<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inox-List</title>
</head>
<body>
<h2>Inox List</h2>
<h3><a href = "${pageContext.request.contextPath}/inox/showform">Add Inox</a></h3>
<h3><a href = "${pageContext.request.contextPath}/">Go Home</a></h3>
<table border="1" cellspacing="0" cellpadding="10">
<tr>
<th>ID</th><th>Title</th><th>Location</th>
<th>Rating</th><th>No Of Screens</th>
<th>Overview</th><th>Action</th>
</tr>
<!--  data row -->
<c:forEach var="inox" items="${inoxes}">
<tr>
<td>${inox.id}</td>
<td>${inox.title}</td>
<td>${inox.inoxLocation}</td>
<td>${inox.inoxServiceRating}</td>
<td>${inox.noOfScreens}</td>


<td><img class="img-rounded"  height="150" width="150" src="${inox.filename}" /></td>



<td>
<a href="editinox/${inox.id}"> Edit</a> || 
<a href="deleteinox/${inox.id}">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>