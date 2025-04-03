package com.example.demo;


public class Exception{
	public static class SsnAlreadyExistsException extends RuntimeException {
	    public SsnAlreadyExistsException(String message) {
	        super(message);
	    }
	}
	public static class EmployeeDoesNotExistsException extends RuntimeException {
		 public EmployeeDoesNotExistsException(String message) {
		        super(message);
		    }
	}
}
