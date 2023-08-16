package com.will.userservice.models;

import com.will.userservice.enums.Day;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workout {
  @NotNull
  private Day day;
  @NotNull
  private String name;
  @NotNull
  private List<Exercise> exercises;

  public Workout(Day day,String name) {
    this.day = day;
    this.name = name;
    this.exercises = new ArrayList();
  }
}
