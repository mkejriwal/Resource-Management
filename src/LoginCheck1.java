import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginCheck1")

public class LoginCheck1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginCheck1() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String uname = request.getParameter("cname");
		PrintWriter out=response.getWriter();
		String upassword = request.getParameter("cpassword");
		DbManager db=new DbManager();
		Statement stmt=null;
		ResultSet rs=null;
		Connection con=db.getConnection();
		try {
		 stmt=con.createStatement();

		    System.out.println("statement found");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("statement null");
			e.printStackTrace();
		}
		String s1="select * from consumer_login where cid='" + uname + "'and password='"+upassword+"';";
		try {
		 rs=stmt.executeQuery(s1);
		 out.println("after execute query");
		 rs.beforeFirst();
		if(rs.next())
		{
			HttpSession session= request.getSession();
			session.setAttribute("Consname", uname);
			response.sendRedirect("consumer.jsp");
		}
		else
		{//System.out.print("blabla");
			response.sendRedirect("index.jsp"); //redirect
		}}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				stmt.close();
				con.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
