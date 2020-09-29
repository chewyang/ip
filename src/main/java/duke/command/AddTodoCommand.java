package duke.command;

import duke.task.Task;
import duke.task.Todo;

/**
 * Adds an todo task to the task list
 */

public class AddTodoCommand extends Command{
    private final Task todoToAdd;

    /**
     * Creates a new todo task
     * @param des description of the todo task
     */
    public AddTodoCommand(String des) {
        this.todoToAdd = new Todo(des, false);
    }


    @Override
    public void execute() {
        tasks.addNewTask(todoToAdd);
    }
}
