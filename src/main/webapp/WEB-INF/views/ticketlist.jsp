<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Ticket List</h1>



<h3><a href = "${pageContext.request.contextPath}/">Go Home</a></h3>
<table border="1" cellspacing="0" cellpadding="10">
<tr>
<th>ID</th><th>Movie</th><th>Inox</th><th>Screen</th>
<th>Timing</th><th>Seats</th><th>Action</th>
</tr>
<!--  data row -->
<tr>
<!--  -->
<td>${show.showId}</td>
<td>${show.movie.title}</td>
<td>${show.inox.title}</td>
<td>${show.screen.title}</td>
<td>${show.time}</td>

<td>

<c:forEach var="show" items="${show.seats}">
${show}
</c:forEach>
</td>
<td>
<a href="deleteticket/${ticket.id}">Delete</a>
</td>
</tr>

</table>
</body>
</html>