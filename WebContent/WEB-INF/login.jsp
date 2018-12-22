<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner Login</title>
</head>
<body>
	<form method="post" action="LoginCheck">
		<table>
			<tr>
				<td>Owner Name</td>
				<td><input type="text" name="oname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="opassword"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Owner login"></td>
			</tr>
		</table>
	</form>

</body>
</html>