package duke.command;

/**
 * Sets a task as done
 */

public class doneCommand extends Command{

    private final int listNum;

    public doneCommand(int listNum) {
            this.listNum = listNum;

    }

    /**
     * Sets the task as done if the index is within the number of tasks in the list
     */
    @Override
    public void execute() {
        try {
            tasks.getTask(listNum - 1).isDone = true;
            tasks.getTask(listNum-1).printMsg("done");
        }catch(IndexOutOfBoundsException e ){
            System.out.println("          Invalid index!");
        }

    }

}
