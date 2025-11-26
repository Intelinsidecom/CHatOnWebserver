package twitter4j.api;

import twitter4j.IDs;
import twitter4j.ResponseList;
import twitter4j.User;

/* loaded from: classes.dex */
public interface BlockMethods {
    User createBlock(long j);

    User createBlock(String str);

    User destroyBlock(long j);

    User destroyBlock(String str);

    boolean existsBlock(long j);

    boolean existsBlock(String str);

    ResponseList getBlockingUsers();

    ResponseList getBlockingUsers(int i);

    IDs getBlockingUsersIDs();
}
