 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<body>
<h2>Welcome, Ninja</h2>

<h4>Here are some of the events in your state:</h4>
	<div class="container">
			<table class="table table-dark table-hover">
			<thead>
			<tr>
			<th>Name</th>
			<th>Date</th>
			<th>Location</th>
			<th>Host</th>
			<th>Action / Status</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${event}" var="event">
			<tr>
			<td><a href="/dashboard/details/${idea.id}">${idea.ideaName}</a></td>
			<td>${idea.user.firstName} ${idea.user.lastName}</td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
			<button><a href="/dashboard/create">Add an idea</a></button>
	</div>

<h4>Here are some of the events in other states:</h4>
		<div class="container">
			<h1>Welcome, ${user.firstName} ${user.lastName}</h1>
			<hr />
			<table class="table table-dark table-hover">
			<thead>
			<tr>
			<th>Ideas</th>
			<th>Created By:</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${idea}" var="idea">
			<tr>
			<td><a href="/dashboard/details/${idea.id}">${idea.ideaName}</a></td>
			<td>${idea.user.firstName} ${idea.user.lastName}</td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
			<button><a href="/dashboard/create">Add an idea</a></button>
	</div>
</body>
</html>