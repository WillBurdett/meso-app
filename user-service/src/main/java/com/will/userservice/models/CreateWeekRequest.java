package com.will.userservice.models;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateWeekRequest {
  @NotNull
  private String email;
  @NotNull
  private String mesoName;
  @NotNull
  private Integer weekNum;
}
