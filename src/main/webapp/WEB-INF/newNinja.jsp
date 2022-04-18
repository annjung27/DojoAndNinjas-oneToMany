<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>New Ninja</h1>
	   <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		   	<div>
		   		<form:select path="dojo">
		   			<c:forEach var="dojo" items="${allDaDojos}">
		   				<form:option value="${dojo.id}">
		   					${dojo.getName()}
		   				</form:option>
		   			</c:forEach>
		   		</form:select>
		   	</div>
	   		
	   		<div class="form-group">
	   			<form:label path="firstName">First Name:</form:label>				
				<form:input path="firstName" class="form-control"/>
				<form:errors path="firstName"/>
	   		</div>			
	   		<div class="form-group">
	   			<form:label path="lastName">Last Name:</form:label>				
				<form:input path="lastName" class="form-control"/>
				<form:errors path="lastName"/>
	   		</div>			
	   		<div class="form-group mb-2">
	   			<form:label path="age">Age:</form:label>				
				<form:input type="number" path="age" class="form-control"/>
				<form:errors path="age"/>
	   		</div>			
			<input type="submit" value="Create" class="btn btn-primary"/>
	   	</form:form>  
	   	<a href="/dojos/new">Create Dojo</a> 
	</div>   
</body>
</html>