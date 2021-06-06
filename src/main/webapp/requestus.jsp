<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div id="firstdiv">
		<a href="userlogin" id="admin">Go to User Page</a>
		<h2 class="hp">Contact Us</h2>
		<p class="hp">Please fill this form in a decent manner</p>
		<form action="requestus" method="post">
			<label for="name">Name *</label><br /> 
			<input type="text" name="name" id="name" required><br /> <br /> 
			<label for="email">E-mail *</label><br /> 
			<input type="email" name="email" id="email" required><br /> <br /> 
			<label for="message">Message *</label><br />
			<textarea name="message" id="message" rows="10" cols="40"></textarea><br /> <br/> 
			<input type="submit" name="submit" id="submit" class="button" value="SUBMIT">
		</form>
	</div>
</body>
</html>