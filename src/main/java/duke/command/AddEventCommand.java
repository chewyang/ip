package duke.command;

import duke.task.Event;
import duke.task.Task;

public class AddEventCommand extends Command{
    private final Task eventToAdd;
    private final boolean isFromFile;

    //adds new event command
    public AddEventCommand(String des, String time, boolean isFromFile) {
        this.eventToAdd = new Event(des, time);
        this.isFromFile = isFromFile;

    }


    @Override
    public void execute() {
        tasks.addNewTask(eventToAdd, isFromFile);
    }
}
