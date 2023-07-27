package com.will.exercisedata.config;

import com.will.exercisedata.enums.BodyPartName;
import com.will.exercisedata.enums.ExerciseName;
import com.will.exercisedata.enums.MovementDirection;
import com.will.exercisedata.enums.MovementType;
import com.will.exercisedata.models.BodyPartInfo;
import com.will.exercisedata.models.ExerciseInfo;
import com.will.exercisedata.repositories.BodyPartInfoRepo;
import com.will.exercisedata.repositories.ExerciseInfoRepo;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Hydration {

  @Bean
  CommandLineRunner commandLineRunner(ExerciseInfoRepo exerciseInfoRepo, BodyPartInfoRepo bodyPartInfoRepo) {
    return args -> {
      BodyPartInfo CHEST = new BodyPartInfo(BodyPartName.CHEST, 10, 20);
      BodyPartInfo REAR_DELTOIDS = new BodyPartInfo(BodyPartName.REAR_DELTOIDS, 8, 22);
      BodyPartInfo LATERAL_DELTOIDS = new BodyPartInfo(BodyPartName.LATERAL_DELTOIDS, 8, 22);
      BodyPartInfo FRONT_DELTOIDS = new BodyPartInfo(BodyPartName.FRONT_DELTOIDS, 6, 12);
      BodyPartInfo BACK = new BodyPartInfo(BodyPartName.BACK, 10, 22);
      BodyPartInfo BICEPS = new BodyPartInfo(BodyPartName.BICEPS, 8, 20);
      BodyPartInfo TRICEPS = new BodyPartInfo(BodyPartName.TRICEPS, 6, 14);
      BodyPartInfo QUADS = new BodyPartInfo(BodyPartName.QUADS, 8, 18);
      BodyPartInfo CALVES = new BodyPartInfo(BodyPartName.CALVES, 8, 16);
      BodyPartInfo HAMSTRINGS = new BodyPartInfo(BodyPartName.HAMSTRINGS, 6, 16);
      BodyPartInfo ABS = new BodyPartInfo(BodyPartName.ABS, 0, 8);

      bodyPartInfoRepo.saveAll(List.of(CHEST, REAR_DELTOIDS, LATERAL_DELTOIDS, FRONT_DELTOIDS, BACK, BICEPS, TRICEPS,
          QUADS, CALVES, HAMSTRINGS, ABS));

      exerciseInfoRepo.saveAll(
          List.of(
              // CHEST
              new ExerciseInfo(
                  ExerciseName.FLAT_BENCH_PRESS_BARBELL,
                  CHEST,
                  MovementType.COMPOUND,
                  MovementDirection.HORIZONTAL,
                  6,
                  12),
              new ExerciseInfo(
                  ExerciseName.CHEST_DIPS,
                  CHEST,
                  MovementType.COMPOUND,
                  MovementDirection.HORIZONTAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.CONVERGING_CHEST_PRESS,
                  CHEST,
                  MovementType.COMPOUND,
                  MovementDirection.HORIZONTAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.CHEST_FLY_MACHINE,
                  CHEST,
                  MovementType.ISOLATION,
                  MovementDirection.HORIZONTAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.INCLINE_DUMBBELL_PRESS,
                  CHEST,
                  MovementType.COMPOUND,
                  MovementDirection.VERTICAL,
                  8,
                  15),

              // REAR DELTS
              new ExerciseInfo(
                  ExerciseName.CABLE_FACE_PULLS,
                  REAR_DELTOIDS,
                  MovementType.ISOLATION,
                  MovementDirection.HORIZONTAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.REAR_DELTOID_FLY_MACHINE,
                  REAR_DELTOIDS,
                  MovementType.ISOLATION,
                  MovementDirection.HORIZONTAL,
                  8,
                  20),

              // LATERAL DELTS
              new ExerciseInfo(
                  ExerciseName.CABLE_LATERAL_RAISES,
                  LATERAL_DELTOIDS,
                  MovementType.ISOLATION,
                  MovementDirection.LATERAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.SUPER_ROM_LATERAL_RAISES,
                  LATERAL_DELTOIDS,
                  MovementType.ISOLATION,
                  MovementDirection.LATERAL,
                  8,
                  20),

              // FRONT DELTS
              new ExerciseInfo(
                  ExerciseName.SEATED_SHOULDER_PRESS,
                  FRONT_DELTOIDS,
                  MovementType.COMPOUND,
                  MovementDirection.VERTICAL,
                  8,
                  15),

              // BACK
              new ExerciseInfo(
                  ExerciseName.BENT_OVER_ROWS,
                  BACK,
                  MovementType.COMPOUND,
                  MovementDirection.HORIZONTAL,
                  8,
                  15),
              new ExerciseInfo(
                  ExerciseName.DIVERGING_ROWS,
                  BACK,
                  MovementType.COMPOUND,
                  MovementDirection.HORIZONTAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.LAT_PULL_DOWNS,
                  BACK,
                  MovementType.COMPOUND,
                  MovementDirection.VERTICAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.ASSISTED_PULL_UPS,
                  BACK,
                  MovementType.COMPOUND,
                  MovementDirection.VERTICAL,
                  8,
                  15),

              // TRICEPS
              new ExerciseInfo(
                  ExerciseName.CABLE_PUSH_DOWNS,
                  TRICEPS,
                  MovementType.ISOLATION,
                  MovementDirection.VERTICAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.SKULL_CRUSHERS,
                  TRICEPS,
                  MovementType.ISOLATION,
                  MovementDirection.VERTICAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.TRICEP_DIPS,
                  TRICEPS,
                  MovementType.ISOLATION,
                  MovementDirection.VERTICAL,
                  8,
                  20),

              // BICEPS
              new ExerciseInfo(
                  ExerciseName.CABLE_BICEP_CURLS,
                  BICEPS,
                  MovementType.ISOLATION,
                  MovementDirection.VERTICAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.BARBELL_BICEP_CURLS,
                  BICEPS,
                  MovementType.ISOLATION,
                  MovementDirection.VERTICAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.HAMMER_CURLS,
                  BICEPS,
                  MovementType.ISOLATION,
                  MovementDirection.VERTICAL,
                  8,
                  20),

              // QUADS
              new ExerciseInfo(
                  ExerciseName.SQUAT,
                  QUADS,
                  MovementType.COMPOUND,
                  MovementDirection.VERTICAL,
                  6,
                  12),
              new ExerciseInfo(
                  ExerciseName.LEG_PRESS,
                  QUADS,
                  MovementType.COMPOUND,
                  MovementDirection.HORIZONTAL,
                  8,
                  15),
              new ExerciseInfo(
                  ExerciseName.LEG_EXTENSION,
                  QUADS,
                  MovementType.ISOLATION,
                  MovementDirection.VERTICAL,
                  8,
                  20),

              // HAMS
              new ExerciseInfo(
                  ExerciseName.STIFF_LEGGED_DEADLIFT,
                  HAMSTRINGS,
                  MovementType.COMPOUND,
                  MovementDirection.VERTICAL,
                  8,
                  15),
              new ExerciseInfo(
                  ExerciseName.HAMSTRING_CURL,
                  HAMSTRINGS,
                  MovementType.ISOLATION,
                  MovementDirection.HORIZONTAL,
                  8,
                  20),

              // CALVES
              new ExerciseInfo(
                  ExerciseName.STANDING_CALF_RAISE,
                  CALVES,
                  MovementType.ISOLATION,
                  MovementDirection.VERTICAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.SEATED_CALF_RAISE,
                  CALVES,
                  MovementType.ISOLATION,
                  MovementDirection.VERTICAL,
                  8,
                  20),

              // ABS
              new ExerciseInfo(
                  ExerciseName.LEG_LIFTS,
                  ABS,
                  MovementType.ISOLATION,
                  MovementDirection.VERTICAL,
                  8,
                  20),
              new ExerciseInfo(
                  ExerciseName.CRUNCH_MACHINE,
                  ABS,
                  MovementType.ISOLATION,
                  MovementDirection.HORIZONTAL,
                  8,
                  20)
          )
      );
    };
  }
}
