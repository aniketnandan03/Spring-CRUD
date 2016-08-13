<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!-- taglibs listing start -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- taglibs listng ended -->

<html>
<head>
<title>Employee Registration</title>

<!-- js include -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/employee.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/ajaxcall.js"></script>
<!-- js ended -->

<!-- css include -->
<link href="<%=request.getContextPath() %>/css/EmployeeRegistration.css" rel="stylesheet" type="text/css"/>
<%-- <link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/> --%>
<link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<!-- css ended -->

<!-- tab icon -->
<link rel="icon" href="<%=request.getContextPath()%>/images/ico.png">
<!-- tab icon ended -->

</head>

	<body>
		<div class="heading">
			<h1>Welcome Employee Registration Portal</h1>
		</div>
		<ul class="nav nav-tabs option-links">
			<li role="presentation" id="home"><a href="home.htm">Home</a></li>
			<li role="presentation" id="add-employee"><a href="addEmployee.htm">Add Employee</a></li>
			<li role="presentation" id="view-employee"><a href="viewEmployee.htm">View Employees</a></li>
			<li role="presentation" id="delete-employee"><a href="deleteEmployee.htm">Delete Employee</a></li>
		</ul>