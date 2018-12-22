import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Owner {
	String oid;
	   public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	String oname;
	   String email;
	   String ophn;
	   String deptname;
		
   
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOphn() {
		return ophn;
	}
	public void setOphn(String ophn) {
		this.ophn = ophn;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
    public void removeRes(int rid)
    {

	    DbManager db=new DbManager();
	    Connection con=db.getConnection();
    	Statement stmt=null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	
	
	String s1="delete from resource where rID="+rid+";";
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
    
    public String ownerid(int rid)
    {
           
    	DbManager db=new DbManager();
	    Connection con=db.getConnection();
    	Statement stmt=null;
    	ResultSet rs=null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	
	String id="";
	String s1="select oEmail from resource r,owner o where rID="+rid+"  and r.oID=o.oID ;";
	//String s1="update booking set status='APPROVED' where bID=2;";
	try {
		rs=stmt.executeQuery(s1);
		rs.next();
		id=rs.getString("oEmail");
		System.out.println("email is:"+id);
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
	
    	return id;
    
    	
    }
    public int fineCal(Booking b)
    {
    	
    	int money=0;
    	int rid=b.getRid();
       // String todate=b.getTodate();
        Date todate=java.sql.Date.valueOf(b.getTodate());
        DbManager db=new DbManager();
		Connection con=db.getConnection();
		Statement stmt=null;
		try {
		stmt=con.createStatement();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	    ResultSet rs=null;
		String s2="select fine_rate from resource where rID='"+rid+"';";
		int fine_rate=0;
		try {
			rs=stmt.executeQuery(s2);
			 System.out.println("query1");
			rs.next();
			 fine_rate=rs.getInt("fine_rate");
			 System.out.println("fine_rate calculated"+fine_rate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s3="select datediff(now(),DATE('"+todate+"')) as diff1";
		System.out.print(s3);
		try {
			rs=stmt.executeQuery(s3);
			System.out.print("blabla");
			rs.next();
			money=rs.getInt("diff1")*fine_rate;
			 System.out.println("money calculated"+money);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			rs.close();
			
			stmt.close();
			con.close();
		
		db.closeConnection();	
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
       
	 	return money;
    }
    
    
    
}
