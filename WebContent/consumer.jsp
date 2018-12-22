<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ include file = "headerc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="/Resource_Management2/consumer.css" type="text/css">
<title>Consumer Page</title>
</head>
<body>
<%
String user=null;
if(session.getAttribute("Consname")==null)
	response.sendRedirect("index.jsp");
else user=session.getAttribute("Consname").toString();
%>
	<div class="dropdown">
  <button class="dropbtn">Resources</button>
  <div class="dropdown-content">
    <a href="dept.jsp">Book Resource</a>
    <a href="viewCurrBooking1.jsp">View Current Bookings</a>
    <a href="viewPrevReq1.jsp">View Previous Logs</a>
    <a href="cancelBook.jsp">Cancel Bookings</a>
  </div>
</div>
</body>
</html>