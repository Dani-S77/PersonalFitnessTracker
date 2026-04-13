package co.com.personal.fitness.tracker.config;



import co.com.personal.fitness.tracker.view.AdminView;
import co.com.personal.fitness.tracker.view.AuthView;
import co.com.personal.fitness.tracker.view.SuperAdminView;
import co.com.personal.fitness.tracker.view.UserView;
import java.util.Scanner;


public class ApplicationContainer {

    private final BaseDependencyContainer baseContainer;
    private final RepositoryContainer repositoryContainer;
    private final ServiceContainer serviceContainer;
    private final ControllerContainer controllerContainer;
    private final ViewContainer viewContainer;


    private final DataInitializer dataInitializer;

    public ApplicationContainer() {

        this.baseContainer = new BaseDependencyContainer();
        this.repositoryContainer = new RepositoryContainer(baseContainer.getDataPersistence());
        this.serviceContainer = new ServiceContainer(repositoryContainer);
        this.controllerContainer = new ControllerContainer(serviceContainer);
        this.viewContainer = new ViewContainer(controllerContainer, baseContainer.getScanner());
        this.dataInitializer = new DataInitializer(repositoryContainer);

        this.dataInitializer.initialize();

    }


    public AuthView getAuthView() {
        return viewContainer.getAuthView();
    }

    public UserView getUserView() {
        return viewContainer.getUserView();
    }

    public AdminView getAdminView() {
        return viewContainer.getAdminView();
    }

    public SuperAdminView getSuperAdminView() {
        return viewContainer.getSuperAdminView();
    }

    public Scanner getScanner() {
        return baseContainer.getScanner();
    }
}
