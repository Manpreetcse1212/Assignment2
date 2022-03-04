<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink">
	<table border="1">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>Subject1</th>
				<th>Subject2</th>
				<th>Subject3</th>
				<th>Subject4</th>
				<th>Subject5</th>
			</tr>
		</thead>
		<tbody>
			<%
			session = request.getSession(false);
			List<String> firstnameValues = (List<String>) session.getAttribute("firstnameValues");
			List<String> lastnameValues = (List<String>) session.getAttribute("lastnameValues");
			List<String> addressValues = (List<String>) session.getAttribute("addressValues");
			List<String> sub1Values = (List<String>) session.getAttribute("sub1Values");
			List<String> sub2Values = (List<String>) session.getAttribute("sub2Values");
			List<String> sub3Values = (List<String>) session.getAttribute("sub3Values");
			List<String> sub4Values = (List<String>) session.getAttribute("sub4Values");
			List<String> sub5Values = (List<String>) session.getAttribute("sub5Values");

			for (int i = 0; i < firstnameValues.size(); i++) {
			%>
			<tr>
				<td><%=firstnameValues.get(i)%></td>
				<td><%=lastnameValues.get(i)%></td>
				<td><%=addressValues.get(i)%></td>
				<td><%=sub1Values.get(i)%></td>
				<td><%=sub2Values.get(i)%></td>
				<td><%=sub3Values.get(i)%></td>
				<td><%=sub4Values.get(i)%></td>
				<td><%=sub5Values.get(i)%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>
