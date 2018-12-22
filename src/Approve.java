

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

/**
 * Servlet implementation class Approve
 */
@WebServlet("/Approve")
public class Approve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Approve() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String str1 = request.getParameter("a");       //  Approve submit button
	    String str2 = request.getParameter("d");       //  Decline submit button
	    int bid = Integer.parseInt(request.getParameter("bid"));       //  Decline submit button
	    DbManager db=new DbManager();
	    Connection con=db.getConnection();
    	Statement stmt=null;
    	ResultSet rs=null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String s5="select c.cEmail,cName from booking b,consumer c where b.bID="+bid+" and b.cID=c.cID;";
    	String cemail="";
    	try {
			rs=stmt.executeQuery(s5);
			rs.next();
	    	cemail=rs.getString("cEmail");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	SendEmail mail = new SendEmail();
    	String subject="";
    	String body="";
	    if(str1 != null)                            // if Approve is clicked
	    {    
	    	// in booking table status is set to approved.
	    	 subject = "Booking Approved";
			 body = "Your booking request has been approved. Please check your Current Booking Requests ";
			
	    	String s1="update booking set status='APPROVED' where bID="+bid+";";
	    	//String s1="update booking set status='APPROVED' where bID=2;";
	    	try {
				stmt.executeUpdate(s1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        db.closeConnection();
	    }			                         
	    else if(str2 != null)                       // if Decline is clicked
	    {  
	    	// in booking table status is set to declined. 
	    	
	    	subject = "Booking Declined";
			 body = "Your booking request has been declined. ";
	
	  
	    	String s3="insert into log select * from booking where bID ="+bid+";";
	    	String s4="update log set status ='DECLINED' where bID="+bid+";";
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
	    }
	    //remove that entry from viewCurrBooking page
	    
	    mail.mailSend(cemail, subject, body);
		response.sendRedirect("viewCurrBooking.jsp");
	}

}
