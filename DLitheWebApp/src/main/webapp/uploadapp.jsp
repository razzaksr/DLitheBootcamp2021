<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload an APP</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body>
<%String user=(String)session.getAttribute("logged"); 
String m=(String)request.getAttribute("msg");
if(m!=null){
	out.println(m);
}
%>
<div class="container">
	<h1 class="text-primary text-center">Upload New App</h1>
	<div class="row justify-content-center">
		<form action="upload" method="post" class="my-4 p-4 shadow-lg rounded col-md-6 col-sm-12">
			<div class="form-group">
				<label for="name">App Name</label>
				<input type="text" name="name" placeholder="Tell us app name" class="form-control">
			</div>
			<div class="form-group">
				<label for="type">App Type</label>
				<input type="text" name="type" placeholder="Tell us app type" class="form-control">
			</div>
			<div class="form-group">
				<label for="category">App Category</label>
				<select name="category" class="form-control">
					<option>Select any category</option>
					<option>Games</option><option>Banking</option><option>Editors</option>
					<option>Social</option><option>Education</option><option>Financial</option>
				</select>
			</div>
			<div class="form-group">
				<label for="app">Browse App</label>
				<input type="file" name="app" placeholder="Locate App to upload" class="form-control">
			</div>
			<div class="form-group">
				<input type="hidden" name="by" value=<%=user %> class="form-control">
			</div>
			<div class="form-group">
				<label for="image">App Image</label>
				<input type="file" name="image" placeholder="upload image for the app" class="form-control">
			</div>
			<div class="row justify-content-around">
				<button class="btn btn-outline-info">Upload</button>
				<button class="btn btn-outline-dark">Cancel</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>