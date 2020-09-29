package duke.command;

/**
 * Lists all the tasks in the tasklist
 */

public class ListCommand extends Command{

    @Override
    public void execute() {
        tasks.printList(false);
    }
}
