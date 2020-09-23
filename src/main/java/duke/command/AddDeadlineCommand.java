package duke.command;

import duke.task.Deadline;
import duke.task.Task;

public class AddDeadlineCommand extends Command{

    private final Task deadlineToAdd;
    private final boolean isFromFile;

    //adds a new deadline command
    public AddDeadlineCommand(String des, String deadline, boolean isFromFile) {
        this.deadlineToAdd = new Deadline(des,deadline);
        this.isFromFile = isFromFile;
    }

    @Override
    public void execute() {
        tasks.addNewTask(deadlineToAdd, isFromFile);
    }
}
