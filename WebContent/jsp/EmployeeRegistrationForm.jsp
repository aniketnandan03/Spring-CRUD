<%@include file="./Heading.jsp" %>

<div class="navigation" nav-attribute="add-employee">

	<h2> ${message} </h2>
	
	<form:form method="POST" class="employee-registration-form" commandName="employee" action="./registerEmployee.htm">
		<div class="form-group">
  			<label for="userName"> User Name</label><br>
  			<form:input path="userName" class="form-control reg-form-input" id="userName" />
  			<form:errors path="userName" cssClass="errors"/><br><br>
  			
  			<label for="password"> password </label><br>
			<form:input path="password" class="form-control reg-form-input" id="password"/>
			<form:errors path="password" cssClass="errors"/><br><br>
			
			<label for="email"> Email</label>
			<form:input path="email" class="form-control reg-form-input" id="email"/>
			<form:errors path="email" cssClass="errors"/><br><br>
			
			<label for="phone"> Phone No.</label>
			<form:input path="phone" class="form-control reg-form-input" id="phone"/>
			<form:errors path="phone" cssClass="errors"/><br><br>
			
			<label for="hometown"> Home Town</label>
			<form:input path="homeTown" class="form-control reg-form-input" id="hometown"/>
			<form:errors path="homeTown" cssClass="errors"/><br><br>
		</div>			
		
		<input type="submit" class="btn btn-success" value="Register New Employee"/>
		<input type="reset" class="btn btn-default" value="Reset"/>
	</form:form>
	
</div>
	
<%@include file="./Footer.jsp" %>