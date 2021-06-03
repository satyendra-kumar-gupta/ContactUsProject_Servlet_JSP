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
					<td>cid</td>
					<td>cname</td>
					<td>cemail</td>
					<td>cmessage</td>
					<td>time</td>
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
					String contactusData = "Select * from contactus";
					ResultSet rs = st.executeQuery(contactusData);
					while (rs.next()) {
						String activeArchive="Active";
						if(rs.getBoolean("isactive")==true){
							activeArchive="Archived";
						}
				%>
				<tr>
					<td><%=rs.getInt("cid")%></td>
					<td><%=rs.getString("cname")%></td>
					<td><%=rs.getString("cemail")%></td>
					<td><%=rs.getString("cmessage")%></td>
					<td><%=rs.getString("time")%></td>
					<td>
					
						<form action="archive" method="post">
							<Button name="button" value="<%=rs.getInt("cid")%>"><%=activeArchive%></Button>
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