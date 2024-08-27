package megamind.task;

import java.util.ArrayList;

public class List {
    private final ArrayList<Task> tasks;

    /**
     * Constructor for the List class.
     */
    public List(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the list.
     *
     * @param task Task object that is to be added to the array list.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Returns the String representation of the list.
     *
     * @return String representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        if (tasks.isEmpty()) {
            return "There are no tasks in your list.";
        }

        for (int i = 0; i < tasks.size(); i++) {
            list.append(i + 1).append(". ").append(tasks.get(i).toString()).append("\n");
        }
        return list.toString();
    }

    /**
     * Marks a task as done.
     *
     * @param index Index of the task to be marked as done.
     * @return True if the task is successfully marked as done, false otherwise.
     */
    public boolean markTaskAsDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Marks a task as not done.
     *
     * @param index Index of the task to be marked as not done.
     * @return True if the task is successfully marked as not done, false otherwise.
     */
    public boolean markTaskAsNotDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsNotDone();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the string representation of task at the specified index.
     * This is to ensure that the task is not modified unintentionally
     *
     * @param index Index of the task to be returned.
     * @return Task at the specified index.
     */
    public String get(int index) {
        return tasks.get(index).toString();
    }

    /**
     * Returns the size of the list.
     *
     * @return Size of the list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Deletes a task from the list.
     *
     * @param index Index of the task to be deleted.
     * @return True if the task is successfully deleted, false otherwise.
     */
    public boolean delete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Finds tasks that contain the keyword.
     *
     * @param keyword Keyword to be searched for in the tasks.
     * @return List of tasks that contain the keyword.
     */
    public String findTasks(String keyword) {
        ArrayList<Task> foundTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                foundTasks.add(task);
            }
        }

        return foundTasks.isEmpty()
                ? "No tasks found."
                : "Here are the found tasks\n" + new List(foundTasks);
    }

    /**
     * Returns the list of tasks.
     * Method is only used for the saving of tasks.
     *
     * @return List of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
