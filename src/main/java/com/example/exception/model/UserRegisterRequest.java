package com.example.exception.model;

import com.example.exception.annotation.PhoneNumber;
import com.example.exception.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value= PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

    @NotBlank
    private String name;

    private  String nickname;

    @NotBlank
    @Size(min=1,max=12)
    private String password;

    @NotNull
    @Max(120)
    @Min(1)
    private Integer age;

    @Email
    private String email;

    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @YearMonth(pattern="yyyy-mm")
    private String birthdayYearMonth;

    @AssertTrue
    public boolean isNameCheck(){
        if(Objects.nonNull(name) && !name.isBlank()){
            return true;
        }
        if(Objects.nonNull(nickname) && !nickname.isBlank()){
            return true;
        }

        return false;
    }
}
