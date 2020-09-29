package duke.command;

import duke.task.Task;
import duke.task.Todo;

/**
 * Adds an todo task to the task list
 */

public class AddTodoCommand extends Command{
    private final Task todoToAdd;
    private final boolean isFromFile;


    /**
     * Creates a new todo task
     * @param des description of the todo task
     */

    public AddTodoCommand(String des, boolean isFromFile) {
        this.todoToAdd = new Todo(des);
        this.isFromFile = isFromFile;

    }


    @Override
    public void execute() {
        tasks.addNewTask(todoToAdd, isFromFile);
    }
}
