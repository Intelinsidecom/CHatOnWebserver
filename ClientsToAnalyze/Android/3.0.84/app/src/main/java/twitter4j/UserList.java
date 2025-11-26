package twitter4j;

import java.io.Serializable;
import java.net.URI;

/* loaded from: classes.dex */
public interface UserList extends Serializable, Comparable<UserList>, TwitterResponse {
    String getDescription();

    String getFullName();

    int getId();

    int getMemberCount();

    String getName();

    String getSlug();

    int getSubscriberCount();

    URI getURI();

    User getUser();

    boolean isFollowing();

    boolean isPublic();
}
