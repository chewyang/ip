package duke.task;

import duke.Duke;

public class Deadline extends Task {
    protected String deadline;


    public Deadline(String description, String deadline, boolean isFromFile) {
        super(description);
        this.deadline=deadline;
        if(!isFromFile) {
            printDeadlineMsg(description);
        }
    }

    @Override
    public String toString() {
        return ("[D]"+"["+ this.getStatusIcon()+ "] "
                + this.description+" (by: "+this.deadline+")" );
    }
    @Override
    public String toStringFile(){
        int isDoneInt = isDone? 1:0;
        return ("D | "+ isDoneInt + " | "
                + this.description +" | "+this.deadline);
    }

    public void printDeadlineMsg(String deadline) {
        String echo_msg ="          ____________________________________________________________\n" +
                "          Got it. I've added this task:\n"+
                "          "+toString()+"\n"+
                "          Now you have "+ taskCounter +" in the list.\n"+
                "          ____________________________________________________________";
        System.out.println(echo_msg);
    }




}
