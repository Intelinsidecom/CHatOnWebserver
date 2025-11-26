package twitter4j.api;

import twitter4j.IDs;

/* loaded from: classes.dex */
public interface FriendsFollowersMethods {
    IDs getFollowersIDs(long j);

    IDs getFollowersIDs(long j, long j2);

    IDs getFollowersIDs(String str, long j);

    IDs getFriendsIDs(long j);

    IDs getFriendsIDs(long j, long j2);

    IDs getFriendsIDs(String str, long j);
}
