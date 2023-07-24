package com.will.hypertrophyadviceservice.models;

import com.will.hypertrophyadviceservice.enums.BodyPartName;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
