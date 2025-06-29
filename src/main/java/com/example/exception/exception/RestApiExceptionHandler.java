package com.example.exception.exception;

import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(basePackages = "com.example.exception.controller")
@Order(1)
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outofBound(
            IndexOutOfBoundsException e
    ){
        log.error("IndexOutOfBoundsException",e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value= NoSuchElementException.class)
    public ResponseEntity<Api> NoSuchElement(NoSuchElementException e){
        log.error("",e);

        var body=Api.builder()
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
