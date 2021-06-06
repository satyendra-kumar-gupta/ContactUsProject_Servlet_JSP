<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.model.RequestUs"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.RequestUsDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.controler.DashboardRequestServlet"%>

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
				ArrayList<RequestUs> requestUsList = (ArrayList<RequestUs>) request.getAttribute("listOfRequestUs");
				%>

				<%
				for (RequestUs requestUs : requestUsList) {
				%>

				<%
				String activeArchive = "Active";
				%>
				<%
				if (requestUs.isActive() == true) {
				%>
				<%
				activeArchive = "Archived";
				%>
				<%
				}
				%>

				<tr>
					<td><%=requestUs.getId()%></td>
					<td><%=requestUs.getName()%></td>
					<td><%=requestUs.getEmail()%></td>
					<td><%=requestUs.getMessage()%></td>
					<td><%=requestUs.getDateTime()%></td>
					<td>

						<form action="archive" method="post">
							<Button name="button" value="<%=requestUs.getId()%>"><%=activeArchive%></Button>
						</form>
					</td>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>