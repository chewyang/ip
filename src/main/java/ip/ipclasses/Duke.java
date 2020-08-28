package ip.ipclasses;

import java.util.Scanner;


public class Duke {

    private static Task[] list= new Task[100];
    private static int list_counter=0;



    public static void main(String[] args) {
        String logo =" .----------------.  .----------------.  .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. || .--------------. |\n" +
                "| |  ________    | || | _____  _____ | || |  ___  ____   | || |  _________   | |\n" +
                "| | |_   ___ `.  | || ||_   _||_   _|| || | |_  ||_  _|  | || | |_   ___  |  | |\n" +
                "| |   | |   `. \\ | || |  | |    | |  | || |   | |_/ /    | || |   | |_  \\_|  | |\n" +
                "| |   | |    | | | || |  | '    ' |  | || |   |  __'.    | || |   |  _|  _   | |\n" +
                "| |  _| |___.' / | || |   \\ `--' /   | || |  _| |  \\ \\_  | || |  _| |___/ |  | |\n" +
                "| | |________.'  | || |    `.__.'    | || | |____||____| | || | |_________|  | |\n" +
                "| |              | || |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------'  '----------------' ";
        System.out.println("Hello from\n" + logo);

        String startMessage ="____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";
        System.out.println(startMessage);
        Scanner input = new Scanner(System.in);




        while (true) {

            String echo = input.nextLine().trim();
            if (echo.equals("")) continue;

            String[] doneTokens = echo.split(" ");

            if(echo.equals("bye")) {
                byeMsg();
                break;
            }
            else if(echo.equals("list")){
                printList();
            }
            else if (doneTokens[0].equals("done")){
                checkValidIndex(doneTokens[1]);
            }
            else {
               addNew(echo);
            }

        }



    }

    public static void printList(){
        System.out.println("          ____________________________________________________________");

        if(list_counter>0) {
            System.out.println("          Here are the tasks in your list:");
            for (int i = 0; i < list_counter; i++) {
                System.out.println("          " +(i + 1)+ ".["+ list[i].getStatusIcon()+ "] "
                        + list[i].description );
            }
        }
        else {
            System.out.println("          " + "Nothing added!");
        }
        System.out.println("          ____________________________________________________________");
    }

    public static void byeMsg(){
        String bye_msg = "          ____________________________________________________________\n" +
                "           Bye, see you again!\n" +
                "          ____________________________________________________________";
        System.out.println(bye_msg);
    }

    public static void checkValidIndex(String word){
        try{
            int listNum = Integer.parseInt(word);
            if(listNum<=list_counter && listNum>0) {
                list[listNum - 1].isDone = true;
//                printList();
                System.out.println("          ____________________________________________________________");
                System.out.println("          Nice! I've marked this task as done:");
                System.out.println("          " + "["+ list[listNum-1].getStatusIcon()+ "] "
                        + list[listNum-1].description );
                System.out.println("          ____________________________________________________________");

            }
            else {
                System.out.println("          invalid index!");
            }

        }catch (NumberFormatException ex) {
            System.out.println("          invalid index!");
        }
    }

    public static void addNew (String description){
        list[list_counter]= new Task(description);
        String echo_msg ="          ____________________________________________________________\n" +
                "           "+"added: "+description+"\n"+
                "          ____________________________________________________________";
        System.out.println(echo_msg);
        list_counter++;
    }
}


