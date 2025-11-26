package twitter4j.api;

import twitter4j.PagableResponseList;
import twitter4j.ProfileImage;
import twitter4j.ResponseList;
import twitter4j.User;

/* loaded from: classes.dex */
public interface UserMethods {
    PagableResponseList getFollowersStatuses(long j);

    PagableResponseList getFollowersStatuses(long j, long j2);

    PagableResponseList getFollowersStatuses(String str, long j);

    PagableResponseList getFriendsStatuses(long j);

    PagableResponseList getFriendsStatuses(long j, long j2);

    PagableResponseList getFriendsStatuses(String str, long j);

    ResponseList getMemberSuggestions(String str);

    ProfileImage getProfileImage(String str, ProfileImage.ImageSize imageSize);

    ResponseList getSuggestedUserCategories();

    ResponseList getUserSuggestions(String str);

    ResponseList lookupUsers(long[] jArr);

    ResponseList lookupUsers(String[] strArr);

    ResponseList searchUsers(String str, int i);

    User showUser(long j);

    User showUser(String str);
}
