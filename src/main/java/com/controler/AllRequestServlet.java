package com.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllRequestServlet
 */
@WebServlet("/archive")
public class AllRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("button"));
		System.out.println(id);

		String url = "jdbc:postgresql://localhost:5432/mountblue";
		String user = "postgres";
		String pass = "12345678";
        String helperQuery="select isactive from contactus where cid="+id;
       
        String UPDATE_QUERY = "UPDATE contactus set isactive=? where cid="+id;

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
			
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(helperQuery);
			
			rs.next();
	        boolean helperValue=rs.getBoolean("isactive");
	      
            
	        if(helperValue==true) {
	        	ps.setBoolean(1, false);
	        }else {
	        	ps.setBoolean(1, true);
	        }
			
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("allrequest.jsp");

	}

}
