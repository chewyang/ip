public class Event extends Task {
    protected String time;


    public Event(String description, String time) {
        super(description);
        this.time =time;
        printEventMsg(description);
    }

    @Override
    public String toString() {
        return ("[E]"+"["+ this.getStatusIcon()+ "] "
                + this.description+" (at: "+this.time +")" );
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
