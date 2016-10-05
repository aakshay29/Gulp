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
</head>
<body>
	<center>
		<h1>Restaurant List</h1>
	</center>
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
						<td><c:out value="${restaurantList.averagerating}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>