public class Todo extends Task{

    public Todo(String description) {
        super(description);
        String echo_msg ="          ____________________________________________________________\n" +
                "          Got it. I've added this task:\n"+
                "          "+printTask()+"\n"+
                "           Now you have "+ taskCounter +" in the list.\n"+
                "          ____________________________________________________________";
        System.out.println(echo_msg);
    }

    @Override
    public String printTask() {
        return ("[T]"+"["+ this.getStatusIcon()+ "] "
                + this.description );
    }
}
