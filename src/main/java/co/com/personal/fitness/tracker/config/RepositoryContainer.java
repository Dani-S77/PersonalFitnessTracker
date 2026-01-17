package co.com.personal.fitness.tracker.config;



import co.com.personal.fitness.tracker.model.service.repository.UserRepository;



public class RepositoryContainer {
    private final UserRepository userRepository;



    public RepositoryContainer() {
        this.userRepository = new UserRepository();

    }

    public UserRepository getUserRepository() {
        return userRepository;
    }




}
