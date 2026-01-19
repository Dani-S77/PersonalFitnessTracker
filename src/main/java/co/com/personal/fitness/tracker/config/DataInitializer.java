package co.com.personal.fitness.tracker.config;

import co.com.personal.fitness.tracker.model.entity.AdminUser;
import co.com.personal.fitness.tracker.model.entity.SuperAdminUser;
import co.com.personal.fitness.tracker.model.entity.RegularUser;

import co.com.personal.fitness.tracker.model.service.repository.UserRepository;



public class DataInitializer {
    private final UserRepository userRepository;


    public DataInitializer(RepositoryContainer repositoryContainer) {
        this.userRepository = repositoryContainer.getUserRepository();

        initializeUsers();

    }

    public void initialize() {

    }





    private void initializeUsers() {


        SuperAdminUser superAdmin = new SuperAdminUser(
                "superadmin1", "Super", "Admin",
                "superadmin@fit.com", "super123"
        );

        RegularUser user = new RegularUser(
                "user1", "John", "Doe",
                "user@fit.com", "user123"
        );
        AdminUser adminUser=new AdminUser(
                "adminuser1", "jose","dos","adminuser1@fit.com","adminuser123"
        );

        userRepository.save(superAdmin);
        userRepository.save(user);
        userRepository.save(adminUser);


    }
}
