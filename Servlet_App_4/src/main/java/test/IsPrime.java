package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/pri")
public class IsPrime extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		int isPrime = Integer.parseInt(req.getParameter("num"));
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		boolean flag = true;
		for(int i=2;i<=isPrime/2;i++)
		{
			if(isPrime%i==0)
			{
				pw.print("No, it's not a Prime Number");
				flag = false;
				break;
			}
		}
		if(flag)
		{
			pw.print("Yes, it's a Prime Number");
		}
		RequestDispatcher rd = req.getRequestDispatcher("input.html");
		rd.include(req, res);
	}
	
}
