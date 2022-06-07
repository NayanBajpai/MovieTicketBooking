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
<h1>Item List</h1>

<div>
      	<form action="${pageContext.request.contextPath}/show/search">
      	<input type="text" name ="freeText" placeholder = "Enter Text To Search">
      	<button>Find </button>
      	</form>
      	</div>
<h3><a href = "${pageContext.request.contextPath}/show/showform">Add Show</a></h3>
<h3><a href = "${pageContext.request.contextPath}/">Go Home</a></h3>
<table border="1" cellspacing="1" cellpadding="10">
<tr>
<th>Show Id</th><th> Movie</th><th>Inox</th><th>Screen</th><th>Timing</th><th>Action</th>
</tr>
<c:forEach var="show" items="${shows}">
<tr>

<td>${show.showId}</td>
<td>${show.movie.title}</td>
<td>${show.inox.title}</td>
<td>${show.screen.title}</td>
<td>${show.time}</td>
<td><a href="edititem/${show.showId}">Edit</a> || 
<a href="deletetem/${show.showId}" onclick="return confirm('Are you sure you want to delete this show?')">Delete</a>||
<a href="${pageContext.request.contextPath}/ticket/addshow/${show.showId}" >Book</a>
</tr>
</c:forEach>
</table>
</body>
</html>