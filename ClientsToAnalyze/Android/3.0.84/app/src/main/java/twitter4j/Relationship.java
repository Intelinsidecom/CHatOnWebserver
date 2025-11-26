package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface Relationship extends Serializable, TwitterResponse {
    long getSourceUserId();

    String getSourceUserScreenName();

    long getTargetUserId();

    String getTargetUserScreenName();

    boolean isSourceBlockingTarget();

    boolean isSourceFollowedByTarget();

    boolean isSourceFollowingTarget();

    boolean isSourceNotificationsEnabled();

    boolean isTargetFollowedBySource();

    boolean isTargetFollowingSource();
}
