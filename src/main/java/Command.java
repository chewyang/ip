import java.util.Scanner;

public class Command{
    protected static String indent = "          ";


    public Command(){

    }

    public static Deadline getDeadline(String command){
        String description = null;
        try {
            command.substring(0, command.indexOf(" "));
        } catch (StringIndexOutOfBoundsException e){
            printLn("Deadline field cannot be empty!");
            return null;
        }
        try {
            description = command.substring(command.indexOf(" ") + 1, command.indexOf(" /by"));

        }catch (StringIndexOutOfBoundsException e ) {
            printLn("Missing '/by' keyword!");
            return null;
        }
        try {
            String deadline = command.substring(command.indexOf("/by") + 4);
            return new Deadline(description, deadline);

        }catch (StringIndexOutOfBoundsException e){
            printLn("Missing deadline!");

        }
        return null;
    }

    public static Event getEvent(String command){
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

    public static Task getTodo(String command){
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

    public static String getDescription(String command) throws DukeException{
        String firstCmd = getFirstCmd(command);
        String description = null;
        try {
            description = command.substring(command.indexOf(firstCmd) + firstCmd.length()).trim();
            return description;
        }catch(NullPointerException e){
            printLn("Todo field cannot be empty!");
        }
      return description;
    }
    public static void printLn(String string) {
        System.out.println(indent+ string);
    }


}
