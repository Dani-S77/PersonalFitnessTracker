package co.com.personal.fitness.tracker.model.entity;

import co.com.personal.fitness.tracker.model.enums.UserRole;

import java.io.Serializable;

public class SuperAdminUser  extends User implements Serializable {
    private static final long serialVersionUID=1L;

    public SuperAdminUser(String id, String firstName, String lastName, String email, String password){
        super(id, firstName, lastName, email, password);
    }

    @Override
    public UserRole getRole() {
        return UserRole.SUPERADMIN;
    }
}
