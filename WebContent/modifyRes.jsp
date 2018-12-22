<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="  java.sql.SQLException" %>
<%@page import=" java.sql.Statement" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ include file = "headero.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/Resource_Management2/modifyRes.css" type="text/css">
<title>Modify Resource</title>
</head>
<script>
function func() {
  alert("Resource Has Been Modified!!");
}
</script>

<body>
	<form action="ModRes" method="post">
		<div class="container">
			<h1>Modify Resource</h1>
			<p>Please fill in this form to modify a resource.</p>
			<hr>

			<!-- <label for="deptname"><b>Department Name</b></label>
			<div class="search_categories" style="width:200px;">
			<select name="deptname" id="deptname" required>
				<option value="cse">CSE</option>
				<option value="ece">ECE</option>
				<option value="sports">Sports</option>
				<option value="lecsupport">Lecture Support</option> 
			</select> </div> -->
			<p>The resources that belong to your department: </p>

			<label for="resname"><b>Resource Name</b></label>
			<div class="search_categories" style="width:200px;">
			<select name="resname" id="resname" required>
			
            <%
            String user = null;
            Statement stmt;
            Connection con=null;
            ResultSet rs=null;
        	if(session.getAttribute("Ownername")==null)
        		response.sendRedirect("index.jsp");
        	else user = session.getAttribute("Ownername").toString();
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
               String s1="select rName from resource where oid ='"+user+"';";
               rs=stmt.executeQuery(s1);
               if(rs.next()==false)
               {
            	   
               }else
               {
            	   rs.beforeFirst();
            	   while(rs.next())
            	   {
            		   %>
            		   <option value="<%=rs.getString("rName") %>"><%=rs.getString("rName")%>
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
			
<!-- 				<option value="Projector">Projector</option> -->
<!-- 				<option value="screen">screen</option> -->
<!-- 				<option value="mic">mic</option> -->
<!-- 				<option value="usb">usb cabel</option>  -->
			
			</select> </div>
			<label for="resnum"><b>Resource Count</b>
			</label> <input type="text" placeholder="Resource Count" name="resnum">
			
			 <label for="finerate"><b>Fine Rate</b></label>
              <input type="text" placeholder="Fine Rate" name="finerate">
			<hr>

			<button type="submit" class="addresbtn" onclick="func()">Submit</button>
		</div>

	</form>
</body>
</html>