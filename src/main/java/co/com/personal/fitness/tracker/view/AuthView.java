package co.com.personal.fitness.tracker.view;

import co.com.personal.fitness.tracker.controller.AuthController;
import co.com.personal.fitness.tracker.model.entity.User;


import java.util.Scanner;

public class AuthView {
    private  AuthController authController;
    private  Scanner scanner;

    public AuthView(AuthController authController, Scanner scanner){
        this.authController=authController;
        this.scanner=scanner;
    }

    public User displayLoginMenu() {
        System.out.println("\n=== LOGIN ===");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        try {
            User user = authController.handleLogin(email, password);
            System.out.println("\n✓ Login successful! Welcome, " + user.getFirstName() + "!");
            return user;
        } catch (Exception e) {
            System.out.println("\n✗ Login failed: " + e.getMessage());
            return null;
        }
    }






    public User displayRegisterMenu(){
        System.out.println("\n=== REGISTER ===");
        System.out.println("First Name: ");
        String firstName=scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName=scanner.nextLine();
        System.out.println("Email: ");
        String email =scanner.nextLine();
        System.out.println("Password: ");
        String password =scanner.nextLine();

        try{
            User user = authController.handleRegister(firstName, lastName, email, password, false);

            System.out.println("\n Registration successful! Welcome, " + user.getFirstName() + "!");
            System.out.println("User ID: " + user.getId());
            System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
            System.out.println("Email: " +user.getEmail());
            System.out.println("Role: " +user.getRole());
        } catch(Exception e){
            System.out.println("\n Registration failed:" + e.getMessage());
        }
        return null;
    }
}
