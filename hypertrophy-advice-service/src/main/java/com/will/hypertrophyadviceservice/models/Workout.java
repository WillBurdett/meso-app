package com.will.hypertrophyadviceservice.models;

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
  private String name;
  @NotNull
  private List<Exercise> exercises;

  public Workout(String name) {
    this.exercises = new ArrayList();
    this.name = name;
  }
}
