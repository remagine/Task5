package commandandtag;

public class Tag {
    private final int tag;

    public Tag(int tag) {
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
}
