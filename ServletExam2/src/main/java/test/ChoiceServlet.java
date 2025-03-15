package test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/dis")
public class ChoiceServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String operation = req.getParameter("sb");
		
		if(operation.equals("Avg"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("av");
			rd.forward(req, res);
		}
		else if(operation.equals("Sum"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("sum");
			rd.forward(req, res);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("fact");
			rd.forward(req, res);
		}
		
	}

}
