package duke.command;

import duke.task.TaskList;

public class findCommand extends Command {
    private final String key;

    public findCommand(String key) {
        this.key = key;
    }

    @Override
    public void execute() {
        TaskList taskList = new TaskList();
        for(int i=0; i < tasks.getTaskCounter(); i++){
            if(tasks.getTask(i).toString().contains(key)){
                taskList.addNewTask(tasks.getTask(i), false);
            }
        }
        taskList.printList(true);
    }
}
