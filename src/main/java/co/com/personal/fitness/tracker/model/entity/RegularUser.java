package co.com.personal.fitness.tracker.model.entity;

import co.com.personal.fitness.tracker.model.enums.UserRole;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegularUser extends User implements Serializable {
    private static final long serialVersionUID=1L;

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
