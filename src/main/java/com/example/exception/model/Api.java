package com.example.exception.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value= PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class Api<T> {

    private String resultCode;
    private String resultMessage;
    @Valid
    private T data;
    private Error error;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonNaming(value= PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Error{
        private List<String> errorMessages;
    }
}
