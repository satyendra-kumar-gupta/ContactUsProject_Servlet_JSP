package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Admin;

public class AdminDao {
	public boolean validate(Admin admin) throws ClassNotFoundException {
		boolean status = false;
		String url = "jdbc:postgresql://localhost:5432/mountblue";
		String user = "postgres";
		String pass = "12345678";

		Class.forName("org.postgresql.Driver");

		try {
			Connection con = DriverManager.getConnection(url, user, pass);

			String selectQuery = "select * from contactus_admin where adminemail = ? and adminpass = ? ";
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setString(1, admin.getAdminEmail());
			ps.setString(2, admin.getAdminPass());

			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
