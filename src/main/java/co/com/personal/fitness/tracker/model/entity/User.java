package co.com.personal.fitness.tracker.model.entity;

import co.com.personal.fitness.tracker.model.enums.UserRole;

public abstract class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(String id, String firstName, String lastName, String email, String password){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
    }

    public abstract UserRole getRole();

    public boolean isAdmin(){
        return this.getRole() == UserRole.ADMIN;
    }

    public boolean isSuperAdmin(){
        return this.getRole()==UserRole.SUPERADMIN;
    }




    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
