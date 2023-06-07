<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
		<title>ToDo List Page</title>
	</head>
	<body>
	<%@ include file="common/navigation.jspf" %>
	<div class = "container">
		<h1>Manage Your Todos </h1>
		<table class="table">
			<thead>
				<tr>
					<th>Username</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.username}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="deleteTodo?id=${todo.id}" type="button" class="btn btn-warning"/a>Delete ${todo.id}</td>
						<td><a href="updateTodo?id=${todo.id}" type="button" class="btn btn-success"/a>update ${todo.id}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="Add-Todo" type="button" class="btn btn-success">Add Todo</a>
			</div>
	<%@ include file="common/footer.jspf" %>