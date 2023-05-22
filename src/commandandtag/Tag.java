package commandandtag;

import java.util.Objects;

public class Tag implements Comparable<Tag>{
    private final Integer tag;

    public Tag(Integer tag) {
        this.tag = tag;
    }

    public static Tag from(String s) {
        try {
            int tag = Integer.parseInt(s);
            return new Tag(tag);
        } catch (NumberFormatException e) {
            System.err.println("유효하지 않은 숫자 형식입니다: " + s);
            e.printStackTrace();
            return EmptyTag.EMPTY_TAG;
        }
    }

    public Integer getTag() {
        return tag;
    }

    @Override
    public int compareTo(Tag o) {
        return Integer.compare(tag, o.tag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag1 = (Tag) o;

        return Objects.equals(tag, tag1.tag);
    }

    @Override
    public int hashCode() {
        return tag != null ? tag.hashCode() : 0;
    }
}
