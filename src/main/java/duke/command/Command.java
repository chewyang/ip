package duke.command;

import duke.task.TaskList;

/**
 * Represents an executable command.
 */

public class Command {

    protected TaskList tasks;

    /**
     * An execute method to be overridden by child classes.
     */
    public void execute(){
        return;
    }

    /**
     * Sets the current task list in the program from the file.
     * @param tasks used to set the current task list
     */
    public void setData(TaskList tasks){
        this.tasks = tasks;
    }
}
