package com.will.userservice.models;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutSubmission {
  @NotNull
  private String email;
  @NotNull
  private String mesoName;
  @NotNull
  private Integer weekNum;
  @NotNull
  private Workout workout;
}
