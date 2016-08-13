<div id="editEmployee" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit Modal</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
			<label> User Id</label><br>
  			<span id="employeeId"></span><br>
		
  			<label> User Name</label><br>
  			<input type="text" class="form-control reg-form-input" id="userName" />
  			  			
  			<label> Email</label>
			<input type="text" class="form-control reg-form-input" id="email"/>
						
			<label> Phone No.</label>
			<input type="text" class="form-control reg-form-input" id="phone"/>
						
			<label> Home Town</label>
			<input type="text" class="form-control reg-form-input" id="hometown"/>
		</div>			
		
		<input class="btn btn-success edit-employe-details" value="Done"/>
		<input type="reset" class="btn btn-default" value="Reset"/>
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>