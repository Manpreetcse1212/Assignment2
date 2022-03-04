<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculate area</title>
</head>
<body style="background-color:pink">
<h1>Areas of Triangle and square</h1>
<table border="1">
<thead>
<tr>
<td><h1>The area of square is <%=session.getAttribute("area_of_square") %> </h1></td>
<td>
<h1>The area of triangle is <%=session.getAttribute("area_of_triangle") %> </h1></td>
</tr>
</table>
</body>
</html>