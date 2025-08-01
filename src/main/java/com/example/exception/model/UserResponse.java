package com.example.exception.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value= PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class UserResponse {

    private String id;
    private String name;
    private Integer age;
}
