package duke;

import duke.command.Command;
import duke.task.TaskList;

import java.io.File;
import java.io.IOException;


public class Duke {


    private TaskList tasks;
    private Storage storage;
    private Ui ui;

    public Duke(String filePath, String folderPath) {
        ui = new Ui();
        storage = new Storage(getJarFilePath()+folderPath, getJarFilePath()+filePath);
        tasks = new TaskList();

        try {
            tasks = storage.loadData();
        } catch (IOException e) {
            ui.printLn("Unable to load file from directory");
        }
    }

    public void run() throws IOException {
        ui.printStartMsg();
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
       new Duke("/data/tasks.txt", "/data").run();

    }

    public void executeCommand(Command cmd) {
        try {
            cmd.setData(tasks);
            cmd.execute();
        }catch(NullPointerException e){

        }
    }

    private static String getJarFilePath() {
        return new File(Duke.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent().replace("%20", " ");
    }


}


