package co.com.personal.fitness.tracker.view;

import co.com.personal.fitness.tracker.controller.AdminController;

import java.util.Scanner;

public class AdminView {
    private AdminController adminController;
    private Scanner scanner;

    public AdminView(AdminController adminController, Scanner scanner){
        this.adminController=adminController;
        this.scanner=scanner;
    }

    public void displayAdminDashboard() {
        while (true) {
            System.out.println("\n" + "=".repeat(80));
            System.out.println("ADMIN DASHBOARD");
            System.out.println("=".repeat(80));
            System.out.println("\n1. Create Exercise");
            System.out.println("2. View All Exercises");
            System.out.println("3. Logout");
            System.out.print("\nEnter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> displayCreateExerciseMenu();
                case "2" -> displayAllExercises();
                case "3" -> {
                    System.out.println("\nLogging out... Goodbye!");
                    return;
                }
                default -> System.out.println("\n✗ Invalid option. Please try again.");
            }
        }
    }
    private void displayCreateExerciseMenu(){

    }
    private void displayAllExercises(){

    }
}
