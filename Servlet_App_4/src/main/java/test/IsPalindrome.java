package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/pal")
public class IsPalindrome extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		int isPalindrome = Integer.parseInt(req.getParameter("num"));
		int num =isPalindrome;
		int sum = 0;
		while(num!=0)
		{
			sum = (sum*10)+num%10;
			num/=10;
		}
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if(sum==isPalindrome) {
			pw.print("Yes, Its Palindrome...");
		}
		else pw.print("No, Its not a Palindrome");
		RequestDispatcher rd = req.getRequestDispatcher("input.html");
		rd.include(req, res);
	}
	
}
