package com.will.userservice.services;

import com.will.userservice.models.User;
import com.will.userservice.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUserDetails() {
    return userRepository.findAll();
  }

  public void createUser(User user) {
    userRepository.save(user);
  }
}
