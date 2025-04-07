package com.example.demo.service;

import java.util.List;

import com.example.demo.model.EmployeeDetails;

public interface EmployeeService {

	 //EmployeeDetails createEmployee(EmployeeDetails employeeDetails);

	List<EmployeeDetails> createMultipleEmployees(List<EmployeeDetails> employeeDetails);

	EmployeeDetails updateEmploye(EmployeeDetails employeeDetails);

	EmployeeDetails getEmployeeBySsn(String ssn);

	void deleteEmployee(int id);

	void deleteMultipleEmployees(List<Integer> ids);

	EmployeeDetails getEmployeeDetails(int id);
	 
	 List<EmployeeDetails> getEmployeeDetails();
}
