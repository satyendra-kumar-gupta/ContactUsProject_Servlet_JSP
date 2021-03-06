package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import com.model.RequestUs;

public class RequestUsDao {

	public int insertRequest(RequestUs requestus) throws ClassNotFoundException {
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

	public ArrayList<RequestUs> getData() {

		ArrayList<RequestUs> requestUsList = new ArrayList<>();
		String url = "jdbc:postgresql://localhost:5432/mountblue";
		String user = "postgres";
		String pass = "12345678";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			String requestusData = "Select * from requestus";
			ResultSet rs = st.executeQuery(requestusData);
			while (rs.next()) {
				RequestUs requestUs = new RequestUs();

				requestUs.setId(rs.getInt(1));
				requestUs.setName(rs.getString(2));
				requestUs.setEmail(rs.getString(3));
				requestUs.setMessage(rs.getString(4));
				requestUs.setDateTime(Timestamp.valueOf(rs.getString(5)));
				requestUs.setActive(rs.getBoolean(6));

				requestUsList.add(requestUs);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestUsList;
	}
}
