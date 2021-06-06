package com.controler;

import java.io.IOException;

import com.dao.RequestUsDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DashboardRequestServlet")
public class DashboardRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestUsDao requestUsDao=new RequestUsDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listOfRequestUs", requestUsDao.getData());
		RequestDispatcher rd = request.getRequestDispatcher("dashboardrequest.jsp");
		rd.forward(request, response);
		
	}
}
