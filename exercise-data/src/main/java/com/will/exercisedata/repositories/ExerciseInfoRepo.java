package com.will.exercisedata.repositories;

import com.will.exercisedata.enums.ExerciseName;
import com.will.exercisedata.models.ExerciseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseInfoRepo extends JpaRepository<ExerciseInfo, ExerciseName> {

}
