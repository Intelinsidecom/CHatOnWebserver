package twitter4j.api;

import twitter4j.PagableResponseList;
import twitter4j.User;
import twitter4j.UserList;

/* loaded from: classes.dex */
public interface ListSubscribersMethods {
    User checkUserListSubscription(String str, int i, long j);

    UserList createUserListSubscription(int i);

    UserList destroyUserListSubscription(int i);

    PagableResponseList<User> getUserListSubscribers(int i, long j);

    PagableResponseList<User> getUserListSubscribers(String str, int i, long j);

    User showUserListSubscription(int i, long j);

    UserList subscribeUserList(String str, int i);

    UserList unsubscribeUserList(String str, int i);
}
