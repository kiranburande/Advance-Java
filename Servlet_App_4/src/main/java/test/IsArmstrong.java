package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/arm")
public class IsArmstrong extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		int isArmstrong = Integer.parseInt(req.getParameter("num"));
		int num = isArmstrong;
		int sum=0,len=0;
		for(int i=0;num!=0;num/=10,i++)len++;
		num = isArmstrong;
		while(num!=0)
		{
			sum = sum+(int)Math.pow(num%10,len);
			num/=10;
		}
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if(sum==isArmstrong) {
			pw.print("Yes, it's Armstrong Number...");
		}
		else {
			pw.print("No, it's not a Armstrong Number...");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("input.html");
		rd.include(req, res);
		
	}
	
}
