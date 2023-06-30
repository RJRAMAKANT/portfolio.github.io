package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
@SuppressWarnings("serial")
@WebServlet("/port")
public class PortfolioServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException
	,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		/*PortBean pb=new PortBean();
		pb.setName(req.getParameter("unaame"));
		pb.setMail(req.getParameter("maail"));
		pb.setSub(req.getParameter("suub"));
		pb.setMsg(req.getParameter("mees"));
		
		int k=new PortDAO().storeD(pb);
		if(k>0)
		{
			pw.println("message recieved successfully");
			RequestDispatcher rd=req.getRequestDispatcher("portfolio.html");
			rd.include(req, res);
		}*/
		try {
			Connection con=DBConnection.getcon();
			  PreparedStatement ps=con.prepareStatement("insert into portfolio values(?,?,?,?)");
				
			  ps.setString(1,req.getParameter("unaame"));
			  ps.setString(2,req.getParameter("maail"));
			  ps.setString(3, req.getParameter("sub"));
			  ps.setString(4,req.getParameter("mees"));
			 int k=ps.executeUpdate();
			 if(k>0)
			 {
					pw.println("message recieved successfully");
					RequestDispatcher rd=req.getRequestDispatcher("portfolio.html");
					rd.include(req, res);
				 
			 }
			
		}
		 catch(Exception e)
		{
			 e.printStackTrace();
		}
	}

}
