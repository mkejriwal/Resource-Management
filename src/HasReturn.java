

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HasReturn
 */
@WebServlet("/HasReturn")
public class HasReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HasReturn() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int rid = Integer.parseInt(request.getParameter("rid")); 
		int bid = Integer.parseInt(request.getParameter("bid")); 
		String todate = request.getParameter("todate");   
		 //  Decline submit button
		    DbManager db=new DbManager();
		    Connection con=db.getConnection();
	    	Statement stmt=null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	    	Owner o=new Owner();
	    	Booking b=new Booking();
	        b.setBid(bid);
	        b.setTodate(todate);
	        b.setRid(rid);
	    	int money=o.fineCal(b);
	    	System.out.print("money: "+money);
	    	
	    	
		String s3="insert into log select * from booking where bID ="+bid+";";
    	String s4="update log set status ='RETURNED' where bID="+bid+";";
    	try {
			stmt.executeUpdate(s3);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
			stmt.executeUpdate(s4);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	String s1="delete from booking where bID="+bid+";";
    	//String s1="update booking set status='APPROVED' where bID=2;";
    	try {
			stmt.executeUpdate(s1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    	try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	 
    	db.closeConnection();
    	PrintWriter out=response.getWriter();
    	out.println("<meta http-equiv='refresh' content='1;URL=HasReturned.jsp'>");//redirects after 3 seconds
    	if(money>0)
    	{
//    		out.println("<script type=\"text/javascript\">");
// 		   out.println("alert('Fine caculated is: '"+money+");");
// 		   out.println("location='HasReturned.jsp';");
// 		   out.println("</script>");
    	}
		    //out.println("<p style='color:#d9534f;'>your fine penalty is: "+money+"</p>");
		//
    	
    	
    	HttpSession session = request.getSession();
		session.setAttribute("money", money);
		response.sendRedirect("fine.jsp");
    	
	}

}
