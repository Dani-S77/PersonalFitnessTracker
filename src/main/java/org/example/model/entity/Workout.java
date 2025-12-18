package org.example.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String id;
    private String name;
    private String description;
    private List<WorkoutExercise> exercises;

    public Workout(String id, String name, String description){
        this.id=id;
        this.name=name;
        this.description=description;
        this.exercises=new ArrayList<>();
    }

    public void addExercise(WorkoutExercise exercise){
        this.exercises.add(exercise);
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }
    public List<WorkoutExercise> getExercises(){
        return exercises;
    }
}
