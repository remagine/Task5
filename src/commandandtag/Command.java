package command;

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
            if(command.getCommandType().equals(input)){
                return Command.valueOf(input);
            }
        }

        return Command.ERROR;
    }
}
