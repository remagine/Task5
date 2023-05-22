package task;

import commandandtag.Tag;

import java.util.Optional;

import static task.TaskService.availableTags;
import static task.TaskService.failHistory;

public class ExecuteTask implements Task, FailTask {
    private final Tag tag;

    public ExecuteTask(Tag tag) {
        this.tag = tag;
    }

    @Override
    public Optional<FailTask> doTask() {
        if (tag.getTag() < 1 || tag.getTag() > 9) {
            return Optional.of(this);
        }

        boolean contains = availableTags.contains(tag);
        if (contains) {
            return Optional.of(this);
        }

        availableTags.add(tag);
        return Optional.empty();
    }

    @Override
    public void executeFail() {
        int count = failHistory.getOrDefault(tag, 0);
        failHistory.put(tag, ++count);
    }
}
