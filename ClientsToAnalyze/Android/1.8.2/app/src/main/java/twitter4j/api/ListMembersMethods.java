package twitter4j.api;

import twitter4j.PagableResponseList;
import twitter4j.User;
import twitter4j.UserList;

/* loaded from: classes.dex */
public interface ListMembersMethods {
    UserList addUserListMember(int i, long j);

    UserList addUserListMembers(int i, long[] jArr);

    UserList addUserListMembers(int i, String[] strArr);

    User checkUserListMembership(String str, int i, long j);

    UserList deleteUserListMember(int i, long j);

    PagableResponseList getUserListMembers(int i, long j);

    PagableResponseList getUserListMembers(long j, int i, long j2);

    PagableResponseList getUserListMembers(String str, int i, long j);

    User showUserListMembership(int i, long j);
}
