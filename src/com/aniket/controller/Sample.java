package com.aniket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Sample {
	@RequestMapping("/click") 
	public String clickMe(Model modal) { 
		String message = "From click me";
		modal.addAttribute("message", message);
		return "helloWorld";
		//return new ModelAndView("helloWorld", "message", message); 
	}
}
