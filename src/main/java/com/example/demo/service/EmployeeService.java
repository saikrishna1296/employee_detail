package com.example.demo.service;

import java.util.List;

import com.example.demo.model.EmployeeDetails;

public interface EmployeeService {

	 EmployeeDetails createEmployee(EmployeeDetails employeeDetails);
	 
	 EmployeeDetails updateEmploye(EmployeeDetails employeeDetails);
	 
	 void deleteEmployee(int id);
	 
	 EmployeeDetails getEmployeeDetails(int id);
	 
	 List<EmployeeDetails> getEmployeeDetails();
}
