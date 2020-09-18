package com.aramburu.websoc.exceptions;

public class NotFoundException extends RuntimeException{
	
	private static final String DESCRIPTION ="Not found Exception (404)";
	
	public NotFoundException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

}
