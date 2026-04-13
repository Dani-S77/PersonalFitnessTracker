package co.com.personal.fitness.tracker.model.service.repository;

import co.com.personal.fitness.tracker.datastructures.PersistentHashMap;
import co.com.personal.fitness.tracker.model.entity.Workout;
import co.com.personal.fitness.tracker.persistance.DataPersistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkoutRepository implements Repository<Workout> {
    private PersistentHashMap<String, Workout> workouts;

    public WorkoutRepository(DataPersistence dataPersistence) {
        this.workouts = new PersistentHashMap<>("workouts.dat", dataPersistence);
        System.out.println("  ✓ Loaded " + workouts.size() + " workouts from storage");
    }

    @Override
    public Workout save(Workout workout) {
        workouts.put(workout.getId(), workout);
        return workout;
    }

    @Override
    public Workout findById(String id) {
        return workouts.get(id);
    }

    @Override
    public List<Workout> findAll() {
        return new ArrayList<>(workouts.values());
    }
}
