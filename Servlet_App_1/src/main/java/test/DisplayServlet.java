package test;

import java.io.*;

import jakarta.servlet.*;
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
		String cId = req.getParameter("cid");
		String cName = req.getParameter("cname");
		String cCity = req.getParameter("ccity");
		String cMid = req.getParameter("cmid");
		long cPhNo = Long.parseLong(req.getParameter("cphno"));
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("Customer Id :"+cId+"<br>");
		pw.println("Customer Name :"+cName+"<br>");
		pw.println("Customer City"+cCity+"<br>");
		pw.println("Customer Mail Id :"+cMid+"<br>");
		pw.println("Customer Phone Number :"+cPhNo +"<br>");
	}


	@Override
	public void destroy() 
	{
		// No Code
		
	}
	
	@Override
	public String getServletInfo() 
	{
		return "This Servlet will display Customer Details";
	}	

	@Override
	public ServletConfig getServletConfig() 
	{		
		return this.getServletConfig();
	}

	
}
