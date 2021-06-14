<%@page import="com.mysql.cj.jdbc.Driver"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deleting Apps</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" user="root" password="" url="jdbc:mysql://localhost:3306/dlithe"/>
<sql:query dataSource="${db}" var="qry" sql="select * from store where app_by = '${sessionScope.logged}'"/>
<div class="container-fluid">
	<table class="table table-responsive">
		<thead class="thead-dark">
			<tr>
				<th>App Name</th><th>App Id</th><th>App Type</th><th>App Category</th><th>App Downloads</th>
				<th>App Rating</th><th>Action</th>
			</tr>
		</thead>
		<tbody>
			<core:forEach var="each" items="${qry.rows }">
				<tr>
					<td>${each.app_name }</td><td>${each.app_id }</td><td>${each.app_type }</td>
					<td>${each.app_category }</td><td>${each.app_downloads }</td><td>${each.app_rating }</td>
					<td><a href="del?id${each.app_id }">Delete</a></td>
				</tr>
			</core:forEach>
		</tbody>
	</table>
</div>
</body>
</html>