package co.com.personal.fitness.tracker.config;

import java.util.Scanner;

public class BaseDependencyContainer {
    private final Scanner scanner;

    public BaseDependencyContainer() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }
}
