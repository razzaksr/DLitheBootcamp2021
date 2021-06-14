<%@page import="java.util.Arrays"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dlithe Store</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<style>
img
{
height:200px;
}
</style>
<script type="text/javascript">
function ask(id)
{
	var hey=prompt("Rate this App 1 to 5","");
	location.assign("http://localhost:8080/DLitheWebApp/rating?id="+id+"&rate="+hey);
	
}
</script>
</head>
<body>
<div class="container-fluid padding">
<%
String who=(String)session.getAttribute("logged");
if(who!=null){
out.println("<h1 class='text-primary bg-warning'>Welcome back....... "+who+"</h1>"); 
String m=(String)request.getAttribute("msg");
if(m!=null){
	out.println("<p class='text-danger'>"+m+"<p>");
}%>

<a href="uploadapp.jsp" class="btn btn-outline-dark">Upload New Apps</a>
<a href="deleteapp.jsp" class="btn btn-outline-danger">Delete your apps</a>
<%
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlithe","root","");
	String qry="select * from store where app_category='Games'";
	PreparedStatement pre=con.prepareStatement(qry);
	ResultSet set=pre.executeQuery();
	%>
	<p class="display-4 text-primary">Games</p>
		<div class="row padding">
	<%
	int num=1;
	while(set.next())
	{
		//System.out.println(set.getString("app_name"));
		InputStream is=(InputStream)set.getBinaryStream("app_image");
		//System.out.println("Image readed from table "+is.available());
		File file=new File("C:\\Users\\ADMIN\\git\\DLitheBoot2021\\DLitheWebApp\\src\\main\\webapp\\images\\game"+num+".jpg");
		FileOutputStream fos=new FileOutputStream(file);
		byte[] tm=new byte[is.available()];
		is.read(tm);
		//System.out.println(Arrays.toString(tm)+" is going to write on "+file.getAbsolutePath());
		fos.write(tm);
		//System.out.println("images downloaded");
		fos.close();
		String ids=""+set.getInt("app_id");
	%>
		
			<div class="card col-md-3 col-sm-6 p-3">
				<img src="images/game<%=num %>.jpg" class="card-img w-100" alt="source is wrong"/>
				<div class="card-body">
					<p class="text-primary display-4 card-title"><%=set.getString("app_name") %></p>
					<p class="text-info card-text">Developed by <%=set.getString("app_by") %></p>
					<p class="text-warning card-text float-left">Downloads <%=set.getInt("app_downloads") %></p>
					<%-- <a href="rating?id=<%=set.getInt("app_id")%>"><p class="text-success card-text float-right">Rating <%=set.getDouble("app_rating") %></p></a> --%>
					<p class="text-dark card-text float-right ml-3" onclick="ask('<%=ids%>')">Rating <%=set.getDouble("app_rating") %></p>
					<a href="download?id=<%=set.getInt("app_id")%>" class="btn btn-outline-success float-right">Download</a>
				</div>
			</div>
	<%num++;}%>
	</div>
<%
qry="select * from store where app_category='Banking'";
pre=con.prepareStatement(qry);
set=pre.executeQuery();
%>
<p class="display-4 text-primary">Banking</p>
	<div class="row padding">
<%
num=1;
while(set.next())
{
	//System.out.println(set.getString("app_name"));
	InputStream is=(InputStream)set.getBinaryStream("app_image");
	//System.out.println("Image readed from table "+is.available());
	File file=new File("C:\\Users\\ADMIN\\git\\DLitheBoot2021\\DLitheWebApp\\src\\main\\webapp\\images\\bank"+num+".jpg");
	FileOutputStream fos=new FileOutputStream(file);
	byte[] tm=new byte[is.available()];
	is.read(tm);
	//System.out.println(Arrays.toString(tm)+" is going to write on "+file.getAbsolutePath());
	fos.write(tm);
	//System.out.println("images downloaded");
	String ids=""+set.getInt("app_id");
	%>
		
			<div class="card col-md-3 col-sm-6 p-3">
				<img src="images/bank<%=num %>.jpg" class="card-img w-100" alt="source is wrong"/>
				<div class="card-body">
					<p class="text-primary display-4 card-title"><%=set.getString("app_name") %></p>
					<p class="text-info card-text">Developed by <%=set.getString("app_by") %></p>
					<p class="text-warning card-text float-left">Downloads <%=set.getInt("app_downloads") %></p>
					<%-- <a href="rating?id=<%=set.getInt("app_id")%>"><p class="text-success card-text float-right">Rating <%=set.getDouble("app_rating") %></p></a> --%>
					<p class="text-dark card-text float-right ml-3" onclick="ask('<%=ids%>')">Rating <%=set.getDouble("app_rating") %></p>
					<a href="download?id=<%=set.getInt("app_id")%>" class="btn btn-outline-success float-right">Download</a>
				</div>
			</div>
<%num++;}%>
</div>
<%
qry="select * from store where app_category='Social'";
pre=con.prepareStatement(qry);
set=pre.executeQuery();
%>
<p class="display-4 text-primary">Social Media</p>
	<div class="row padding">
<%
num=1;
while(set.next())
{
	//System.out.println(set.getString("app_name"));
	InputStream is=(InputStream)set.getBinaryStream("app_image");
	//System.out.println("Image readed from table "+is.available());
	File file=new File("C:\\Users\\ADMIN\\git\\DLitheBoot2021\\DLitheWebApp\\src\\main\\webapp\\images\\social"+num+".jpg");
	FileOutputStream fos=new FileOutputStream(file);
	byte[] tm=new byte[is.available()];
	is.read(tm);
	//System.out.println(Arrays.toString(tm)+" is going to write on "+file.getAbsolutePath());
	fos.write(tm);
	//System.out.println("images downloaded");
	String ids=""+set.getInt("app_id");
	%>
		
			<div class="card col-md-3 col-sm-6 p-3">
				<img src="images/social<%=num %>.jpg" class="card-img w-100" alt="source is wrong"/>
				<div class="card-body">
					<p class="text-primary display-4 card-title"><%=set.getString("app_name") %></p>
					<p class="text-info card-text">Developed by <%=set.getString("app_by") %></p>
					<p class="text-warning card-text float-left">Downloads <%=set.getInt("app_downloads") %></p>
					<%-- <a href="rating?id=<%=set.getInt("app_id")%>"><p class="text-success card-text float-right">Rating <%=set.getDouble("app_rating") %></p></a> --%>
					<p class="text-dark card-text float-right ml-3" onclick="ask('<%=ids%>')">Rating <%=set.getDouble("app_rating") %></p>
					<a href="download?id=<%=set.getInt("app_id")%>" class="btn btn-outline-success float-right">Download</a>
				</div>
			</div>
<%num++;}%>
</div>
<%
qry="select * from store where app_category='Education'";
pre=con.prepareStatement(qry);
set=pre.executeQuery();
%>
<p class="display-4 text-primary">Education</p>
	<div class="row padding">
<%
num=1;
while(set.next())
{
	//System.out.println(set.getString("app_name"));
	InputStream is=(InputStream)set.getBinaryStream("app_image");
	//System.out.println("Image readed from table "+is.available());
	File file=new File("C:\\Users\\ADMIN\\git\\DLitheBoot2021\\DLitheWebApp\\src\\main\\webapp\\images\\edu"+num+".jpg");
	FileOutputStream fos=new FileOutputStream(file);
	byte[] tm=new byte[is.available()];
	is.read(tm);
	//System.out.println(Arrays.toString(tm)+" is going to write on "+file.getAbsolutePath());
	fos.write(tm);
	//System.out.println("images downloaded");
	String ids=""+set.getInt("app_id");
	%>
		
			<div class="card col-md-3 col-sm-6 p-3">
				<img src="images/edu<%=num %>.jpg" class="card-img w-100" alt="source is wrong"/>
				<div class="card-body">
					<p class="text-primary display-4 card-title"><%=set.getString("app_name") %></p>
					<p class="text-info card-text">Developed by <%=set.getString("app_by") %></p>
					<p class="text-warning card-text float-left">Downloads <%=set.getInt("app_downloads") %></p>
					<%-- <a href="rating?id=<%=set.getInt("app_id")%>"><p class="text-success card-text float-right">Rating <%=set.getDouble("app_rating") %></p></a> --%>
					<p class="text-dark card-text float-right ml-3" onclick="ask('<%=ids%>')">Rating <%=set.getDouble("app_rating") %></p>
					<a href="download?id=<%=set.getInt("app_id")%>" class="btn btn-outline-success float-right">Download</a>
				</div>
			</div>
<%num++;}%>
</div>
<% }
catch(Exception e){}
%>

<%}%>
</div>
</body>
</html>