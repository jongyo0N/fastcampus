package com.example.exception.validator;

import com.example.exception.annotation.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    private  String regexp;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = Pattern.matches(regexp,s);
        return result;
    }

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }
}
