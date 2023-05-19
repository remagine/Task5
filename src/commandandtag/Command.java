package commandandtag;

public enum Command {
    CREATE("create"), EXECUTE("execute"), ERROR("error");

    private final String commandType;

    Command(String commandType) {
        this.commandType = commandType;
    }

    private String getCommandType() {
        return commandType;
    }

    public static Command from(String input) {
        for(Command command : Command.values()){
            if(command.getCommandType().equalsIgnoreCase(input)){
                return command;
            }
        }

        return Command.ERROR;
    }
}
