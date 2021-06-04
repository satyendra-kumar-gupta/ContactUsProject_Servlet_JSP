package com.controler;

import java.io.IOException;

import com.dao.UserDao;
import com.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);

		try {
			if (userDao.validate(user)) {
				System.out.println("login ........");
				RequestDispatcher rd = request.getRequestDispatcher("dashboardrequest.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
