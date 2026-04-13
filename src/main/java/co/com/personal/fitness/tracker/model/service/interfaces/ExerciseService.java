package co.com.personal.fitness.tracker.model.service.interfaces;

import co.com.personal.fitness.tracker.model.entity.Exercise;

import java.util.List;

public interface ExerciseService {
    Exercise createExercise(String name, String description);
    List<Exercise> getAllExercises();
}
