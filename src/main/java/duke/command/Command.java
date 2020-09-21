package duke.command;

import duke.task.TaskList;

public class Command {

    protected TaskList tasks;

    public void execute(){
        return;
    }

    public void setData(TaskList tasks){
        this.tasks = tasks;
    }
}
