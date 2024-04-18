package com.example.springbootstudentmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionController {
	//For your UIs
		@ExceptionHandler(StudentNotFoundException.class)
		public String studentNotFoundException(StudentNotFoundException px) {
			return "error";
		}
		
		//For REST APIs
		@ExceptionHandler(IllegalArgumentException.class)
		public ResponseEntity<?> illegalArgumentException(IllegalArgumentException ix){
			return new ResponseEntity<>(ix.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}

}
