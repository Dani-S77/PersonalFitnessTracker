package co.com.personal.fitness.tracker.model.service.repository;

import co.com.personal.fitness.tracker.datastructures.PersistentHashMap;
import co.com.personal.fitness.tracker.model.entity.Exercise;
import co.com.personal.fitness.tracker.persistance.DataPersistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseRepository implements Repository<Exercise> {
    private PersistentHashMap<String, Exercise> exercises;

    public ExerciseRepository(DataPersistence dataPersistence) {
        this.exercises = new PersistentHashMap<>("exercises.dat", dataPersistence);
        System.out.println("  ✓ Loaded " + exercises.size() + " exercises from storage");
    }


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
