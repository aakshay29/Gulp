<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<center>
		<h1>Login to Gulp</h1>
		<form action="LoginServlet" method="post">
			User Name: <br /> <input type="text" name="username"> <br />
			<br /> Password: <br /> <input type="password" name="password"
				id="password"> <br />
			<br /> <input type="submit" value="submit" id="submit">
			<br/><br/><input type="text" value="${alert}" size="24" readonly>
		</form>
	</center>
</body>
</html>