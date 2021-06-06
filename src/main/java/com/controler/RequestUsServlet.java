package com.controler;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.dao.RequestUsDao;
import com.model.RequestUs;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/requestus")
public class RequestUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestUsDao requestUsDao = new RequestUsDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("requestus.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("requestus.jsp");
		rd.forward(request, response);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");

		RequestUs requestUs = new RequestUs();

		requestUs.setName(name);
		requestUs.setEmail(email);
		requestUs.setMessage(message);
		requestUs.setDateTime(Timestamp.valueOf(LocalDateTime.now()));
		requestUs.setActive(false);

		try {
			requestUsDao.insertRequest(requestUs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
