package org.example.model.entity;

public class ExerciseLog {
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
