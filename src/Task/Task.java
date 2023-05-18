package Task;

import commandandtag.Command;
import commandandtag.Tag;

public class Task {
    private final Tag tag;
    private final Command command;

    public Task(Tag tag, Command command) {
        this.tag = tag;
        this.command = command;
    }

}
