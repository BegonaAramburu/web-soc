package com.aramburu.websoc.exceptions;

public class ErrorMessage {
	
	private final String error;
	
	private final String message;
	
	private final String path;
	
	public ErrorMessage(Exception exception, String path) {
		this.error = exception.getClass().getSimpleName();
		this.message = exception.getMessage();
		this.path = path;
	}
	
	public ErrorMessage(String message) {
		this.message = message;
		this.path = null;
		this.error = null;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		return "ErrorMessage [error=" + error + ", message=" + message + ", path=" + path + "]";
	}
	
	

}
