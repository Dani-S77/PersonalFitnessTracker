package co.com.personal.fitness.tracker.config;

import co.com.personal.fitness.tracker.persistance.DataPersistence;

import java.util.Scanner;

public class BaseDependencyContainer {
    private final Scanner scanner;
    private final DataPersistence dataPersistence;

    public BaseDependencyContainer() {
        this.scanner = new Scanner(System.in);
        this.dataPersistence=new DataPersistence();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public DataPersistence getDataPersistence() {
        return dataPersistence;
    }
}
