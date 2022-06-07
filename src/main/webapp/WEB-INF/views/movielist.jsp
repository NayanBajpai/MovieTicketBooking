<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie-List</title>
</head>
<body>
<h2>Movie List</h2>
<h3><a href = "${pageContext.request.contextPath}/movie/showform">Add Movie</a></h3>
<h3><a href = "${pageContext.request.contextPath}/">Go Home</a></h3>
<table border="1" cellspacing="0" cellpadding="10">
<tr>
<th>ID</th><th>Title</th>
<th>Date</th><th>Duration</th><th>Genre</th>
<th>Language</th><th>Description</th><th>Status</th>
<th>Director</th><th>Cast</th>
<th>Image</th><th>Action</th>
</tr>
<!--  data row -->
<c:forEach var="movie" items="${movies}">
<tr>
<td>${movie.id}</td>
<td>${movie.title}</td>

<td>${movie.releaseDate}</td>
<td>${movie.movieLength}</td>
<td>${movie.movieGenre}</td>
<td>${movie.movieLanguage}</td>
<td>${movie.movieDescription}</td>
<td>${movie.movieStatus}</td>
<td>${movie.movieDirector}</td>
<td>${movie.movieHero}</td>

<td><img class="img-rounded"  height="150" width="150" src="${pageContext.request.contextPath}/${movie.filename}" /></td>



<td>
<a href="editmovie/${movie.id}"> Edit</a> || 
<a href="deletemovie/${movie.id}">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>