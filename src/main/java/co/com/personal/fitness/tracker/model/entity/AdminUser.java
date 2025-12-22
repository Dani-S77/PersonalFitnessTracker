package co.com.personal.fitness.tracker.model.entity;

import co.com.personal.fitness.tracker.model.enums.UserRole;

public class AdminUser extends User{

    public AdminUser(String id, String firstName, String lastName, String email, String password){
        super(id, firstName, lastName, email, password);
    }

    @Override
    public UserRole getRole(){
        return UserRole.ADMIN;
    }
}
