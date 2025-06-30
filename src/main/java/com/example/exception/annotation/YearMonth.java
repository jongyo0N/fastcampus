package com.example.exception.annotation;

import com.example.exception.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NotBlank
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface YearMonth {
    String message() default "year month 양식에 맞지 않습니다.";

    String pattern() default "yyyyMMdd";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
