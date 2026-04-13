package co.com.personal.fitness.tracker.config;

import  co.com.personal.fitness.tracker.controller.AdminController;
import  co.com.personal.fitness.tracker.controller.AuthController;
import  co.com.personal.fitness.tracker.controller.UserController;
import co.com.personal.fitness.tracker.controller.WorkoutController;


public class ControllerContainer {
    private final AuthController authController;
    private final UserController userController;
    private final AdminController adminController;
    private final WorkoutController workoutController;

    public ControllerContainer(ServiceContainer serviceContainer) {



        this.authController = new AuthController(
                serviceContainer.getLoginService(),
                serviceContainer.getRegisterService()
        );


        this.userController = new UserController(
                serviceContainer.getUserService()
        );

        this.workoutController=new WorkoutController(
                serviceContainer.getWorkoutService(),
                authController,
                userController
        );





        this.adminController = new AdminController(
                authController
        );


    }

    public AuthController getAuthController() {
        return authController;
    }

    public UserController getUserController() {
        return userController;
    }



    public AdminController getAdminController() {
        return adminController;
    }

    public WorkoutController getWorkoutController(){
        return workoutController;
    }
}
