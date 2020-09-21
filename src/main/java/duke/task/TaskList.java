package duke.task;

import duke.task.Task;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasks;
    private int taskCounter;


    /** Constructs an empty task list **/
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

    public Task getTask(int i) {
        return tasks.get(i);
    }

    public int getTaskCounter(){
        return taskCounter;
    }

    public void printList(){
        System.out.println("          ____________________________________________________________");
        if(taskCounter >0) {
            System.out.println("          Here are the tasks in your list:");

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
