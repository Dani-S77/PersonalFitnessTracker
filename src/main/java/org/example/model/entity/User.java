package org.example.model.entity;

import org.example.model.enums.UserRole;

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

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }


}
