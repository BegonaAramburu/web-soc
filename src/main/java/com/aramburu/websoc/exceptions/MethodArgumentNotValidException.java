package com.aramburu.websoc.exceptions;

@SuppressWarnings("serial")
public class MethodArgumentNotValidException extends RuntimeException{
	
	private static final String DESCRIPTION ="Not Valid Exception ";
	
	public MethodArgumentNotValidException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

}
