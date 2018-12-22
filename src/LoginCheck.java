

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheck
 */
//Stateme stmt;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("oname");
		PrintWriter out=response.getWriter();
		String upassword = request.getParameter("opassword");
		DbManager db=new DbManager();
		Statement stmt=null;
		ResultSet rs=null;
		Connection con=db.getConnection();
		try {
		 stmt=con.createStatement();
		    out.println("statement found");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("statement null");
			e.printStackTrace();
		}
		String s1="select * from owner_login where id='" + uname + "'and password='"+upassword+"';";
		try {
		 rs=stmt.executeQuery(s1);
		 out.println("after execute query");
		 rs.beforeFirst();
		if(rs.next())
		{
			HttpSession session= request.getSession();
			session.setAttribute("Ownername", uname);
			response.sendRedirect("owner.jsp");
		}
		else
		{
			response.sendRedirect("index.jsp"); //redirect
		}}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally
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
