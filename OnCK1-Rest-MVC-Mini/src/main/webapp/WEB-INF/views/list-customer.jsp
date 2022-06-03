<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<div class="container">
		<div class="content">
			<h1>List customer</h1>
			<a href="showFormForAdd">Add customer</a>
			<table>
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Factory</th>
					<th style="width: 100px">Action</th>
				</tr>
				<c:forEach var="item" items="${customers}">
					<tr>
						<td>${item.firstName }</td>
						<td>${item.lastName }</td>
						<td>${item.email }</td>
							<td>${item.factory.name }</td>
						<td><a class="btn btn-update" href="showformForUpdate?customerId=${item.id}">Update</a>
							<a class="btn btn-delete" href="delete?customerId=${item.id}"
							onclick="if(!(confirm('Are you sure you want delete this student?'))) return false;">Delete</a>
						</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>