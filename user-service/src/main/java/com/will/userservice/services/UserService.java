package com.will.userservice.services;

import com.will.userservice.exceptions.EmailAlreadyInUseException;
import com.will.userservice.exceptions.MesocycleNotFoundException;
import com.will.userservice.exceptions.UserNotFoundException;
import com.will.userservice.exceptions.WeekDoesNotExistException;
import com.will.userservice.exceptions.WeekNumberAlreadyExistsException;
import com.will.userservice.models.CreateWeekRequest;
import com.will.userservice.models.Mesocycle;
import com.will.userservice.models.MesocycleCreationDeletion;
import com.will.userservice.models.User;
import com.will.userservice.models.Week;
import com.will.userservice.models.Workout;
import com.will.userservice.models.WorkoutSubmission;
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
    if (emailAlreadyInUse(user.getEmail())){
      throw new EmailAlreadyInUseException("email address already in use: " + user.getEmail());
    }
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

  public ResponseEntity<Week> createWeek(CreateWeekRequest createWeekRequest) {
    Optional <User> optUser = userRepository.findById(createWeekRequest.getEmail());

    if (!optUser.isPresent()){
      throw new UserNotFoundException("id: " + createWeekRequest.getEmail());
    }

    User user = optUser.get();

    Mesocycle meso = findMesoById(user.getMesocycles(), createWeekRequest.getMesoName());

    Integer weekIndex = findWeekByWeekNum(meso, createWeekRequest.getWeekNum());

    if (weekIndex != null){
      throw new WeekNumberAlreadyExistsException(
          "Week number: " + createWeekRequest.getWeekNum()
              + ", already exists for user: " + createWeekRequest.getEmail()
              + ", in mesocycle: " + createWeekRequest.getMesoName());
    } else {
      meso.getWeeks().add(new Week(createWeekRequest.getWeekNum()));
    }

    User savedUser = userRepository.save(user);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getEmail())
        .toUri();

    return ResponseEntity.created(location).build();
  }


  public ResponseEntity<Workout> addWorkoutToGivenWeekOfMeso(WorkoutSubmission workoutSubmission) {
    Optional <User> optUser = userRepository.findById(workoutSubmission.getEmail());

    if (!optUser.isPresent()){
      throw new UserNotFoundException("id: " + workoutSubmission.getEmail());
    }

    User user = optUser.get();

    Mesocycle meso = findMesoById(user.getMesocycles(), workoutSubmission.getMesoName());

    Integer weekIndex = findWeekByWeekNum(meso, workoutSubmission.getWeekNum());

    if (weekIndex != null){
      meso.getWeeks().get(weekIndex).getAllWorkouts().add(workoutSubmission.getWorkout());
    } else {
      throw new WeekDoesNotExistException(
          "week number " + workoutSubmission.getWeekNum() +
              " does not exist for mesocycle named: " + workoutSubmission.getMesoName());
    }

    User savedUser = userRepository.save(user);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getEmail())
        .toUri();

    return ResponseEntity.created(location).build();
  }

  private Integer findWeekByWeekNum(Mesocycle meso, Integer weekNum) {
    for (int i = 0; i < meso.getWeeks().size(); i++) {
      if (meso.getWeeks().get(i).getWeekNumber() == weekNum){
        return i;
      }
    }
    return null;
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

  private Boolean emailAlreadyInUse(String email){
    Optional<User> user = userRepository.findById(email);
    return user.isPresent();
  }
}
