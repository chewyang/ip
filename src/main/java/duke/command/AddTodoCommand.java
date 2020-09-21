package duke.command;

import duke.task.Task;
import duke.task.Todo;

public class AddTodoCommand extends Command{
    private final Task todoToAdd;

    public AddTodoCommand(String des) {
        this.todoToAdd = new Todo(des, false);
    }


    @Override
    public void execute() {
        tasks.addNewTask(todoToAdd);
    }
}
