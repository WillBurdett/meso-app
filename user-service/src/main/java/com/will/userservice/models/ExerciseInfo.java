package com.will.userservice.models;

import com.will.userservice.enums.ExerciseName;
import com.will.userservice.enums.MovementDirection;
import com.will.userservice.enums.MovementType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseInfo {

  private ExerciseName exerciseName;
  private BodyPartInfo bodyPartInfo;
  private MovementType movementType;
  private MovementDirection movementDirection;
  private Integer minReps;
  private Integer maxReps;
}
