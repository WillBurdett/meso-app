package com.will.hypertrophyadviceservice.feign;

import com.will.hypertrophyadviceservice.models.BodyPartInfo;
import com.will.hypertrophyadviceservice.models.ExerciseInfo;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exercise-data", url = "localhost:8081")
public interface ExerciseDataCalls {

    @GetMapping("/exercise-data")
    List<ExerciseInfo> getAllExerciseInfo();

    @GetMapping("/exercise-data/exercise/{exName}")
    ExerciseInfo getExerciseInfo(@PathVariable String exName);

    @GetMapping("/exercise-data/bodypart/{bpName}")
    BodyPartInfo getBodyPartInfo(@PathVariable String bpName);

}

