<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<h1 class="display-4 text-center text-info">Signup New User</h1>
	<div class="row justify-content-center">
		<form action="NewUser" method="post" class="shadow col-md-6 col-sm-12 rounded p-5">
			<div class="form-group">
				<label for="user">User Name</label>
				<input type="text" name="user" placeholder="User name" class="form-control">
			</div>
			<div class="form-group">
				<label for="pass">Select Password</label>
				<input type="password" name="pass" placeholder="Password" class="form-control">
			</div>
			<div class="form-group">
				<label for="contact">User Contact</label>
				<input type="number" name="contact" placeholder="User contact" class="form-control">
			</div>
			<div class="row justify-content-around">
				<button class="btn btn-outline-success">Signup</button>
				<button class="btn btn-outline-dark">Clear</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>