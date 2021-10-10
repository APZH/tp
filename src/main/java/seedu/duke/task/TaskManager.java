package seedu.duke.task;

import seedu.duke.exception.EmptyTasklistException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskManager {

    private ArrayList<Task> tasklist;

    private static Logger logger = Logger.getLogger("TaskManager");

    public TaskManager() {
        this.tasklist = new ArrayList<Task>();
    }

    public String listTasklist() throws EmptyTasklistException {
        logger.log(Level.INFO, "listTasklist method called");
        assert tasklist.size() >= 0 : "Tasklist cannot be negative";

        if (tasklist.size() == 0) {
            logger.log(Level.WARNING, "tasklist is empty, throwing EmptyTasklistException");
            throw new EmptyTasklistException();
        }

        String tasks = "-------------\n"
                + " MY TASKLIST\n"
                + "-------------\n";

        for (int i = 0; i < tasklist.size(); i++) {
            tasks += i + 1 + ". " + tasklist.get(i).getTaskEntryDescription() + "\n";
        }

        logger.log(Level.INFO, "end of listTasklist - no issues detected");
        return tasks;
    }

    public ArrayList<Task> getTasklist() {
        return this.tasklist;
    }

    public void setTasklist(ArrayList<Task> tasklist) {
        this.tasklist = tasklist;
    }

}
