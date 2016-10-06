<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
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
				<h1>Login to Gulp</h1>
				<form action="LoginServlet" method="post">
					User Name: <br /> <input type="text" name="username"> <br />
					<br /> Password: <br /> <input type="password" name="password"
						id="password"> <br /> <br /> <input type="submit"
						value="submit" id="submit"> <br /> <br /> <input
						type="text" value="${alert}" size="24" readonly>
				</form>
				<form action="NewUser.jsp" method="post">
					<br /> <input type="submit" value="Signup" id="Signup"> <br />
					<input type="hidden" name="action" value="Signup">

				</form>
			</div>
		</center>
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

</body>
</html>