package twitter4j.api;

import twitter4j.PagableResponseList;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.UserList;

/* loaded from: classes.dex */
public interface ListMethods {
    UserList createUserList(String str, boolean z, String str2);

    UserList destroyUserList(int i);

    ResponseList<UserList> getAllUserLists(long j);

    ResponseList<UserList> getAllUserLists(String str);

    PagableResponseList<UserList> getUserListMemberships(long j);

    PagableResponseList<UserList> getUserListMemberships(long j, long j2);

    PagableResponseList<UserList> getUserListMemberships(long j, long j2, boolean z);

    PagableResponseList<UserList> getUserListMemberships(String str, long j);

    PagableResponseList<UserList> getUserListMemberships(String str, long j, boolean z);

    ResponseList<Status> getUserListStatuses(int i, Paging paging);

    ResponseList<Status> getUserListStatuses(long j, int i, Paging paging);

    ResponseList<Status> getUserListStatuses(String str, int i, Paging paging);

    PagableResponseList<UserList> getUserListSubscriptions(String str, long j);

    PagableResponseList<UserList> getUserLists(long j, long j2);

    PagableResponseList<UserList> getUserLists(String str, long j);

    UserList showUserList(int i);

    UserList showUserList(String str, int i);

    UserList updateUserList(int i, String str, boolean z, String str2);
}
