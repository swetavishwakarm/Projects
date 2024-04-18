package com.example.springbootstudentmanagementsystem.exception;

public class StudentNotFoundException  extends IllegalArgumentException{
	
	private static final long serialVersionUID = 1L;
	
	public StudentNotFoundException(Long id) {
		super(String.format("Student with Id %d not found",id));
	}{

	}
}