package co.com.personal.fitness.tracker.controller;

import co.com.personal.fitness.tracker.exceptions.EmailAlreadyExistsException;
import co.com.personal.fitness.tracker.exceptions.UnauthorizedActionException;
import co.com.personal.fitness.tracker.model.entity.Exercise;
import co.com.personal.fitness.tracker.model.entity.User;
import co.com.personal.fitness.tracker.model.service.interfaces.ExerciseService;

import java.util.List;

public class AdminController {
    private AuthController authController;


    public AdminController(AuthController authController){
        this.authController=authController;

    }






    public User handleCreationAdmin(User currentUser, String firstName, String lastName, String email, String password)
        throws EmailAlreadyExistsException, UnauthorizedActionException{
        if(!currentUser.isSuperAdmin()){
           throw new UnauthorizedActionException("Only superadmin can create admin users");
        }
        return authController.handleRegisterAdmin(firstName, lastName, email, password);
    }
}
