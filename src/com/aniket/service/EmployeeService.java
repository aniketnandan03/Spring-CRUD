package com.aniket.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aniket.bean.Employee;
import com.aniket.dao.IEmployeeDao;

@Service("empService")
public class EmployeeService implements IEmployeeServices {

	@Autowired
	private IEmployeeDao empDao;
	
	@Transactional
	public String createEmployee(Employee e) {
		@SuppressWarnings("unused")
		int success;
		String successMessage;
		try {
			success = (int) this.empDao.CreateNewEmployee(e);
			successMessage = "Employee is successfully created";
		} catch (SQLException e1) {
			e1.printStackTrace();
			successMessage = "Problem in creation in employee, please try again later";
		}
		return successMessage;
	}

	@Transactional
	public ArrayList<Employee> fetchEmployeeList() {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		System.out.println("right");
		try {
			
			empList = this.empDao.fetchEmployees();
		} catch (SQLException e) {
			empList = null;
			e.printStackTrace();
			System.out.println("SQL exception while fetching all employees");
		}
		return empList;
	}

	@Transactional
	public Employee getParticularEmployee(int id) {
		Employee e = null;
		
		try {
			e = this.empDao.getEmployee(id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;	
	}
	
	@Transactional
	public int updateEmployee(Employee e){
		int count = 0;
		try {
			count = this.empDao.updateEmployee(e);
			
		} catch(SQLException s) {
			s.printStackTrace();
		}
		return count;
	}

}
