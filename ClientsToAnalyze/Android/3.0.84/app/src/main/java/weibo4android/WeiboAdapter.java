package weibo4android;

import java.util.List;

/* loaded from: classes.dex */
public class WeiboAdapter implements WeiboListener {
    @Override // weibo4android.WeiboListener
    public void gotHomeTimeline(List<Status> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotPublicTimeline(List<Status> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotFriendsTimeline(List<Status> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotUserTimeline(List<Status> list) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void gotShow(Status status) {
    }

    @Override // weibo4android.WeiboListener
    public void gotShowStatus(Status status) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void updated(Status status) {
    }

    @Override // weibo4android.WeiboListener
    public void updatedStatus(Status status) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void gotReplies(List<Status> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotMentions(List<Status> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotRetweetedByMe(List<Status> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotRetweetedToMe(List<Status> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotRetweetsOfMe(List<Status> list) {
    }

    @Override // weibo4android.WeiboListener
    public void destroyedStatus(Status status) {
    }

    @Override // weibo4android.WeiboListener
    public void retweetedStatus(Status status) {
    }

    @Override // weibo4android.WeiboListener
    public void gotFriends(List<User> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotFollowers(List<User> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotFeatured(List<User> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotUserDetail(User user) {
    }

    @Override // weibo4android.WeiboListener
    public void gotDirectMessages(List<DirectMessage> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotSentDirectMessages(List<DirectMessage> list) {
    }

    @Override // weibo4android.WeiboListener
    public void sentDirectMessage(DirectMessage directMessage) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void deletedDirectMessage(DirectMessage directMessage) {
    }

    @Override // weibo4android.WeiboListener
    public void destroyedDirectMessage(DirectMessage directMessage) {
    }

    @Override // weibo4android.WeiboListener
    public void gotFriendsIDs(IDs iDs) {
    }

    @Override // weibo4android.WeiboListener
    public void gotFollowersIDs(IDs iDs) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void created(User user) {
    }

    @Override // weibo4android.WeiboListener
    public void createdFriendship(User user) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void destroyed(User user) {
    }

    @Override // weibo4android.WeiboListener
    public void destroyedFriendship(User user) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void gotExists(boolean z) {
    }

    @Override // weibo4android.WeiboListener
    public void gotExistsFriendship(boolean z) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void updatedLocation(User user) {
    }

    @Override // weibo4android.WeiboListener
    public void updatedProfile(User user) {
    }

    @Override // weibo4android.WeiboListener
    public void updatedProfileColors(User user) {
    }

    @Override // weibo4android.WeiboListener
    public void gotRateLimitStatus(RateLimitStatus rateLimitStatus) {
    }

    @Override // weibo4android.WeiboListener
    public void updatedDeliverlyDevice(User user) {
    }

    @Override // weibo4android.WeiboListener
    public void gotFavorites(List<Status> list) {
    }

    @Override // weibo4android.WeiboListener
    public void createdFavorite(Status status) {
    }

    @Override // weibo4android.WeiboListener
    public void destroyedFavorite(Status status) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void followed(User user) {
    }

    @Override // weibo4android.WeiboListener
    public void enabledNotification(User user) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void left(User user) {
    }

    @Override // weibo4android.WeiboListener
    public void disabledNotification(User user) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void blocked(User user) {
    }

    @Override // weibo4android.WeiboListener
    public void createdBlock(User user) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void unblocked(User user) {
    }

    @Override // weibo4android.WeiboListener
    public void destroyedBlock(User user) {
    }

    @Override // weibo4android.WeiboListener
    public void gotExistsBlock(boolean z) {
    }

    @Override // weibo4android.WeiboListener
    public void gotBlockingUsers(List<User> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotBlockingUsersIDs(IDs iDs) {
    }

    @Override // weibo4android.WeiboListener
    public void tested(boolean z) {
    }

    @Override // weibo4android.WeiboListener
    @Deprecated
    public void gotDowntimeSchedule(String str) {
    }

    @Override // weibo4android.WeiboListener
    public void searched(QueryResult queryResult) {
    }

    @Override // weibo4android.WeiboListener
    public void gotTrends(Trends trends) {
    }

    @Override // weibo4android.WeiboListener
    public void gotCurrentTrends(Trends trends) {
    }

    @Override // weibo4android.WeiboListener
    public void gotDailyTrends(List<Trends> list) {
    }

    @Override // weibo4android.WeiboListener
    public void gotWeeklyTrends(List<Trends> list) {
    }

    @Override // weibo4android.WeiboListener
    public void onException(WeiboException weiboException, int i) {
    }
}
