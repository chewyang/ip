public class Deadline extends Task {
    protected String deadline;


    public Deadline(String description, String deadline) {
        super(description);
        this.deadline=deadline;
        printDeadlineMsg(deadline);
    }

    @Override
    public String toString() {
        return ("[D]"+"["+ this.getStatusIcon()+ "] "
                + this.description+" (by: "+this.deadline+")" );
    }

    public void printDeadlineMsg(String deadline) {
        String echo_msg ="          ____________________________________________________________\n" +
                "          Got it. I've added this task:\n"+
                "          "+toString()+"\n"+
                "          Now you have "+ Task.taskCounter +" in the list.\n"+
                "          ____________________________________________________________";
        System.out.println(echo_msg);
    }
}
