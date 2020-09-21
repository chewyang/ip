package duke.task;


public class Task {
    public String description;
    public boolean isDone;
    public static int taskCounter;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        taskCounter++;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    @Override
    public String toString() {
        return ("["+ this.getStatusIcon()+ "] "
                + this.description );
    }

    public String toStringFile(){
        return null;
    }

    public void printMsg(String cmd){
        String echo_msg ="          ____________________________________________________________\n" +
                "          Got it. I've marked this task as "+cmd+":\n"+
                "          "+toString()+"\n"+
                "          ____________________________________________________________";
        System.out.println(echo_msg);
    }
}
