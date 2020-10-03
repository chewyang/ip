package duke.command;

import duke.task.Event;
import duke.task.Task;

/**
 * Adds an event task to the task list
 */

public class AddEventCommand extends Command{

    private final Task eventToAdd;
    private final boolean isFromFile;

    /**
     * Creates a new event task
     * @param des description of the event task
     * @param time time of the task to be done at
     */

    public AddEventCommand(String des, String time, boolean isFromFile) {
        this.eventToAdd = new Event(des, time);
        this.isFromFile = isFromFile;

    }

    @Override
    public void execute() {
        tasks.addNewTask(eventToAdd, isFromFile);
    }
}
