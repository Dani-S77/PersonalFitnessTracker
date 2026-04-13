package co.com.personal.fitness.tracker.model.entity;

import java.io.Serializable;

public class WorkoutExercise implements Serializable {
    private static final long serialVersionUID=1L;

    private Exercise Exercise;
    private Integer repetitions;
    private Integer sets;

    public WorkoutExercise(Exercise Exercise, Integer repetitions, Integer sets){
        this.Exercise=Exercise;
        this.repetitions=repetitions;
        this. sets=sets;
    }

    public Exercise getExercise() {
        return Exercise;
    }
    public Integer getRepetitions(){
        return repetitions;
    }
    public Integer getSets(){
        return sets;
    }
}
