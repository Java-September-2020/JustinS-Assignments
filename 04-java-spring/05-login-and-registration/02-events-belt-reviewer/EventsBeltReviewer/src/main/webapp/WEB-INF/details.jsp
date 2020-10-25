<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
<title>Show Idea</title>
</head>
<body>
	<div class="container">
		<h2>${event}</h2>
			<h4>Name: ${ event.name }</h4>
			<h4>Created By: ${ event.date }</h4>
			<h4>Created By: ${ event.location }</h4>
			<button><a href="/events/edit${idea.id}">Edit Idea</a></button>
		</div>
</body>
</html>