<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">
    </head>
    <body style = "background-color:#570A57 ">
    <div align = "center">
        <h1 style = "color:#FFE69A">WELCOME TO ONLINE TICKET BOOKING </h1>
        <p style = "color:#FFE69A">Book Tickets from Your Home</p></div>
        <div align = "center"><a href="${pageContext.request.contextPath}/adminpanel" style = "color:#FFE69A"> Admin Panel</a></div>
       <div align = "center">  
        
       
      <a h1 style = "color:#F9F3EE" href="${pageContext.request.contextPath}/show/list">Shows</a>
       </div>

          
         <!-- Heading -->
    
      <table cellspacing="0" cellpadding="10" width="100%">
      	<tr>
      	
      	<td>
      	<!--  Heading  -->
      	<div align = "center">
      	<table cellspacing="0" cellpadding="0" bgcolor="yellow">
      		<tr>
      		<td width="10%">
      		</td>
      		<td align="center">
      		<h1>INOX BOOKING</h1>
      		</td>
      		<td width="10%">
      		</tr>
      		<tr>
      		<td colspan="2"><hr color="white"></td>
      		</tr>
      		<tr>
      		<td colspan="2" class="menutd" align="center"> <a class="menu" style = "color:black" href="${pageContext.request.contextPath}/login">Login</a> 
      		</td>
      		</tr>
      	</table>
      	</div align="center">
      	
      	</td>
      	</tr>
      	<tr>
      	<td>&nbsp;</td>
      	</tr>
      		<tr>
      	<td>
      	
      	
      	</center>
      	</td>
      	</tr>
      	
      	
      	<tr>
      	<td align="center">
      	<h1> My Tickets</h1>
      	</tr>
      	<tr>
      
   
      	<td>
       
      	
      	<table border="1" cellspacing="0" cellpadding="10" width="100%">
      	<c:set var="divCount" scope="page" value="0"/>
      <c:forEach var="item" items="${shows}">
       <c:if test="${divCount % 2 == 0}"> 
      	<tr>
      	<td style="text-align: center;">
      	
      	<table  cellspacing="0" cellpadding="10" width="100%">
      	<tr>
      	<td>
      	<h1>${show.movie.title}</h1>
      	</td>
      	</tr>
      	<tr>
      	<td>
      	<h1><img class="img-rounded"  height="150" width="150" src="${movie.filename}" /></h1>
      	</td>
      	</tr>
      	
      	<tr>
      	<td>
      	<a href="itemdetails/${show.showId}" class="menu">View Details</a>
      	<a href="addtocart/${show.showId}" class="menu">Add To cart</a>
      	</td>
      	</tr>
      	
      	</table>
      	</td>
      	</c:if>
      	
      	 <c:if test="${divCount % 2 != 0}">  
      	<td style="text-align: center;">
      	
      	<table  cellspacing="0" cellpadding="10" width="100%">
      		
      	<tr>
      	<td>
      	<h1>${movie.title}</h1>
      	</td>
      	</tr>
      	
      	<td>
      	<h1>${movie.title}</h1>
      	</td>
      	</tr>
      	<tr>
      	<td>
      	<a href="itemdetails/${item.itemId}" class="menu">View Details</a>
      	<a href="addtocart/${item.itemId}" class="menu">Add To cart</a>
      	</td>
      	</tr>
      	
      	</table>
     
      	</td>
      	
      	</tr>
      	</c:if>
     <c:set var="divCount" value="${divCount + 1}" />

      	</c:forEach>
      	
      </table>
      </td>
      </tr>
      </table>
    </body>
</html>
