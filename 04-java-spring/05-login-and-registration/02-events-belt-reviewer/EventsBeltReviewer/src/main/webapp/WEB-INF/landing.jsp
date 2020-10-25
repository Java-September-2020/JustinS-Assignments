<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome To BeltTest Site</h1>
<div class="row">
<div class="col">
	<h4>Register</h4>
		<form:form action="/register" method="post" modelAttribute="user">
			<div class="form-group">
			    <form:label path="primaryName">First Name</form:label>
			  	<form:errors path="primaryName"/>
			  	<form:input class="form-control" path="primaryName"/>
			</div>
			
			<div class="form-group">
			    <form:label path="surName">Last Name</form:label>
			  	<form:errors path="surName"/>
			  	<form:input class="form-control" path="surName"/>
			</div>
			
			<div class="form-group">
			    <form:label path="email">Email</form:label>
			  	<form:errors path="email"/>
			 	<form:input type="email" class="form-control" path="email"/>
			</div>
			
			<div class="form-group">
			    <form:label path="city">Location</form:label>
			  	<form:errors path="city"/>
			 	<form:input type="city" class="form-control" path="city"/>
			</div>
			
			<div>
			<label for="state"></label>
			<select name="state" id="state">
			  <option value="WA">WA</option>
			  <option value="OR">OR</option>
			  <option value="CA">CA</option>
			  <option value="NV">NV</option>
			  <option value="CO">CO</option>
			  <option value="NJ">NJ</option>
			  <option value="NM">NM</option>
			</select>
			</div>
			
			<div class="form-group">
			    <form:label path="password">Password</form:label>
			  	<form:errors path="password"/>
			 	<form:input type="password" class="form-control" path="password"/>
			</div>
			
			<div class="form-group">
			    <form:label path="confirmPassword">Confirm Password</form:label>
			  	<form:errors path="confirmPassword"/>
			 	<form:input type="confirmPassword" class="form-control" path="confirmPassword"/>
			</div>
			<input class="btn btn-danger" type="submit" value="Submit"/>
		</form:form>
</div>


<div class="col">
	<h4>Login</h4>
		<p>${loginError}</p>
		<form method="POST" action="/login">
		
			<div class="form-group">
		    	<label>Email:</label>
		    	<input class="form-control" type="email" name="email">
		    </div>
		    
		    <div class="form-group">
		    	<label>Password:</label>
		    	<input class="form-control" type="password" name="password">
		    </div>
		    <button class="btn btn-danger">Login</button>
		</form>
	</div>
<div class="col">

</div>


</div>
</div>

</body>
</html>