package co.com.personal.fitness.tracker.config;



import co.com.personal.fitness.tracker.model.service.repository.UserRepository;
import co.com.personal.fitness.tracker.model.service.repository.WorkoutRepository;
import co.com.personal.fitness.tracker.persistance.DataPersistence;


public class RepositoryContainer {
    private final UserRepository userRepository;
    private final WorkoutRepository workoutRepository;



    public RepositoryContainer(DataPersistence dataPersistence) {
        this.userRepository = new UserRepository(dataPersistence);
        this.workoutRepository=new WorkoutRepository(dataPersistence);

    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public WorkoutRepository getWorkoutRepository() {
        return workoutRepository;
    }
}
