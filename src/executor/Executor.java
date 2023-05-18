package executor;

import commandandtag.Command;
import commandandtag.Tag;

public interface Executor {
    Executor get(Command command, Tag tag);

}
