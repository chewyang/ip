package duke.command;

public class doneCommand extends Command{

    private final int listNum;

    public doneCommand(int listNum) {
            this.listNum = listNum;

    }

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
