package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.EmployeeDoesNotExistsException;
import com.example.demo.Exception.SsnAlreadyExistsException;
import com.example.demo.model.EmployeeDetails;
import com.example.demo.repo.EmployeeDetailsRepo;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	private final EmployeeDetailsRepo employeeDetailsRepo;
	
	public EmployeeServiceImpl(EmployeeDetailsRepo employeeDetailsRepo) {
		this.employeeDetailsRepo=employeeDetailsRepo;
	}

//	public EmployeeDetails createEmployee(EmployeeDetails employeeDetails) {
//		 if (employeeDetailsRepo.existsBySsn(employeeDetails.getSsn())) {
//	            throw new SsnAlreadyExistsException("Employee with SSN already exists");
//	        }
//		return employeeDetailsRepo.save(employeeDetails);
//	}

	@Override
	public List<EmployeeDetails> createMultipleEmployees(List<EmployeeDetails> employees) {
		List<EmployeeDetails> toBeSaved = new ArrayList<>();

		for (EmployeeDetails emp : employees) {
			if (!employeeDetailsRepo.existsBySsn(emp.getSsn())) {
				toBeSaved.add(emp);
			}
		}

		return employeeDetailsRepo.saveAll(toBeSaved);
	}

	public EmployeeDetails getEmployeeBySsn(String ssn) {
		return employeeDetailsRepo.findBySsn(ssn);
	}


	public EmployeeDetails updateEmploye(EmployeeDetails employeeDetails) {
		if (employeeDetailsRepo.findById(employeeDetails.getId()).isEmpty()) {
            throw new EmployeeDoesNotExistsException("Employee with employeeId does not exists");
        }
		return employeeDetailsRepo.save(employeeDetails);
	}
	
	public void deleteEmployee(int id) {
		if (employeeDetailsRepo.findById(id).isEmpty()) {
            throw new EmployeeDoesNotExistsException("Employee with employeeId does not exists");
        }
		employeeDetailsRepo.deleteById(id);
	}

	@Override
	public void deleteMultipleEmployees(List<Integer> ids) {
		employeeDetailsRepo.deleteAllById(ids);
	}
	
	public EmployeeDetails getEmployeeDetails(int id) {
		
		return employeeDetailsRepo.findById(id).orElse(null);
		
	}
	
	public List<EmployeeDetails> getEmployeeDetails() {
		return employeeDetailsRepo.findAll();
	}
}
