package com.will.hypertrophyadviceservice.controllers;


import com.will.hypertrophyadviceservice.models.Exercise;
import com.will.hypertrophyadviceservice.models.ExerciseInfo;
import com.will.hypertrophyadviceservice.models.RecommendedWeek;
import com.will.hypertrophyadviceservice.models.Workout;
import com.will.hypertrophyadviceservice.models.Week;
import com.will.hypertrophyadviceservice.service.MPService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mp")
public class MPController {

  @Autowired
  private MPService mpService;

  public MPController(MPService mpService) {
    this.mpService = mpService;
  }

  @GetMapping("/exercise-info")
  public List<ExerciseInfo> getAllExerciseInfo(){
    return mpService.getAllExerciseInfo();
  }

  @PostMapping("/make-exercise-harder")
  public Exercise makeExerciseHarder(@Valid @RequestBody Exercise exercise){
    return mpService.makeExerciseHarder(exercise);
  }

  @PostMapping("/make-workout-harder")
  public Workout makeWorkoutHarder(@Valid @RequestBody Workout workout){
    return mpService.makeWorkoutHarder(workout);
  }

  @PostMapping("/make-week-harder")
  public RecommendedWeek makeWeekHarder(@Valid @RequestBody Week week){
    return mpService.makeWeekHarder(week);
  }
}
