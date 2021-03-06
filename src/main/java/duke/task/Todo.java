package duke.task;

/**
 * Represents a todo task in the tasklist
 */

public class Todo extends Task {

    public Todo(String description) {
        super(description);
        //only print acknowledgement message if task added is from the file
//        if(!isFromFile) {
//            printAckMsg();
//        }
    }

    @Override
    public String toString() {
        return ("[T]"+"["+ this.getStatusIcon()+ "] "
                + this.description );
    }

    //format of task to be written in the file
    @Override
    public String toStringFile(){
        int isDoneInt = isDone? 1:0;
        return ("T | "+ isDoneInt + " | "
                + this.description );
    }


}
