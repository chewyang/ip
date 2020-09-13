package duke.task;

public class Todo extends Task {

    public Todo(String description, boolean isFromFile) {
        super(description);
        if(!isFromFile) {
            printTodoMsg(description);
        }
    }

    @Override
    public String toString() {
        return ("[T]"+"["+ this.getStatusIcon()+ "] "
                + this.description );
    }

    @Override
    public String toStringFile(){
        int isDoneInt = isDone? 1:0;
        return ("T | "+ isDoneInt + " | "
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
