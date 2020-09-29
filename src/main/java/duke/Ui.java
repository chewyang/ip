package duke;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Text UI of the application
 */

class Ui {

    private final Scanner in;
    private final PrintStream out;

    public static final String INDENT = "          ";

    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public Ui(){
        this(System.in, System.out);
    }

    /**
     * Takes in the user input.
     * @return the raw string of the user input.
     */
    public String getUserCommand() {
        out.println(INDENT + "Enter command: ");
        String fullInputLine = in.nextLine();
        return fullInputLine;
    }

    public void printErrorMessage() {
        printLn(INDENT+"Invalid command!");
    }

    public void printByeMsg() {
        printDivider();
        printLn("Bye, see you again!");
        printDivider();
    }

    public void printStartMsg() {
        String logo = INDENT + "    .___     __\n" +
                INDENT + "  __| _/_ __|  | __ ____\n" +
                INDENT + " / __ |  |  \\  |/ // __ \\\n" +
                INDENT + "/ /_/ |  |  /    <\\  ___/\n" +
                INDENT + "\\____ |____/|__|_ \\\\___  >\n" +
                INDENT + "     \\/          \\/    \\/";
        printLn("Hello from\n" + logo);
        printDivider();
        printLn("Hello! I'm Duke\n" +
                INDENT + "What can I do for you?");
        printDivider();
    }

    public void printDivider() {
        out.println(INDENT+"____________________________________________________________");
    }

    public void printLn(String string) {
        out.println(INDENT + string);
    }


}
