<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Add More Restaurant</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" type="text/css" href="css/mobile.css">
<script src="js/mobile.js" type="text/javascript"></script>
</head>
<body>
	<div id="page">
		<div id="header">

			<div>
				<a href="index.html" class="menu"> <font size="12">Gulp!</font>
				</a>
				<ul id="navigation">

				</ul>
			</div>
		</div>
		<div id="body" class="home">
			<center>
				<form action="AddServlet" method="post">
					<br> <input type="submit" value="Add"> <input
						type="hidden" name=action value="Add">

				</form>
				<form action="RestaurantDetail.jsp" method="post">
					<br> <input type="submit" value="Update"> <input
						type="hidden" name=action value="Update">

				</form>
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
	</div>
</body>

</html>