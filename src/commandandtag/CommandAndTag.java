package commandandtag;

public class CommandAndTag {
    private final Command command;
    private final Tag tag;

    public CommandAndTag(Command command, Tag tag) {
        this.command = command;
        this.tag = tag;
    }

    public Command getCommand() {
        return command;
    }

    public Tag getTag() {
        return tag;
    }
}
