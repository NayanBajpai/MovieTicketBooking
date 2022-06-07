<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.error{color:red}
</style>
</head>
<body>
<h1>Add Movie</h1>
<form:form action="${pageContext.request.contextPath}/movie/save" method="post" modelAttribute="movie" enctype="multipart/form-data">
<table border="1" cellsspacing="0" cellpadding="10">
<tr>
<td>Title :</td><td><form:input path="title"/>
<form:errors path="title" cssClass="error"/>

<!-- create a hiiden field to store the id -->
<form:hidden path="Id"/>
</td>
</tr>


<tr>
<td>Release Date :</td><td><form:input path="releaseDate" />
<form:errors path="releaseDate" cssClass="error"/>
</td>
</tr>

<tr>
<td>Duration :</td><td><form:input path="movieLength" />
<form:errors path="movieLength" cssClass="error"/>
</td>
</tr>

<tr>
<td>Genre :</td><td><form:input path="movieGenre" />
<form:errors path="movieGenre" cssClass="error"/>
</td>
</tr>



<tr>
<td>Language :</td><td><form:select path="movieLanguage">  
        <form:option value="Hindi" label="Hindi"/>  
        <form:option value="Telugu" label="Telugu"/>  
        <form:option value="Kannada" label="Kannada"/>  
        <form:option value="Marathi" label="Marathi"/>  
        <form:option value="Bengali" label="Bengali"/>
        </form:select>  
</td>
</tr>

<tr>
<td>Description :</td><td><form:input path="movieDescription" />
<form:errors path="movieDescription" cssClass="error"/>
</td>
</tr>

<tr>
<td>Status :</td><td><form:radiobutton path="movieStatus" value="Available" />Available
<td><form:radiobutton path="movieStatus" value="Not Available" />Not Available
<form:errors path="movieStatus" cssClass="error"/>
</td>
</tr>

<tr>
<td>Director :</td><td><form:input path="movieDirector" />
<form:errors path="movieDirector" cssClass="error"/>
</td>
</tr>

<tr>
<td>Cast :</td><td><form:input path="movieHero" />
<form:errors path="movieHero" cssClass="error"/>
</td>
</tr>


<tr>
<td>
Select photo:
<input type="file" name="photo"/></td>
<form:errors path="filename" cssClass="error"/>
<form:hidden path="filename"/>
<form:hidden path="Id"/>
</tr>

<tr>
<td>


</td>
</tr>
<td colspan="2"><input type="Submit" value="Submit"></td>
</table>
 

</form:form>

 
</body>
</html>