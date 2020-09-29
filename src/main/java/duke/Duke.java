package duke;

import duke.command.Command;
import duke.task.TaskList;
import java.io.IOException;

/**
 * Entry point of the Duke application.
 * Initializes the application and starts the interaction with the user.
 */

public class Duke {


    private TaskList tasks;
    private Storage storage;
    private Ui ui;

    /**Sets up required objects and loads up the data from the storage file */
    public Duke(String filePath, String folderPath) {
        ui = new Ui();
        storage = new Storage(folderPath, filePath);
        tasks = new TaskList();

        try {
            tasks = storage.loadData();
        } catch (IOException e) {
            ui.printLn("Unable to load file from directory");
        }
    }

    /** Runs the program until termination.  */
    public void run() throws IOException {
        ui.printStartMsg();
        System.out.println(tasks.getTaskCounter());

        String command;
        do{
            command = ui.getUserCommand();
            Command c = new Parser(ui).parse(command);
            executeCommand(c);

        }while(!command.equals("bye"));
        storage.updateFile(tasks);
        ui.printByeMsg();
    }


    public static void main(String[] args) throws IOException {
       new Duke("data/tasks.txt", "data").run();

    }

    /**
     * Executes the command
     * @param command user command
     */
    public void executeCommand(Command command) {
        try {
            command.setData(tasks);
            command.execute();
        }catch(NullPointerException e){
            ui.printErrorMessage();
        }
    }


}


