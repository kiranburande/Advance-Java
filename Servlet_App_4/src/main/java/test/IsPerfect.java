package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/per")
public class IsPerfect extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		int isPerfect = Integer.parseInt(req.getParameter("num"));
		int sum = 0;
		for(int i=1;i<=isPerfect/2;i++)
		{
			if(isPerfect%i==0) {
				sum=sum+i;
			}
		}
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if(sum==isPerfect) {
			pw.print("Yes, it's Perfect Number");
		}
		else {
			pw.print("No, It's not a Perfect Number");
		}
		RequestDispatcher rd = req.getRequestDispatcher("input.html");
		rd.include(req, res);
	}

}
