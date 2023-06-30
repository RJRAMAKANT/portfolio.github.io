package test;
import java.sql.*;
public class DBConnection {
	private static Connection con=null;
	private DBConnection(){}
    static {
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mydb2pm","mydb2pm");	
    		//con=DriverManager.getConnection("jdbc:mysql:// localhost:3306/jdbc","root","123456789");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public static Connection getcon()
    {
    	return con;
    }

}
