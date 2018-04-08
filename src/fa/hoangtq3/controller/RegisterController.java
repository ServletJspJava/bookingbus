
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

import fa.hoangtq3.dao.RegisterDao;
import fa.hoangtq3.model.RegisterModel;

public class RegisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// get the input parameters in to local variables
		String fullName = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		RegisterModel registerModel = new RegisterModel();
		registerModel.setFullName(fullName);
		registerModel.setGender(gender);
		registerModel.setEmail(email);
		registerModel.setUserName(userName);
		registerModel.setPassword(password);

		RegisterDao registerDao = new RegisterDao();
		String userRegistered = registerDao.registerUser(registerModel);
		if (userRegistered.equals("SUCCESS")) 
		{
			req.getRequestDispatcher("/JSP/Home.jsp").forward(req, resp);
		} else 
		{
			req.setAttribute("errMessage", userRegistered);
			req.getRequestDispatcher("/JSP/Register.jsp").forward(req, resp);
		}
		

	}

}
