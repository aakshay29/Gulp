<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Restaurant List</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" type="text/css" href="css/mobile.css">
<script src="js/mobile.js" type="text/javascript"></script>
</head>
<body>
	<div id="page">
		<div id="header">
			<div>
				<a href="index.html" class="menu"> <font size="12">Gulp!</font> </a>
				<ul id="navigation">
					<li class="selected"><a href="index.html">Home</a></li>
					<li class="menu"><a href="about.html">Profile</a>
					</li>
					<li class="menu"><a href="blog.html">Log Out</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="body" class="home">
			<center>
				<h1>Restaurant List</h1>
			<div class="container">
				<table class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Address</th>
							<th>Description</th>
							<th>Rating</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="restaurantList" items="${restaurantList}">
							<tr>
								<td><c:out value="${restaurantList.id}" /></td>
								<td><c:out value="${restaurantList.name}" /></td>
								<td><c:out value="${restaurantList.address}" /></td>
								<td><c:out value="${restaurantList.description}" /></td>
								<td><c:forEach var="counter" begin="0"
										end="${restaurantList.averagerating}">
										<span class="glyphicon glyphicon-star"></span>
									</c:forEach></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<form action="EnterRating" method="post">
				Enter restaurant ID: <br />
				<input type="text" name="restaurantID"><br /> Enter rating
				(1-5): <br />
				<input type="text" name="rating"><br /> <input type="submit"
					value="submit" id="submit"><br />
			</form><hr>
			<form action="EnterReview" method="post">
				Enter restaurant ID: <br />
				<input type="text" name="restaurantID"><br /> Enter review:
				<br />
				<input type="text" name="review"><br /> <input type="submit"
					value="submit" id="submit"><br />
			</form><hr>
			<form action="SeeReviews" method="post">
				Enter restaurant ID: <br />
				<input type="text" name="restaurantID"><br /> <input
					type="submit" value="See Reviews" id="submit"><br />
			</form>
			<input type="text" value="${alert}" size="28" readonly>
			</center>
		</div>
		
		<div id="footer">
			<div>
				<div class="connect">
					<a href="#"
						class="facebook">facebook</a> <a
						href="#" class="twitter">twitter</a>
					<a href="#"
						class="googleplus">googleplus</a> <a
						href="#" class="pinterest">pinterest</a>
				</div>
				<p>&copy; 2016 Gulp. All Rights Reserved.</p>
			</div>
		</div>
	</div>
</body>
</html>