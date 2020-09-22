package duke;

import duke.command.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {

    private Ui ui;

    public Parser(Ui ui){
        this.ui = ui;
    }

    //takes in the user's commands and performs its functions
    public Command parse(String userInput){
        String firstCmd = getFirstCommand(userInput);

        switch(firstCmd){
        case("todo"):
            return prepareAddTodoArgs(userInput);
        case("deadline"):
            return prepareDeadlineArgs(userInput);
        case("event"):
            return prepareEventArgs(userInput);
        case("list"):
            return new ListCommand();
        case("done"):
            return checkValidIndex(userInput, "done");
        case("delete"):
            return checkValidIndex(userInput, "delete");
        case("find"):
            return prepareFind(userInput);
        }
        return null;
    }

    //
    private Command prepareAddTodoArgs(String userInput) {
        try{
            String description = getDscOfCommand(userInput);
            return new AddTodoCommand(description);
        }catch (StringIndexOutOfBoundsException e){
            ui.printLn("Todo field cannot be empty!");
        }
        return null;
    }

    private Command prepareDeadlineArgs(String userInput) {
        String description = null;
        try {
            userInput.substring(0, userInput.indexOf(" "));
        } catch (StringIndexOutOfBoundsException e){
            ui.printLn("Deadline field cannot be empty!");
            return null;
        }
        try {
            //obtains description of deadline task
            description = userInput.substring(userInput.indexOf(" ") + 1, userInput.indexOf(" /by"));

        }catch (StringIndexOutOfBoundsException e ) {
            ui.printLn("Missing '/by' keyword!");
            return null;
        }
        try {
            //obtains the deadline
            String deadline = userInput.substring(userInput.indexOf("/by") + 4);
            try {
                String dateTime = checkDateTime(deadline);
                return new AddEventCommand(description, dateTime);

            }catch(DateTimeParseException e){
                return new AddEventCommand(description, deadline);
            }

        }catch (StringIndexOutOfBoundsException e){
            ui.printLn("Missing deadline!");

        }
        return null;
    }

    private Command prepareEventArgs(String userInput) {
        String description=null;
        try {
            userInput.substring(0, userInput.indexOf(" "));
        } catch (StringIndexOutOfBoundsException e){
            ui.printLn("Event field cannot be empty!");
            return null;
        }
        try {
            //obtains description of timed task
            description = userInput.substring(userInput.indexOf(" ") + 1, userInput.indexOf(" /at"));
        } catch (StringIndexOutOfBoundsException e){
            ui.printLn("Missing '/at' keyword!");
            return null;
        }
        try{
            //obtains the time string
            String time = userInput.substring(userInput.indexOf("/at") + 4);
            try {
                String dateTime = checkDateTime(time);
                return new AddEventCommand(description, dateTime);

            }catch(DateTimeParseException e){
                return new AddEventCommand(description, time);
            }
        }catch (StringIndexOutOfBoundsException e){
            ui.printLn("Missing time!");

        }
        return null;
    }

    private String getFirstCommand(String userInput){
        userInput = userInput.trim();
        return userInput.split(" ")[0];
    }

    private String getDscOfCommand(String userInput){
        userInput = userInput.trim();
        return userInput.substring(userInput.indexOf(" ") + 1);
    }

    //checks if the index given to the done or delete function is valid
    public Command checkValidIndex(String word, String cmdType){
        word= getDscOfCommand(word);

        try{
            int listNum = Integer.parseInt(word);
            if(cmdType.equals("done")){
                return new doneCommand(listNum);
            }
            else if(cmdType.equals("delete")){
                return new deleteCommand(listNum);
            }

            return new doneCommand(listNum);
        }catch (NumberFormatException e) {
            ui.printLn("invalid index!");

        }
        return null;

    }


    public Command prepareFind(String userInput){
        userInput = userInput.trim();
        String key = userInput.substring(userInput.indexOf(" ")+1);
        System.out.println(key);
        return new findCommand(key);
    }


    private String checkDateTime(String dateTime){
        try{
            LocalDateTime dateTime1 = LocalDateTime.parse(dateTime);
            String dateTime2 = dateTime1.format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm"));
            return dateTime2;

        }catch(DateTimeParseException e){
                return dateTime;
        }

    }

}




