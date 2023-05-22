package commandandtag;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class TagManager {
    private final static TagManager TAG_MANAGER = new TagManager();
    private final static ConcurrentSkipListSet<Tag> availableTags = new ConcurrentSkipListSet<>();
    private final static HashSet<Tag> toDoTags = new HashSet<>();
    private final static ConcurrentHashMap<Tag, Integer> failHistory = new ConcurrentHashMap<>();

    static {
        for (int i = 1; i <= 9; i++) {
            availableTags.add(new Tag(i));
        }
    }

    public static TagManager getInstance(){
        return TAG_MANAGER;
    };

    public Tag getMinTag() {
        //        if (tag == null) {
//            tag = new EmptyTag();
//        }
        return availableTags.pollFirst();
    }

    public void addTodo(Tag minTag) {
        toDoTags.add(minTag);
    }

    public void executeFail(Tag tag) {
        int count = failHistory.getOrDefault(tag, 0);
        failHistory.put(tag, ++count);
    }

    public Tag getTodo(Tag target) {
        if(toDoTags.contains(target)){
            toDoTags.remove(target);
            return target;
        }
        return new EmptyTag();
    }

    public void printTodoHistory() {
        int createFailCnt = failHistory.getOrDefault(EmptyTag.EMPTY_TAG,0);
        System.out.println(createFailCnt);
        failHistory.remove(EmptyTag.EMPTY_TAG);
        System.out.println(failHistory);
        System.out.println(availableTags);
        System.out.println(toDoTags);
    }

    public void returnTag(Tag todo) {
        availableTags.add(todo);
    }


}
