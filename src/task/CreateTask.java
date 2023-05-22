package task;

import commandandtag.EmptyTag;
import commandandtag.Tag;

import java.util.Optional;

import static task.TaskService.availableTags;
import static task.TaskService.failHistory;

public class CreateTask implements Task, FailTask {
    private Tag tag;

    public CreateTask() {
    }

    @Override
    public Optional<FailTask> doTask() {
        Tag minTag = availableTags.pollFirst();
        tag = minTag;
        if(minTag == null){
            tag = EmptyTag.EMPTY_TAG;
            return Optional.of(this);
        }
        return Optional.empty();
    }

    @Override
    public void executeFail() {
        int count = failHistory.getOrDefault(tag, 0);
        failHistory.put(tag, ++count);
    }
}
