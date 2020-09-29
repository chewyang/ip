package duke.command;

import duke.task.Deadline;
import duke.task.Task;

/**
 * Adds a deadline task to the task list
 */

public class AddDeadlineCommand extends Command{

    private final Task deadlineToAdd;
    private final boolean isFromFile;


    /**
     * Creates a new deadline task
     * @param des description of the deadline task
     * @param deadline deadline of the task
     */

    public AddDeadlineCommand(String des, String deadline, boolean isFromFile) {
        this.deadlineToAdd = new Deadline(des,deadline);
        this.isFromFile = isFromFile;
    }

    @Override
    public void execute() {
        tasks.addNewTask(deadlineToAdd, isFromFile);
    }
}
