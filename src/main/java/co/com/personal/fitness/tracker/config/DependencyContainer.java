package co.com.personal.fitness.tracker.config;

import co.com.personal.fitness.tracker.controller.AuthController;
import co.com.personal.fitness.tracker.model.service.impl.LoginServiceImpl;
import co.com.personal.fitness.tracker.model.service.impl.RegisterServiceImpl;
import co.com.personal.fitness.tracker.model.service.interfaces.LoginService;
import co.com.personal.fitness.tracker.model.service.interfaces.RegisterService;
import co.com.personal.fitness.tracker.model.service.repository.UserRepository;
import co.com.personal.fitness.tracker.view.AuthView;


import java.util.Scanner;

public class DependencyContainer {
    private Scanner scanner;

    private UserRepository userRepository;

    private LoginService loginService;
    private RegisterService registerService;

    private AuthView authView;


    private AuthController authController;

    public DependencyContainer(){
        this.scanner=new Scanner(System.in);

        this.userRepository=new UserRepository();

        this.loginService=new LoginServiceImpl(userRepository);
        this.registerService=new RegisterServiceImpl(userRepository);

        this.authController=new AuthController(loginService, registerService);

        this.authView=new AuthView(authController, scanner);
    }


    public Scanner getScanner(){
        return scanner;
    }



    public AuthView getAuthView(){
        return authView;
    }
}
