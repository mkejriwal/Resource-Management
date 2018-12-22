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
<link rel="stylesheet" href="/Resource_Management2/viewRes.css" type="text/css">
<title>View Current Resources</title>

</head>
<body>
 <!-- <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/mydb"
        user="root" password="secret"
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM users;
    </sql:query> -->
     
    <div align="center" id="customers">
        <table border=1>
            <caption>Resources of your Department</caption>
            <tr>
                <th>RID</th>
                <th>Resource Name</th>
                <th>Resource Quantity</th>
                <th>Fine Rate</th>
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
               String s1="select rID,rName,rQty,fine_rate from resource where oID='"+user+"';";
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
				<td>   <%=rs.getString("rID") %>	</td>
				
				<td>   <%=rs.getString("rName") %>	</td>
				<td>   <%=rs.getString("rQty") %>	</td>
				<td>   <%=rs.getString("fine_rate") %>	</td>
				
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