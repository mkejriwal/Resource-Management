<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ include file = "headerc.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/Resource_Management2/viewCurrBooking.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>
        View Previous Bookings
</title>
</head>
<body>


     
    <div align="center" id="customers">
        <table border=1>
            <caption>View Current Booking Status</caption>
            <tr>
                <th>Booking Id</th>
                <th>From Date</th>
                <th>To Date</th>
                <th>Resource Name</th>
                <th>Owner Name</th>
                <th>Booking Count</th>
                <th>Status</th>
            </tr>            
           
           
           <%
            String user = null;
        	if(session.getAttribute("Consname")==null)
        		response.sendRedirect("index.jsp");
        	else user = session.getAttribute("Consname").toString();
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
               String s1="select b.bID,b.fromDate,b.toDate,b.bQty,r.rName,o.oName,b.status from log b,resource r,owner o where r.rID=b.rID and r.oID=o.oID and b.cID='"+user+"';";
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
				<td>   <%=rs.getString("rName") %>	</td>
				<td>   <%=rs.getString("oName") %>	</td>
				<td>   <%=rs.getString("bQty") %>	</td>
				<td>   <%=rs.getString("status") %>	</td>
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