package com.will.userservice.controllers;

import com.will.userservice.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-service")
public class UserServiceController {

  @GetMapping
  public User getUserDetails(){
    return new User("bob@gmail.com", "pass123");
  }
}
