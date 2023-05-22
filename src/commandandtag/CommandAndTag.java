package commandandtag;

import task.CreateTask;
import task.ExecuteTask;
import task.Task;

public class CommandAndTag  {
    private final Command command;
    private final Tag tag;

    public CommandAndTag(Command command, Tag tag) {
        this.command = command;
        this.tag = tag;
    }
    public Task getTask(){
        switch (command){
            case CREATE:
                return new CreateTask();
            case EXECUTE:
                return new ExecuteTask(tag);
            default:
                return null;
        }
    }
}
