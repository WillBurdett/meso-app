package com.will.userservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewMesocycleRequestBody {
  private String email;
  private String mesoName;
}
