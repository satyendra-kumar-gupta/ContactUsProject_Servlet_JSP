package com.controler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.dao.ContactUsDao;
import com.model.ContactUs;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactUsServlet
 */
@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactUsDao contactUsDao = new ContactUsDao();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("contactus.jsp");
		rd.forward(request, response);
		String cname = request.getParameter("cname");
		String cemail = request.getParameter("cemail");
		String cmessage = request.getParameter("cmessage");

		ContactUs contactus = new ContactUs();

		contactus.setCname(cname);
		contactus.setCemail(cemail);
		contactus.setCmessage(cmessage);
		contactus.setCtime(dtf.format(now));
		contactus.setIsactive(false);

		try {
			contactUsDao.insertQueryMessage(contactus);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
