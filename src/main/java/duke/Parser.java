package duke;

import duke.command.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *  Parses the user input
 */

public class Parser {

    private Ui ui;

    public Parser(Ui ui){
        this.ui = ui;
    }

    /**
     *  parses user input into command for execution
     * @param userInput full user input string
     * @return the command based on the user input
     */
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

    /**
     * Parses arguments in the context of the add Todo task.
     * Checks if the user has input the todo field.
     * @param userInput full user input
     * @return the prepared command
     */
    private Command prepareAddTodoArgs(String userInput) {
        try{
            String description = getDscOfCommand(userInput);
            return new AddTodoCommand(description);
        }catch (StringIndexOutOfBoundsException e){
            ui.printLn("Todo field cannot be empty!");
        }
        return null;
    }

    /**
     * Parses arguments in the context of the add Deadline task.
     * Checks if the user has input the deadline field , '/by' keyword and deadline
     * * @param userInput full user input
     * @return the prepared command
     */
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

    /**
     * Parses arguments in the context of the add Event task
     * Checks if the user has input the event field , '/at' keyword and time
     * @param userInput full user input
     * @return the prepared command
     */
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

    /**
     * Obtains the first word of the user input command.
     * @param userInput raw user input
     * @return the first word of the user input
     */
    private String getFirstCommand(String userInput){
        userInput = userInput.trim();
        return userInput.split(" ")[0];
    }

    /**
     * Obtains the description of the user command from the raw user input.
     * @param userInput raw user input
     * @return description of the user command
     */
    private String getDscOfCommand(String userInput){
        userInput = userInput.trim();
        return userInput.substring(userInput.indexOf(" ") + 1);
    }

    /**
     * Checks the validity of the index given by the user to delete or set the task as done
     * @param word string to parse as index number
     * @param cmdType to check which command is using this method
     * @return the command to delete or set as done if index parsed is valid
     * @throws NumberFormatException the word string region is not a valid number
     */

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


    /**
     * Parses arguments in the context of the find command
     * @param userInput raw user input
     * @return the prepared command
     */
    public Command prepareFind(String userInput){
        userInput = userInput.trim();
        String key = userInput.substring(userInput.indexOf(" ")+1);
        System.out.println(key);
        return new findCommand(key);
    }


    /**
     * Checks validity of the user inputted string as a datetime object
     * @param dateTime string to be parsed
     * @return the converted string if the datetime string parsed is valid
     */
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




