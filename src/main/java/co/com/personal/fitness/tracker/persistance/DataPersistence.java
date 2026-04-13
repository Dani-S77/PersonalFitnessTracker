package co.com.personal.fitness.tracker.persistance;

import java.io.*;

public class DataPersistence {
    private static final String DATA_DIR = "data";

    public DataPersistence() {
        createDataDirectory();
    }

    private void createDataDirectory() {
        File directory = new File(DATA_DIR);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("✓ Data directory created: " + DATA_DIR);
            }
        }
    }

    /**
     * Generic save method - works with any Serializable object
     */
    public <T> void saveData(String filename, T data) {
        String filepath = DATA_DIR + "/" + filename;
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filepath))) {
            oos.writeObject(data);
            // Silent save - only log on errors
        } catch (IOException e) {
            System.err.println("✗ Error saving data to " + filepath + ": " + e.getMessage());
        }
    }

    /**
     * Generic load method - works with any Serializable object
     */
    @SuppressWarnings("unchecked")
    public <T> T loadData(String filename) {
        String filepath = DATA_DIR + "/" + filename;
        File file = new File(filepath);

        if (!file.exists()) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filepath))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("✗ Error loading data from " + filepath + ": " + e.getMessage());
            return null;
        }
    }

    /**
     * Delete a data file
     */
    public boolean deleteData(String filename) {
        File file = new File(DATA_DIR + "/" + filename);
        return file.delete();
    }

    /**
     * Check if data file exists
     */
    public boolean exists(String filename) {
        File file = new File(DATA_DIR + "/" + filename);
        return file.exists();
    }
}
