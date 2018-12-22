

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;  
import java.util.Date; 

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/ModRes")
public class ModRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModRes() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resname = request.getParameter("resname");
		String rnum=request.getParameter("resnum");
		
		int num,rate;
		if(rnum!="")
		   num = Integer.parseInt(rnum);
		else 
			num=-1;
		String frate=request.getParameter("finerate");
		if(frate!="")
	    	 rate = Integer.parseInt(frate);
		else 
	     	rate=-1;
		//System.out.println("resname and resnum and num "+resname+rnum+num);
		//System.out.println("resname and frate and rate"+resname+frate+rate);
		     PrintWriter out = response.getWriter();
		     out.println("hello world");
			 Resource resource=new Resource();
			 resource.setRname(resname);
			 out.println(resname);
			 resource.setRnum(num);
			 resource.setFinerate(rate);
			 resource.modifyResource();
		     response.sendRedirect("viewRes.jsp");
		     if(num==-1 && rate==-1)//Todo: alert
				response.sendRedirect("owner.jsp"); 
		
	}

}