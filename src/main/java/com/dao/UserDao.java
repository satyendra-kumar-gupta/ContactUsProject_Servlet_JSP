package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.User;

public class UserDao {
	public boolean validate(User admin) throws ClassNotFoundException {
		boolean status = false;
		String url = "jdbc:postgresql://localhost:5432/mountblue";
		String user = "postgres";
		String pass = "12345678";

		Class.forName("org.postgresql.Driver");

		try {
			Connection con = DriverManager.getConnection(url, user, pass);

			String selectQuery = "select * from requestus_user where username = ? and password = ? ";
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setString(1, admin.getUserName());
			ps.setString(2, admin.getPassword());

			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
