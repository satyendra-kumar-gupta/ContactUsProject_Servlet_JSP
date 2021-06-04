<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AllRequest</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="firstdivall">
		<h3>All Request</h3>
		<table align="center" id="table" border="1">
			<thead>
				<tr>
					<td>id</td>
					<td>name</td>
					<td>email</td>
					<td>message</td>
					<td>datetime</td>
					<td>isactive</td>
				</tr>
			</thead>
			<tbody>
				<%
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
						String activeArchive="Active";
						if(rs.getBoolean("isactive")==true){
							activeArchive="Archived";
						}
				%>
				<tr>
					<td><%=rs.getInt("id")%></td>
					<td><%=rs.getString("name")%></td>
					<td><%=rs.getString("email")%></td>
					<td><%=rs.getString("message")%></td>
					<td><%=rs.getString("datetime")%></td>
					<td>
					
						<form action="archive" method="post">
							<Button name="button" value="<%=rs.getInt("id")%>"><%=activeArchive%></Button>
						</form>
					</td>
				</tr>
				<%
				}
				con.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>