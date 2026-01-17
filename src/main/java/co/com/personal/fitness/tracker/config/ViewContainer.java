package co.com.personal.fitness.tracker.config;

import co.com.personal.fitness.tracker.view.AdminView;
import co.com.personal.fitness.tracker.view.AuthView;
import co.com.personal.fitness.tracker.view.SuperAdminView;
import co.com.personal.fitness.tracker.view.UserView;
import java.util.Scanner;


public class ViewContainer {
    private final AuthView authView;
    private final UserView userView;
    private final AdminView adminView;
    private final SuperAdminView superAdminView;

    public ViewContainer(ControllerContainer controllerContainer, Scanner scanner) {


        this.authView = new AuthView(
                controllerContainer.getAuthController(),
                scanner
        );

        this.userView = new UserView(
                controllerContainer.getUserController(),
                scanner
        );

        this.adminView = new AdminView(
                controllerContainer.getAdminController(),
                scanner
        );

        this.superAdminView = new SuperAdminView(
                controllerContainer.getAdminController(),
                scanner
        );


    }

    public AuthView getAuthView() {
        return authView;
    }

    public UserView getUserView() {
        return userView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public SuperAdminView getSuperAdminView() {
        return superAdminView;
    }
}
