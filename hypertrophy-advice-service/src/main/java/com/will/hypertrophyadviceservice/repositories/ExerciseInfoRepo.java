package com.will.hypertrophyadviceservice.repositories;

import com.will.hypertrophyadviceservice.enums.ExerciseName;
import com.will.hypertrophyadviceservice.models.ExerciseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseInfoRepo extends JpaRepository<ExerciseInfo, ExerciseName> {

}
