<%@include file="./Heading.jsp" %>

<div class="navigation" nav-attribute="view-employee">

	<h2> ${message} </h2>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Hometown</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${empList}" var="employee" varStatus="counts">
			<tbody>
				<tr>
					<td>${employee.userId}</td>
					<td>${employee.userName}</td>
					<td>${employee.email}</td>
					<td>${employee.phone}</td>
					<td>${employee.homeTown}</td>
					<td><button class="edit-employee btn btn-primary" count="${counts.count}">Edit</button>
						<button class="delete-employee btn btn-danger" count="${count.count}">Delete</button>
					</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</div>
	
<%@include file="./Footer.jsp" %>
<%@include file="./modals.jsp" %>