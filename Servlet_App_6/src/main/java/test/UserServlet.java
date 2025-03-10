package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/user")
public class UserServlet extends GenericServlet
{
	
	static Connection conn=null;
	
	@Override
	public void init(ServletConfig arg0) throws ServletException 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			  conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##practice","bk");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{		
		PrintWriter pw=res.getWriter();
		String userId = req.getParameter("id");
		  String userFName = req.getParameter("fname");
		  String userLName = req.getParameter("lname");
		  String mailId = req.getParameter("mailid");
		  long phNo = Long.parseLong(req.getParameter("phno"));
		  
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO SERVLETDEMO VALUES(?,?,?,?,?)");
			ps.setString(1, userId);
			ps.setString(2, userFName);
			ps.setString(3, userLName);
			ps.setString(4, mailId);
			ps.setLong(5, phNo);
			int k = ps.executeUpdate();
			if(k>0) {
				pw.print("<h1> Data Inserted </h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("Display.jsp");
		rd.forward(req, res);
	}
	@Override
	public  void destroy()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}
