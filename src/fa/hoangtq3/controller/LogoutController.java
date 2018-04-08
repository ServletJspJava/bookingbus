
/*
	* (C) copyright 2018 Fresher Academy.
	* 
	* @author hoangcode
	* @date Apr 7, 2018
	* @version 1.0
*/

package fa.hoangtq3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false); // Fetch session object

		if (session != null) // If session is not null
		{
			session.invalidate(); // removes all session attributes bound to the session
			req.setAttribute("errMessage", "You have logged out successfully");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/JSP/Login.jsp");
			requestDispatcher.forward(req, resp);
			System.out.println("Logged out");
		}
	}

}
