package com.will.hypertrophyadviceservice.models;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendedWeek {

  private Week week;
  private List<String> suggestions;

  public RecommendedWeek() {
    this.week = new Week();
    this.suggestions = new ArrayList<>();
  }
}
