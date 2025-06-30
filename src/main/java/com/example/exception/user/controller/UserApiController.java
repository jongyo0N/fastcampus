package com.example.exception.user.controller;

import com.example.exception.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.exception.user.service.UesrService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserApiController {

    private UesrService uesrService;

   @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity
   ){
       return uesrService.save(userEntity);
   }

   @GetMapping("/all")
    public List<UserEntity> findAll(){
       return uesrService.findAll();
   }

   @DeleteMapping("/id/{id}")
   public void delete(
           @PathVariable Long id
   ){
     uesrService.delete(id);
   }

   @GetMapping("/id/{id}")
    public UserEntity findOne(
            @PathVariable Long id
   ){
       var response=uesrService.findById(id);
       return response.get();
   }

   @GetMapping("/")
   public List<UserEntity> filterScore(
           @RequestParam int score
   ){
       return uesrService.filterScore(score);
   }
}
