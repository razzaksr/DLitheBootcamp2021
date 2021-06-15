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
<%response.addHeader("Cache-Control","no-cache, no-store, must-revalidate");
response.addHeader("Pragma", "no-cache");
response.addHeader("Exipiry","0");
String user=(String)session.getAttribute("logged"); 
if(user!=null)
{ %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<p class="text-danger text-center">${requestScope.msg}</p>
<%ArrayList<Store> bin =(ArrayList<Store>) session.getAttribute("bin"); %>
<nav class="navbar navbar-expand-lg navbar-light">
	<a class="navbar-brand" href="https://dlithe.com">
		<img src="images/dlithe.png"/>
	</a>
	<button class="navbar-toggler" data-ride="collapse" data-target="#dlithe">
		<span class="navbar-togglet-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="dlithe">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item active mr-3">
				<a href="home.jsp" class="btn btn-outline-success badge-pill">Home</a>
			</li>
			<li class="nav-item mr-3">
				<a href="out" class="btn btn-outline-dark badge-pill">Logout</a>
			</li>
		</ul>
	</div>
</nav>
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
<%}
else
{
	response.sendRedirect("index.jsp");
}%>
</body>
</html>