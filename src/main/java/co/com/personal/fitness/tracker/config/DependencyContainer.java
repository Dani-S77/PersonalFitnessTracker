package co.com.personal.fitness.tracker.config;

import co.com.personal.fitness.tracker.controller.AdminController;
import co.com.personal.fitness.tracker.controller.AuthController;
import co.com.personal.fitness.tracker.controller.UserController;
import co.com.personal.fitness.tracker.model.entity.RegularUser;
import co.com.personal.fitness.tracker.model.entity.SuperAdminUser;
import co.com.personal.fitness.tracker.model.service.impl.LoginServiceImpl;
import co.com.personal.fitness.tracker.model.service.impl.RegisterServiceImpl;
import co.com.personal.fitness.tracker.model.service.impl.UserServiceImpl;
import co.com.personal.fitness.tracker.model.service.interfaces.LoginService;
import co.com.personal.fitness.tracker.model.service.interfaces.RegisterService;
import co.com.personal.fitness.tracker.model.service.interfaces.UserService;
import co.com.personal.fitness.tracker.model.service.repository.UserRepository;
import co.com.personal.fitness.tracker.view.AdminView;
import co.com.personal.fitness.tracker.view.AuthView;
import co.com.personal.fitness.tracker.view.SuperAdminView;
import co.com.personal.fitness.tracker.view.UserView;


import java.util.Scanner;

public class DependencyContainer {
    private Scanner scanner;

    private UserRepository userRepository;

    private LoginService loginService;
    private RegisterService registerService;
    private UserService userService;

    private AuthController authController;
    private AdminController adminController;
    private UserController userController;

    private AuthView authView;
    private AdminView adminView;
    private SuperAdminView superAdminView;
    private UserView userView;




    public DependencyContainer(){
        this.scanner=new Scanner(System.in);

        this.userRepository=new UserRepository();

        this.loginService=new LoginServiceImpl(userRepository);
        this.registerService=new RegisterServiceImpl(userRepository);
        this.userService=new UserServiceImpl(userRepository);

        this.authController=new AuthController(loginService, registerService);
        this.adminController =new AdminController( authController);
        this.userController=new UserController(userService);

        this.authView=new AuthView(authController, scanner);
        this.adminView=new AdminView(adminController, scanner);
        this.superAdminView=new SuperAdminView(adminController, scanner);
        this.userView=new UserView(userController, scanner);

        initializeSampleData();
    }

    private void initializeSampleData(){
        SuperAdminUser superAdmin=new SuperAdminUser("superadmin1", "Super", "Admin", "superadmin@fit.com", "super123");
        RegularUser user=new RegularUser("user1", "john", "Doe", "user@fit.com", "user123");


        userRepository.save(superAdmin);
        userRepository.save(user);

    }


    public Scanner getScanner(){
        return scanner;
    }



    public AuthView getAuthView(){
        return authView;
    }
    public AdminView getAdminView(){
        return adminView;
    }
    public SuperAdminView getSuperAdminView(){
        return superAdminView;
    }
    public UserView getUserView(){
        return userView;
    }
}
