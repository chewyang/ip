package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    protected static ArrayList<Task> tasks = new ArrayList<>();
    protected static String indent = "          ";
    public static int taskCounter=0;
    public static String folderDir = "data";
    public static String fileDir = "data/tasks.txt";


    public static void main(String[] args) throws IOException {
        createFileHierarchy(folderDir, fileDir);
        Task task = null;
        printStartMsg();
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
                checkValidIndex(command.substring(command.indexOf(" ") + 1),"done");
                updateFile();
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
                checkValidIndex(command.substring(command.indexOf(" ") + 1), "delete");
                updateFile();
                break;
            default:
                printLn("invalid command!");
                break;
            }
            if(task!=null){
                addNewTask(task);
                appendToFile("data/tasks.txt",task.toStringFile());
                task=null;
            }
            //exits program
            if(firstCmd.equals("bye"))break;



        }
    }

    private static void appendToFile(String filePath, String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(filePath, true); // create a FileWriter in append mode
        fw.write(textToAppend+ System.lineSeparator());
        fw.close();
    }

    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    private static void processFile(String filePath) throws IOException, FileNotFoundException{
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        boolean isDone;
        while (s.hasNext()) {
            Task task = null;
            //System.out.println(s.nextLine());
            String line = s.nextLine();
            String words[] = line.split(" \\| ");
            String firstCommand= words[0];
            isDone= words[1].equals("1");

            switch(firstCommand){
            case "T":
                task = new Todo(words[2],true);
                break;
            case "D":
                task = new Deadline(words[2],words[3], true);
                break;
            case "E":
                task = new Event(words[2],words[3], true);
                break;

            }
            if(task!=null) {
                task.isDone=isDone;
                addNewTask(task);
            }
        }
    }

    
    public static void addNewTask(Task task) {
        tasks.add(task);
        taskCounter++;
    }


    private static void updateFile() throws IOException {
        writeToFile(fileDir, "");
        if(taskCounter >0) {
            for (int i = 0; i < taskCounter; i++) {
                appendToFile(fileDir, tasks.get(i).toStringFile());
            }
        }

    }


    public static void createFileHierarchy(String folderPath, String filePath) throws IOException {
        File folder = new File(folderPath);
        File file = new File(filePath);
        if(folder.exists()) {
            if(file.exists()){
                processFile(filePath);
                return;
            }
            else{
                file.createNewFile();
            }
        }
        else {
            folder.mkdir();
            file.createNewFile();
        }
        
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


    public static void printStartMsg() {
        String logo = indent + "    .___     __\n" +
                indent + "  __| _/_ __|  | __ ____\n" +
                indent + " / __ |  |  \\  |/ // __ \\\n" +
                indent + "/ /_/ |  |  /    <\\  ___/\n" +
                indent + "\\____ |____/|__|_ \\\\___  >\n" +
                indent + "     \\/          \\/    \\/";
        printLn("Hello from\n" + logo);
        printDivider();
        printLn("Hello! I'm Duke\n" +
                indent + "What can I do for you?");
        printDivider();
    }


    public static void checkValidIndex(String word, String command) {
                String message = null;
                String description =null;
        try{
            int listNum = Integer.parseInt(word);
                if (listNum <= taskCounter && listNum > 0) {

                    switch (command) {
                    case "done":
                        tasks.get(listNum - 1).isDone = true;
                        message = "Nice! I've marked this task as done: ";
                        description =  tasks.get(listNum - 1).toString();
                        break;

                    case "delete":
                        Task.taskCounter--;
                        taskCounter--;
                        description = tasks.get(listNum - 1).toString() + "\n" + indent +
                                "Now you have " + taskCounter + " tasks in the list.";
                        tasks.remove(listNum - 1);

                        message = "Noted. I've removed this task: ";
                        break;
                    default:
                        break;
                    }
                    printDivider();
                    printLn(message);
                    printLn(description);
                    printDivider();
                }

            else {
                printLn("invalid index!");
            }

        }catch (NumberFormatException | IndexOutOfBoundsException e) {
            printLn("invalid index!");
        }

    }

    public static void printByeMsg() {
        printDivider();
        printLn("Bye, see you again!");
        printDivider();
    }

    public static void printDivider() {
        System.out.println(indent+"____________________________________________________________");
    }

    public static void printLn(String string) {
        System.out.println(indent+ string);
    }
}


