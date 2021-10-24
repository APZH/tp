package seedu.duke.task.reminder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.jupiter.api.Test;
import seedu.duke.task.Task;
import seedu.duke.task.TaskManager;
import seedu.duke.task.type.Deadline;
import seedu.duke.task.type.Event;
import seedu.duke.task.type.Todo;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReminderManagerTest {

    private String expectedOut;

    ReminderManagerTest(){
    }

    @Test
    void sendReminder() {
        Calendar start = Calendar.getInstance();
        start.add(Calendar.MINUTE, 10);
        Calendar end = Calendar.getInstance();
        end.add(Calendar.MINUTE, 20);
        LocalDateTime startDate = start.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime endDate = end.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        Task todoWithReminder = new Todo("lecture with reminder", startDate);
        TaskManager.addTask(todoWithReminder);
        Task todoWithoutReminder = new Todo("lecture without reminder", endDate);
        TaskManager.addTask(todoWithoutReminder);
        Task deadlineWithReminder = new Deadline("exercise 1", startDate);
        TaskManager.addTask(deadlineWithReminder);
        Task deadlineWithoutReminder = new Deadline("exercise 1", endDate);
        TaskManager.addTask(deadlineWithoutReminder);
        Task eventTest = new Event("meeting", startDate, endDate);
        TaskManager.addTask(eventTest);

        expectedOut = "Reminder! 10 min before the following task:\n" + "\t"
                + todoWithReminder.getTaskEntryDescription()
                + "Reminder! 10 min before the following task:\n" + "\t"
                + deadlineWithReminder.getTaskEntryDescription()
                + "Reminder! 10 min before the following task:\n" + "\t"
                + eventTest.getTaskEntryDescription();

        assertEquals(expectedOut, ReminderManager.sendReminder());
    }
}