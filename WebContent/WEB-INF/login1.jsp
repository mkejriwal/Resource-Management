<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consumer Login</title>
</head>
<body>
	<form method="post" action="LoginCheck1">
		<table>
			<tr>
				<td>Consumer Name</td>
				<td><input type="text" name="cname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="cpassword"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="consumer login"></td>
			</tr>
		</table>
	</form>
</body>
</html>