package commandandtag;

import java.util.concurrent.ConcurrentSkipListSet;

public class AvailableTags {
    private final static ConcurrentSkipListSet<Tag> availableTags = new ConcurrentSkipListSet<>();

    static {
        for (int i = 1; i <= 9; i++) {
            availableTags.add(new Tag(i));
        }
    }


}
