package com.example.exception.validator;

import com.example.exception.annotation.PhoneNumber;
import com.example.exception.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {
    private  String pattern;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        var value= s+"01";
        var newPattern= pattern+"dd";
        try{
            LocalDate date = LocalDate.parse(value, DateTimeFormatter.ofPattern(newPattern));
            System.out.println(date);
            return true;
        }
        catch ( Exception e ){
            return false;
        }
    }

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }
}
