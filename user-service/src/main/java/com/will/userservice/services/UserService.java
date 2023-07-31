package com.will.userservice.services;

import com.will.userservice.models.Mesocycle;
import com.will.userservice.models.User;
import com.will.userservice.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
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

  public void createMeso(String email, String mesoName) {
    Optional <User> optUser = userRepository.findById(email);

    if (!optUser.isPresent()){
      // TODO: 31/07/2023 throw expeception
    }

    List <Mesocycle> mesocycles = optUser.get().getMesocycles();

    mesocycles.add(new Mesocycle(mesoName));

    optUser.get().setMesocycles(mesocycles);

    userRepository.save(optUser.get());


  }
}
