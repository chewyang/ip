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
}
