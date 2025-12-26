package co.com.personal.fitness.tracker.model.service.repository;

import co.com.personal.fitness.tracker.model.entity.Exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseRepository implements Repository<Exercise> {
    private Map<String, Exercise> exercises=new HashMap<>();


    @Override
    public Exercise save(Exercise exercise) {
        exercises.put(exercise.getId(), exercise);
        return exercise;
    }

    @Override
    public Exercise findById(String id) {
        return exercises.get(id);
    }

    @Override
    public List<Exercise> findAll() {
        return new ArrayList<>(exercises.values());
    }
}
