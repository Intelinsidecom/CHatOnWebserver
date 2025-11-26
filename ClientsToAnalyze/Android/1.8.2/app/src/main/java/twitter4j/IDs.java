package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface IDs extends Serializable, CursorSupport, TwitterResponse {
    long[] getIDs();

    @Override // twitter4j.CursorSupport
    long getNextCursor();

    @Override // twitter4j.CursorSupport
    long getPreviousCursor();

    @Override // twitter4j.CursorSupport
    boolean hasNext();

    @Override // twitter4j.CursorSupport
    boolean hasPrevious();
}
