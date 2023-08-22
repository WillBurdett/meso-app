package com.will.userservice.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Week {

  @NotNull
  private Integer weekNumber;

  @NotNull
  private List<Workout> allWorkouts;

  public Week() {
    this.weekNumber = 0;
    this.allWorkouts = new ArrayList<>();
  }

  public Week(Integer weekNumber) {
    this.weekNumber = weekNumber;
    this.allWorkouts = new ArrayList<>();
  }
}
