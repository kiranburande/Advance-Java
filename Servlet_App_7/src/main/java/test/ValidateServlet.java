package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/login")
public class ValidateServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String uname = req.getParameter("uname");
		String password = req.getParameter("password");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM SERVLETLOGIN");
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			ResultSet rs = ps.executeQuery();boolean flag= false;
			while(rs.next())
			{
				if(rs.getString(1).equals(uname) && rs.getString(3).equals(password))
				{
					pw.println("Welcome "+rs.getString(2));
					flag = true;
					break;					
				}
			}
			if(flag == false)
			{
				pw.print("Invalid Credentials...");
				RequestDispatcher rd = req.getRequestDispatcher("Index.html");
				rd.forward(req, res);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
/* 
SQL> CREATE TABLE SERVLETLOGIN(USERNAME VARCHAR2(25)PRIMARY KEY,
NAME VARCHAR2(20), PASSWORD VARCHAR2(20)); */