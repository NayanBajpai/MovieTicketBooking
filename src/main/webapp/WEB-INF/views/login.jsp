<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>
<form action="processlogin" method="POST">
<table cellspacing="0" cellpadding="10" border="1">

<tr>
<th>Email *</th><td><input type="text" name="email" 
id="email" value="" placeholder="Enter email" maxlength="20" required></td>
</tr>
<tr>
<th>Password *</th><td><input type="password" name="password" 
id="password" value="" placeholder="Enter Password" maxlength="20" required></td>
</tr>
<tr>
<td colspan="2">
<font color="red"> ${errormessages}</font>
</td>
<tr>
<td colspan="2"><input type="submit" value="Submit"></td>
</tr>
</table>
</form>
</body>
</html>