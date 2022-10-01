<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Customers Directory</title>
</head>
<body>
	<div class="container">
		<h3>Customers Directory</h3>
		<hr>
		<form action="/CustomerRelationshipManagement/customers/search" class="form-inline">
			<a href="/CustomerRelationshipManagement/customers/showFormForAdd"
				class="btn btn-primary btn-sm mb-3">Add Customer</a><input
				type="search" name="first_name" placeholder="first_name"
				class="form-control-sm ml-5 mr-2 mb-3" /> <input type="search"
				name="email" placeholder="email" class="form-control-sm mr-2 mb-3" />
			<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>	
		</form>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>first_name</th>
					<th>last_name</th>
					<th>email</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${Customers}" var="tempCustomer">
					<tr>
						<td><c:out value="${tempCustomer.first_name}" /></td>
						<td><c:out value="${tempCustomer.last_name}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/CustomerRelationshipManagement/customers/showFormForUpdate?customerId=${tempCustomer.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link --><a 
							href="/CustomerRelationshipManagement/customers/delete?customerId=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>	
	</div>

</body>
</html>