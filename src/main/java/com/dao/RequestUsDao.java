package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.model.RequestUs;

public class RequestUsDao {

	public int insertQueryMessage(RequestUs requestus) throws ClassNotFoundException {
		int result = 0;
		String INSERT_QUERY_MESSAGE = "INSERT INTO requestus" + "(name,email,message,datetime,isactive) VALUES"
				+ "(?,?,?,?,?);";
		String url = "jdbc:postgresql://localhost:5432/mountblue";
		String user = "postgres";
		String pass = "12345678";

		Class.forName("org.postgresql.Driver");
		try {

			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY_MESSAGE);

			ps.setString(1, requestus.getName());
			ps.setString(2, requestus.getEmail());
			ps.setString(3, requestus.getMessage());
			ps.setTimestamp(4, requestus.getDateTime());
			ps.setBoolean(5, requestus.isActive());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
