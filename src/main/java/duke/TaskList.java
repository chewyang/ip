package duke;

import duke.task.Task;

import java.util.ArrayList;

public class TaskList {

    private static ArrayList<Task> tasks;
    private static int TaskCounter;


    /** Constructs an empty task list **/
    public TaskList(){
        tasks = new ArrayList<>();
        TaskCounter =0;
    }


    public static void addNewTask(Task task) {
        tasks.add(task);
        TaskCounter++;
    }

    public static void deleteTask(int index){
        tasks.remove(index);
        TaskCounter--;
    }

    public Task getTask(int i) {
        return tasks.get(i);
    }

    public int getTaskCounter(){
        return TaskCounter;
    }
}
