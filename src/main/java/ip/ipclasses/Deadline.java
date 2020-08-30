package ip.ipclasses;

public class Deadline extends Task{
    protected String deadline;


    public Deadline(String description, String deadline) {
        super(description);
        this.deadline=deadline;
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
        return ("[D]"+"["+ this.getStatusIcon()+ "] "
                + this.description+" (by: "+this.deadline+")" );
    }
}
