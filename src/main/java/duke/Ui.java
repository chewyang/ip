package duke;

public class Ui {

    public static final String INDENT = "          ";









    public static void printByeMsg() {
        printDivider();
        printLn("Bye, see you again!");
        printDivider();
    }

    public static void printStartMsg() {
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

    public static void printDivider() {
        System.out.println(INDENT+"____________________________________________________________");
    }

    public static void printLn(String string) {
        System.out.println(INDENT + string);
    }

}
