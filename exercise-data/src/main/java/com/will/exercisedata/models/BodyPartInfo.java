package com.will.exercisedata.models;

import com.will.exercisedata.enums.BodyPartName;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BodyPartInfo {
  @Id
  @Column(name = "body_part_name")
  private BodyPartName bodyPartName;

  @Column
  private Integer minSetsPerWeek;

  @Column
  private Integer maxSetsPerWeek;
}
