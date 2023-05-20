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
                    tagManager.executeFail(EmptyTag.EMPTY_TAG);
                } else {
                    tagManager.addTodo(createTag);
                }
                break;
            case EXECUTE:
                // Tag 값이 null 인지 체크를 어디서 해야하지??
                Tag executeTag = commandAndTag.getTag();
                Tag doneTag = execute(executeTag);
                if(doneTag.equals(EmptyTag.EMPTY_TAG)){
                    tagManager.executeFail(executeTag);
                }
                break;
            case ERROR:
                throw new IllegalArgumentException("존재하지 않는 명령어입니다.");
        }
    }

    private Tag execute(Tag target) {
        Tag todo = tagManager.getTodo(target);
        if(todo.equals(EmptyTag.EMPTY_TAG)){
            return EmptyTag.EMPTY_TAG;
        }
        tagManager.returnTag(todo);
        return todo;
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
