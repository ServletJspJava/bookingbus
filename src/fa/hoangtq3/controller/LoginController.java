
/*
	* (C) copyright 2018 Fresher Academy.
	* 
	* @author hoangcode
	* @date Apr 7, 2018
	* @version 1.0
*/

package fa.hoangtq3.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.hoangtq3.dao.LoginDao;
import fa.hoangtq3.model.LoginModel;

public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		LoginModel loginModel = new LoginModel();
		loginModel.setUsername(username);
		loginModel.setPassword(password);

		LoginDao loginDao = new LoginDao();
		try {
			String userValidate = loginDao.authenticateUser(loginModel);

			if (userValidate.equals("Admin_Role")) {
				System.out.println("Admin's Home");

				HttpSession session = req.getSession(); // Creating a session
				session.setAttribute("Admin", username); // setting session attribute
				req.setAttribute("userName", username);

				req.getRequestDispatcher("/JSP/Admin.jsp").forward(req, resp);
				
				
				
			} else if (userValidate.equals("Seller_Role")) {
				System.out.println("Seller's Home");

				HttpSession session = req.getSession();
				session.setAttribute("Seller", username);
				req.setAttribute("userName", username);
				req.getRequestDispatcher("/JSP/Seller.jsp").forward(req, resp);
				
			} else if (userValidate.equals("User_Role")) {
				System.out.println("User's Home");

				HttpSession session = req.getSession();
				session.setMaxInactiveInterval(10 * 60);
				session.setAttribute("Student", username);
				req.setAttribute("userName", username);

				req.getRequestDispatcher("/JSP/User.jsp").forward(req, resp);
			} else {
				System.out.println("Error message = " + userValidate);
				req.setAttribute("errMessage", userValidate);

				req.getRequestDispatcher("/JSP/Login.jsp").forward(req, resp);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
