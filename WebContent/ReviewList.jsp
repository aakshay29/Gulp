<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
					<li class="selected"><a href="index.html">Home</a></li>
					<li class="menu"><a href="about.html">Profile</a></li>
					<li class="menu"><a href="blog.html">Log Out</a></li>
				</ul>
			</div>
		</div>
		<div id="body" class="home">
			<center>
				<h1>Review List</h1>
			</center>
			<div class="container">
				<table class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>Restaurant</th>
							<th>User</th>
							<th>Review</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rev" items="${rev}">
							<tr>
								<td><c:out value="${rev.gulprestaurant.name}" /></td>
								<td><c:out value="${rev.gulpuser.username}" /></td>
								<td><c:out value="${rev.review}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
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