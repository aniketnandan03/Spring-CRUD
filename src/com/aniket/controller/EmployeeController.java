package com.aniket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aniket.bean.Employee;
import com.aniket.response.Response;
import com.aniket.service.IEmployeeServices;
import com.aniket.validators.EmployeeValidator;

@Controller 
public class EmployeeController {
	@Autowired
	private EmployeeValidator empValidator;
	@Autowired
	private IEmployeeServices empService;
	@Autowired
	private Response response;
	
	@RequestMapping("/home") 
	public String home() { 
		return "Index";
	}
	
	@RequestMapping("/addEmployee") 
	public String addEmployee(@ModelAttribute("employee") Employee e, Model model) { 
		String message = "Register New Employee";
		model.addAttribute("message", message);
		return "EmployeeRegistrationForm";
	}
	
	@RequestMapping(value="/registerEmployee", method=RequestMethod.POST )
	public String registerEmployee(@ModelAttribute("employee") Employee e, BindingResult bindingResult, Model model){
		empValidator.validate(e, bindingResult);
		
		if(bindingResult.hasErrors()){
			return "redirect:/addEmployee.htm";
		} else {
			System.out.println(e.getEmail() + " " + e.getUserName() + " " + e.getPassword() + " " + e.getHomeTown() + " " + e.getPhone());
			model.addAttribute("dbMessage", this.empService.createEmployee(e));
			return "Index";
		}
	}
		
	@RequestMapping("/deleteEmployee") 
	public String deleteEmployee(Model modal) { 
		String message = "From delete emoloyee";
		modal.addAttribute("message", message);
		return "helloWorld";
		//return new ModelAndView("helloWorld", "message", message); 
	} 
	
	@RequestMapping("/viewEmployee") 
	public String viewEmployee(Model model) { 
		String message = "Employee List";
		model.addAttribute("message", message);
		List<Employee> e = this.empService.fetchEmployeeList();
		model.addAttribute("empList", e);
		return "ListEmployees";
		//return new ModelAndView("helloWorld", "message", message); 
	} 
	
	@RequestMapping("/updateEmployee")
	public @ResponseBody Response updateEmployee(@RequestBody Employee employee){
		this.response.setStatus(400);
		if(this.empService.updateEmployee(employee) > 0) {
			this.response.setStatus(200);
			this.response.setEmpoyee(employee);
		}
		
		return this.response;
	}
	
	
}