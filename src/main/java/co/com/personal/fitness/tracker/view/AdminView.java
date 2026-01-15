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
            System.out.println("1. Logout");
            System.out.print("\nEnter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.println("\nLogging out... Goodbye!");
                    return;
                }
                default -> System.out.println("\n✗ Invalid option. Please try again.");
            }
        }
    }
}
