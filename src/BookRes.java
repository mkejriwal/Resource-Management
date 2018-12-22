

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookRes
 */
@WebServlet("/BookRes")
public class BookRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookRes() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//String deptname = request.getParameter("deptname");
		int rid = Integer.parseInt(request.getParameter("resid").toString());
		int bqty = Integer.parseInt(request.getParameter("resnum"));
		String fromdate = request.getParameter("fromdate");
		String todate = request.getParameter("todate");
		String cid= request.getSession(true).getAttribute("Consname").toString();
		Booking b=new Booking();
		b.setbQty(bqty);
		b.setRid(rid);
		b.setCid(cid);
		b.setFromdate(fromdate);
		b.setTodate(todate);
		String cemail=cid+"@lnmiit.ac.in";
		Consumer c=new Consumer();
		c.setCid(cid);
		Boolean flag=c.bookRes(b);
		if(flag.equals(true))
		{
			
			Owner o=new Owner();
			String s=o.ownerid(rid);
			SendEmail mail = new SendEmail();
			SendEmail mail1 = new SendEmail();
			String subject = "Resource requested";
			String body = "User "+cid+" has requested a resource. Please check your Current Booking Requests;";
			String subject1 = "Resource request sent successfully";
			String body1 = "Your request has been sent successfully. Wait for confirmation from owner's side.;";
			mail.mailSend(s, subject, body);
			//mail1.mailSend(cemail, subject1, body1);
			response.sendRedirect("viewCurrBooking1.jsp");
			//updated bookings
		}
		else
		{
			//window alert with the error message
			
			response.sendRedirect("bookRes.jsp"); //redirect
		}

	}

}
