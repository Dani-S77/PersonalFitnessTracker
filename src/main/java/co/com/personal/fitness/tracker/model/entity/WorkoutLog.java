package co.com.personal.fitness.tracker.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkoutLog {
    private String id;
    private Workout workout;
    private LocalDate date;
    private Integer totalTime;
    private List<ExerciseLog> exerciseLogs;


    public WorkoutLog(String id, Workout workout, LocalDate date, Integer totalTime){
        this.id=id;
        this.workout=workout;
        this.date=date;
        this.totalTime=totalTime;
        this.exerciseLogs=new ArrayList<>();
    }

    public void addExerciseLog(ExerciseLog log){
        this.exerciseLogs.add(log);
    }



    public String getId(){
        return id;
    }
    public Workout getWorkout(){
        return workout;
    }
    public LocalDate getDate(){
        return date;
    }
    public Integer getTotalTime(){
        return totalTime;
    }
    public List<ExerciseLog> getExerciseLogs(){
        return exerciseLogs;
    }



}
