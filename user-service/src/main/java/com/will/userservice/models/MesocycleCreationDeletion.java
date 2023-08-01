package com.will.userservice.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MesocycleCreationDeletion {
  @NotNull(message = "email must be present")
  @Size(min = 4, message = "email must be at least 4 characters long")
  private String email;
  @NotNull(message = "mesocycle name must be present")
  @Size(min = 1, message = "mesocycle name must be at least 1 character long")
  private String mesoName;
}
