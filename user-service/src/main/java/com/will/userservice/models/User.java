package com.will.userservice.models;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class User {
  private String email;
  private String password;
  private List<Mesocycle> mesocycles;

  public User() {
    this.email = "";
    this.password = "";
    this.mesocycles = new ArrayList<>();
  }

  public User(String email, String password) {
    this.email = email;
    this.password = password;
    this.mesocycles = new ArrayList<>();
  }
}
