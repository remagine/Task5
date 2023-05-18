package commandandtag;

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
            return null;
        }
    }

    @Override
    public int compareTo(Tag o) {
        return Integer.compare(tag, o.tag);
    }
}
