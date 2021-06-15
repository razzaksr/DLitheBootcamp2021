<%@page import="servlets.dlithe.strore.Store"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apps in BIN</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="home.jsp" class="btn btn-outline-success badge-pill">Home</a>
<a href="out" class="btn btn-outline-secondary badge-pill">Logout</a>
<p class="text-danger text-center">${requestScope.msg}</p>
<%ArrayList<Store> bin =(ArrayList<Store>) session.getAttribute("bin"); %>
<div class="container-fluid">
	<div class="row justify-content-center">
		<table class="table table-responsive border rounded shadow p-3">
			<thead class="thead-dark">
				<tr>
					<th>App Name</th><th>App Id</th><th>App Type</th><th>App Category</th><th>App Downloads</th>
					<th>App Rating</th><th>Action</th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="each" items="${bin }">
					<tr>
						<td>${each.getApp_name() }</td><td>${each.getApp_id() }</td><td>${each.getApp_type() }</td>
						<td>${each.getApp_category() }</td><td>${each.getApp_downloads() }</td>
						<td>${each.getApp_rating() }</td>
						<td><a href="restore?id=${each.getApp_id() }">Restore</a></td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>