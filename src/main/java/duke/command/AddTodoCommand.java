package duke.command;

import duke.task.Task;
import duke.task.Todo;

public class AddTodoCommand extends Command{
    private final Task todoToAdd;
    private final boolean isFromFile;

    //adds new todo command
    public AddTodoCommand(String des, boolean isFromFile) {
        this.todoToAdd = new Todo(des);
        this.isFromFile = isFromFile;
    }


    @Override
    public void execute() {
        tasks.addNewTask(todoToAdd, isFromFile);
    }
}
