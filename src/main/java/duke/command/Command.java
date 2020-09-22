package duke.command;

import duke.task.TaskList;

public class Command {

    protected TaskList tasks;

    //to execute the commands, to be overwritten
    public void execute(){
        return;
    }

    //sets the tasks list for the functions to work on
    public void setData(TaskList tasks){
        this.tasks = tasks;
    }
}
