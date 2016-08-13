function callAjax(method, object) {
	 $.ajax({
	      type: method,
	      dataType : 'json',
	      url: "./updateEmployee.htm",
	      data: JSON.stringify(object),
	      success :function(result) {
	    	  console.log(result);
	      },
	      error: function(e){
	    	  console.log(e);
	      }
	  });
}