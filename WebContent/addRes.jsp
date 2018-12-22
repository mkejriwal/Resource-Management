<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ include file = "headero.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/Resource_Management2/addRes.css" type="text/css">
<title>Add Resource</title>
</head>
<script>
function func() {
  alert("Resource Has Been Added!!");
}
</script>

<body>
<% 
    if(session.getAttribute("Ownername")==null)
     	response.sendRedirect("index.jsp");
%>
<form action="AddRes" method="post">
  <div class="container">
    <h1>Add Resource</h1>
    <p>Please fill in this form to add a resource.</p>
    <hr>

<!-- 	<label for="resid"><b>Resource Id</b></label> -->
<!--     <input type="text" placeholder="Enter Resource Id" name="resid" required> -->
	
    <label for="resname"><b>Resource Name</b></label>
    <input type="text" placeholder="Enter Resource Name" name="resname" required>

    <label for="resnum"><b>Resource Count</b></label>
    <input type="text" placeholder="Resource Count" name="resnum" required>
    
     <label for="finerate"><b>Fine Rate</b></label>
    <input type="text" placeholder="Fine Rate" name="finerate" required>
    <hr>

    <p>The resource will belong to your department.</p> 
    <button type="submit" class="addresbtn" onclick="func()">Submit</button>
  </div>

</form>
</body>
</html>