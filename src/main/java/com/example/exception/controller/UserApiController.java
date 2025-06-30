package com.example.exception.controller;


import com.example.exception.model.Api;
import com.example.exception.model.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.exception.model.UserResponse;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private static List<UserResponse> userList = List.of(
        UserResponse.builder()
            .id("1")
            .age(10)
            .name("홍길동")
            .build(),
        UserResponse.builder().id("2")
            .age(10)
            .name("유관순")
            .build()
            );

    @GetMapping("id/{userId")
    public Api<UserResponse> getUser(@PathVariable String userId){

        var user=userList.stream().filter(it -> it.getId().equals(userId)).findFirst().get();

        Api<UserResponse> response = Api.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(user).build();

        return response;
    }

    @PostMapping("")
    public Api<UserRegisterRequest> register(

            @Valid
            @RequestBody
            Api<UserRegisterRequest> userRegisterRequest

    ){
        log.info("init : {}", userRegisterRequest);

        var body = userRegisterRequest.getData();

        var response = Api.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();

        return response;
    }
}
