package duke.command;

/**
 * Deletes a task from the task list
 */

public class deleteCommand extends Command {

    private final int listNum;

    public deleteCommand(int listNum) {
        this.listNum = listNum;
    }

    /**
     * Deletes the task if the index is within the number of tasks in the list
     */
    @Override
    public void execute() {
        try {
            tasks.getTask(listNum-1).printMsg("deleted");
            tasks.deleteTask(listNum-1);
        }catch(IndexOutOfBoundsException e ){
            System.out.println("          Invalid index!");
        }
    }

}
