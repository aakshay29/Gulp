<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
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
					<li class="menu"><a href="RestaurantList.jsp">Home</a></li>
					<li class="selected"><a href="Profile.jsp"><img alt="" src="${gravatarURL}"/>Profile</a></li>
					<li class="menu"><a href="Login.jsp">Log Out</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="body" class="home">
			<table class="table table-bordered table-striped table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Restaurant</th>
						<th>Rating</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ratingList" items="${ratingList}">
						<tr>
							<td><c:out value="${ratingList.id}" /></td>
							<td><c:out value="${ratingList.gulprestaurant.name}" /></td>
							<td><c:forEach var="counter" begin="1"
									end="${ratingList.rating}">
									<span class="glyphicon glyphicon-star"></span>
								</c:forEach>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<table class="table table-bordered table-striped table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Restaurant</th>
						<th>Review</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reviewList" items="${reviewList}">
						<tr>
							<td><c:out value="${reviewList.id}" /></td>
							<td><c:out value="${reviewList.gulprestaurant.name}" /></td>
							<td><c:out value="${reviewList.review}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%
				model.Gulpuser u = (model.Gulpuser) session.getAttribute("user");
			%>
			<form action="UpdateEmail" method="post">
				<input name="emailID" id="emailID" type="text" value=<%=u.getEmail()%> /> 
				<input type="submit" value="Update Email" id="submit"><br />
			</form>
			<form action="EditRating" method="post">
				Enter rating ID: <br />
				<input type="text" name="ratingID"><br /> Enter rating
				(1-5): <br />
				<input type="text" name="rating"><br /> <input type="submit"
					value="submit" id="submit"><br />
			</form><hr>
			<form action="EditReview" method="post">
				Enter review ID: <br />
				<input type="text" name="reviewID"><br /> Enter review: <br />
				<input type="text" name="review"><br /> <input type="submit"
					value="submit" id="submit"><br />
			</form><hr>
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