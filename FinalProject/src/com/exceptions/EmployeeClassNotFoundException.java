package com.exceptions;

public class EmployeeClassNotFoundException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	public EmployeeClassNotFoundException() {
		super();
	}
	
	public EmployeeClassNotFoundException(String msg) {
		super(msg);
	}

	public EmployeeClassNotFoundException(Exception e) {
		super(e);
	}
	
}		
