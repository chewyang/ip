package duke.command;

import duke.task.Deadline;
import duke.task.Task;

public class AddDeadlineCommand extends Command{
    private final Task deadlineToAdd;

    public AddDeadlineCommand(String des, String deadline) {
        this.deadlineToAdd = new Deadline(des,deadline, false);
    }


    @Override
    public void execute() {
        tasks.addNewTask(deadlineToAdd);
    }
}
