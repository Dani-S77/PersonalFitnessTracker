package co.com.personal.fitness.tracker.view;

import co.com.personal.fitness.tracker.controller.AdminController;
import co.com.personal.fitness.tracker.model.entity.SuperAdminUser;
import co.com.personal.fitness.tracker.model.entity.User;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SuperAdminView {
    private AdminController adminController;
    private Scanner scanner;

    public SuperAdminView(AdminController adminController, Scanner scanner){
        this.adminController=adminController;
        this.scanner=scanner;
    }

    public void displaySuperAdminDashboard(SuperAdminUser superAdmin){
        while(true){
            System.out.println("\n" + "=".repeat(80));
            System.out.println(" SUPERAMDIN DASHBOARD");
            System.out.println("=".repeat(80));
            System.out.println("1. Create Admin User  (Superadmin Only)");
            System.out.println("2. logout");
            System.out.println("\nEnter your choice: ");

            String choice=scanner.nextLine();

            switch(choice){
                case "1"->displayCreateAdminMenu(superAdmin);
                case "2" -> {
                    System.out.println("\nLogging out... Goodbye, Superadmin!");
                    return;
                }
                default -> System.out.println("\n Invalid option. Please try again.");
            }
        }
    }

    private void displayCreateAdminMenu(SuperAdminUser superAdmin) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("⭐ CREATE ADMIN USER - SUPERADMIN PRIVILEGE ⭐");
        System.out.println("=".repeat(80));
        System.out.println("\n⚠️  WARNING: This will create a new administrator account.");
        System.out.println("Admins can manage exercises but CANNOT create other admins.");
        System.out.println("Only YOU (superadmin) can create admin accounts.\n");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("\nConfirm creation of admin user? (yes/no): ");
        String confirm = scanner.nextLine();

        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("\n✗ Admin creation cancelled.");
            return;
        }

        try {
            User admin = adminController.handleCreationAdmin(superAdmin, firstName, lastName, email, password);
            System.out.println("\n✓ Admin user created successfully!");
            System.out.println("═".repeat(50));
            System.out.println("Name: " + admin.getFirstName() + " " + admin.getLastName());
            System.out.println("Email: " + admin.getEmail());
            System.out.println("Role: ADMIN");
            System.out.println("═".repeat(50));
            System.out.println("\nℹ️  This admin can:");
            System.out.println("  • Create and manage exercises");
            System.out.println("  • View all exercises");
            System.out.println("\nℹ️  This admin CANNOT:");
            System.out.println("  • Create other admin users");
            System.out.println("  • Access superadmin functions");
        } catch (Exception e) {
            System.out.println("\n✗ Error creating admin: " + e.getMessage());
        }
    }
}
