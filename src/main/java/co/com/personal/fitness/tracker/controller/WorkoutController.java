package co.com.personal.fitness.tracker.controller;


import co.com.personal.fitness.tracker.model.entity.RegularUser;
import co.com.personal.fitness.tracker.model.entity.User;
import co.com.personal.fitness.tracker.model.entity.Workout;
import co.com.personal.fitness.tracker.model.entity.WorkoutLog;
import co.com.personal.fitness.tracker.model.service.interfaces.WorkoutService;
import java.util.List;
import java.util.Map;

public class WorkoutController {
    private WorkoutService workoutService;
    private AuthController authController;
    private UserController userController;

    public WorkoutController(WorkoutService workoutService, AuthController authController, UserController userController) {
        this.workoutService = workoutService;
        this.authController = authController;
        this.userController = userController;
    }

    public WorkoutLog handleLogWorkout(RegularUser user, String workoutId, Map<String, Integer> exerciseTimes)
            throws Exception {
        return workoutService.logWorkout(user, workoutId, exerciseTimes);
    }

    public List<Workout> getAvailableWorkouts() {
        return workoutService.getAllWorkouts();
    }

    public List<WorkoutLog> getUserHistory(RegularUser user) {
        return workoutService.getHistory(user);
    }

    public User getCurrentUserInfo(String userId) {
        return userController.handleGetUser(userId);
    }
}
