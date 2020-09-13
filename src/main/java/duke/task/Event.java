package duke.task;

public class Event extends Task {
    protected String time;


    public Event(String description, String time, boolean isFromFile) {
        super(description);
        this.time =time;
        if(!isFromFile) {
            printEventMsg(description);
        }
    }

    @Override
    public String toString() {
        return ("[E]"+"["+ this.getStatusIcon()+ "] "
                + this.description+" (at: "+this.time +")" );
    }
    @Override
    public String toStringFile(){
        int isDoneInt = isDone? 1:0;
        return ("E | "+ isDoneInt + " | "
                + this.description +" | "+this.time);
    }

    public void printEventMsg(String description) {
        String echo_msg ="          ____________________________________________________________\n" +
                "          Got it. I've added this task:\n"+
                "          "+ toString()+"\n"+
                "          Now you have "+ taskCounter +" in the list.\n"+
                "          ____________________________________________________________";
        System.out.println(echo_msg);
    }
}
