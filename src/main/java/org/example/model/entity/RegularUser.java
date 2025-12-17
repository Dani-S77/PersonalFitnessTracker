package org.example.model.entity;

import org.example.model.enums.UserRole;

import java.util.ArrayList;
import java.util.List;

public class RegularUser extends User{
    private List<WorkoutLog> history;

    public RegularUser(String id,String firstName, String lastName, String email, String password){
        super(id, firstName, lastName, email, password);
        this.history=new ArrayList<>();
    }

    @Override
    public UserRole getRole(){
        return UserRole.REGULAR;
    }

    public List<WorkoutLog> getHistory() {
        return history;
    }

    public void addWorkoutLog(WorkoutLog log){
        this.history.add(log);
    }
}
