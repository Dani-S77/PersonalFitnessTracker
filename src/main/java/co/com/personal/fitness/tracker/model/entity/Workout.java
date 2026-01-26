package co.com.personal.fitness.tracker.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Workout implements Serializable {
    private static final long serialVersionUID=1L;

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

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Workout: ").append(name).append("\n");
        sb.append("Description: ").append(description).append("\n");
        sb.append("Exercises:\n");
        for(WorkoutExercise we : exercises){
            sb.append(" - ").append(we.getExercise().getName())
                    .append(": ").append(we.getSets()).append(" sets x")
                    .append(we.getRepetitions()).append(" reps\n");

        }
        return sb.toString();
    }
}
