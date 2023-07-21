package com.will.hypertrophyadviceservice.config;

import com.will.hypertrophyadviceservice.models.ExerciseInfo;
import com.will.hypertrophyadviceservice.enums.BodyPartName;
import com.will.hypertrophyadviceservice.enums.ExerciseName;
import com.will.hypertrophyadviceservice.enums.MovementDirection;
import com.will.hypertrophyadviceservice.enums.MovementType;
import com.will.hypertrophyadviceservice.models.BodyPart;
import com.will.hypertrophyadviceservice.repositories.BodyPartRepo;
import com.will.hypertrophyadviceservice.repositories.ExerciseInfoRepo;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Hydration {

  @Bean
  CommandLineRunner commandLineRunner(ExerciseInfoRepo exerciseInfoRepo, BodyPartRepo bodyPartRepo) {
    return args -> {
      BodyPart CHEST = new BodyPart(BodyPartName.CHEST, 10, 20);
      BodyPart REAR_DELTOIDS = new BodyPart(BodyPartName.REAR_DELTOIDS, 8, 22);
      BodyPart LATERAL_DELTOIDS = new BodyPart(BodyPartName.LATERAL_DELTOIDS, 8, 22);
      BodyPart FRONT_DELTOIDS = new BodyPart(BodyPartName.FRONT_DELTOIDS, 6, 12);
      BodyPart BACK = new BodyPart(BodyPartName.BACK, 10, 22);
      BodyPart BICEPS = new BodyPart(BodyPartName.BICEPS, 8, 20);
      BodyPart TRICEPS = new BodyPart(BodyPartName.TRICEPS, 6, 14);
      BodyPart QUADS = new BodyPart(BodyPartName.QUADS, 8, 18);
      BodyPart CALVES = new BodyPart(BodyPartName.CALVES, 8, 16);
      BodyPart HAMSTRINGS = new BodyPart(BodyPartName.HAMSTRINGS, 6, 16);
      BodyPart ABS = new BodyPart(BodyPartName.ABS, 0, 8);

      bodyPartRepo.saveAll(List.of(CHEST, REAR_DELTOIDS, LATERAL_DELTOIDS, FRONT_DELTOIDS, BACK, BICEPS, TRICEPS,
          QUADS, CALVES, HAMSTRINGS, ABS));

      exerciseInfoRepo.saveAll(
          List.of(
          // CHEST
          new ExerciseInfo(
              ExerciseName.BARBELL_BENCH_PRESS,
              CHEST,
              MovementType.COMPOUND,
              MovementDirection.HORIZONTAL,
              6,
              12),
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
