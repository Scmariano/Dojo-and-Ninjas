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
<title>New Ninja</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>New Ninja</h1>
				<form:form action="/ninjas/create" method="POST" modelAttribute="ninja">
					<div class="container">
						<form:errors path="*" class="text-danger"/>
					</div>
					<table class="table">
						<tbody>
							<tr>
								<td><form:label path="dojo">Dojo:</form:label></td>
								<td><form:select path="dojo">
										<c:forEach items="${dojos}" var="dojo">
											<form:option value="${dojo.id}">
												<c:out value="${dojo.name}" />
											</form:option>
										</c:forEach>
									</form:select></td>
							</tr>
							<tr>
								<td><form:label path="firstName">First Name:</form:label></td>
								<td><form:input path="firstName" /></td>
							</tr>
							<tr>
								<td><form:label path="lastName">Last Name:</form:label></td>
								<td><form:input path="lastName" /></td>
							</tr>
							<tr>
								<td><form:label path="age">Age:</form:label></td>
								<td><form:input type ="number" path="age" /></td>
							</tr>
						</tbody>
					</table>
					<button>Create</button>
				</form:form>
			</div>
		</div><hr />
		<div class="row">
			<div class="col">
				<a href="/">Home</a>
			</div>
		</div>
	</div>

</body>
</html>