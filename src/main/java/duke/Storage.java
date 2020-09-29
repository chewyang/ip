package duke;

import duke.command.AddTodoCommand;
import duke.command.Command;
import duke.task.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents the file use to store the tasks data
 */

public class Storage {
    private File dataFile;
    private File dataFolder;
    private String filePath;


    public Storage(String folderDir, String fileDir){

        dataFile = new File(fileDir);
        dataFolder = new File(folderDir);
        filePath = fileDir;
    }

    public File getDataFile(){return dataFile;}

    /**
     * Creates file hierarchy if necessary
     * @throws IOException if unsuccessful in creating new file
     */
    private void createFileHierarchy() throws IOException {

        if(dataFolder.exists()) {
            if(dataFile.exists()){
//                processFile(dataFile);
                return;
            }
            else{
                dataFile.createNewFile();
            }
        }
        else {
            dataFolder.mkdir();
            dataFile.createNewFile();
        }

    }

    //Returns the TaskList object after processing the tasks.txt file

    /**
     * Loads the {@code Duke} data from this storage file and processes it
     * @return the task list loaded from the file
     * @throws IOException if there were errors reading the file
     */
    public TaskList loadData() throws IOException {
        createFileHierarchy();
        return processFile();
    }

    /**
     * Updates the text file with the new tasklist after the user exits the program
     * @param taskList the current task list in the program
     * @throws IOException if there were errors updating the file
     */
    public void updateFile(TaskList taskList) throws IOException {
        writeToFile(filePath, "");
        if(taskList.getTaskCounter() >0) {
            for (int i = 0; i < taskList.getTaskCounter(); i++) {
                appendToFile(filePath, taskList.getTask(i).toStringFile());
            }
        }

    }


    /**
     * Overwrites the text file
     * @param filePath filepath of the text file to modify
     * @param textToAdd text to overwrite with
     * @throws IOException if there were errors writing to the file
     */
    private void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    /**
     * Appends to the text file
     * @param filePath filepath to the text file to modify
     * @param textToAppend text to append to the text file with
     * @throws IOException if there were errors appending to the file
     */
    private void appendToFile(String filePath, String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(filePath, true); // create a FileWriter in append mode
        fw.write(textToAppend+ System.lineSeparator());
        fw.close();
    }


    /**
     * Process the contents of the text file
     * @return the task list loaded on the text file
     * @throws IOException if there are errors opening the file
     * @throws FileNotFoundException if the files needed is not found
     */
    private TaskList processFile() throws IOException, FileNotFoundException {
        TaskList tasks = new TaskList();
        Scanner s = new Scanner(dataFile); // create a Scanner using the File as the source
        boolean isDone;
        //scans the file line by line and converts them to tasks
        while (s.hasNext()) {
            Task task = null;
            String line = s.nextLine();
            String words[] = line.split(" \\| ");
            String firstCommand= words[0];
            isDone= words[1].equals("1");

            switch(firstCommand){
            case "T":
                task = new Todo(words[2]);
                break;
            case "D":
                task = new Deadline(words[2],words[3]);
                break;
            case "E":
                task = new Event(words[2],words[3]);
                break;
            default:
                break;

            }
            if(task!=null) {
                task.isDone=isDone;
                //set isFromFile to true so as not to print the acknowledgement message once task is added
                tasks.addNewTask(task, true);
            }
        }
        return tasks;
    }


}
