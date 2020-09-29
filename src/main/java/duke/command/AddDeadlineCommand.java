package duke.command;

import duke.task.Deadline;
import duke.task.Task;

/**
 * Adds a deadline task to the task list
 */

public class AddDeadlineCommand extends Command{

    private final Task deadlineToAdd;

    /**
     * Creates a new deadline task
     * @param des description of the deadline task
     * @param deadline deadline of the task
     */
    public AddDeadlineCommand(String des, String deadline) {
        this.deadlineToAdd = new Deadline(des,deadline, false);
    }

    @Override
    public void execute() {
        tasks.addNewTask(deadlineToAdd);
    }
}
