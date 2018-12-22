
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.sun.org.apache.xpath.internal.operations.Bool;
public class Consumer {
	
	String cid;
	String cname;
	String cphn;
	String cemail;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCphn() {
		return cphn;
	}
	public void setCphn(String cphn) {
		this.cphn = cphn;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	
	public boolean bookRes(Booking b)
	{
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1=java.sql.Date.valueOf(b.getFromdate());
		Date date2=java.sql.Date.valueOf(b.getTodate());
      		
		//System.out.println("date1"+date1);
		//System.out.println("date2"+date2);
         Boolean flag=true;
		DbManager db=new DbManager();
		Connection con=db.getConnection();
		Statement stmt=null;
		try {
		stmt=con.createStatement();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	    ResultSet rs=null,rs1=null;
		String s2="select bQty from booking where rID="+b.getRid()+" and not (fromDate>= DATE('"+date2+"') or  toDate<=DATE('"+date1+"'));";
		int maxbook;
		try {
			rs=stmt.executeQuery(s2);
			
			   int maxm=0;    
			if(rs.next()==false)
			{ 
				System.out.println("query1");
				String s1="insert into booking(cID,rID,bQty,fromDate,toDate) values ('"+b.getCid()+"',"+b.getRid()+","+b.getbQty()+",'"+date1+"','"+date2+"');";
			    stmt.executeUpdate(s1);
			    System.out.println("after query1");
			    
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
			    
			}
			else
			{
				rs.beforeFirst();
				
				maxm=0;
			
				while(rs.next())
				{
					 System.out.println("mahima ki jai :)");
					 if(maxm<rs.getInt("bQty"))
						maxm=rs.getInt("bQty");
						 System.out.println("maxm: "+maxm);
				}
		  		maxbook=maxm;
				rs.close();
				
		  		String s3="select rQty from resource r,booking b where r.rID="+b.getRid()+";";
				rs1=stmt.executeQuery(s3);
				rs1.next();
				int maxavail=rs1.getInt("rQty");
				if((maxavail-maxbook)>=b.getbQty())
				{
					String s1="insert into booking(cID,rID,bQty,fromDate,toDate) values ('"+b.getCid()+"',"+b.getRid()+","+b.getbQty()+",'"+date1+"','"+date2+"');";
				    stmt.executeUpdate(s1);
				    System.out.println("query2");
				}else
				{
					 System.out.println("query4");
					flag=false;
					
				}
				
				
				try{
					rs.close();
					rs1.close();
					stmt.close();
					con.close();
				
				db.closeConnection();	
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}	
				
			}		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		 System.out.println("flag"+flag);
		return flag;
		
	}
	
	
	
	
	
	
	
	
	public void cancelBooking(int bid)
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
    	
	String s3="insert into log select * from booking where bID ="+bid+";";
	String s4="update log set status ='CANCELLED' where bID="+bid+";";
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
}
