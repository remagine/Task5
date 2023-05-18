package commandandtag;

import java.util.HashSet;
import java.util.TreeSet;

public class TagManager {
    private final static TreeSet<Tag> tagHashSet = new TreeSet<>();

    static {
        for (int i = 1; i <= 9; i++) {
            tagHashSet.add(new Tag(i));
        }
    }

    public Tag getMinTag() {
        Tag tag = tagHashSet.pollFirst();
        if(tag == null){
            tag = new EmptyTag();
        }
        return tag;
    }
}
