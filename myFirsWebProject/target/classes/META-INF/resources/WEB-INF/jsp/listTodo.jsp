<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">	
	<h1>Your Todo</h1>
	<table class="table table-dark table-hover bg-dark text-white">
		<thead>
			<tr>
				<th>Discription</th>
				<th>Target Date</th>
				<th>Done ?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.discription}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="delete-todo?id=${todo.id}" 
						class="btn btn-outline-warning border
						 border-3 border-warning">Delete</a></td>
	 					<td><a href="update-todo?id=${todo.id}" 
						class="btn btn-outline-success border
						 border-3 border-success">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>		
	</table>
	
			<a href="add-todo" class="btn btn-outline-success border
			 border-3 border-success">Add Todo</a>
</div>
		
<%@ include file="common/footer.jspf" %>


