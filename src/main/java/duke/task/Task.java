package duke.task;

/**
 * Represents a task in the task list
 */

public class Task {
    public String description;
    public boolean isDone;
    public static int taskCounter;


    /**
     * Basic make up of a task
     * @param description description of the task
     */

    public Task(String description) {

        this.description = description;
        this.isDone = false;
        taskCounter++;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    //format of tasks shown, to be overridden
    @Override
    public String toString() {
        return ("["+ this.getStatusIcon()+ "] "
                + this.description );
    }

    //format of task to be written in the file, to be overridden
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

//    public void printAckMsg() {
//        String ackMsg ="          ____________________________________________________________\n" +
//                "          Got it. I've added this task:\n"+
//                "          "+toString()+"\n"+
//                "          Now you have "+  +" in the list.\n"+
//                "          ____________________________________________________________";
//        System.out.println(ackMsg);
//    }
}
