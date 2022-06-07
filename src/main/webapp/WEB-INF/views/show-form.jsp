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
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a href="javascript:history.go(-1)" class="btn btn-info">Go Back</a><br/>

	<h1>Register a New Show</h1>

<div>

<form:form action="${contextPath}/show/save" modelAttribute="show" method="post" >

	
	<form:hidden path="showId"/>
		<table border="1" cellspacing="0" cellpadding="10">
		<tr>
		<td>Movie Name </td><td>
 <form:select path="movie.Id">    
       <option value="-1">Select a type</option>
       <c:forEach items="${movies}" var="movie">
       <option value="${movie.id}"  ${show.movie.id == movie.id ? 'selected' : ''}>${movie.title}</option>
      	 
       </c:forEach>
      </form:select>
     
</td>
 		
 		</tr>

<tr>
		<td>Inox Name </td><td>
 <form:select path="inox.Id">    
       <option value="-1">Select a type</option>
       <c:forEach items="${inox}" var="inox">
       <option value="${inox.id}"  ${show.inox.id == inox.id ? 'selected' : ''}>${inox.title}</option>
      	 
       </c:forEach>
      </form:select>
     
</td>
 		
 		</tr>
			
<tr>
		<td>Screen Name </td><td>
 <form:select path="screen.Id">    
       <option value="-1">Select a type</option>
       <c:forEach items="${screen}" var="screen">
       <option value="${screen.id}"  ${show.screen.id == screen.id ? 'selected' : ''}>${screen.title}</option>
      	 
       </c:forEach>
      </form:select>
     
</td>
 		
 		</tr>		
		
		<tr>
<td>Timing :</td><td><form:input path="time" />

</td>
</tr>	
			
		<tr>
			<td colspan="2"><input type="submit" value="Register Movie" class="btn btn-info" /></td>
			</tr>
		</table>
	

	
	

	</form:form>
</div>

</body>
</html>