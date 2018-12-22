

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CancelBook
 */
@WebServlet("/CancelBook")
public class CancelBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		 int bid = Integer.parseInt(request.getParameter("bid"));       //  Decline submit button
			String cid= request.getSession(true).getAttribute("Consname").toString();
        Consumer c=new Consumer();
        c.setCid(cid);
        c.cancelBooking(bid);
		response.sendRedirect("viewCurrBooking1.jsp");		
		
	}

}
