<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/Resource_Management2/login.css" type="text/css">
<title>Owner Login</title>
</head>
<body>
	<form method="post" action="LoginCheck">
	<div class="container">
		<table>
			<tr>
				<td><label for="oname"><b>Owner Id</b></label></td>
				<td><input type="text" placeholder="Owner Id" name="oname" id="oname" required></td>
			</tr>
			<tr>
				<td><label for="opassword"><b>Password</b></label></td>
				<td><input type="password" placeholder="Password" name="opassword" id="opassword" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="owner login" class="addresbtn"></td>
			</tr>
		</table>
		</div>
	</form>

</body>
</html>