package com.controler;

import java.io.IOException;

import com.dao.AdminDao;
import com.model.Admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginSevlet
 */
@WebServlet("/adminlogin")
public class AdminLoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDao adminDao = new AdminDao();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("adminEmail");
		String password = request.getParameter("adminPass");
		Admin admin = new Admin();
		admin.setAdminEmail(username);
		admin.setAdminPass(password);

		try {
			if (adminDao.validate(admin)) {
				System.out.println("login ........");
				RequestDispatcher rd = request.getRequestDispatcher("allrequest.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
