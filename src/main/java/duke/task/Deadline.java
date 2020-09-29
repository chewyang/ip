package duke.task;

/**
 * Represents a deadline task in the tasklist
 */

public class Deadline extends Task {
    protected String deadline;


    public Deadline(String description, String deadline, boolean isFromFile) {
        super(description, isFromFile);
        this.deadline=deadline;
        //only print acknowledgement message if task added is from the file
        if(!isFromFile) {
            printAckMsg();
        }
    }

    @Override
    public String toString() {
        return ("[D]"+"["+ this.getStatusIcon()+ "] "
                + this.description+" (by: "+this.deadline+")" );
    }

    //format of task to be written in the file
    @Override
    public String toStringFile(){
        int isDoneInt = isDone? 1:0;
        return ("D | "+ isDoneInt + " | "
                + this.description +" | "+this.deadline);
    }

}
