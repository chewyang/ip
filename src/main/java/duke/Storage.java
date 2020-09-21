package duke;

import duke.task.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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

    //Creates folder and file if necessary
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
    public TaskList loadData() throws IOException {
        createFileHierarchy();
        return processFile();
    }

    //updates the file with the new tasklist
    public void updateFile(TaskList taskList) throws IOException {
        writeToFile(filePath, "");
        if(taskList.getTaskCounter() >0) {
            for (int i = 0; i < taskList.getTaskCounter(); i++) {
                appendToFile(filePath, taskList.getTask(i).toStringFile());
            }
        }

    }


    private void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    private void appendToFile(String filePath, String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(filePath, true); // create a FileWriter in append mode
        fw.write(textToAppend+ System.lineSeparator());
        fw.close();
    }



    //processes the file for the tasks
    private TaskList processFile() throws IOException, FileNotFoundException {
        TaskList tasks = new TaskList();
         // create a File for the given file path
        Scanner s = new Scanner(dataFile); // create a Scanner using the File as the source
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
                tasks.addNewTask(task);
            }
        }
        return tasks;
    }


}
