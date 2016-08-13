package com.aniket.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aniket.bean.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> target) {
		return Employee.class.equals(target);
	}

	@Override
	public void validate(Object target, Errors error) {
		Employee e = null;
		
		if(target instanceof Employee){
			e = (Employee) target;	
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "userName", "user name can not be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "password can not be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "email", "email can not be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "phone", "phone can not be blank");
	}

}
