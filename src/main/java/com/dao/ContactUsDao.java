package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.model.ContactUs;

public class ContactUsDao {

	public int insertQueryMessage(ContactUs contactus) throws ClassNotFoundException {
		int result = 0;
		String INSERT_QUERY_MESSAGE = "INSERT INTO contactus" + "(cname,cemail,cmessage,time,isactive) VALUES"
				+ "(?,?,?,?,?);";
		String url = "jdbc:postgresql://localhost:5432/mountblue";
		String user = "postgres";
		String pass = "12345678";

		Class.forName("org.postgresql.Driver");
		try {

			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY_MESSAGE);

			ps.setString(1, contactus.getCname());
			ps.setString(2, contactus.getCemail());
			ps.setString(3, contactus.getCmessage());
			ps.setString(4, contactus.getCtime());
			ps.setBoolean(5, contactus.isIsactive());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
