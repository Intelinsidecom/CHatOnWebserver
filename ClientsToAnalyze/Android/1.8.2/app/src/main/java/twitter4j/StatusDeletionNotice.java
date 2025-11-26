package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface StatusDeletionNotice extends Serializable, Comparable {
    long getStatusId();

    long getUserId();
}
