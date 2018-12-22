<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>    
  
<title></title>
</head>
<body>
<nav class="navbar navbar-default">
  
    <ul class="nav navbar-nav">
      <li class="active"><a href="owner.jsp"> <span class="glyphicon glyphicon-home"></span>Home</a></li>
    </ul>
    <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">&nbsp;&nbsp; Welcome <%=session.getAttribute("Ownername")  %> </a>
    </div>
  <ul class="nav navbar-nav navbar-right">
      <li><a href="index.jsp"><span class="glyphicon glyphicon-log-out"></span>Log Out</a></li>
      </ul>
  </div>
</nav>

</body>
</html>

