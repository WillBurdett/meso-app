package com.will.hypertrophyadviceservice.service;

import com.will.hypertrophyadviceservice.enums.BodyPartName;
import com.will.hypertrophyadviceservice.enums.ExerciseName;
import com.will.hypertrophyadviceservice.enums.WeightUnit;
import com.will.hypertrophyadviceservice.exceptions.ExerciseInfoNotFoundException;
import com.will.hypertrophyadviceservice.exceptions.InvalidWeeklyVolumeException;
import com.will.hypertrophyadviceservice.exceptions.RepRangeInvalidException;
import com.will.hypertrophyadviceservice.feign.ExerciseDataCalls;
import com.will.hypertrophyadviceservice.models.BodyPartInfo;
import com.will.hypertrophyadviceservice.models.Exercise;
import com.will.hypertrophyadviceservice.models.ExerciseInfo;
import com.will.hypertrophyadviceservice.models.RecommendedWeek;
import com.will.hypertrophyadviceservice.models.Week;
import com.will.hypertrophyadviceservice.models.Weight;
import com.will.hypertrophyadviceservice.models.Workout;
import com.will.hypertrophyadviceservice.enums.MinOrMax;
import com.will.hypertrophyadviceservice.exceptions.BodyPartNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MPService {

  @Autowired
  private final ExerciseDataCalls exerciseDataCalls;

  public MPService(ExerciseDataCalls exerciseDataCalls) {
    this.exerciseDataCalls = exerciseDataCalls;
  }

  public List<ExerciseInfo> getAllExerciseInfo(){
    return exerciseDataCalls.getAllExerciseInfo();
  }

  public RecommendedWeek makeWeekHarder(Week week) {
    isValidWeeklyVolume(week);
    Week harderWeek = new Week();

    for (Workout w:
        week.getAllWorkouts()) {
      harderWeek.getAllWorkouts().add(makeWorkoutHarder(w));
    }

    harderWeek.setWeekNumber(week.getWeekNumber() + 1);

    return new RecommendedWeek(harderWeek, createSuggestions(harderWeek));
  }

  public List<String> createSuggestions(Week week){
    List<String> output = new ArrayList<>();
    List<BodyPartName> bpsToIncrease = new ArrayList<>();
    HashMap<BodyPartName, Integer> weeklyVolume = countWeeklyVolume(week);

    for (BodyPartName bpName: weeklyVolume.keySet()) {
      BodyPartInfo bpInfo = getBodyPartInfo(bpName);

      /**
       * Currently suggestions to increase volume for a particular body part are prompted when a user is both:
       *  - At least at Week 4 of their Mesocycle
       *  - Still training <= 3 sets of the minimum recommended weekly volume for a body part
       **/

      Integer minRepRange4WeeksIn = bpInfo.getMinSetsPerWeek() + 3;

      if (weeklyVolume.get(bpName) < minRepRange4WeeksIn && week.getWeekNumber() > 3){
        if (bpName.equals(BodyPartName.ABS) && !areDirectlyTrainingAbs(weeklyVolume)){
          continue;
        } else {
          output.add("current weekly volume is " + weeklyVolume.get(bpName) + " set(s) for " + bpName + ", but "
              + "we recommend increasing this to at "
              + "least " + minRepRange4WeeksIn + " for Week " + week.getWeekNumber());
        }
        bpsToIncrease.add(bpName);
      }
    }

    return output;
  }
  
  public Workout makeWorkoutHarder(Workout workout){
      Workout harderWorkout = new Workout(workout.getName());
    for (Exercise e:
        workout.getExercises()
    ) {
      harderWorkout.getExercises().add(makeExerciseHarder(e));
    }
    return harderWorkout;
  }

  public Exercise makeExerciseHarder(Exercise exercise) {
    isValidExercise(exercise);
    Exercise harderExercise = exercise;

    if (exercise.getRepsInReserve() > 0){
      harderExercise.setRepsInReserve(exercise.getRepsInReserve() - 1);
      List<Integer> reps = transformRepStringToIntegerList(exercise.getReps());

      if (getHighestRepsAchieved(reps) < getRepsForExercise(exercise.getExerciseName(), MinOrMax.MAX)){
        harderExercise.setReps(increaseReps(reps));
      } else {
        harderExercise.setWeight(increaseWeight(exercise.getWeight()));
      }
    }
    return harderExercise;
  }

  public ExerciseInfo getExerciseInfo(String exerciseName){
    ExerciseInfo e = exerciseDataCalls.getExerciseInfo(exerciseName);
    if (e != null){
      return e;
    }
    throw new ExerciseInfoNotFoundException("no exercise found called: " + exerciseName);
  }

  public BodyPartInfo getBodyPartInfo(BodyPartName bpName){
    BodyPartInfo b = exerciseDataCalls.getBodyPartInfo(bpName.toString());
    if (b != null) {
      return b;
    }

    throw new BodyPartNotFoundException("no body part found called: " + bpName);
  }

  public Weight increaseWeight(Weight weight){
    if (isKilo(weight)){
      if (weight.getValue() < 20.0){
        return new Weight(weight.getValue() + 1, WeightUnit.KG);
      } else if (weight.getValue() >= 20.0 && weight.getValue() < 40){
        return new Weight(weight.getValue() + 2, WeightUnit.KG);
      } else{
        return new Weight(weight.getValue() + 2.5, WeightUnit.KG);
      }
  }
    if (weight.getValue() < 45.0){
      return new Weight(weight.getValue() + 2.5, WeightUnit.LBS);
    } else if (weight.getValue() >= 45.0 && weight.getValue() < 90){
      return new Weight(weight.getValue() + 5, WeightUnit.LBS);
    } else{
      return new Weight(weight.getValue() + 10, WeightUnit.LBS);
    }
  }

  private String increaseReps(List<Integer> reps) {
    String output = "";
    for (Integer i:
        reps
    ) {
      output += (i + 1) + ",";
    }
    return output.substring(0, output.length() - 1);
  }

  private void isValidExercise(Exercise exercise){
    ExerciseInfo exerciseInfo = getExerciseInfo(exercise.getExerciseName());
    List<Integer> reps = transformRepStringToIntegerList(exercise.getReps());

    if (getLowestRepsAchieved(reps) < exerciseInfo.getMinReps() ||
               getHighestRepsAchieved(reps) > exerciseInfo.getMaxReps()){
      throw new RepRangeInvalidException(
          String.format("the valid rep range for %s is between %s - %s reps",
              exercise.getExerciseName(), exerciseInfo.getMinReps(), exerciseInfo.getMaxReps()));
    }
  }

  private void isValidWeeklyVolume(Week week){
    HashMap<BodyPartName, Integer> weeklyVolume = countWeeklyVolume(week);

    for (BodyPartName bpName: weeklyVolume.keySet()) {
      BodyPartInfo bpInfo = getBodyPartInfo(bpName);
      if (weeklyVolume.get(bpName) < bpInfo.getMinSetsPerWeek() ||
          weeklyVolume.get(bpName) > bpInfo.getMaxSetsPerWeek()){
          throw new InvalidWeeklyVolumeException(
              String.format("weekly sets for %s are: %d. They must be between %d - %d",
              bpName, weeklyVolume.get(bpName), bpInfo.getMinSetsPerWeek(), bpInfo.getMaxSetsPerWeek()));
      }
    }
  }

  private Boolean areDirectlyTrainingAbs(HashMap<BodyPartName, Integer> weeklyVolume){
    return weeklyVolume.get(BodyPartName.ABS) != 0;
  }

  private HashMap<BodyPartName, Integer> countWeeklyVolume(Week week) {
    HashMap<BodyPartName, Integer> weeklyVolume = createEmptyBodyPartMap();

    for (Workout w: week.getAllWorkouts()) {
      for (Exercise e: w.getExercises()) {
        ExerciseInfo exerciseInfo = getExerciseInfo(e.getExerciseName());
        BodyPartName bodyPartName = exerciseInfo.getBodyPartInfo().getBodyPartName();

        weeklyVolume.put(bodyPartName,  weeklyVolume.get(bodyPartName) + e.getSets());
      }
    }

    return weeklyVolume;
  }

  private HashMap<BodyPartName, Integer> createEmptyBodyPartMap() {
    HashMap<BodyPartName, Integer> weeklyVolume = new HashMap<>();

    weeklyVolume.put(BodyPartName.ABS, 0);
    weeklyVolume.put(BodyPartName.BACK, 0);
    weeklyVolume.put(BodyPartName.BICEPS, 0);
    weeklyVolume.put(BodyPartName.TRICEPS, 0);
    weeklyVolume.put(BodyPartName.CHEST, 0);
    weeklyVolume.put(BodyPartName.CALVES, 0);
    weeklyVolume.put(BodyPartName.QUADS, 0);
    weeklyVolume.put(BodyPartName.HAMSTRINGS, 0);
    weeklyVolume.put(BodyPartName.REAR_DELTOIDS, 0);
    weeklyVolume.put(BodyPartName.FRONT_DELTOIDS, 0);
    weeklyVolume.put(BodyPartName.LATERAL_DELTOIDS, 0);

    return weeklyVolume;
  }

  private Integer getRepsForExercise(String exerciseName, MinOrMax minOrMax){
    return minOrMax.equals(MinOrMax.MIN) ?
        getExerciseInfo(exerciseName).getMinReps() :
        getExerciseInfo(exerciseName).getMaxReps();
  }

  private Boolean isKilo(Weight weight){
    return weight.getUnit().equals(WeightUnit.KG);
  }

  private List<Integer> transformRepStringToIntegerList(String reps) {
    List<Integer> transformedList = new ArrayList<>();
    for (String s:
        reps.split(",")
    ) {
      try{
        transformedList.add(Integer.parseInt(s));
      } catch (NumberFormatException n){
        throw new NumberFormatException(n.getMessage());
      }
    }
    return transformedList;
  }

  private Integer getHighestRepsAchieved(List<Integer> reps){
    Integer max = 0;
    for (Integer i:
        reps
    ) {
      if (i > max){
        max = i;
      }
    }
    return max;
  }

  private Integer getLowestRepsAchieved(List<Integer> reps){
    Integer min = 0;
    for (Integer i:
        reps
    ) {
      if (min == 0 || i < min){
        min = i;
      }
    }
    return min;
  }
}
