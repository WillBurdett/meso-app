package com.will.userservice.services;

import com.will.userservice.exceptions.MesocycleNotFoundException;
import com.will.userservice.exceptions.UserNotFoundException;
import com.will.userservice.models.Mesocycle;
import com.will.userservice.models.MesocycleCreationDeletion;
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

  public User getUserById(String id) {
    Optional <User> optUser = userRepository.findById(id);

    if (!optUser.isPresent()){
      throw new UserNotFoundException("id: " + id);
    }

    return optUser.get();
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

  public ResponseEntity<Mesocycle> createMeso(MesocycleCreationDeletion mesocycleCreationDeletion) {
    Optional <User> optUser = userRepository.findById(mesocycleCreationDeletion.getEmail());

    if (!optUser.isPresent()){
      throw new UserNotFoundException("id: " + mesocycleCreationDeletion.getEmail());
    }

    User user = optUser.get();

    List <Mesocycle> mesocycles = user.getMesocycles();
    mesocycles.add(new Mesocycle(mesocycleCreationDeletion.getMesoName()));

    user.setMesocycles(mesocycles);
    User savedUser = userRepository.save(user);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getEmail())
        .toUri();

    return ResponseEntity.created(location).build();
  }

  public void deleteUserById(String id) {
    userRepository.deleteById(id);
  }

  public ResponseEntity<User> deleteUsersMesoById(MesocycleCreationDeletion mesocycleCreationDeletion) {
    Optional <User> optUser = userRepository.findById(mesocycleCreationDeletion.getEmail());

    if (!optUser.isPresent()){
      throw new UserNotFoundException("id: " + mesocycleCreationDeletion.getEmail());
    }

    User user = optUser.get();

    deleteMesoById(user.getMesocycles(), mesocycleCreationDeletion.getMesoName());
    User savedUser = userRepository.save(user);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getEmail())
        .toUri();

    return ResponseEntity.created(location).build();

  }

  public Mesocycle findMesoById(List<Mesocycle> mesocycles, String mesoName){
    for (Mesocycle m:
        mesocycles
    ) {
      if (m.getName().equals(mesoName)){
        return m;
      }
    }
    throw new MesocycleNotFoundException("id: " + mesoName);
  }

  public void deleteMesoById(List<Mesocycle> mesocycles, String mesoName){
    for (int i = 0; i < mesocycles.size(); i++) {
      if (mesocycles.get(i).getName().equals(mesoName)){
        mesocycles.remove(i);
        return;
      }
    }
    throw new MesocycleNotFoundException("id: " + mesoName);
  }
}
