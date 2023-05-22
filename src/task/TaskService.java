package task;

import commandandtag.*;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class TaskService {
    private final static TaskService TODO_SERVICE = new TaskService();
    public final static ConcurrentSkipListSet<Tag> availableTags = new ConcurrentSkipListSet<>();
    public final static ConcurrentHashMap<Tag, Integer> failHistory = new ConcurrentHashMap<>();

    static {
        for (int i = 1; i <= 9; i++) {
            availableTags.add(new Tag(i));
        }
    }

    public static TaskService getTaskService() {
        return TODO_SERVICE;
    }

    public Optional<FailTask> doTask(CommandAndTag commandAndTag) {
        Task task = commandAndTag.getTask();
        return task.doTask();
    }

    public void printTaskHistory() {
        int createFailCnt = failHistory.getOrDefault(EmptyTag.EMPTY_TAG, 0);
        failHistory.remove(EmptyTag.EMPTY_TAG);
        System.out.println(createFailCnt);
        System.out.println(availableTags);
        System.out.println(failHistory);
    }
}
