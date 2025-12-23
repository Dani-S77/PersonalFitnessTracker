package co.com.personal.fitness.tracker.repository;

import co.com.personal.fitness.tracker.model.entity.Workout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkoutRepository implements IRepository<Workout> {
    private Map<String, Workout> workouts= new HashMap<>();

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
