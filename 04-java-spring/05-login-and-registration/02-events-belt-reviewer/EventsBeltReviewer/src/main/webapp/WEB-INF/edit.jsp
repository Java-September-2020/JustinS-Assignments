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
<title>Edit</title>
</head>
<h1>${event.eventName}</h1>

<body>
<h3>Edit Event</h3>
	<div class="container">
		<form:form action="/dashboard/edit/${event.id}" method="post" modelAttribute="event">
		 <form:input type="hidden" value="${ user_id }" path="user"/>
		<div class="form-group">
		    <form:label path="eventName">Name
		    <form:errors path="eventName"/>
		    <form:input path="eventName"/></form:label>
	    </div>

		<div class="form-group">
		    <form:label path="eventDate">Date
		    <form:errors path="eventDate"/>
		    <form:input path="eventDate"/></form:label>
	    </div>
	    
	    <div class="form-group">
		    <form:label path="eventLocation">Name
		    <form:errors path="eventLocation"/>
		    <form:input path="eventLocation"/></form:label>
	    </div>
	    
 	<button>Update</button>
	    </form:form>
	    
	</div>
</body>


</html>