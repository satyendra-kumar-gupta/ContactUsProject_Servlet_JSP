<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="firstdiv">
		<h2 class="hp">User Login</h2>
		<p class="hp">Please enter your username and password</p>
		<form action="userlogin" method="post">
			<label for="username">Email *</label><br /> 
			<input type="email" name="username" id="email" required><br /> <br /> 
			<label for="password">Password *</label><br /> 
			<input type="password" name="password" id="pass" required><br /> <br /> 
			<input type="submit" name="submit" id="submit" class="button" value="SUBMIT">
		</form>
	</div>
</body>
</html>