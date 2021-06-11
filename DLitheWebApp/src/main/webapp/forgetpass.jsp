<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body>
<% 		Random random=new Random(); 
		int alpha=random.nextInt(1000);
		int cosmo=random.nextInt(1000);
		int result=alpha*cosmo;
		boolean state=false;
		String log="";
		
		if(request.getParameter("res")!=null&&request.getParameter("user")!=null&&request.getParameter("original")!=null)
		{
			int tmp=Integer.parseInt(request.getParameter("res"));
			int real=Integer.parseInt(request.getParameter("original"));
			if(tmp==real)
			{
				state=true;
				log=request.getParameter("user");
			}
		}
%>
<div class="container">
	<h1 class="text-primary text-center">Reset Password</h1>
	<div class="row justify-content-center">
		<div class="col-md-6 col-sm-12 shadow-lg rounded p-4">
			<form action="#" method="post">
				<input type="text" name="user" placeholder="username" class="form-control">
				<div class="form-inline">
					<label>Enter the result <%=alpha %> * <%=cosmo %> </label>
					<input type="hidden" value=<%=result %> name="original">
					<input type="number" name="res" placeholder="result">
					<button class="btn btn-success">Verify</button>
				</div>
			</form>
		</div>
	</div>
	<hr class="my-4"/>
	<%if(state) {%>
		<div class="my-4 row justify-content-center">
			<form action="UpdatePassword" method="post">
				<input type="hidden" name="user" value=<%=log %>>
				<input type="password" name="pass" placeholder="password" class="form-control">
				<input type="password" name="conpass" placeholder="confirm password" class="form-control">
				<button class="btn btn-outline-dark">Reset</button>
			</form>
		</div>
	<%} %>
</div>
</body>
</html>