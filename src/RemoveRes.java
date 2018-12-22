

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveRes
 */
@WebServlet("/RemoveRes")
public class RemoveRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveRes() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		 int rid = Integer.parseInt(request.getParameter("rid"));       //  Decline submit button
		 String oid= request.getSession(true).getAttribute("Ownername").toString();
         
     Owner o=new Owner();
     o.setOid(oid);
     o.removeRes(rid);
     response.sendRedirect("viewRes.jsp");	
	}

}
