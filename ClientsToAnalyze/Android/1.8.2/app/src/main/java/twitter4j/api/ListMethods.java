package twitter4j.api;

import twitter4j.PagableResponseList;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.UserList;

/* loaded from: classes.dex */
public interface ListMethods {
    UserList createUserList(String str, boolean z, String str2);

    UserList destroyUserList(int i);

    ResponseList getAllUserLists(long j);

    ResponseList getAllUserLists(String str);

    PagableResponseList getUserListMemberships(long j);

    PagableResponseList getUserListMemberships(long j, long j2);

    PagableResponseList getUserListMemberships(long j, long j2, boolean z);

    PagableResponseList getUserListMemberships(String str, long j);

    PagableResponseList getUserListMemberships(String str, long j, boolean z);

    ResponseList getUserListStatuses(int i, Paging paging);

    ResponseList getUserListStatuses(long j, int i, Paging paging);

    ResponseList getUserListStatuses(String str, int i, Paging paging);

    PagableResponseList getUserListSubscriptions(String str, long j);

    PagableResponseList getUserLists(long j, long j2);

    PagableResponseList getUserLists(String str, long j);

    UserList showUserList(int i);

    UserList showUserList(String str, int i);

    UserList updateUserList(int i, String str, boolean z, String str2);
}
