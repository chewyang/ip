import java.util.Scanner;


public class Duke {

    private static Task[] tasks = new Task[100];
    private static int taskCounter =0;

    public static void main(String[] args) {

        startMsg();
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {

            String command = input.nextLine().trim();
            String[] doneTokens = command.split(" ");
            if (command.equals("")) continue;

            if(command.equals("bye")) {
                byeMsg();
                break;
            }
            else if(command.equals("list")){
                printList();
            }
            else if (doneTokens[0].equals("done")){
                checkValidIndex(doneTokens[1]);
            }
            else {
                //this switch statement checks the nature of the task
                switch (doneTokens[0]){
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
                    System.out.println("invalid command!");
                }

            }

        }



    }

    public static void startMsg() {
        String logo ="    .___     __\n" +
                "  __| _/_ __|  | __ ____\n" +
                " / __ |  |  \\  |/ // __ \\\n" +
                "/ /_/ |  |  /    <\\  ___/\n" +
                "\\____ |____/|__|_ \\\\___  >\n" +
                "     \\/          \\/    \\/";
        System.out.println("Hello from\n" + logo);

        String startMessage ="____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";
        System.out.println(startMessage);
    }

    public static void byeMsg(){
        String bye_msg = "          ____________________________________________________________\n" +
                "           Bye, see you again!\n" +
                "          ____________________________________________________________";
        System.out.println(bye_msg);
    }

    public static void printList(){
        System.out.println("          ____________________________________________________________");
        if(taskCounter >0) {
            System.out.println("          Here are the tasks in your list:");
            for (int i = 0; i < taskCounter; i++) {
                System.out.println("          " +(i + 1)+"."+ tasks[i].printTask());
            }
        }
        else {
            System.out.println("          " + "Nothing added!");
        }
        System.out.println("          ____________________________________________________________");
    }



    public static void checkValidIndex(String word){
        try{
            int listNum = Integer.parseInt(word);

            if(listNum<= taskCounter && listNum>0) {
                tasks[listNum - 1].isDone = true;
                System.out.println("          ____________________________________________________________");
                System.out.println("          Nice! I've marked this task as done:");
                System.out.println("          " + "["+ tasks[listNum-1].getStatusIcon()+ "] "
                        + tasks[listNum-1].description );
                System.out.println("          ____________________________________________________________");
            }
            else {
                System.out.println("          invalid index!");
            }

        }catch (NumberFormatException e) {
            System.out.println("          invalid index!");
        }
    }

    public static void addNewTodo(String description){
        tasks[taskCounter]= new Todo(description);
        taskCounter++;
    }

    public static void addNewDeadline(String dsc, String deadline){
        tasks[taskCounter]= new Deadline(dsc, deadline);
        taskCounter++;
    }

    public static void addNewEvent(String dsc, String time){
        tasks[taskCounter]= new Event(dsc, time);
        taskCounter++;
    }


}


