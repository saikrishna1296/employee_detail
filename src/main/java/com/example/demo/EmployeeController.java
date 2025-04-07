package com.example.demo;

import org.springframework.web.bind.annotation.*;

import com.example.demo.Exception.EmployeeDoesNotExistsException;
import com.example.demo.Exception.SsnAlreadyExistsException;
import com.example.demo.model.EmployeeDetails;
import com.example.demo.service.EmployeeService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
//	@PostMapping("/create")
//	public ResponseEntity<?> createEmployee(@RequestBody EmployeeDetails employeeDetails){
//		try {
//		employeeService.createEmployee(employeeDetails);
//		return ResponseEntity.status(HttpStatus.OK).body("Employee created Sucessfully");
//		}catch(SsnAlreadyExistsException e){
//			 return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//		}
//	}


	@PostMapping("/create")
	public ResponseEntity<?> createEmployees(@RequestBody List<EmployeeDetails> employees) {
		try {
			List<EmployeeDetails> savedEmployees = employeeService.createMultipleEmployees(employees);
			return ResponseEntity.status(HttpStatus.OK).body("Employee created Sucessfully");
		}catch(SsnAlreadyExistsException e){
			 return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable int id,@RequestBody EmployeeDetails employeeDetails){
		try {
		employeeDetails.setId(id);
		employeeService.updateEmploye(employeeDetails);
		return ResponseEntity.status(HttpStatus.OK).body("Employee updated Sucessfully");
		}catch(EmployeeDoesNotExistsException e) {
			 return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@GetMapping("/details/ssn/{ssn}")
	public ResponseEntity<?> getEmployeeBySsn(@PathVariable String ssn) {
		EmployeeDetails employee = employeeService.getEmployeeBySsn(ssn);
		if (employee != null) {
			return ResponseEntity.ok(employee);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with SSN not found");
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.OK).body("Employee deleted Sucessfully");
	}


	@DeleteMapping("/delete-multiple")
	public ResponseEntity<String> deleteMultipleEmployees(@RequestBody List<Integer> ids) {
		employeeService.deleteMultipleEmployees(ids);
		return ResponseEntity.status(HttpStatus.OK).body("Employee deleted Sucessfully");
	}


	@GetMapping("/details/{id}")
	public  EmployeeDetails getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeDetails(id);
	}
	
	@GetMapping("/allDetails")
	public List< EmployeeDetails> getAllEmployees() {
		return employeeService.getEmployeeDetails();
	}
}
