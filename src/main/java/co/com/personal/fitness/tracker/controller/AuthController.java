package co.com.personal.fitness.tracker.controller;

import co.com.personal.fitness.tracker.exceptions.EmailAlreadyExistsException;
import co.com.personal.fitness.tracker.exceptions.InvalidCredentialsException;
import co.com.personal.fitness.tracker.exceptions.UserNotFoundException;
import co.com.personal.fitness.tracker.model.entity.User;
import co.com.personal.fitness.tracker.model.service.interfaces.LoginService;
import co.com.personal.fitness.tracker.model.service.interfaces.RegisterService;

public class AuthController {
    private LoginService loginService;
    private RegisterService registerService;

    public AuthController(LoginService loginService, RegisterService registerService){
        this.loginService=loginService;
        this.registerService=registerService;
    }



    public User handleLogin(String email, String password) throws UserNotFoundException, InvalidCredentialsException {
        return loginService.login(email, password);
    }

    public User handleRegister(String firstName, String lastName, String email, String password, boolean isAdmin)throws EmailAlreadyExistsException{
        return registerService.register(firstName, lastName, email, password, isAdmin);
    }

    public User handleRegisterAdmin(String firstName,String lastName, String email, String password) throws EmailAlreadyExistsException{
        return registerService.registerAdmin(firstName, lastName, email, password);
    }
}
