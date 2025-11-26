package weibo4android;

import java.util.List;

/* loaded from: classes.dex */
public interface WeiboListener {
    @Deprecated
    void blocked(User user);

    @Deprecated
    void created(User user);

    void createdBlock(User user);

    void createdFavorite(Status status);

    void createdFriendship(User user);

    @Deprecated
    void deletedDirectMessage(DirectMessage directMessage);

    @Deprecated
    void destroyed(User user);

    void destroyedBlock(User user);

    void destroyedDirectMessage(DirectMessage directMessage);

    void destroyedFavorite(Status status);

    void destroyedFriendship(User user);

    void destroyedStatus(Status status);

    void disabledNotification(User user);

    void enabledNotification(User user);

    @Deprecated
    void followed(User user);

    void gotBlockingUsers(List<User> list);

    void gotBlockingUsersIDs(IDs iDs);

    void gotCurrentTrends(Trends trends);

    void gotDailyTrends(List<Trends> list);

    void gotDirectMessages(List<DirectMessage> list);

    @Deprecated
    void gotDowntimeSchedule(String str);

    @Deprecated
    void gotExists(boolean z);

    void gotExistsBlock(boolean z);

    void gotExistsFriendship(boolean z);

    void gotFavorites(List<Status> list);

    void gotFeatured(List<User> list);

    void gotFollowers(List<User> list);

    void gotFollowersIDs(IDs iDs);

    void gotFriends(List<User> list);

    void gotFriendsIDs(IDs iDs);

    void gotFriendsTimeline(List<Status> list);

    void gotHomeTimeline(List<Status> list);

    void gotMentions(List<Status> list);

    void gotPublicTimeline(List<Status> list);

    void gotRateLimitStatus(RateLimitStatus rateLimitStatus);

    @Deprecated
    void gotReplies(List<Status> list);

    void gotRetweetedByMe(List<Status> list);

    void gotRetweetedToMe(List<Status> list);

    void gotRetweetsOfMe(List<Status> list);

    void gotSentDirectMessages(List<DirectMessage> list);

    @Deprecated
    void gotShow(Status status);

    void gotShowStatus(Status status);

    void gotTrends(Trends trends);

    void gotUserDetail(User user);

    void gotUserTimeline(List<Status> list);

    void gotWeeklyTrends(List<Trends> list);

    @Deprecated
    void left(User user);

    void onException(WeiboException weiboException, int i);

    void retweetedStatus(Status status);

    void searched(QueryResult queryResult);

    void sentDirectMessage(DirectMessage directMessage);

    void tested(boolean z);

    @Deprecated
    void unblocked(User user);

    @Deprecated
    void updated(Status status);

    void updatedDeliverlyDevice(User user);

    @Deprecated
    void updatedLocation(User user);

    void updatedProfile(User user);

    void updatedProfileColors(User user);

    void updatedStatus(Status status);
}
