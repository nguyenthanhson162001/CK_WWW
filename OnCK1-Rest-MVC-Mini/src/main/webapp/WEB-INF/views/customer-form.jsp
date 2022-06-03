<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<div class="container">
	<div class="content">
		<h2 class="title">Add Customers</h2>
		<form:form action="saveCustomer" modelAttribute="customer"
			method="GET">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName"
							value="${customer.firstName }" /></td>
				</tr>

				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" value="${customer.lastName }" />
					</td>
				</tr>

				<tr>
					<td>Email:</td>
					<td><form:input path="email" value="${customer.email }" /></td>
				</tr>
				<tr>
					<td>Factory:</td>
	
					<td><form:select path="factory.id">
						<c:forEach var="item" items="${factories}">
						
							<option value="${item.id}" ${item.id == customer.factory.id ? 'selected':''} >${item.name}</option>
						</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Save" class="btn btn-primary"></td>
				</tr>

			</table>
		</form:form>

	</div>
</div>
</body>
</html>