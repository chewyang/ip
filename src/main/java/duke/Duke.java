package duke;

import duke.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    protected static ArrayList<Task> tasks = new ArrayList<>();
    protected static String indent = "          ";
    protected static int taskCounter=0;

    public static void main(String[] args) {
        Task task = null;        printStartMsg();
        Scanner input = new Scanner(System.in);
        String firstCmd="";
        while (input.hasNextLine()) {
            String command = input.nextLine().trim();
            firstCmd = Command.getFirstCmd(command);

            switch (firstCmd) {
            case ("bye"):
                printByeMsg();
                break;
            case ("list"):
                printList();
                break;
            case ("done"):
                checkValidIndex(command.substring(command.indexOf(" ") + 1));
                break;
            case ("todo"):
                task = Command.addTodo(command);
                break;
            case ("deadline"):
                task = Command.addDeadline(command);
                break;
            case ("event"):
                task = Command.addEvent(command);
                break;
            case ("delete"):
                deleteTask(command.substring(command.indexOf(" ") + 1));

                break;
            default:
                printLn("invalid command!");
                break;
            }
            if(task!=null){
                addNewTask(task);
                task=null;
            }
            if(firstCmd.equals("bye"))break;



        }
    }

    public static void deleteTask(String num) {
        try {
            int delTaskatIndex = Integer.parseInt(num);
            tasks.remove(delTaskatIndex-1);
            Task.taskCounter--;
            taskCounter--;
            printList();
        }catch (IndexOutOfBoundsException e){
            System.out.println(indent+"invalid index!");
        }catch (NumberFormatException e){
            System.out.println(indent+"invalid index!");
        }

    }
    
    public static void addNewTask(Task task) {
        tasks.add(task);
        taskCounter++;
    }


    public static void printStartMsg() {
        String logo =indent+"    .___     __\n" +
                indent+"  __| _/_ __|  | __ ____\n" +
                indent+" / __ |  |  \\  |/ // __ \\\n" +
                indent+"/ /_/ |  |  /    <\\  ___/\n" +
                indent+"\\____ |____/|__|_ \\\\___  >\n" +
                indent+"     \\/          \\/    \\/";
        printLn("Hello from\n" + logo);
        printDivider();
        printLn("Hello! I'm Duke\n" +
                indent+ "What can I do for you?");
        printDivider();
    }


    public static void printByeMsg() {
        printDivider();
        printLn("Bye, see you again!");
        printDivider();
    }


    public static void printList() {
        printDivider();
        if(taskCounter >0) {
            printLn("Here are the tasks in your list:");

            for (int i = 0; i < taskCounter; i++) {
                printLn((i + 1) +"."+ tasks.get(i).toString());
            }
        }
        else {
            printLn("Nothing added!");
        }
        printDivider();
    }

    public static void checkValidIndex(String word) {
        try{
            int listNum = Integer.parseInt(word);

            if(listNum<= taskCounter && listNum>0) {
                tasks.get(listNum - 1).isDone = true;
                printDivider();
                printLn("Nice! I've marked this task as done:");
                printLn("["+ tasks.get(listNum-1).getStatusIcon()+ "] "
                        + tasks.get(listNum-1).description );
                printDivider();
            }
            else {
                printLn("invalid index!");
            }

        }catch (NumberFormatException e) {
            System.out.println(indent+"invalid index!");
        }
    }




    public static void printDivider() {
        System.out.println(indent+"____________________________________________________________");
    }

    public static void printLn(String string) {
        System.out.println(indent+ string);
    }


}


