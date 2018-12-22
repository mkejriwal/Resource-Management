<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file = "headerc.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/Resource_Manangement2/bookRes.css" type="text/css">
<title>Department</title>
</head>
<script>
function func() {
  alert("Departent Has Been Selected!!");
}
</script>

<body>
<form action="Dept" method="post">
  <div class="container">
    <h1>Select Department</h1>
    <p>Please fill in this form to select a department</p>
    <hr>

	 <label for="deptname"><b>Department Name</b></label>
			<div class="search_categories" style="width:200px;">
			<select name="deptname"  id="deptname" required>
				<option value="CSE" id="cse">CSE</option>
				<option value="ECE">ECE</option>
				<option value="PHY">PHYSICS</option>
				<option value="MME">MME</option>
				<option value="SPORTS">Sports</option>
				<option value="LT">LT Support</option> 
			</select>
		     
			</div>
			<button type="submit" value="submit" onclick="func()"> Submit </button>
	 
  </div>

</form>
</body>
</html>