<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file = "headero.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/Resource_Manangement2/bookRes.css" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Fine Amount</title>
</head>


<body>
<form action="HasReturned.jsp">
  <div class="container">
    
			
		     <%
		        int money=Integer.parseInt(request.getSession().getAttribute("money").toString());
		     if(money>0){
		     %>
			<h1 align=center> Fine to be collected : <%=money %></h1>
			<%}
		     else
		     {
		     %>
		     <h1 align=center> No Fine to be collected!</h1>
		     <%
		     }%>
			<button type="submit" class="btn btn-success" name="back"> Back</button>
	 
  </div></form>
   
</body>
</html>