package co.com.personal.fitness.tracker.config;



import co.com.personal.fitness.tracker.model.service.repository.UserRepository;
import co.com.personal.fitness.tracker.model.service.repository.WorkoutRepository;


public class RepositoryContainer {
    private final UserRepository userRepository;
    private final WorkoutRepository workoutRepository;



    public RepositoryContainer() {
        this.userRepository = new UserRepository();
        this.workoutRepository=new WorkoutRepository();

    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public WorkoutRepository getWorkoutRepository() {
        return workoutRepository;
    }
}
