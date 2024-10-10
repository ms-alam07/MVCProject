<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="Menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration List</title>
</head>
<body>
	<h2>Registration List</h2>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Action</th>
		</tr>

		<%
		ResultSet result = (ResultSet) request.getAttribute("res");
		if (result != null) {
			while (result.next()) { %>
		<tr>
			<td><%= result.getString(1) %></td>
			<td><%= result.getString(2) %></td>
			<td><%= result.getString(3) %></td>

			
			<td><a href="DeleteReg?email=<%= result.getString(2) %>">Delete</a></td>
			<td><a href="UpdateReg?email=<%= result.getString(2) %>&mobile=<%= result.getString(3) %>">Update</a></td>
		</tr>
		<% } } else { %>
		<tr>
			<td colspan="5">No records found.</td>
		</tr>
		<% } %>
	</table>
</body>
</html>
