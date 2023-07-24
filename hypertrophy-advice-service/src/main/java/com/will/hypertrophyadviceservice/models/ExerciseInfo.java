package com.will.hypertrophyadviceservice.models;

import com.will.hypertrophyadviceservice.enums.ExerciseName;
import com.will.hypertrophyadviceservice.enums.MovementDirection;
import com.will.hypertrophyadviceservice.enums.MovementType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
