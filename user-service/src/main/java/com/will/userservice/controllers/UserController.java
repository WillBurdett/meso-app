package com.will.userservice.controllers;

import com.will.userservice.enums.Day;
import com.will.userservice.models.CreateWeekRequest;
import com.will.userservice.models.Mesocycle;
import com.will.userservice.models.MesocycleCreationDeletion;
import com.will.userservice.models.User;
import com.will.userservice.models.Week;
import com.will.userservice.models.Workout;
import com.will.userservice.models.WorkoutSubmission;
import com.will.userservice.services.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

  @DeleteMapping(path = "/{id}")
  public void deleteUserById(@PathVariable String id){
    userService.deleteUserById(id);
  }

  @PostMapping
  public ResponseEntity<User> createUser(@Valid @RequestBody User user){
    return userService.createUser(user);
  }

  @PostMapping(path = "/meso/create")
  public ResponseEntity<Mesocycle> createMeso(@Valid @RequestBody MesocycleCreationDeletion mesocycleCreationDeletion){
    return userService.createMeso(mesocycleCreationDeletion);
  }

  @PostMapping(path = "/meso/create-week")
  public ResponseEntity<Week> createWeek(@Valid @RequestBody CreateWeekRequest createWeekRequest){
    return userService.createWeek(createWeekRequest);
  }

  @PostMapping(path = "/meso/add-workout")
  public ResponseEntity<Workout> addWorkoutToGivenWeekOfMeso(@Valid @RequestBody WorkoutSubmission workoutSubmission){
    return userService.addWorkoutToGivenWeekOfMeso(workoutSubmission);
  }

  @DeleteMapping(path = "/meso")
  public ResponseEntity<User> deleteUsersMesoById(@RequestBody MesocycleCreationDeletion mesocycleCreationDeletion){
    return userService.deleteUsersMesoById(mesocycleCreationDeletion);
  }

  @GetMapping(path = "demo")
  public WorkoutSubmission getDemo(){
    return new WorkoutSubmission(
        "bob@gmail.com",
        "My First Meso",
        1,
        new Workout(Day.MONDAY, "Chest day"));
  }
}
