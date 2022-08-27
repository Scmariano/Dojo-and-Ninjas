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
<meta charset="ISO-8859-1">
<title><c:out value="${dojo.name}" /></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1 class="text-center">
					<c:out value="${dojo.name}" />
					Ninjas
				</h1>
			</div>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">First Name</th>
						<th scope="col">Last name</th>
						<th scope="col">Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dojo.ninjas}" var="ninja">
						<tr>
							<td><c:out value="${ninja.firstName}" /></td>
							<td><c:out value="${ninja.lastName}" /></td>
							<td><c:out value="${ninja.age}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div><hr />
		<div class="row">
			<div class="col">
				<a href="/">Home</a>
			</div>
		</div>
	</div>
</body>
</html>