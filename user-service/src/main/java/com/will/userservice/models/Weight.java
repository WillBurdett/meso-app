package com.will.userservice.models;

import com.will.userservice.enums.WeightUnit;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weight {
  @Min(value = 0, message = "weight cannot be below 0")
  private Double value;
  private WeightUnit unit;
}
