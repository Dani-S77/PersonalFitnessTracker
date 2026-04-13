package co.com.personal.fitness.tracker.model.service.impl;

import co.com.personal.fitness.tracker.model.entity.Exercise;
import co.com.personal.fitness.tracker.model.service.interfaces.ExerciseService;
import co.com.personal.fitness.tracker.model.service.repository.ExerciseRepository;

import java.util.List;

public class ExerciseServiceImpl implements ExerciseService {
    private ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository){
        this.exerciseRepository=exerciseRepository;
    }

    @Override
    public Exercise createExercise(String name, String description){
        String id=String.valueOf(System.currentTimeMillis());
        Exercise exercise=new Exercise(id, name, description);
        return exerciseRepository.save(exercise);
    }
    @Override
    public List<Exercise> getAllExercises(){
        return exerciseRepository.findAll();
    }
}
