package duke.command;

public class deleteCommand extends Command{

    private final int listNum;

    public deleteCommand(int listNum) {
        this.listNum = listNum;

    }

    @Override
    public void execute() {
        try {
            tasks.getTask(listNum-1).printMsg("delete");
            tasks.deleteTask(listNum-1);
        }catch(IndexOutOfBoundsException e ){
            System.out.println("          Invalid index!");
        }

    }

}
