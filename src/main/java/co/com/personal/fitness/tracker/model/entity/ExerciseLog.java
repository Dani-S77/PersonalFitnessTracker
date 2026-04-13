package co.com.personal.fitness.tracker.model.entity;

import java.io.Serializable;

public class ExerciseLog implements Serializable {
    private static final long serialVersionUID=1L;

    private Exercise exercise;
    private Integer timetaken;

    public  ExerciseLog(Exercise exercise, Integer timetaken){
        this.exercise=exercise;
        this.timetaken=timetaken;
    }

    public Exercise getExercise(){
        return exercise;
    }
    public Integer getTimetaken(){
        return timetaken;
    }


}
