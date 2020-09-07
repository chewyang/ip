public class Todo extends Task {

    public Todo(String description) {
        super(description);
        printTodoMsg(description);
    }

    @Override
    public String toString() {
        return ("[T]"+"["+ this.getStatusIcon()+ "] "
                + this.description );
    }

    public void printTodoMsg(String description) {
        String echo_msg ="          ____________________________________________________________\n" +
                "          Got it. I've added this task:\n"+
                "          "+toString()+"\n"+
                "          Now you have "+ taskCounter +" in the list.\n"+
                "          ____________________________________________________________";
        System.out.println(echo_msg);
    }
}
