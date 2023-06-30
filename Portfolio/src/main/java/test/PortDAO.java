package test;
import java.sql.*;
public class PortDAO {
  public int k=0;
  public int storeD(PortBean pb)
  {
	  try {
		  Connection con=DBConnection.getcon();
		  //PreparedStatement ps=con.prepareStatement("insert into portfolio values(?,?,?,?)");
		  PreparedStatement ps=con.prepareStatement("insert into portfolio values(?,?,?,?)");
		
		  ps.setString(1,pb.getName());
		  ps.setString(2, pb.getMail());
		  ps.setString(3, pb.getSub());
		  ps.setString(4,pb.getMsg());
		  k=ps.executeUpdate();
		  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return k;
  }
}
