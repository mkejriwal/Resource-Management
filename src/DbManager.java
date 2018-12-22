

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	Connection con=null;
	Statement stmt=null;
        public Connection getConnection()
        {
        	try {
				Class.forName("com.mysql.jdbc.Driver");
        		//Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("class not found");
				return null;
			}
        	
			try {
				con = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/resource_management", "admin", "admin");
				return con;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("connection not successful");
				e.printStackTrace();
				return null;
			}
        	
        	
        }public Statement createStatement()
        {
        	try {
       		 stmt=con.createStatement();
       			//prstmt=con.prepareStatement(s1);
       		   // out.println("statement found");
       		 return stmt;
       		} catch (SQLException e) {
       			// TODO Auto-generated catch block
       			//out.println("statement null");
       			e.printStackTrace();
       			return null;
       		}catch (Exception e) {
				// TODO: handle exception
       			e.printStackTrace();
       			return null;
			}
        }public void closeConnection()
        {
        	try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
        }
}
