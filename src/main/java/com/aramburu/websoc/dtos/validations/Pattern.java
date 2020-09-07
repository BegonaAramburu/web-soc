package com.aramburu.websoc.dtos.validations;

public final class Pattern {
	
	public static final String NINE_DIGITS = "\\d{9}";
	
	public static final String EMAIL_FORMAT = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$";

    private Pattern() {
        // Nothing to do
    }
    
    
}
