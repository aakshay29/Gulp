<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Add More Restaurant</title>
</head>
<body>
<center>
<form action="AddServlet" method="post">
	<br>
	<br>
	
		New Restaurant:
		<input type="text" name="Restuarant">
		<br>
		<br>
		Address:
		<input type="text" name="Address">
		<br>
		<br>
		Details:
		<input type="text" name="Details">
		<br>
		<input type="submit" value="Add">
		<input type="hidden" name=action value="Add">

</form>
</center>
</body>

</html>