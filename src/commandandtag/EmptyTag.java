package commandandtag;

public class EmptyTag extends Tag {
    public final static EmptyTag EMPTY_TAG = new EmptyTag();

    public EmptyTag() {
        super(null);
    }
}
