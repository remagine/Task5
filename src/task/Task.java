package task;

import java.util.Optional;

public interface Task {
    Optional<FailTask> doTask();

}
