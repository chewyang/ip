package duke.task;

/**
 * Represents an event task in the tasklist
 */

public class Event extends Task {
    protected String time;



    public Event(String description, String time) {
        super(description);
        this.time =time;

    }

    @Override
    public String toString() {
        return ("[E]"+"["+ this.getStatusIcon()+ "] "
                + this.description+" (at: "+this.time +")" );
    }

    //format of task to be written in the file
    @Override
    public String toStringFile() {
        int isDoneInt = isDone? 1:0;
        return ("E | "+ isDoneInt + " | "
                + this.description +" | "+this.time);
    }

}
