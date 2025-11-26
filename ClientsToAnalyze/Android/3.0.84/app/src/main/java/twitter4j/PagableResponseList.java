package twitter4j;

import twitter4j.TwitterResponse;

/* loaded from: classes.dex */
public interface PagableResponseList<T extends TwitterResponse> extends CursorSupport, ResponseList<T> {
    @Override // twitter4j.CursorSupport
    long getNextCursor();

    @Override // twitter4j.CursorSupport
    long getPreviousCursor();

    @Override // twitter4j.CursorSupport
    boolean hasNext();

    @Override // twitter4j.CursorSupport
    boolean hasPrevious();
}
