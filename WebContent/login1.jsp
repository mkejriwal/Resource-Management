<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/Resource_Management2/login1.css" type="text/css">
<title>Consumer Login</title>
</head>
<body>
	<form method="post" action="LoginCheck1">
	<div class="container">
		<table>
			<tr>
				<td><label for="cname"><b>Consumer Id</b></label></td>
				<td><input type="text" placeholder="Consumer Id" name="cname" id="cname" required></td>
			</tr>
			<tr>
				<td><label for="cpassword"><b>Password</b></label></td>
				<td><input type="password" placeholder="Password" name="cpassword" id="cpassword" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="consumer login" class="addresbtn"></td>
			</tr>
		</table>
		</div>
	</form>
</body>
</html>