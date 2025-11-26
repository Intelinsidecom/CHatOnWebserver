package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface StatusDeletionNotice extends Serializable, Comparable<StatusDeletionNotice> {
    long getStatusId();

    long getUserId();
}
