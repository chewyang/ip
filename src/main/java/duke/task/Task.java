package duke.task;


public class Task {
    public String description;
    public boolean isDone;
    public static int taskCounter;

    public Task(String description, boolean isFromFile) {
        this.description = description;
        this.isDone = false;
        taskCounter++;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    //format of tasks shown, to be overwritten
    @Override
    public String toString() {
        return ("["+ this.getStatusIcon()+ "] "
                + this.description );
    }

    //format of task to be written in the file, to be overwritten
    public String toStringFile(){
        return null;
    }

    public void printMsg(String cmd){
        String msg ="          ____________________________________________________________\n" +
                "          Got it. I've marked this task as "+cmd+":\n"+
                "          "+toString()+"\n"+
                "          ____________________________________________________________";
        System.out.println(msg);
    }

    public void printAckMsg() {
        String ackMsg ="          ____________________________________________________________\n" +
                "          Got it. I've added this task:\n"+
                "          "+toString()+"\n"+
                "          Now you have "+ taskCounter +" in the list.\n"+
                "          ____________________________________________________________";
        System.out.println(ackMsg);
    }
}
