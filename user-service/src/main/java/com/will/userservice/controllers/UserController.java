package com.will.userservice.controllers;

import com.will.userservice.models.NewMesocycleRequestBody;
import com.will.userservice.models.User;
import com.will.userservice.services.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-service")
public class UserController {

  @Autowired
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<User> getAllUserDetails(){
    return userService.getAllUserDetails();
  }

  @GetMapping(path = "/{id}")
  public User getUserById(@PathVariable String id){
    return userService.getUserById(id);
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody @Valid User user){
    return userService.createUser(user);
  }

  @PostMapping(path = "/create-meso")
  public void createMeso(@RequestBody @Valid NewMesocycleRequestBody newMesocycleRequestBody){
    userService.createMeso(newMesocycleRequestBody);
  }

  @GetMapping(path = "demo")
  public NewMesocycleRequestBody getDemo(){
    return new NewMesocycleRequestBody("bob@gmail.com", "My First Meso");
  }
}
