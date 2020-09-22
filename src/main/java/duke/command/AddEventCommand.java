package duke.command;

import duke.task.Event;
import duke.task.Task;

public class AddEventCommand extends Command{
    private final Task eventToAdd;

    //adds new event command
    public AddEventCommand(String des, String time) {
        this.eventToAdd = new Event(des, time,false);
    }


    @Override
    public void execute() {
        tasks.addNewTask(eventToAdd);
    }
}
