package test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/dis")
public class DisplayServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String choice = req.getParameter("sb");
		if(choice.equals("prime"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("pri");
			rd.forward(req, res);
		}
		else if(choice.equals("palindromeno"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("pal");
			rd.forward(req, res);
		}
		else if(choice.equals("armstrongno"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("arm");
			rd.forward(req, res);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("per");
			rd.forward(req, res);
		}
	}

}
