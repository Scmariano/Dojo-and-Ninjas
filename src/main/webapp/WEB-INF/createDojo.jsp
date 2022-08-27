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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>New Dojo</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>New Dojo</h1>
			<div class="col">
				<form:form action="/dojos/create" method = "POST" modelAttribute="dojo">
					<div class="container">
						<form:errors path="*" class="text-danger"/>
					</div>
					<p>
						<form:label path="name">Name: </form:label>
						<form:input path="name"/>
					</p>
					<button>Create</button>
				</form:form>
			</div>
		</div><hr />
		<div class="row mt-3">
			<div class="col">
				<h2>List of Dojos</h2>
				<ul>
					<c:forEach var="dojo" items="${dojos}">
						<li><a href="/dojos/<c:out value="${dojo.id}" />"> <c:out
									value="${dojo.name}" />
						</a></li>
					</c:forEach>
				</ul>
			</div>
		</div><hr />
		<div class="row">
			<div class="col">
				<a href="/ninjas/new">Add a ninja</a>
			</div>
		</div>
	</div>
</body>
</html>