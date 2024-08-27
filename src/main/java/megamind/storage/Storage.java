package megamind.storage;

import java.io.*;
import java.util.ArrayList;

import megamind.task.Task;

public class Storage {

    /**
     * Saves tasks to the file.
     * If the file doesn't exist, it is created.
     */
    public void saveTasks(ArrayList<Task> tasks) {
        // Create the directory if it doesn't exist
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();  // Create the directory including any necessary parent directories
        }

        // Save the tasks to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/tasks.ser"))) {
            oos.writeObject(tasks);
            System.out.println("Tasks have been saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads tasks from the file.
     * If the file doesn't exist, an empty task list is initialized.
     * If loading fails, an empty task list is initialized.
     * If loading is successful, the tasks are loaded into the task list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Task> loadTasks() {
        // Create the directory if it doesn't exist
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();  // Create the directory including any necessary parent directories
        }

        // Check if the file exists
        File taskFile = new File(dataDir, "tasks.ser");
        if (!taskFile.exists()) {
            System.out.println("No saved tasks found.");
            return new ArrayList<>();  // Initialize an empty task list if the file doesn't exist
        }

        // Load tasks from the file if it exists
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(taskFile))) {
            System.out.println("Tasks have been loaded successfully.");
            return (ArrayList<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();  // Initialize an empty task list if loading fails
        }
    }
}
