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
public class DisplayEmployeeDetails implements Servlet
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
		String name = req.getParameter("name");
		String addr = req.getParameter("address");
		Long sal = Long.parseLong(req.getParameter("salary"));
		String gender = req.getParameter("gender");
		String profile = req.getParameter("profile");
		String hobbies[] = req.getParameterValues("hobbies");
		
		PrintWriter pw = res.getWriter();
		pw.print("Employee id :"+id+"<br>");
		pw.print("Employee name :"+name+"<br>");
		pw.print("Employee Address :"+addr+"<br>");
		pw.print("Employee Salary :"+sal+"<br>");
		pw.print("Employee Gender :"+gender+"<br>");
		pw.print("Employee Profile :"+profile+"<br>");
		pw.print("Employee Hobbies :"+"<br>");
		for(String hobby:hobbies)
		{
			pw.print(hobby+"<br>");
		}
	}

	@Override
	public void destroy() 
	{
		// No code
		
	}

	@Override
	public String getServletInfo() 
	{
		return "This Servlet will display Employee Details";
	}
	
	@Override
	public ServletConfig getServletConfig() 
	{
		return this.getServletConfig();
	}
	
	
}
