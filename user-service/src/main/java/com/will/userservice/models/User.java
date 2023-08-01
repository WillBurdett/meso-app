package com.will.userservice.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class User {

  @Id
  @NotNull(message = "email must be present")
  @Size(min = 4, message = "email must be at least 4 characters long")
  private String email;
  @NotNull(message = "password must be present")
  @Size(min = 4, message = "password must be at least 4 characters long")
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
