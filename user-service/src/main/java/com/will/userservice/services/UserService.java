package com.will.userservice.services;

import com.will.userservice.models.Mesocycle;
import com.will.userservice.models.NewMesocycleRequestBody;
import com.will.userservice.models.User;
import com.will.userservice.repositories.UserRepository;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  public ResponseEntity<User> createUser(User user) {
    User savedUser = userRepository.save(user);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getEmail())
        .toUri();

    return ResponseEntity.created(location).build();
  }

  public void createMeso(NewMesocycleRequestBody newMesocycleRequestBody) {
    Optional <User> optUser = userRepository.findById(newMesocycleRequestBody.getEmail());

    if (!optUser.isPresent()){
      // TODO: 31/07/2023 throw expeception
    }

    User user = optUser.get();

    List <Mesocycle> mesocycles = user.getMesocycles();
    mesocycles.add(new Mesocycle(newMesocycleRequestBody.getMesoName()));

    user.setMesocycles(mesocycles);
    userRepository.save(user);

  }
}
