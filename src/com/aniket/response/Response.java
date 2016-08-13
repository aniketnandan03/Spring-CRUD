package com.aniket.response;

import org.springframework.stereotype.Component;

import com.aniket.bean.Employee;

@Component("response")
public class Response {
	private int status;
	private Employee empoyee;
	public void setStatus(int status) {
		this.status = status;
	}
	public void setEmpoyee(Employee empoyee) {
		this.empoyee = empoyee;
	}
	public int getStatus() {
		return status;
	}
	public Employee getEmpoyee() {
		return empoyee;
	}	


}
