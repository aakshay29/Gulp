<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Sign up here for Gulp</title>
</head>
<body>
<center>

			<form action ="NewuserServlet" method="post">
			<br>
			Name:
			<Input type="text" name="username" id="username">
			<br>
			Email:
			<Input type="text" name="email" id="email">
			<br>
			Password:
			<Input type="text" name="password" id="password">
			<br>
			Zip code:
			<Input type="text" name="zipcode" id="zipcode">
			<br>
			Role 1 or 2:
			<Input type="text" name="role" id="role">
			
			<br><Input type="Submit" value="Signup" id="Signup">
			
			
			
</form>

	</center>
</body>
</html>

