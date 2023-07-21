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
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseInfo {

  @Id
  @Column
  private ExerciseName exerciseName;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "body_part_name", referencedColumnName = "body_part_name")
  private BodyPart bodyPart;

  @Column
  private MovementType movementType;

  @Column
  private MovementDirection movementDirection;

  @Column
  private Integer minReps;

  @Column
  private Integer maxReps;
}
