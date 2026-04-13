package co.com.personal.fitness.tracker.config;


import co.com.personal.fitness.tracker.controller.WorkoutController;
import co.com.personal.fitness.tracker.model.service.impl.LoginServiceImpl;
import co.com.personal.fitness.tracker.model.service.impl.RegisterServiceImpl;
import co.com.personal.fitness.tracker.model.service.impl.UserServiceImpl;
import co.com.personal.fitness.tracker.model.service.impl.WorkoutServiceImpl;
import co.com.personal.fitness.tracker.model.service.interfaces.LoginService;
import co.com.personal.fitness.tracker.model.service.interfaces.RegisterService;
import co.com.personal.fitness.tracker.model.service.interfaces.UserService;
import co.com.personal.fitness.tracker.model.service.interfaces.WorkoutService;

public class ServiceContainer {
    private final LoginService loginService;
    private final RegisterService registerService;
    private final UserService userService;
    private final WorkoutService workoutService;
    public ServiceContainer(RepositoryContainer repositoryContainer) {


        this.loginService = new LoginServiceImpl(repositoryContainer.getUserRepository());
        this.registerService = new RegisterServiceImpl(repositoryContainer.getUserRepository());
        this.userService = new UserServiceImpl(repositoryContainer.getUserRepository());
        this.workoutService=new WorkoutServiceImpl(repositoryContainer.getWorkoutRepository());


    }

    public LoginService getLoginService() {
        return loginService;
    }

    public RegisterService getRegisterService() {
        return registerService;
    }

    public UserService getUserService() {
        return userService;
    }

    public WorkoutService getWorkoutService(){
        return workoutService;
    }
}
