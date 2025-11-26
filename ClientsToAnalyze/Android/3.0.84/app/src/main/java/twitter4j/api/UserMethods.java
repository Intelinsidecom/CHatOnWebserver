package twitter4j.api;

import twitter4j.Category;
import twitter4j.PagableResponseList;
import twitter4j.ProfileImage;
import twitter4j.ResponseList;
import twitter4j.User;

/* loaded from: classes.dex */
public interface UserMethods {
    PagableResponseList<User> getFollowersStatuses(long j);

    PagableResponseList<User> getFollowersStatuses(long j, long j2);

    PagableResponseList<User> getFollowersStatuses(String str, long j);

    PagableResponseList<User> getFriendsStatuses(long j);

    PagableResponseList<User> getFriendsStatuses(long j, long j2);

    PagableResponseList<User> getFriendsStatuses(String str, long j);

    ResponseList<User> getMemberSuggestions(String str);

    ProfileImage getProfileImage(String str, ProfileImage.ImageSize imageSize);

    ResponseList<Category> getSuggestedUserCategories();

    ResponseList<User> getUserSuggestions(String str);

    ResponseList<User> lookupUsers(long[] jArr);

    ResponseList<User> lookupUsers(String[] strArr);

    ResponseList<User> searchUsers(String str, int i);

    User showUser(long j);

    User showUser(String str);
}
