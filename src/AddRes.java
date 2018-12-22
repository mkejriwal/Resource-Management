

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;


@WebServlet("/AddRes")
public class AddRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRes() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String rname =request.getParameter("resname");
		String rid=request.getParameter("resid");
		int rnum=Integer.parseInt(request.getParameter("resnum"));
		int finerate=Integer.parseInt(request.getParameter("finerate"));
		Resource resource=new Resource();
		resource.setRname(rname);
		resource.setRid(rid);
		resource.setRnum(rnum);
		resource.setFinerate(finerate);
		//PrintWriter out=response.getWriter();
		//out.println("bla");
		String s1 = request.getSession(true).getAttribute("Ownername").toString();
	   //out.println(s1);
		resource.setOid(s1);
		resource.addResource();
		response.sendRedirect("viewRes.jsp");
	}

}
