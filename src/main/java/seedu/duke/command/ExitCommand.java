package seedu.duke.command;

public class ExitCommand extends Command {

    private static final String EXIT_MSG = "Exiting program!";

    @Override
    public CommandResult executeCommand() {
        return new CommandResult(EXIT_MSG, false, true);
    }
}