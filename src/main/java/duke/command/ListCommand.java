package duke.command;

public class ListCommand extends Command{

    @Override
    public void execute() {
        tasks.printList(false);
    }
}
