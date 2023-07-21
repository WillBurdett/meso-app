package com.will.exercisedata.controllers;

import com.will.exercisedata.enums.BodyPartName;
import com.will.exercisedata.enums.MinOrMax;
import com.will.exercisedata.models.BodyPartInfo;
import com.will.exercisedata.models.ExerciseInfo;
import com.will.exercisedata.services.ExerciseDataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exercise-data")
public class ExerciseDataController {

  @Autowired
  ExerciseDataService exerciseDataService;

  public ExerciseDataController(ExerciseDataService exerciseDataService) {
    this.exerciseDataService = exerciseDataService;
  }

  @GetMapping
  public List<ExerciseInfo> getAllExerciseInfo(){
    return exerciseDataService.getAllExerciseInfo();
  }

  @GetMapping(path = "/{bpName}")
  public BodyPartInfo getBodyPartInfo(@PathVariable BodyPartName bpName){
    return exerciseDataService.getBodyPartInfo(bpName);
  }

  @GetMapping(path = "/{bpName}/{minOrMax}")
  public Integer getMinOrMaxSetsPerWeekForBodyPart(@PathVariable BodyPartName bpName, @PathVariable MinOrMax minOrMax){
    return exerciseDataService.getMinOrMaxSetsPerWeekForBodyPart(bpName, minOrMax);
  }
}
