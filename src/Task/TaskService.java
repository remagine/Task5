package Task;

import commandandtag.CommandAndTag;
import commandandtag.Tag;
import commandandtag.TagManager;

public class TaskService {
    private final static TaskService taskService = new TaskService();
    private final static TagManager tagManager = new TagManager();
    public TaskService() {
    }
    public static TaskService getTaskService() {
        return taskService;
    }

    public void doTask(CommandAndTag commandAndTag) {
        switch (commandAndTag.getCommand()) {
            case CREATE:
                create();
                break;
            case EXECUTE:
                execute(commandAndTag.getTag());
                break;
            case ERROR:
                throw new IllegalArgumentException("존재하지 않는 명령어입니다.");
        }

    }

    private void execute(Tag tag) {
        // 생성된 태그 목록에서 tag로 조회
        // 값이 있으면 실행하고 생성된 목록에서 제거
        // 값이 없으면 실행 실패
        failHandler(tag); // 해당 태그의 실패횟수를 증가
    }

    private void create() {
        // 가장 작은 tag를 가져온다
        Tag minTag = tagManager.getMinTag();
        if(minTag == null){
            failHandler(minTag); // emptyTag의 실패횟수를 증가
        }
    }

    private void failHandler(Tag minTag) {


    }
}
