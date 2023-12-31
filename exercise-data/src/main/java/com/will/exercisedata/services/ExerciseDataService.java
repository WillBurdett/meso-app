package com.will.exercisedata.services;

import com.will.exercisedata.enums.BodyPartName;
import com.will.exercisedata.enums.ExerciseName;
import com.will.exercisedata.enums.MinOrMax;
import com.will.exercisedata.models.BodyPartInfo;
import com.will.exercisedata.models.ExerciseInfo;
import com.will.exercisedata.repositories.BodyPartInfoRepo;
import com.will.exercisedata.repositories.ExerciseInfoRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseDataService {

  @Autowired
  private final ExerciseInfoRepo exerciseInfoRepo;

  @Autowired
  private final BodyPartInfoRepo bodyPartInfoRepo;

  public ExerciseDataService(ExerciseInfoRepo exerciseInfoRepo, BodyPartInfoRepo bodyPartInfoRepo) {
    this.exerciseInfoRepo = exerciseInfoRepo;
    this.bodyPartInfoRepo = bodyPartInfoRepo;
  }

  public List<ExerciseInfo> getAllExerciseInfo(){
    return exerciseInfoRepo.findAll();
  }

  public BodyPartInfo getBodyPartInfo(BodyPartName bpName) {
    Optional<BodyPartInfo> bpInfo = bodyPartInfoRepo.findById(bpName);
    if (bpInfo.isPresent()){
      return bpInfo.get();
    }
    return null;
  }

  public ExerciseInfo getExerciseInfo(ExerciseName exName) {
    Optional<ExerciseInfo> exInfo = exerciseInfoRepo.findById(exName);
    if (exInfo.isPresent()){
      return exInfo.get();
    }
    return null;
  }
}
