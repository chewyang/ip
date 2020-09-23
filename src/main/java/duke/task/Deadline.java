package duke.task;

public class Deadline extends Task {
    protected String deadline;


    public Deadline(String description, String deadline) {
        super(description);
        this.deadline=deadline;
        //only print acknowledgement message if task added is from the file
//        if(!isFromFile) {
//            printAckMsg();
//        }
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
