package com.will.userservice.models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mesocycle {
  private String name;
  private String creationDate;
  private List<Week> weeks;

  public Mesocycle() {
    this.name = "";
    this.creationDate = "";
    this.weeks = new ArrayList<>();
  }

  public Mesocycle(String name) {
    this.name = name;
    this.creationDate = ZonedDateTime.now().toString().substring(0, 10);
    this.weeks = new ArrayList<>();
  }
}
