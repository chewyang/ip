
package ip.ipclasses;

public class Task {
    protected String description;
    protected boolean isDone;
    protected static int taskCounter;



    public Task(String description) {
        this.description = description;
        this.isDone = false;
        taskCounter++;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String printTask(){
        return ("["+ this.getStatusIcon()+ "] "
                + this.description );
    }


}
