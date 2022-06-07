<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome to the admin panel

<div align = "center">  
        
       <a h1 style = "color:#827BCD" href="${pageContext.request.contextPath}/movie/list">Movies</a> ||  <a h1 style = "color:#827BCD" href="${pageContext.request.contextPath}/user/list">Users</a> 
      || <a h1 style = "color:#827BCD" href="${pageContext.request.contextPath}/role/list">Roles</a>
      || <a h1 style = "color:#827BCD" href="${pageContext.request.contextPath}/inox/list">Inox</a>
         || <a h1 style = "color:#827BCD" href="${pageContext.request.contextPath}/screen/list">Screens</a>
      || <a h1 style = "color:#827BCD" href="${pageContext.request.contextPath}/show/list">Shows</a>
       </div>
</body>
</html>