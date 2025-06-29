package com.example.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/api")
@RestController
public class RestApiController {

    @GetMapping(path="")
    public void hello(){
        var lst = List.of("hello");
        var elem= lst.get(1);

        log.info("element: ",elem);

    }
}
