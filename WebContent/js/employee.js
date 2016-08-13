$(document).ready(function(){
	//to set which link is on
	var selectedLink = $(".navigation").attr("nav-attribute"); 
	$("#" + selectedLink).addClass("active");
	
	//open edit employee modal
	$(".edit-employee").on("click", function(e){
		var allTdsArray = $(this).closest("tr").find("td");
		
		var employeeId = Number($(allTdsArray[0]).html());
		var employeeName =  $(allTdsArray[1]).html();
		var employeeEmail = $(allTdsArray[2]).html();
		var employeePhone = $(allTdsArray[3]).html();
		var employeeHomeTown = $(allTdsArray[4]).html();
		
		$('#editEmployee').modal('toggle');
		$("#employeeId").html(employeeId);
		$("#userName").val(employeeName);
		$("#email").val(employeeEmail);
		$("#phone").val(employeePhone);
		$("#hometown").val(employeeHomeTown);
	});
	
	//update employee 
	$(".edit-employe-details").on("click", function(){
		var employee = {
			userId : $("#employeeId").html(),
			userName : $("#userName").val(),
			email : $("#email").val(),
			phone : $("#phone").val(),
			homeTown : $("#hometown").val()
		}
		callAjax("PUT", employee);
	});
});