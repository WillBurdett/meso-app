package com.will.userservice.services;

import com.will.userservice.models.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {


  public List<User> getAllUserDetails() {
    return List.of(new User("bob@gmail.com", "pass123"));
  }
}
