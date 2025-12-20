package co.com.personal.fitness.tracker.repository;

import co.com.personal.fitness.tracker.model.entity.Workout;

import java.util.List;

public class WorkoutRepository implements IRepository<Workout> {


    @Override
    public Workout save(Workout workout) {
        return null;
    }

    @Override
    public Workout findById(String id) {
        return null;
    }

    @Override
    public List<Workout> findAll() {
        return List.of();
    }
}
