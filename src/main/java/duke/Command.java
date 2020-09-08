package duke;


import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

public class Command {
    protected static String indent = "          ";


    public static Deadline addDeadline(String command) {
        String description = null;
        try {
            command.substring(0, command.indexOf(" "));
        } catch (StringIndexOutOfBoundsException e){
            printLn("Deadline field cannot be empty!");
            return null;
        }
        try {
            //obtains description of deadline task
            description = command.substring(command.indexOf(" ") + 1, command.indexOf(" /by"));

        }catch (StringIndexOutOfBoundsException e ) {
            printLn("Missing '/by' keyword!");
            return null;
        }
        try {
            //obtains the deadline
            String deadline = command.substring(command.indexOf("/by") + 4);
            return new Deadline(description, deadline);

        }catch (StringIndexOutOfBoundsException e){
            printLn("Missing deadline!");

        }
        return null;
    }

    public static Event addEvent(String command) {
        String description=null;
        try {
            command.substring(0, command.indexOf(" "));
        } catch (StringIndexOutOfBoundsException e){
            printLn("Event field cannot be empty!");
            return null;
        }
        try {
            //obtains description of timed task
            description = command.substring(command.indexOf(" ") + 1, command.indexOf(" /at"));
        } catch (StringIndexOutOfBoundsException e){
            printLn("Missing '/at' keyword!");
            return null;
        }
        try{
            //obtains the time string
            String time = command.substring(command.indexOf("/at") + 4);
            return new Event(description, time);
        }catch (StringIndexOutOfBoundsException e){
            printLn("Missing time!");

        }
        return null;
    }

    public static Task addTodo(String command) {
        try{
            command.substring(0,command.indexOf(" "));
            String description = command.substring(command.indexOf(" ") + 1);
            return new Todo(description);
        }catch (StringIndexOutOfBoundsException e){
            printLn("Todo field cannot be empty!");
        }
        return null;
    }




    public static String getFirstCmd(String command){
            return command.split(" ")[0];
    }

    public static void printLn(String string) {
        System.out.println(indent+ string);
    }


}
