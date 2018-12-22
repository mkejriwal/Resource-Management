<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file = "headerc.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/Resource_Management2/bookRes.css" type="text/css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
 var dateToday = new Date(); 
  $( function() {
    $( "#datepicker" ).datepicker({
        dateFormat: 'yy-mm-dd',
        	numberOfMonths: 1,
            showButtonPanel: true,
            minDate: dateToday,
            onSelect: function(dateText, inst){
                $("#datepicker1").datepicker("option","minDate",
                $("#datepicker").datepicker("getDate"));
             }
    });
  } );
  $( function() {
	    $( "#datepicker1" ).datepicker({
	        dateFormat: 'yy-mm-dd',
	        	numberOfMonths: 1,
	            showButtonPanel: true
	           
	    });
	  } );
  </script>
 
<!--   <script> 
 function func() {
   alert("Booking Request sent successfully!!");
 }
 </script> -->
  
  <title>Book Resource</title>
</head>
<body>

	<form action="BookRes" method="post">
		<div class="container">
			<h1>Book Resource</h1>
<%-- 			<h3> Hello, <%=resultSet.getString("id") %> </h3> --%>
			<p>Please fill in this form to book a resource.</p>
			<hr>
			
			
			
			<label for="resid"><b>Resource Name</b></label>
			<div class="search_categories" style="width:200px;">
			   <select name="resid" id="resname" required>
			
			 <%
			 String dept=request.getParameter("deptname");
			 //System.out.print("dept name: "+dept);
            String user = null;
            Statement stmt;
            Connection con=null;
            ResultSet rs=null;
        	if(session.getAttribute("Consname")==null)
        		response.sendRedirect("index.jsp");
        	else user = session.getAttribute("Consname").toString();
        	String deptname=session.getAttribute("deptname").toString();
//              try{
                 
              
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
               
               rs=null;
               String s1="select * from resource where oID in (select oID from owner where deptName='"+deptname+"' )";
              // String s1="select rName from resource where oID in (select oID from owner where deptName='CSE')";
               rs=stmt.executeQuery(s1);
               if(rs.next()==false)
               {
            	   
               }else
               {
            	   rs.beforeFirst();
            	   while(rs.next())
            	   {
            		   %>
            		   
            		   <option value="<%=rs.getString("rID") %>"><%=rs.getString("rName")+" "+rs.getInt("rQty") %>
            		   </option>
            		   
            		   <% 
            	   }
            	   
               }
              
              /* catch(Exception e)
              {
            	  e.printStackTrace();
              } */
              try{
               rs.close();
               stmt.close();
               con.close();
              }catch(Exception e)
              {
            	  e.printStackTrace();
              }
              
              
            %>
            </select></div>
		
			
			<label for="resnum"><b>Resource Count</b>
			</label> <input type="number" placeholder="Resource Count" name="resnum" required>
			<hr>
			
			<label for="resfromdate"><b>From Date</b>
			</label> 
			<input type="text" id="datepicker" name="fromdate" required>
			<hr>
			
			<label for="restodate"><b>To Date</b>
			</label> 
			<input type="text" id="datepicker1" name="todate" required>
			<hr>

			<p>The resource belongs to this department.</p> <!-- sql to retrieve department name -->
			<button type="submit" class="addresbtn" onclick="func()">Submit</button>
		</div>
	</form>
</body>
</html>