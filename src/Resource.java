import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

public class Resource {
	  String rid;
      String rname;
      int rnum;
      int finerate;
      String rtype;
      String oid;

		
		
      public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public int getFinerate() {
		return finerate;
	}
	public void setFinerate(int finerate) {
		this.finerate = finerate;
	}
	public Resource ()
      {
    	  super();
      }
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public void addResource()
	{

		DbManager db=new DbManager();
		Connection con=db.getConnection();
		Statement stmt=null;
		try {
		stmt=con.createStatement();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		String s1="insert into resource(rName,fine_rate,rQty,oID) values('"+rname+"','"+finerate+"','"+rnum+"','"+oid+"');";
		try {
			stmt.executeUpdate(s1);
		}
		// rs.beforeFirst();
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConnection();
	}
	public void modifyResource()
	{

		DbManager db=new DbManager();
		Connection con=db.getConnection();
		/*try {
		//	con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		Statement stmt=null;
		try {
		stmt=con.createStatement();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	    String s1=null;
	    //int k;
	    if(rnum>=0 && finerate>=0)
	        s1="update resource set rQty="+rnum+",fine_rate="+finerate+" where rName='"+rname+"';";
	    else if(rnum>=0)
	    {
	    	s1="update resource set rQty='"+rnum+"' where rName='"+rname+"';";
	    }
	    else
	    {
	    	s1="update resource set fine_rate='"+finerate+"' where rName='"+rname+"';";
	    }
	    try {
			 stmt.executeUpdate(s1);
			 
		} 
	    catch (SQLException e) {
			e.printStackTrace();
		}
	    try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    db.closeConnection();
	}
}
