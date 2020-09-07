import java.util.Scanner;

public class Duke {

    private static Task[] tasks = new Task[100];
    private static int taskCounter =0;
    public static String indent = "          ";

    public static void main(String[] args) {

        printStartMsg();
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {

            String command = input.nextLine().trim();
            String[] cmdTokens = command.split(" ");

            switch (cmdTokens[0]){
            case ("bye"):
                printByeMsg();
                break;
            case("list"):
                printList();
                break;
            case("done"):
                checkValidIndex(command.substring(command.indexOf(" ")+1));
                break;
            case ("todo"):
                //obtains description of todo task
                String dsc = command.substring(command.indexOf(" ") + 1);
                addNewTodo(dsc);
                break;
            case("deadline"):
                //obtains description of deadlined task
                dsc = command.substring(command.indexOf(" ")+1,command.indexOf(" /by "));
                //obtains the deadline string
                String deadline = command.substring(command.indexOf("/by")+4);
                addNewDeadline(dsc,deadline);
                break;
            case("event"):
                //obtains description of timed task
                dsc = command.substring(command.indexOf(" ")+1,command.indexOf(" /at "));
                //obtains the time string
                String time = command.substring(command.indexOf("/at")+4);
                addNewEvent(dsc,time);
                break;
            default:
                printLn("invalid command!");
                break;
            }

        }

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
                printLn((i + 1)+"."+ tasks[i].toString());
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
                tasks[listNum - 1].isDone = true;
                printDivider();
                printLn("Nice! I've marked this task as done:");
                printLn("["+ tasks[listNum-1].getStatusIcon()+ "] "
                        + tasks[listNum-1].description );
                printDivider();
            }
            else {
                printLn("invalid index!");
            }

        }catch (NumberFormatException e) {
            System.out.println(indent+"invalid index!");
        }
    }


    public static void addNewTodo(String description) {
        tasks[taskCounter]= new Todo(description);
        taskCounter++;
    }

    public static void addNewDeadline(String dsc, String deadline) {
        tasks[taskCounter]= new Deadline(dsc, deadline);
        taskCounter++;
    }

    public static void addNewEvent(String dsc, String time) {
        tasks[taskCounter]= new Event(dsc, time);
        taskCounter++;
    }

    public static void printDivider() {
        System.out.println(indent+"____________________________________________________________");
    }

    public static void printLn(String string) {
        System.out.println(indent+ string);
    }


}


