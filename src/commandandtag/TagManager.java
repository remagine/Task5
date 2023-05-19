package commandandtag;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class TagManager {
    private final static ConcurrentSkipListSet<Tag> availableTags = new ConcurrentSkipListSet<>();
    private final static HashSet<Tag> toDoTags = new HashSet<>();
    private final static ConcurrentHashMap<Tag, Integer> failHistory = new ConcurrentHashMap<>();

    static {
        for (int i = 1; i <= 9; i++) {
            availableTags.add(new Tag(i));
        }
    }

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
            return target;
        }
        return new EmptyTag();
    }
}
