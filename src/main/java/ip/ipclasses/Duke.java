package ip.ipclasses.java;

import java.util.Scanner;


public class Duke {

    private static Task[] list= new Task[100];
    private static int list_counter=0;



    public static void main(String[] args) {
        String logo =
//                  " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
            " .----------------.  .----------------.  .----------------.  .----------------. \n" +
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

            String echo = input.nextLine();


            if(echo.equals("bye")) {
                String bye_msg = "          ____________________________________________________________\n" +
                        "           Bye, see you again!\n" +
                        "          ____________________________________________________________\n";
                System.out.println(bye_msg);
                break;
            }
            else if(echo.equals("list")){
                printList();
//
            }
            else {
               list[list_counter]= new Task(echo);
                String echo_msg ="          ____________________________________________________________\n" +
                    "           "+"added: "+echo+"\n"+
                    "          ____________________________________________________________\n";
                System.out.println(echo_msg);
                list_counter++;
            }

        }



    }

    public static void printList(){
        System.out.println("          ____________________________________________________________\n");
        if(list_counter>0) {
            for (int i = 0; i < list_counter; i++) {
                System.out.println("          " + (i + 1) + "." + list[i].description + "\n");
            }
        }
        else
            System.out.println("          " +"Nothing added!");
        System.out.println("          ____________________________________________________________\n");
    }
}
