package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="employye_details",schema = "dbo")
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Integer id;
	private String firstName;
	private String lastName;
	private String ssn;
	private LocalDateTime dob;
	private String city;
	private String zip;
	
}
