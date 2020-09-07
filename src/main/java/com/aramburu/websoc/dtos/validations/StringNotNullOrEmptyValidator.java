package com.aramburu.websoc.dtos.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aramburu.websoc.business_controllers.CenterController;

public class StringNotNullOrEmptyValidator implements ConstraintValidator<StringNotNullOrEmpty, String> {

	
    @Override
    public void initialize(StringNotNullOrEmpty constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       
    return s != null && !s.isEmpty();
    }
}
