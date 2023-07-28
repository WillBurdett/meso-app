package com.will.userservice.models;

import com.will.userservice.enums.BodyPartName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BodyPartInfo {

  private BodyPartName bodyPartName;
  private Integer minSetsPerWeek;
  private Integer maxSetsPerWeek;
}
