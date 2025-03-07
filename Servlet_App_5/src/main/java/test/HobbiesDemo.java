package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/dis")
public class HobbiesDemo extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String name = req.getParameter("name");
		String[] hobbies = req.getParameterValues("hobbies");
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.print("<h2>Hello "+name+" Your Hobbies Are</h2>");
		for(String str:hobbies)
		{
			pw.print("<h3>"+str+"</h3><br>");
		}
		pw.print("<h2>Thanking You...</h2>");
	}
}
