package Todo;

import commandandtag.CommandAndTag;
import commandandtag.EmptyTag;
import commandandtag.Tag;
import commandandtag.TagManager;

public class TodoService {
    private final static TodoService TODO_SERVICE = new TodoService();
    private final static TagManager tagManager = TagManager.getInstance();

    public TodoService() {
    }
    public static TodoService getTaskService() {
        return TODO_SERVICE;
    }

    public void doTask(CommandAndTag commandAndTag) {
        switch (commandAndTag.getCommand()) {
            case CREATE:
                Tag createTag = create();
                if(createTag.equals(EmptyTag.EMPTY_TAG)){
                    tagManager.executeFail(createTag);
                } else {
                    tagManager.addTodo(createTag);
                }
                break;
            case EXECUTE:
                // Tag 값이 null 인지 체크를 어디서 해야하지??
                Tag executeTag = commandAndTag.getTag();
                boolean result = execute(executeTag);
                if(!result){
                    tagManager.executeFail(executeTag);
                }
                break;
            case ERROR:
                throw new IllegalArgumentException("존재하지 않는 명령어입니다.");
        }
    }

    private boolean execute(Tag target) {
        // 먼저 target이 null이면 안된다
        if(target == null){
            return false;
        }

        Tag todo = tagManager.getTodo(target);
        if(todo.equals(EmptyTag.EMPTY_TAG)){
            tagManager.executeFail(target);
            return false;
        }
        return true;
    }

    private Tag create() {
        Tag minTag = tagManager.getMinTag();
        if(minTag == null){
            return new EmptyTag();
        }
        return minTag;
    }

    private void failHandler(Tag tag) {
        tagManager.executeFail(tag);
    }

    public void printTodoHistory() {
        tagManager.printTodoHistory();
    }
}
