package com.will.hypertrophyadviceservice.models;

import com.will.hypertrophyadviceservice.enums.BodyPartName;
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
public class BodyPart {
  @Id
  @Column(name = "body_part_name")
  private BodyPartName bodyPartName;

  @Column
  private Integer minSetsPerWeek;

  @Column
  private Integer maxSetsPerWeek;
}
