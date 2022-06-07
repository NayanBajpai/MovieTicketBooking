<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration</h1>
<form action="processform" method="POST">
<table cellspacing="0" cellpadding="10" border="1">
<tr>
<th>Name</th><td><input type="text" name="name" 
id="name" value="" placeholder="Enter Name" maxlength="20" required ></td>
</tr>
<tr>
<th>Email</th><td><input type="text" name="email" 
id="email" value="" placeholder="Enter email" maxlength="20" required></td>
</tr>
<tr>
<th>Password</th><td><input type="password" name="password" 
id="password" value="" placeholder="Enter Password" maxlength="20"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Submmit"></td>
</tr>
</table>
</form>
</body>
</html>