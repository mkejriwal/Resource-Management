<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ include file = "headero.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/Resource_Management2/viewCurrBooking.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>
        View Current Booking Requests
</title>
</head>
<body>

<script>
function func() {
  alert("Resource Request Approved!!");
}
function func1() {
	alert("Resource Request Declined!!")
}
</script>


     
    <div align="center" id="customers">
        <table border=1>
            <caption>View Current Booking Requests</caption>
            <tr>
                <th>Booking Id</th>
                <th>From Date</th>
                <th>To Date</th>
                <th>Consumer Id</th>
                <th>Resource Id</th>
                <th>Booking Count</th>
                <th>Status</th>
               <!--  <th>Has returned</th> -->
            </tr>
            
           
           
           <%
            String user = null;
        	if(session.getAttribute("Ownername")==null)
        		response.sendRedirect("index.jsp");
        	else user = session.getAttribute("Ownername").toString();
              try{
                 
               Statement stmt;
               Connection con=null;
               
               try {
   				Class.forName("com.mysql.jdbc.Driver");
           		//Class.forName("com.mysql.cj.jdbc.Driver");
   			} catch (ClassNotFoundException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   				System.out.println("class not found");
   		
   			}
           	
   			try {
   				con = DriverManager.getConnection
   						("jdbc:mysql://localhost:3306/resource_management", "admin", "admin");
   			
   			} catch (SQLException e) {
   				// TODO Auto-generated catch block
   				System.out.println("connection not successfl");
   				e.printStackTrace();
   				
   			}
               
               
               
               
               stmt=con.createStatement();
               
               ResultSet rs=null;
               String s1="select b.bID,b.fromDate,b.toDate,b.bQty,b.cID,b.rID from booking b,resource r where r.rID=b.rID and r.oID='"+user+"' and b.status='PENDING';";
               rs=stmt.executeQuery(s1);
               if(rs.next()==false)
               {
            	   
               }else
               {
            	   rs.beforeFirst();
            	   while(rs.next())
            	   {
            		   %>


			<tr>
				<td>   <%=rs.getString("bID") %>	</td>
				<td>   <%=rs.getString("fromDate") %>	</td>
				<td>   <%=rs.getString("toDate") %>	</td>
				<td>   <%=rs.getString("cID") %>	</td>
				<td>   <%=rs.getString("rID") %>	</td>
				<td>   <%=rs.getString("bQty") %>	</td>
				<td>
					<form method="post" action="Approve">
						<div class="btn-group" id="appdec">
						<input type="hidden" name="bid" value="<%=rs.getString("bID") %>" />
							<button type="submit" class="btn btn-success" name="a" id="a"
								onclick="func()">Approve</button>
							<button type="submit" class="btn btn-danger" name="d" id="d"
								onclick="func1()">Decline</button>
						</div>
					</form>
				</td>
			</tr>
			


			<%
				}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
           
           
        </table>
    </div>
</body>
</html>