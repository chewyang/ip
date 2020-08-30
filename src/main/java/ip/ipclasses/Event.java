package ip.ipclasses;

public class Event extends Task{
    protected String time;


    public Event(String description, String time) {
        super(description);
        this.time =time;
        String echo_msg ="          ____________________________________________________________\n" +
                "          Got it. I've added this task:\n"+
                "          "+printTask()+"\n"+
//                "           "+"added: "+description+"\n"+
                "          Now you have "+ Task.taskCounter +" in the list.\n"+
                "          ____________________________________________________________";


        System.out.println(echo_msg);
    }

    @Override
    public String printTask() {
        return ("[E]"+"["+ this.getStatusIcon()+ "] "
                + this.description+" (at: "+this.time +")" );
    }
}
