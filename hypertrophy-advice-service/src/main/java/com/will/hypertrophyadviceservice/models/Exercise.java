package com.will.hypertrophyadviceservice.models;

import com.will.hypertrophyadviceservice.enums.ExerciseName;
import com.will.hypertrophyadviceservice.enums.SetConditions;

import com.will.hypertrophyadviceservice.enums.validation.ValueOfEnum;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
  @NotNull
  @ValueOfEnum(enumClass = ExerciseName.class, message = "invalid exercise name")
  private String exerciseName;
  private SetConditions setConditions;

  @Min(value = 1)
  @Max(value = 5)
  private Integer sets;

  @NotEmpty
  private String reps;

  @Valid
  private Weight weight;

  @Min(value = 0, message = "minutes of rest cannot be below 0")
  private Integer minutesOfRest;

  @Min(value = 0, message = "reps in reserve cannot be below 0")
  private Integer repsInReserve;
}
