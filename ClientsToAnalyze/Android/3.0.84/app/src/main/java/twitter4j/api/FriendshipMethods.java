package twitter4j.api;

import twitter4j.Friendship;
import twitter4j.IDs;
import twitter4j.Relationship;
import twitter4j.ResponseList;
import twitter4j.User;

/* loaded from: classes.dex */
public interface FriendshipMethods {
    User createFriendship(long j);

    User createFriendship(long j, boolean z);

    User createFriendship(String str);

    User createFriendship(String str, boolean z);

    User destroyFriendship(long j);

    User destroyFriendship(String str);

    boolean existsFriendship(String str, String str2);

    IDs getIncomingFriendships(long j);

    IDs getNoRetweetIds();

    IDs getOutgoingFriendships(long j);

    ResponseList<Friendship> lookupFriendships(long[] jArr);

    ResponseList<Friendship> lookupFriendships(String[] strArr);

    Relationship showFriendship(long j, long j2);

    Relationship showFriendship(String str, String str2);

    Relationship updateFriendship(long j, boolean z, boolean z2);

    Relationship updateFriendship(String str, boolean z, boolean z2);
}
