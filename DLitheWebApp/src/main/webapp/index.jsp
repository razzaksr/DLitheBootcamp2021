<%@page import="java.util.Arrays"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body>
<div class="container padding">
	<h1 class="text-primary text-center">Login to Dlithe Store</h1>
	<!-- <img src="images/image.jpg"/> -->
	<%File file=new File(System.getProperty("user.dir"));%>
	<div class="row justify-content-center">
		<div class="col-md-6 col-sm-12 shadow-lg rounded my-4 p-4">
			<form action="log" method="post">
				<div class="form-group">
					<label for="user">User name</label>
					<input type="text" class="form-control" placeholder="Tell us user name" name="user">
				</div>
				<div class="form-group">
					<label for="pass">Pass word</label>
					<input type="password" class="form-control" placeholder="Tell us password" name="pass">
				</div>
				<div class="row justify-content-around my-4">
					<button class="btn btn-outline-primary">Login</button>
					<button class="btn btn-outline-danger">Cancel</button>
				</div>
				<a href="forgetpass.jsp" class="float-right">Forget Password</a>
				<a href="signup.jsp" class="btn btn-outline-success float-left">SignUP</a>
			</form>
		</div>
	</div>
	<%out.print(request.getAttribute("info")); %>
	${requestScope.info }
</div>
</body>
</html>