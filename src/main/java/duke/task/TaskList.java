package duke.task;

import duke.task.Task;

import java.util.ArrayList;

/**
 * Represents the current list of tasks.
 */

public class TaskList {

    private ArrayList<Task> tasks;
    private int taskCounter;


    /**
     * Constructs an empty task list.
     */
    public TaskList(){
        tasks = new ArrayList<>();
        taskCounter =0;
    }


    public void addNewTask(Task task) {
        tasks.add(task);
        taskCounter++;
    }

    public void deleteTask(int index){
        tasks.remove(index);
        taskCounter--;
    }

    //obtains the task of the given indexed item in the list
    public Task getTask(int i) {
        return tasks.get(i);
    }

    //obtains the current number of tasks in the list
    public int getTaskCounter(){
        return taskCounter;
    }

    /**
     * Prints the full list of tasks or the list of matching tasks from the {@code find} command
     * @param isMatching checks if this method needs to list the full or matching task list
     */
    public void printList(boolean isMatching){
        System.out.println("          ____________________________________________________________");
        if(taskCounter >0) {
            if(isMatching) {
                System.out.println("          Here are the matching tasks in your list:");
            }
            else{
                System.out.println("          Here are the tasks in your list:");
            }
            for (int i = 0; i < taskCounter; i++) {
                System.out.println("          "+(i + 1) +"."+ getTask(i).toString());
            }
        }
        else {
            System.out.println("          Nothing added!");
        }
        System.out.println("          ____________________________________________________________");

    }
}
