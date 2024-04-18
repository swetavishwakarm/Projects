package com.exceptions;

public class InvalidAmountException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidAmountException() {
		super();
	}
	
	public InvalidAmountException(String errMsg) {
		super(errMsg);
	}
}
