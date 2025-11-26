package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface Friendship extends Serializable {
    long getId();

    String getName();

    String getScreenName();

    boolean isFollowedBy();

    boolean isFollowing();
}
