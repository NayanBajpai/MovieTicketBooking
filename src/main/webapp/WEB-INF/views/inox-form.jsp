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
<h1>Add Inox</h1>
<form:form action="${pageContext.request.contextPath}/inox/save" method="post" modelAttribute="inox" enctype="multipart/form-data">
<table border="1" cellsspacing="0" cellpadding="10">
<tr>
<td>Title :</td><td><form:input path="title"/>
<form:errors path="title" cssClass="error"/>
<!-- create a hiiden field to store the id -->
<form:hidden path="Id"/>
</td>
</tr>


<tr>
<td>Inox Location :</td><td><form:input path="inoxLocation" />
<form:errors path="inoxLocation" cssClass="error"/>
</td>
</tr>

<tr>
<td>Rating :</td><td><form:input path="inoxServiceRating" />
<form:errors path="inoxServiceRating" cssClass="error"/>
</td>
</tr>

<tr>
<td>No Of Screens :</td><td><form:input path="noOfScreens" />
<form:errors path="noOfScreens" cssClass="error"/>
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