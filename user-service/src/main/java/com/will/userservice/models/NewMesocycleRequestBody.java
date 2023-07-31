package com.will.userservice.models;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewMesocycleRequestBody {
  @NotNull
  private String email;
  @NotNull
  private String mesoName;
}
