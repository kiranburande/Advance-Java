package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/dis")
public class DisplayServlet implements Servlet
{
	@Override
	public void init(ServletConfig scf) throws ServletException 
	{
		// No code
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String id = req.getParameter("id"); 
		String fName = req.getParameter("fname"); 
		String lName = req.getParameter("lname"); 
		String mId = req.getParameter("mid"); 
		Long phNo = Long.parseLong(req.getParameter("phno"));
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.print("User Id :"+id+"<br>");
		pw.print("User FName :"+fName+"<br>");
		pw.print("User LName :"+lName+"<br>");
		pw.print("User Mail Id :"+mId+"<br>");
		pw.print("User Phone No :"+phNo);
	}

	@Override
	public void destroy() 
	{
		// No code
		
	}
	
	@Override
	public String getServletInfo() 
	{
		return "This Servlet will display customer result";
	}

	

	@Override
	public ServletConfig getServletConfig() 
	{
		return this.getServletConfig();
	}

	

}
