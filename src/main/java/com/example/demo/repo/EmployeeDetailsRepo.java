package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EmployeeDetails;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails, Integer> {

	boolean existsBySsn(String ssn);

	String findBySsn(String ssn);

	void deleteBySsn(String ssn);

}
