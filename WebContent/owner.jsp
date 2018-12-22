
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file = "headero.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/Resource_Management2/owner.css" type="text/css">
<title>Welcome Owner!</title>
</head>
<body>
<%  
	String user = null;
	if(session.getAttribute("Ownername")==null)
		response.sendRedirect("index.jsp");
	else user = session.getAttribute("Ownername").toString();
%>
<div class="dropdown">
  <button class="dropbtn">Resources</button>
  <div class="dropdown-content">
  	<a href="viewRes.jsp">View Resources</a>
    <a href="addRes.jsp">Add Resource</a>
    <a href="modifyRes.jsp">Modify Resource</a>
    <a href="removeRes.jsp">Remove Resource</a>
    <a href="viewCurrBooking.jsp">View Current Booking Requests</a>
    <a href="HasReturned.jsp">Resource Returned</a>
    <a href="viewPrevReq.jsp">View Previous Requests</a>
  </div>
</div>
</body>
</html>