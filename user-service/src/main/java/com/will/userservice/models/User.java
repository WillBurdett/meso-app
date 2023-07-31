package com.will.userservice.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class User {

  @Id
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
