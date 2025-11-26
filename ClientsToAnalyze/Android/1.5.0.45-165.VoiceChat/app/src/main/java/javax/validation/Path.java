package javax.validation;

/* loaded from: classes.dex */
public interface Path extends Iterable<Node> {

    public interface Node {
        Integer getIndex();

        Object getKey();

        String getName();

        boolean isInIterable();
    }
}
