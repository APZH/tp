package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.CommandResult;
import seedu.duke.parser.Parser;
import seedu.duke.task.TaskManager;
import seedu.duke.ui.Ui;

import java.util.Scanner;

public class Duke {

    private final Scanner in;
    private final Ui ui;
    private final Parser parser;
    private final TaskManager taskManager;

    public Duke() {
        in = new Scanner(System.in);
        ui = new Ui();
        parser = new Parser();
        taskManager = new TaskManager();
    }

    public String readInput() {
        ui.printCursor();
        String input = in.nextLine();
        return input;
    }

    public CommandResult runCommand(Command userCommand) {
        CommandResult commandResult = null;
        try {
            commandResult = userCommand.executeCommand();
        } catch (Exception e) {
            commandResult = new CommandResult(e.toString(), false, false);
        }
        return commandResult;
    }

    public void startProgram() {

        ui.printLogo();

        Command userCommand;
        CommandResult commandResult;

        do {

            String userInput = readInput();

            userCommand = parser.parseCommand(taskManager, userInput);

            commandResult = runCommand(userCommand);

            ui.printMessage(commandResult.getMessage());

        } while (commandResult.getIsExited() != true);

    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.startProgram();
    }

}
