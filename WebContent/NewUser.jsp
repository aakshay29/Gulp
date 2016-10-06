<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Sign up here for Gulp</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" type="text/css" href="css/mobile.css">
<script src="js/mobile.js" type="text/javascript"></script>
</head>
<body>
	<div id="page">
		<center>
			<div id="header">

				<div>
					<a href="index.html" class="menu"> <font size="12">Gulp!</font>
					</a>
					<ul id="navigation">

					</ul>
				</div>
			</div>
			<div id="body" class="home">

				<form action="NewuserServlet" method="post">
					<br> Name: <Input type="text" name="username" id="username">
					<br> Email: <Input type="text" name="email" id="email">
					<br> Password: <Input type="password" name="password"
						id="password"> <br> Zip code: <Input type="text"
						name="zipcode" id="zipcode"> <br> <Input
						type="Submit" value="Signup" id="Signup"><br/><br/>



				</form>
			</div>
			<div id="footer">
				<div>
					<div class="connect">
						<a href="#" class="facebook">facebook</a> <a href="#"
							class="twitter">twitter</a> <a href="#" class="googleplus">googleplus</a>
						<a href="#" class="pinterest">pinterest</a>
					</div>
					<p>&copy; 2016 Gulp. All Rights Reserved.</p>
				</div>
			</div>
		</center>
	</div>
</body>
</html>

