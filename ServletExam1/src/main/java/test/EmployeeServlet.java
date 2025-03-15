package test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/dis")
public class EmployeeServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("Employee.jsp");
		rd.forward(req, res);
	}

}
