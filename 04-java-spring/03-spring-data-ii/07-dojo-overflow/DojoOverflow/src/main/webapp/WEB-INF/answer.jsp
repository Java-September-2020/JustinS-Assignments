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
</head>
<title>Create Idea</title>

 <form:form action="/answer" method="post" modelAttribute="answer">
 <form:input type="hidden" value="${ user_id }" path="user"/>
      <div class="form-group">
          <form:label path="answer">Idea</form:label>
          <form:errors path="answer"/>
          <form:input type="answer" class="form-control" path="answer" />
      </div>    
      <button>Create</button>
  </form:form>

</body>
</html>