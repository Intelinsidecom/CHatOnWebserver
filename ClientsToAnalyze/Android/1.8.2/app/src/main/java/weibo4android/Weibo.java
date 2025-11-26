package weibo4android;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import twitter4j.conf.PropertyConfiguration;
import weibo4android.http.AccessToken;
import weibo4android.http.HttpClient;
import weibo4android.http.ImageItem;
import weibo4android.http.PostParameter;
import weibo4android.http.RequestToken;
import weibo4android.http.Response;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;
import weibo4android.util.URLEncodeUtils;

/* loaded from: classes.dex */
public class Weibo extends WeiboSupport implements Serializable {
    private static final long serialVersionUID = -1486360080128882436L;
    private String baseURL;
    private SimpleDateFormat format;
    private String searchBaseURL;
    public static String CONSUMER_KEY = "";
    public static String CONSUMER_SECRET = "";

    /* renamed from: IM */
    public static final Device f7919IM = new Device("im");
    public static final Device SMS = new Device("sms");
    public static final Device NONE = new Device("none");

    public void setupConsumerConfig(String str, String str2) {
        CONSUMER_KEY = str;
        CONSUMER_SECRET = str2;
        System.setProperty("weibo4j.oauth.consumerKey", str);
        System.setProperty("weibo4j.oauth.consumerSecret", str2);
    }

    public static String getAppKey() {
        return CONSUMER_KEY;
    }

    public static String getAppSecret() {
        return CONSUMER_SECRET;
    }

    public List searchUser(Query query) {
        return User.constructUsers(get(String.valueOf(this.searchBaseURL) + "users/search.json", query.getParameters(), false));
    }

    public List search(Query query) {
        return SearchResult.constructResults(get(String.valueOf(this.searchBaseURL) + "search.json", query.getParameters(), true));
    }

    public List statussearch(Query query) {
        return Status.constructStatuses(get(String.valueOf(this.searchBaseURL) + "statuses/search.json", query.getParameters(), true));
    }

    public List getFavorites(int i) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "favorites.json", "page", String.valueOf(i), true));
    }

    public Status createFavorite(long j) {
        return new Status(this.http.post(String.valueOf(getBaseURL()) + "favorites/create/" + j + ".json", true));
    }

    public Status destroyFavorite(long j) {
        return new Status(this.http.post(String.valueOf(getBaseURL()) + "favorites/destroy/" + j + ".json", true));
    }

    public List destroyFavorites(String str) {
        return Status.constructStatuses(this.http.post(String.valueOf(getBaseURL()) + "favorites/destroy_batch.json", new PostParameter[]{new PostParameter("ids", str)}, true));
    }

    public List destroyFavorites(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return Status.constructStatuses(this.http.post(String.valueOf(getBaseURL()) + "favorites/destroy_batch.json", new PostParameter[]{new PostParameter("ids", sb.toString())}, true));
    }

    public User verifyCredentials() {
        return new User(get(String.valueOf(getBaseURL()) + "account/verify_credentials.json", true).asJSONObject());
    }

    public User updateProfile(String str, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList(5);
        addParameterToList(arrayList, "name", str);
        addParameterToList(arrayList, "email", str2);
        addParameterToList(arrayList, RtspHeaders.Values.URL, str3);
        addParameterToList(arrayList, "location", str4);
        addParameterToList(arrayList, "description", str5);
        return new User(this.http.post(String.valueOf(getBaseURL()) + "account/update_profile.json", (PostParameter[]) arrayList.toArray(new PostParameter[arrayList.size()]), true).asJSONObject());
    }

    public User updateProfileImage(File file) {
        return new User(this.http.multPartURL("image", String.valueOf(getBaseURL()) + "account/update_profile_image.json", new PostParameter[]{new PostParameter("source", CONSUMER_KEY)}, file, true).asJSONObject());
    }

    public RateLimitStatus rateLimitStatus() {
        return new RateLimitStatus(this.http.get(String.valueOf(getBaseURL()) + "account/rate_limit_status.json", true), this);
    }

    public User endSession() {
        return new User(get(String.valueOf(getBaseURL()) + "account/end_session.json", true).asJSONObject());
    }

    public List getTags(String str, Paging paging) {
        return Tag.constructTags(get(String.valueOf(getBaseURL()) + "tags.json", new PostParameter[]{new PostParameter("user_id", str)}, paging, true));
    }

    public List createTags(String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strArr) {
            stringBuffer.append(str).append(",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return createTags(stringBuffer.toString());
    }

    public List createTags(String str) {
        return Tag.constructTags(this.http.post(String.valueOf(getBaseURL()) + "tags/create.json", new PostParameter[]{new PostParameter("tags", str)}, true));
    }

    public List getSuggestionsTags() {
        return Tag.constructTags(get(String.valueOf(getBaseURL()) + "tags/suggestions.json", true));
    }

    public boolean destoryTag(String str) throws WeiboException {
        try {
            return this.http.post(new StringBuilder(String.valueOf(getBaseURL())).append("tags/destroy.json").toString(), new PostParameter[]{new PostParameter("tag_id", str)}, true).asJSONObject().getInt("result") == 0;
        } catch (JSONException e) {
            throw new WeiboException(e);
        }
    }

    public List destory_batchTags(String str) {
        return Tag.constructTags(this.http.post(String.valueOf(getBaseURL()) + "tags/destroy_batch.json", new PostParameter[]{new PostParameter("ids", str)}, true));
    }

    public User createBlock(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "blocks/create.json", new PostParameter[]{new PostParameter("user_id", str)}, true).asJSONObject());
    }

    public User createBlockByScreenName(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "blocks/create.json", new PostParameter[]{new PostParameter("screen_name", str)}, true).asJSONObject());
    }

    public User destroyBlock(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "blocks/destroy.json", new PostParameter[]{new PostParameter("id", str)}, true).asJSONObject());
    }

    public boolean existsBlock(String str) throws WeiboException {
        try {
            return -1 == get(new StringBuilder(String.valueOf(getBaseURL())).append("blocks/exists.json?user_id=").append(str).toString(), true).asString().indexOf("<error>You are not blocking this user.</error>");
        } catch (WeiboException e) {
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }

    public List getBlockingUsers() {
        return User.constructUsers(get(String.valueOf(getBaseURL()) + "blocks/blocking.json", true));
    }

    public List getBlockingUsers(int i) {
        return User.constructUsers(get(String.valueOf(getBaseURL()) + "blocks/blocking.json?page=" + i, true));
    }

    public IDs getBlockingUsersIDs() {
        return new IDs(get(String.valueOf(getBaseURL()) + "blocks/blocking/ids.json", true), this);
    }

    public User updatePrivacy(Privacy privacy) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "account/update_privacy.json", privacy.getParameters(), true).asJSONObject());
    }

    public Privacy getPrivacy() {
        return new Privacy(this.http.post(String.valueOf(getBaseURL()) + "account/get_privacy.json", true).asJSONObject());
    }

    public IDs getFriendsIDSByUserId(String str, Paging paging) {
        return new IDs(get(String.valueOf(this.baseURL) + "friends/ids.json", new PostParameter[]{new PostParameter("user_id", str)}, paging, true), this);
    }

    public IDs getFriendsIDSByScreenName(String str, Paging paging) {
        return new IDs(get(String.valueOf(this.baseURL) + "friends/ids.json", new PostParameter[]{new PostParameter("screen_name", str)}, paging, true), this);
    }

    public IDs getFollowersIDSByUserId(String str, Paging paging) {
        return new IDs(get(String.valueOf(this.baseURL) + "followers/ids.json", new PostParameter[]{new PostParameter("user_id", str)}, paging, true), this);
    }

    public IDs getFollowersIDSByScreenName(String str, Paging paging) {
        return new IDs(get(String.valueOf(this.baseURL) + "followers/ids.json", new PostParameter[]{new PostParameter("screen_name", str)}, paging, true), this);
    }

    public List getTrends(String str, Paging paging) {
        return UserTrend.constructTrendList(get(String.valueOf(this.baseURL) + "trends.json", new PostParameter[]{new PostParameter("user_id", str)}, paging, true));
    }

    public List getTrendStatus(String str, Paging paging) {
        return Status.constructStatuses(get(String.valueOf(this.baseURL) + "trends/statuses.json", new PostParameter[]{new PostParameter("trend_name", str)}, paging, true));
    }

    public UserTrend trendsFollow(String str) {
        return new UserTrend(this.http.post(String.valueOf(this.baseURL) + "trends/follow.json", new PostParameter[]{new PostParameter("trend_name", str)}, true));
    }

    public boolean trendsDestroy(String str) throws WeiboException {
        try {
            return this.http.delete(String.valueOf(this.baseURL) + "trends/destroy.json?trend_id=" + str + "&source=" + CONSUMER_KEY, true).asJSONObject().getBoolean("result");
        } catch (JSONException e) {
            throw new WeiboException("e");
        }
    }

    public List getTrendsHourly(Integer num) {
        if (num == null) {
            num = 0;
        }
        return Trends.constructTrendsList(get(String.valueOf(this.baseURL) + "trends/hourly.json", "base_app", num.toString(), true));
    }

    public List getTrendsDaily(Integer num) {
        if (num == null) {
            num = 0;
        }
        return Trends.constructTrendsList(get(String.valueOf(this.baseURL) + "trends/daily.json", "base_app", num.toString(), true));
    }

    public List getTrendsWeekly(Integer num) {
        if (num == null) {
            num = 0;
        }
        return Trends.constructTrendsList(get(String.valueOf(this.baseURL) + "trends/weekly.json", "base_app", num.toString(), true));
    }

    private String toDateStr(Date date) {
        if (date == null) {
            date = new Date();
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public User createFriendship(String str) {
        return new User(get(String.valueOf(getBaseURL()) + "friendships/create.json", "id", str, true).asJSONObject());
    }

    public User createFriendshipByScreenName(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "friendships/create.json", new PostParameter[]{new PostParameter("screen_name", str)}, true).asJSONObject());
    }

    public User createFriendshipByUserid(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "friendships/create.json", new PostParameter[]{new PostParameter("user_id", str)}, true).asJSONObject());
    }

    public User destroyFriendship(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "friendships/destroy.json", "id", str, true).asJSONObject());
    }

    public User destroyFriendshipByUserid(int i) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "friendships/destroy.json", "user_id", new StringBuilder().append(i).toString(), true).asJSONObject());
    }

    public User destroyFriendshipByScreenName(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "friendships/destroy.json", "screen_name", str, true).asJSONObject());
    }

    public List getDirectMessages() {
        return DirectMessage.constructDirectMessages(get(String.valueOf(getBaseURL()) + "direct_messages.json", true));
    }

    public List getDirectMessages(Paging paging) {
        return DirectMessage.constructDirectMessages(get(String.valueOf(getBaseURL()) + "direct_messages.json", (PostParameter[]) null, paging, true));
    }

    public List getSentDirectMessages() {
        return DirectMessage.constructDirectMessages(get(String.valueOf(getBaseURL()) + "direct_messages/sent.json", new PostParameter[0], true));
    }

    public List getSentDirectMessages(Paging paging) {
        return DirectMessage.constructDirectMessages(get(String.valueOf(getBaseURL()) + "direct_messages/sent.json", new PostParameter[0], paging, true));
    }

    public DirectMessage sendDirectMessage(String str, String str2) {
        return new DirectMessage(this.http.post(String.valueOf(getBaseURL()) + "direct_messages/new.json", new PostParameter[]{new PostParameter("user_id", str), new PostParameter("text", str2), new PostParameter("source", this.source)}, true).asJSONObject());
    }

    public DirectMessage sendDirectMessageByScreenName(String str, String str2) {
        return new DirectMessage(this.http.post(String.valueOf(getBaseURL()) + "direct_messages/new.json", new PostParameter[]{new PostParameter("screen_name", str), new PostParameter("text", str2), new PostParameter("source", this.source)}, true).asJSONObject());
    }

    public DirectMessage destroyDirectMessage(long j) {
        return new DirectMessage(this.http.post(String.valueOf(getBaseURL()) + "direct_messages/destroy/" + j + ".json", new PostParameter[0], true).asJSONObject());
    }

    public List destroyDirectMessages(String str) {
        return DirectMessage.constructDirectMessages(this.http.post(String.valueOf(getBaseURL()) + "direct_messages/destroy_batch.json", new PostParameter[]{new PostParameter("ids", str)}, true));
    }

    public List destroyDirectMessages(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return DirectMessage.constructDirectMessages(this.http.post(String.valueOf(getBaseURL()) + "direct_messages/destroy_batch.json", new PostParameter[]{new PostParameter("ids", sb.toString())}, true));
    }

    public User showUser(String str) {
        return new User(get(String.valueOf(getBaseURL()) + "users/show.json", new PostParameter[]{new PostParameter("id", str)}, this.http.isAuthenticationEnabled()).asJSONObject());
    }

    public List getFriendsStatuses() {
        return User.constructResult(get(String.valueOf(getBaseURL()) + "statuses/friends.json", true));
    }

    public UserWapper getFriendsStatuses2(String str, int i, int i2) {
        return User.constructWapperUsers(get(String.valueOf(getBaseURL()) + "statuses/friends.json", new PostParameter[]{new PostParameter("uid", str), new PostParameter("cursor", i), new PostParameter("count", i2)}, true));
    }

    public List getFriendsStatuses(int i) {
        return User.constructUser(get(String.valueOf(getBaseURL()) + "statuses/friends.json", new PostParameter[]{new PostParameter("cursor", i)}, true));
    }

    public List getFriendsStatuses(String str, Paging paging) {
        return User.constructUsers(get(String.valueOf(getBaseURL()) + "statuses/friends.json", new PostParameter[]{new PostParameter("id", str)}, paging, true));
    }

    public List getFriendsStatuses(Paging paging) {
        return User.constructUsers(get(String.valueOf(getBaseURL()) + "statuses/friends.json", (PostParameter[]) null, paging, true));
    }

    public List getFriendsStatuses(String str) {
        return User.constructUsers(get(String.valueOf(getBaseURL()) + "statuses/friends.json", new PostParameter[]{new PostParameter("id", str)}, false));
    }

    public List getFollowersStatuses() {
        return User.constructResult(get(String.valueOf(getBaseURL()) + "statuses/followers.json", true));
    }

    public List getFollowersStatuses(String str, Paging paging) {
        return User.constructUsers(get(String.valueOf(getBaseURL()) + "statuses/followers.json", new PostParameter[]{new PostParameter("id", str)}, paging, true));
    }

    public List getFollowersStatuses(Paging paging) {
        return User.constructUsers(get(String.valueOf(getBaseURL()) + "statuses/followers.json", (PostParameter[]) null, paging, true));
    }

    public List getFollowersStatuses(int i) {
        return User.constructUser(get(String.valueOf(getBaseURL()) + "statuses/followers.json", new PostParameter[]{new PostParameter("cursor", i)}, true));
    }

    public List getFollowersStatuses(String str) {
        return User.constructUsers(get(String.valueOf(getBaseURL()) + "statuses/followers.json", new PostParameter[]{new PostParameter("id", str)}, true));
    }

    public List getHotUsers(String str) {
        return User.constructUsers(get(String.valueOf(getBaseURL()) + "users/hot.json", "category", str, true));
    }

    public User updateRemark(String str, String str2) {
        if (!URLEncodeUtils.isURLEncoded(str2)) {
            str2 = URLEncodeUtils.encodeURL(str2);
        }
        return new User(this.http.post(String.valueOf(getBaseURL()) + "user/friends/update_remark.json", new PostParameter[]{new PostParameter("user_id", str), new PostParameter("remark", str2)}, true).asJSONObject());
    }

    public User updateRemark(Long l, String str) {
        return updateRemark(Long.toString(l.longValue()), str);
    }

    public List getSuggestionUsers() {
        return User.constructUsers(get(String.valueOf(getBaseURL()) + "users/suggestions.json", "with_reason", "0", true));
    }

    public List getPublicTimeline() {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/public_timeline.json", true));
    }

    public List getPublicTimeline(int i, int i2) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/public_timeline.json", new PostParameter[]{new PostParameter("count", i), new PostParameter("base_app", i2)}, false));
    }

    public List getFriendsTimeline() {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/friends_timeline.json", true));
    }

    public List getFriendsTimeline(Paging paging) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/friends_timeline.json", (PostParameter[]) null, paging, true));
    }

    public List getHomeTimeline() {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/home_timeline.json", true));
    }

    public List getHomeTimeline(Paging paging) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/home_timeline.json", (PostParameter[]) null, paging, true));
    }

    public List getUserTimeline(String str, Paging paging) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/user_timeline.json", new PostParameter[]{new PostParameter("id", str)}, paging, this.http.isAuthenticationEnabled()));
    }

    public List getUserTimeline(String str, Integer num, Integer num2, Paging paging) {
        HashMap map = new HashMap();
        if (str != null) {
            map.put("id", str);
        }
        if (num != null) {
            map.put("base_app", num.toString());
        }
        if (num2 != null) {
            map.put("feature", num2.toString());
        }
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/user_timeline.json", generateParameterArray(map), paging, this.http.isAuthenticationEnabled()));
    }

    public List getUserTimeline(String str) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/user_timeline.json", new PostParameter[]{new PostParameter("id", str)}, this.http.isAuthenticationEnabled()));
    }

    public List getUserTimeline() {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/user_timeline.json", true));
    }

    public List getUserTimeline(Paging paging) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/user_timeline.json", (PostParameter[]) null, paging, true));
    }

    public List getUserTimeline(Integer num, Integer num2, Paging paging) {
        return getUserTimeline(null, num, num2, paging);
    }

    public List getMentions() {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/mentions.json", null, true));
    }

    public List getMentions(Paging paging) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/mentions.json", (PostParameter[]) null, paging, true));
    }

    public List getCommentsTimeline() {
        return Comment.constructComments(get(String.valueOf(getBaseURL()) + "statuses/comments_timeline.json", true));
    }

    public List getCommentsTimeline(Paging paging) {
        return Comment.constructComments(get(String.valueOf(getBaseURL()) + "statuses/comments_timeline.json", (PostParameter[]) null, paging, true));
    }

    public List getCommentsByMe() {
        return Comment.constructComments(get(String.valueOf(getBaseURL()) + "statuses/comments_by_me.json", true));
    }

    public List getCommentsByMe(Paging paging) {
        return Comment.constructComments(get(String.valueOf(getBaseURL()) + "statuses/comments_by_me.json", (PostParameter[]) null, paging, true));
    }

    public List getCommentsToMe() {
        return Comment.constructComments(get(String.valueOf(getBaseURL()) + "statuses/comments_to_me.json", true));
    }

    public List getCommentsToMe(Paging paging) {
        return Comment.constructComments(get(String.valueOf(getBaseURL()) + "statuses/comments_to_me.json", (PostParameter[]) null, paging, true));
    }

    public List getrepostbyme(String str) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/repost_by_me.json", "id", str, true));
    }

    public List getrepostbyme(String str, Paging paging) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/repost_by_me.json", new PostParameter[]{new PostParameter("id", str)}, paging, true));
    }

    public List getreposttimeline(String str) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/repost_timeline.json", "id", str, true));
    }

    public List getreposttimeline(String str, Paging paging) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/repost_timeline.json", new PostParameter[]{new PostParameter("id", str)}, paging, true));
    }

    public List getComments(String str) {
        return Comment.constructComments(get(String.valueOf(getBaseURL()) + "statuses/comments.json", "id", str, true));
    }

    public List getComments(String str, Paging paging) {
        return Comment.constructComments(get(String.valueOf(getBaseURL()) + "statuses/comments.json", new PostParameter[]{new PostParameter("id", str)}, paging, true));
    }

    public List getCounts(String str) {
        return Count.constructCounts(get(String.valueOf(getBaseURL()) + "statuses/counts.json", "ids", str, true));
    }

    public Count getUnread() {
        return new Count(get(String.valueOf(getBaseURL()) + "statuses/unread.json", true));
    }

    public Count getUnread(Integer num, Long l) {
        HashMap map = new HashMap();
        if (num != null) {
            map.put("with_new_status", Integer.toString(num.intValue()));
        }
        if (l != null) {
            map.put("since_id", Long.toString(l.longValue()));
        }
        return new Count(get(String.valueOf(getBaseURL()) + "statuses/unread.json", generateParameterArray(map), true).asJSONObject());
    }

    public Boolean resetCount(int i) throws WeiboException {
        JSONObject jSONObjectAsJSONObject = null;
        try {
            jSONObjectAsJSONObject = this.http.post(String.valueOf(getBaseURL()) + "statuses/reset_count.json", new PostParameter[]{new PostParameter("type", i)}, true).asJSONObject();
            return Boolean.valueOf(jSONObjectAsJSONObject.getBoolean("result"));
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + jSONObjectAsJSONObject, e);
        }
    }

    public List getEmotions(String str, String str2) {
        if (str == null) {
            str = "face";
        }
        if (str2 == null) {
            str2 = "cnname";
        }
        HashMap map = new HashMap();
        map.put("type", str);
        map.put("language", str2);
        return Emotion.constructEmotions(get(String.valueOf(getBaseURL()) + "emotions.json", generateParameterArray(map), true));
    }

    public List getEmotions() {
        return getEmotions(null, null);
    }

    public Status showStatus(String str) {
        return new Status(get(String.valueOf(getBaseURL()) + "statuses/show/" + str + ".json", true));
    }

    public Status showStatus(long j) {
        return showStatus(Long.toString(j));
    }

    public Status updateStatus(String str) {
        return new Status(this.http.post(String.valueOf(getBaseURL()) + "statuses/update.json", new PostParameter[]{new PostParameter("status", str)}, true));
    }

    public Status updateStatus(String str, double d, double d2) {
        return new Status(this.http.post(String.valueOf(getBaseURL()) + "statuses/update.json", new PostParameter[]{new PostParameter("status", str), new PostParameter("lat", d), new PostParameter("long", d2)}, true));
    }

    public Status updateStatus(String str, long j) {
        return new Status(this.http.post(String.valueOf(getBaseURL()) + "statuses/update.json", new PostParameter[]{new PostParameter("status", str), new PostParameter("in_reply_to_status_id", String.valueOf(j)), new PostParameter("source", this.source)}, true));
    }

    public Status updateStatus(String str, long j, double d, double d2) {
        return new Status(this.http.post(String.valueOf(getBaseURL()) + "statuses/update.json", new PostParameter[]{new PostParameter("status", str), new PostParameter("lat", d), new PostParameter("long", d2), new PostParameter("in_reply_to_status_id", String.valueOf(j)), new PostParameter("source", this.source)}, true));
    }

    public Status uploadStatus(String str, ImageItem imageItem) {
        if (!URLEncodeUtils.isURLEncoded(str)) {
            str = URLEncodeUtils.encodeURL(str);
        }
        return new Status(this.http.multPartURL(String.valueOf(getBaseURL()) + "statuses/upload.json", new PostParameter[]{new PostParameter("status", str), new PostParameter("source", this.source)}, imageItem, true));
    }

    public Status uploadStatus(String str, ImageItem imageItem, double d, double d2) {
        if (!URLEncodeUtils.isURLEncoded(str)) {
            str = URLEncodeUtils.encodeURL(str);
        }
        return new Status(this.http.multPartURL(String.valueOf(getBaseURL()) + "statuses/upload.json", new PostParameter[]{new PostParameter("status", str), new PostParameter("source", this.source), new PostParameter("lat", d), new PostParameter("long", d2)}, imageItem, true));
    }

    public Status uploadStatus(String str, File file) {
        if (!URLEncodeUtils.isURLEncoded(str)) {
            str = URLEncodeUtils.encodeURL(str);
        }
        return new Status(this.http.multPartURL(Constants.UPLOAD_MODE, String.valueOf(getBaseURL()) + "statuses/upload.json", new PostParameter[]{new PostParameter("status", str), new PostParameter("source", this.source)}, file, true));
    }

    public Status uploadStatus(String str, File file, double d, double d2) {
        if (!URLEncodeUtils.isURLEncoded(str)) {
            str = URLEncodeUtils.encodeURL(str);
        }
        return new Status(this.http.multPartURL(Constants.UPLOAD_MODE, String.valueOf(getBaseURL()) + "statuses/upload.json", new PostParameter[]{new PostParameter("status", str), new PostParameter("source", this.source), new PostParameter("lat", d), new PostParameter("long", d2)}, file, true));
    }

    public Status destroyStatus(long j) {
        return destroyStatus(Long.toString(j));
    }

    public Status destroyStatus(String str) {
        return new Status(this.http.post(String.valueOf(getBaseURL()) + "statuses/destroy/" + str + ".json", new PostParameter[0], true));
    }

    public Status repost(String str, String str2) {
        return repost(str, str2, 0);
    }

    public Status repost(String str, String str2, int i) {
        return new Status(this.http.post(String.valueOf(getBaseURL()) + "statuses/repost.json", new PostParameter[]{new PostParameter("id", str), new PostParameter("status", str2), new PostParameter("is_comment", i)}, true));
    }

    public Comment updateComment(String str, String str2, String str3) {
        PostParameter[] postParameterArr;
        if (str3 == null) {
            postParameterArr = new PostParameter[]{new PostParameter("comment", str), new PostParameter("id", str2)};
        } else {
            postParameterArr = new PostParameter[]{new PostParameter("comment", str), new PostParameter("cid", str3), new PostParameter("id", str2)};
        }
        return new Comment(this.http.post(String.valueOf(getBaseURL()) + "statuses/comment.json", postParameterArr, true));
    }

    public Comment destroyComment(long j) {
        return new Comment(this.http.delete(String.valueOf(getBaseURL()) + "statuses/comment_destroy/" + j + ".json?source=" + CONSUMER_KEY, true));
    }

    public List destroyComments(String str) {
        return Comment.constructComments(this.http.post(String.valueOf(getBaseURL()) + "statuses/comment/destroy_batch.json", new PostParameter[]{new PostParameter("ids", str)}, true));
    }

    public List destroyComments(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return Comment.constructComments(this.http.post(String.valueOf(getBaseURL()) + "statuses/comment/destroy_batch.json", new PostParameter[]{new PostParameter("ids", sb.toString())}, true));
    }

    public Comment reply(String str, String str2, String str3) {
        return new Comment(this.http.post(String.valueOf(getBaseURL()) + "statuses/reply.json", new PostParameter[]{new PostParameter("id", str), new PostParameter("cid", str2), new PostParameter("comment", str3)}, true));
    }

    public synchronized void setOAuthConsumer(String str, String str2) {
        this.http.setOAuthConsumer(str, str2);
    }

    public RequestToken getOAuthRequestToken() {
        return this.http.getOAuthRequestToken();
    }

    public RequestToken getOAuthRequestToken(String str) {
        return this.http.getOauthRequestToken(str);
    }

    public synchronized AccessToken getOAuthAccessToken(RequestToken requestToken) {
        return this.http.getOAuthAccessToken(requestToken);
    }

    public synchronized AccessToken getOAuthAccessToken(RequestToken requestToken, String str) {
        AccessToken oAuthAccessToken;
        oAuthAccessToken = this.http.getOAuthAccessToken(requestToken, str);
        setUserId(oAuthAccessToken.getScreenName());
        return oAuthAccessToken;
    }

    public synchronized AccessToken getOAuthAccessToken(String str, String str2) {
        AccessToken oAuthAccessToken;
        oAuthAccessToken = this.http.getOAuthAccessToken(str, str2);
        setUserId(oAuthAccessToken.getScreenName());
        return oAuthAccessToken;
    }

    public synchronized AccessToken getOAuthAccessToken(String str, String str2, String str3) {
        return this.http.getOAuthAccessToken(str, str2, str3);
    }

    public synchronized AccessToken getXAuthAccessToken(String str, String str2, String str3) {
        return this.http.getXAuthAccessToken(str, str2, str3);
    }

    public synchronized AccessToken getXAuthAccessToken(String str, String str2) {
        return getXAuthAccessToken(str, str2, Constants.X_AUTH_MODE);
    }

    public void setOAuthAccessToken(AccessToken accessToken) {
        this.http.setOAuthAccessToken(accessToken);
    }

    public void setOAuthAccessToken(String str, String str2) {
        setOAuthAccessToken(new AccessToken(str, str2));
    }

    public RateLimitStatus getRateLimitStatus() {
        return new RateLimitStatus(get(String.valueOf(getBaseURL()) + "account/rate_limit_status.json", true), this);
    }

    public List getRetweetedByMe() {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/retweeted_by_me.json", null, true));
    }

    public List getRetweetedByMe(Paging paging) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/retweeted_by_me.json", null, true));
    }

    public List getRetweetedToMe() {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/retweeted_to_me.json", null, true));
    }

    public List getRetweetedToMe(Paging paging) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/retweeted_to_me.json", (PostParameter[]) null, paging, true));
    }

    public List getRetweetsOfMe() {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/retweets_of_me.json", null, true));
    }

    public List getRetweetsOfMe(Paging paging) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/retweets_of_me.json", (PostParameter[]) null, paging, true));
    }

    public Status retweetStatus(long j) {
        return new Status(this.http.post(String.valueOf(getBaseURL()) + "statuses/retweet/" + j + ".json", new PostParameter[0], true));
    }

    public List getRetweets(long j) {
        return RetweetDetails.createRetweetDetails(get(String.valueOf(getBaseURL()) + "statuses/retweets/" + j + ".json", true));
    }

    public User updatePrivacy(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "account/update_privacy.json", new PostParameter[]{new PostParameter("comment", str)}, true).asJSONObject());
    }

    public List getFeatured() {
        return User.constructUsers(get(String.valueOf(getBaseURL()) + "statuses/featured.json", true));
    }

    public boolean existsFriendship(String str, String str2) {
        return -1 != get(new StringBuilder(String.valueOf(getBaseURL())).append("friendships/exists.json").toString(), "user_a", str, "user_b", str2, true).asString().indexOf("true");
    }

    public IDs getFriendsIDs() {
        return getFriendsIDs(-1L);
    }

    public IDs getFriendsIDs(long j) {
        return new IDs(get(String.valueOf(getBaseURL()) + "friends/ids.xml?cursor=" + j, true));
    }

    public IDs getFriendsIDs(int i) {
        return getFriendsIDs(i, -1L);
    }

    public IDs getFriendsIDs(int i, long j) {
        return new IDs(get(String.valueOf(getBaseURL()) + "friends/ids.json?user_id=" + i + "&cursor=" + j, true), this);
    }

    public IDs getFriendsIDs(String str) {
        return getFriendsIDs(str, -1L);
    }

    public IDs getFriendsIDs(String str, long j) {
        return new IDs(get(String.valueOf(getBaseURL()) + "friends/ids.json?screen_name=" + str + "&cursor=" + j, true), this);
    }

    public IDs getFollowersIDs() {
        return getFollowersIDs(-1L);
    }

    public IDs getFollowersIDs(long j) {
        return new IDs(get(String.valueOf(getBaseURL()) + "followers/ids.json?cursor=" + j, true), this);
    }

    public IDs getFollowersIDs(int i) {
        return getFollowersIDs(i, -1L);
    }

    public IDs getFollowersIDs(int i, long j) {
        return new IDs(get(String.valueOf(getBaseURL()) + "followers/ids.xml?user_id=" + i + "&cursor=" + j, true));
    }

    public IDs getFollowersIDs(String str) {
        return getFollowersIDs(str, -1L);
    }

    public IDs getFollowersIDs(String str, long j) {
        return new IDs(get(String.valueOf(getBaseURL()) + "followers/ids.json?screen_name=" + str + "&cursor=" + j, true), this);
    }

    private void addParameterToList(List list, String str, String str2) {
        if (str2 != null) {
            list.add(new PostParameter(str, str2));
        }
    }

    public User enableNotification(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "notifications/follow/" + str + ".json", true).asJSONObject());
    }

    public User disableNotification(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "notifications/leave/" + str + ".json", true).asJSONObject());
    }

    public List getSavedSearches() {
        return SavedSearch.constructSavedSearches(get(String.valueOf(getBaseURL()) + "saved_searches.json", true));
    }

    public SavedSearch showSavedSearch(int i) {
        return new SavedSearch(get(String.valueOf(getBaseURL()) + "saved_searches/show/" + i + ".json", true));
    }

    public SavedSearch createSavedSearch(String str) {
        return new SavedSearch(this.http.post(String.valueOf(getBaseURL()) + "saved_searches/create.json", new PostParameter[]{new PostParameter("query", str)}, true));
    }

    public SavedSearch destroySavedSearch(int i) {
        return new SavedSearch(this.http.post(String.valueOf(getBaseURL()) + "saved_searches/destroy/" + i + ".json", true));
    }

    public List getListStatuses(String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(getBaseURL()).append(str).append("/lists/").append(str2).append("/statuses.xml").append("?source=").append(CONSUMER_KEY);
        return Status.constructStatuses(this.http.httpRequest(sb.toString(), null, z, "GET"), this);
    }

    public UserWapper getListMembers(String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(getBaseURL()).append(str).append("/").append(str2).append("/members.xml").append("?source=").append(CONSUMER_KEY);
        return User.constructWapperUsers(this.http.httpRequest(sb.toString(), null, z, "GET"), this);
    }

    public UserWapper getListSubscribers(String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(getBaseURL()).append(str).append("/").append(str2).append("/subscribers.xml").append("?source=").append(CONSUMER_KEY);
        return User.constructWapperUsers(this.http.httpRequest(sb.toString(), null, z, "GET"), this);
    }

    public boolean isListMember(String str, String str2, String str3, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(getBaseURL()).append(str).append("/").append(str2).append("/members/").append(str3).append(".xml").append("?source=").append(CONSUMER_KEY);
        return "true".equals(this.http.httpRequest(sb.toString(), null, z, "GET").asDocument().getDocumentElement().getNodeValue());
    }

    public boolean isListSubscriber(String str, String str2, String str3, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(getBaseURL()).append(str).append("/").append(str2).append("/subscribers/").append(str3).append(".xml").append("?source=").append(CONSUMER_KEY);
        return "true".equals(this.http.httpRequest(sb.toString(), null, z, "GET").asDocument().getDocumentElement().getNodeValue());
    }

    public boolean test() {
        return -1 != get(new StringBuilder(String.valueOf(getBaseURL())).append("help/test.json").toString(), false).asString().indexOf("ok");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Weibo weibo = (Weibo) obj;
        return this.baseURL.equals(weibo.baseURL) && this.format.equals(weibo.format) && this.http.equals(weibo.http) && this.searchBaseURL.equals(weibo.searchBaseURL) && this.source.equals(weibo.source);
    }

    public int hashCode() {
        return (((((((this.http.hashCode() * 31) + this.baseURL.hashCode()) * 31) + this.searchBaseURL.hashCode()) * 31) + this.source.hashCode()) * 31) + this.format.hashCode();
    }

    public String toString() {
        return "Weibo{http=" + this.http + ", baseURL='" + this.baseURL + "', searchBaseURL='" + this.searchBaseURL + "', source='" + this.source + "', format=" + this.format + '}';
    }

    public JSONObject showFriendships(String str) {
        return get(String.valueOf(getBaseURL()) + "friendships/show.json?target_id=" + str, true).asJSONObject();
    }

    public JSONObject showFriendships(String str, String str2) {
        return get(String.valueOf(getBaseURL()) + "friendships/show.json?target_id=" + str2 + "&source_id=" + str + "&source=" + CONSUMER_KEY, true).asJSONObject();
    }

    public JSONObject register(String str, String... strArr) {
        return this.http.post(String.valueOf(getBaseURL()) + "account/register.json", new PostParameter[]{new PostParameter("nick", strArr[2]), new PostParameter("gender", strArr[3]), new PostParameter(PropertyConfiguration.PASSWORD, strArr[4]), new PostParameter("email", strArr[5]), new PostParameter("ip", str)}, true).asJSONObject();
    }

    public Weibo() {
        this.baseURL = String.valueOf(Configuration.getScheme()) + "api.t.sina.com.cn/";
        this.searchBaseURL = String.valueOf(Configuration.getScheme()) + "api.t.sina.com.cn/";
        this.format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        this.format.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.http.setRequestTokenURL(String.valueOf(Configuration.getScheme()) + "api.t.sina.com.cn/oauth/request_token");
        this.http.setAuthorizationURL(String.valueOf(Configuration.getScheme()) + "api.t.sina.com.cn/oauth/authorize");
        this.http.setAccessTokenURL(String.valueOf(Configuration.getScheme()) + "api.t.sina.com.cn/oauth/access_token");
    }

    public void setToken(String str, String str2) {
        this.http.setToken(str, str2);
    }

    public Weibo(String str) {
        this();
        this.baseURL = str;
    }

    public Weibo(String str, String str2) {
        this();
        setUserId(str);
        setPassword(str2);
    }

    public Weibo(String str, String str2, String str3) {
        this();
        setUserId(str);
        setPassword(str2);
        this.baseURL = str3;
    }

    public void setBaseURL(String str) {
        this.baseURL = str;
    }

    public String getBaseURL() {
        return this.baseURL;
    }

    public void setSearchBaseURL(String str) {
        this.searchBaseURL = str;
    }

    public String getSearchBaseURL() {
        return this.searchBaseURL;
    }

    private Response get(String str, boolean z) {
        return get(str, null, z);
    }

    protected Response get(String str, String str2, String str3, boolean z) {
        return get(str, new PostParameter[]{new PostParameter(str2, str3)}, z);
    }

    protected Response get(String str, String str2, String str3, String str4, String str5, boolean z) {
        return get(str, new PostParameter[]{new PostParameter(str2, str3), new PostParameter(str4, str5)}, z);
    }

    protected Response get(String str, PostParameter[] postParameterArr, boolean z) {
        String str2;
        if (str.indexOf("?") == -1) {
            str2 = String.valueOf(str) + "?source=" + CONSUMER_KEY;
        } else {
            str2 = str.indexOf("source") == -1 ? String.valueOf(str) + "&source=" + CONSUMER_KEY : str;
        }
        if (postParameterArr != null && postParameterArr.length > 0) {
            str2 = String.valueOf(str2) + "&" + HttpClient.encodeParameters(postParameterArr);
        }
        return this.http.get(str2, z);
    }

    protected Response get(String str, PostParameter[] postParameterArr, Paging paging, boolean z) {
        if (paging != null) {
            ArrayList arrayList = new ArrayList(4);
            if (-1 != paging.getMaxId()) {
                arrayList.add(new PostParameter("max_id", String.valueOf(paging.getMaxId())));
            }
            if (-1 != paging.getSinceId()) {
                arrayList.add(new PostParameter("since_id", String.valueOf(paging.getSinceId())));
            }
            if (-1 != paging.getPage()) {
                arrayList.add(new PostParameter("page", String.valueOf(paging.getPage())));
            }
            if (-1 != paging.getCount()) {
                if (-1 != str.indexOf("search")) {
                    arrayList.add(new PostParameter("rpp", String.valueOf(paging.getCount())));
                } else {
                    arrayList.add(new PostParameter("count", String.valueOf(paging.getCount())));
                }
            }
            PostParameter[] postParameterArr2 = (PostParameter[]) null;
            PostParameter[] postParameterArr3 = (PostParameter[]) arrayList.toArray(new PostParameter[arrayList.size()]);
            if (postParameterArr != null) {
                postParameterArr2 = new PostParameter[postParameterArr.length + arrayList.size()];
                System.arraycopy(postParameterArr, 0, postParameterArr2, 0, postParameterArr.length);
                System.arraycopy(postParameterArr3, 0, postParameterArr2, postParameterArr.length, arrayList.size());
            } else if (postParameterArr3.length != 0) {
                String strEncodeParameters = HttpClient.encodeParameters(postParameterArr3);
                if (-1 != str.indexOf("?")) {
                    str = String.valueOf(str) + "&source=" + CONSUMER_KEY + "&" + strEncodeParameters;
                } else {
                    str = String.valueOf(str) + "?source=" + CONSUMER_KEY + "&" + strEncodeParameters;
                }
            }
            return get(str, postParameterArr2, z);
        }
        return get(str, postParameterArr, z);
    }

    private PostParameter[] generateParameterArray(Map map) {
        PostParameter[] postParameterArr = new PostParameter[map.size()];
        int i = 0;
        for (String str : map.keySet()) {
            if (map.get(str) != null) {
                postParameterArr[i] = new PostParameter(str, (String) map.get(str));
                i++;
            }
        }
        return postParameterArr;
    }

    class Device {
        final String DEVICE;

        public Device(String str) {
            this.DEVICE = str;
        }
    }

    public List getFriends(String str, Paging paging) {
        return getFriendsStatuses(str, paging);
    }

    public List getFriends(String str, int i) {
        return getFriendsStatuses(str, new Paging(i));
    }

    public List getFriends(int i) {
        return getFriendsStatuses(new Paging(i));
    }

    public List getFriends() {
        return getFriendsStatuses();
    }

    public List getFriends(Paging paging) {
        return getFriendsStatuses(paging);
    }

    public List getFriends(String str) {
        return getFriendsStatuses(str);
    }

    public List getFollowers(String str, Paging paging) {
        return getFollowersStatuses(str, paging);
    }

    public List getFollowers(String str, int i) {
        return getFollowersStatuses(str, new Paging(i));
    }

    public List getFollowers() {
        return getFollowersStatuses();
    }

    public List getFollowers(Paging paging) {
        return getFollowersStatuses(paging);
    }

    public List getFollowers(int i) {
        return getFollowersStatuses(new Paging(i));
    }

    public List getFollowers(String str) {
        return getFollowersStatuses(str);
    }

    public List getPublicTimeline(int i) {
        return getPublicTimeline(i);
    }

    public List getPublicTimeline(long j) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/public_timeline.json", (PostParameter[]) null, new Paging(j), false));
    }

    public List getFriendsTimelineByPage(int i) {
        return getFriendsTimeline(new Paging(i));
    }

    public List getFriendsTimeline(int i) {
        return getFriendsTimeline(new Paging(i));
    }

    public List getFriendsTimeline(long j, int i) {
        return getFriendsTimeline(new Paging(i).sinceId(j));
    }

    public List getFriendsTimeline(String str) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    public List getFriendsTimelineByPage(String str, int i) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    public List getFriendsTimeline(String str, int i) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    public List getFriendsTimeline(long j, String str, int i) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    public List getFriendsTimeline(String str, Paging paging) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    public List getFriendsTimeline(Date date) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/friends_timeline.xml", "since", this.format.format(date), true), this);
    }

    public List getFriendsTimeline(long j) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/friends_timeline.xml", "since_id", String.valueOf(j), true), this);
    }

    public List getFriendsTimeline(String str, Date date) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    public List getFriendsTimeline(String str, long j) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    public List getUserTimeline(String str, int i, Date date) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/user_timeline/" + str + ".xml", "since", this.format.format(date), "count", String.valueOf(i), this.http.isAuthenticationEnabled()), this);
    }

    public List getUserTimeline(String str, int i, long j) {
        return getUserTimeline(str, new Paging(j).count(i));
    }

    public List getUserTimeline(String str, Date date) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/user_timeline/" + str + ".xml", "since", this.format.format(date), this.http.isAuthenticationEnabled()), this);
    }

    public List getUserTimeline(String str, int i) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/user_timeline/" + str + ".xml", "count", String.valueOf(i), this.http.isAuthenticationEnabled()), this);
    }

    public List getUserTimeline(int i, Date date) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/user_timeline.xml", "since", this.format.format(date), "count", String.valueOf(i), true), this);
    }

    public List getUserTimeline(int i, long j) {
        return getUserTimeline(new Paging(j).count(i));
    }

    public List getUserTimeline(String str, long j) {
        return getUserTimeline(str, new Paging(j));
    }

    public List getUserTimeline(long j) {
        return getUserTimeline(new Paging(j));
    }

    public Status update(String str) {
        return updateStatus(str);
    }

    public Status update(String str, long j) {
        return updateStatus(str, j);
    }

    public List getReplies() {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/replies.xml", true), this);
    }

    public List getReplies(long j) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/replies.xml", "since_id", String.valueOf(j), true), this);
    }

    public List getRepliesByPage(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("page should be positive integer. passed:" + i);
        }
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/replies.xml", "page", String.valueOf(i), true), this);
    }

    public List getReplies(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("page should be positive integer. passed:" + i);
        }
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/replies.xml", "page", String.valueOf(i), true), this);
    }

    public List getReplies(long j, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("page should be positive integer. passed:" + i);
        }
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "statuses/replies.xml", "since_id", String.valueOf(j), "page", String.valueOf(i), true), this);
    }

    public Status show(int i) {
        return showStatus(i);
    }

    public Status show(long j) {
        return new Status(get(String.valueOf(getBaseURL()) + "statuses/show/" + j + ".xml", false), this);
    }

    public User getUserDetail(String str) {
        return showUser(str);
    }

    public List getDirectMessagesByPage(int i) {
        return getDirectMessages(new Paging(i));
    }

    public List getDirectMessages(int i, int i2) {
        return getDirectMessages(new Paging(i).sinceId(i2));
    }

    public List getDirectMessages(int i) {
        return getDirectMessages(new Paging(i));
    }

    public List getDirectMessages(Date date) {
        return DirectMessage.constructDirectMessages(get(String.valueOf(getBaseURL()) + "direct_messages.xml", "since", this.format.format(date), true), this);
    }

    public List getSentDirectMessages(Date date) {
        return DirectMessage.constructDirectMessages(get(String.valueOf(getBaseURL()) + "direct_messages/sent.xml", "since", this.format.format(date), true), this);
    }

    public List getSentDirectMessages(int i) {
        return getSentDirectMessages(new Paging(i));
    }

    public List getSentDirectMessages(int i, int i2) {
        return getSentDirectMessages(new Paging(i, i2));
    }

    public DirectMessage deleteDirectMessage(int i) {
        return destroyDirectMessage(i);
    }

    public User create(String str) {
        return createFriendship(str);
    }

    public User destroy(String str) {
        return destroyFriendship(str);
    }

    public boolean exists(String str, String str2) {
        return existsFriendship(str, str2);
    }

    public IDs getFriendsIDs(Paging paging) {
        return new IDs(get(String.valueOf(getBaseURL()) + "friends/ids.xml", (PostParameter[]) null, paging, true));
    }

    public IDs getFriendsIDs(int i, Paging paging) {
        return new IDs(get(String.valueOf(getBaseURL()) + "friends/ids.xml?user_id=" + i, (PostParameter[]) null, paging, true));
    }

    public IDs getFriendsIDs(String str, Paging paging) {
        return new IDs(get(String.valueOf(getBaseURL()) + "friends/ids.xml?screen_name=" + str, (PostParameter[]) null, paging, true));
    }

    public IDs getFollowersIDs(Paging paging) {
        return new IDs(get(String.valueOf(getBaseURL()) + "followers/ids.xml", (PostParameter[]) null, paging, true));
    }

    public IDs getFollowersIDs(int i, Paging paging) {
        return new IDs(get(String.valueOf(getBaseURL()) + "followers/ids.xml?user_id=" + i, (PostParameter[]) null, paging, true));
    }

    public IDs getFollowersIDs(String str, Paging paging) {
        return new IDs(get(String.valueOf(getBaseURL()) + "followers/ids.xml?screen_name=" + str, (PostParameter[]) null, paging, true));
    }

    public User updateLocation(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "account/update_location.xml", new PostParameter[]{new PostParameter("location", str)}, true), this);
    }

    public List favorites() {
        return getFavorites();
    }

    public List favorites(int i) {
        return getFavorites(i);
    }

    public List favorites(String str) {
        return getFavorites(str);
    }

    public List favorites(String str, int i) {
        return getFavorites(str, i);
    }

    public User follow(String str) {
        return enableNotification(str);
    }

    public User leave(String str) {
        return disableNotification(str);
    }

    public User block(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "blocks/create/" + str + ".xml", true), this);
    }

    public User unblock(String str) {
        return new User(this.http.post(String.valueOf(getBaseURL()) + "blocks/destroy/" + str + ".xml", true), this);
    }

    public User getAuthenticatedUser() {
        return new User(get(String.valueOf(getBaseURL()) + "account/verify_credentials.xml", true), this);
    }

    public String getDowntimeSchedule() throws WeiboException {
        throw new WeiboException("this method is not supported by the Weibo API anymore", new NoSuchMethodException("this method is not supported by the Weibo API anymore"));
    }

    public List getDailyTrends() {
        return Trends.constructTrendsList(get(String.valueOf(this.searchBaseURL) + "trends/daily.json", false));
    }

    public List getDailyTrends(Date date, boolean z) {
        return Trends.constructTrendsList(get(String.valueOf(this.searchBaseURL) + "trends/daily.json?date=" + toDateStr(date) + (z ? "&exclude=hashtags" : ""), false));
    }

    public List getWeeklyTrends() {
        return Trends.constructTrendsList(get(String.valueOf(this.searchBaseURL) + "trends/weekly.json", false));
    }

    public List getWeeklyTrends(Date date, boolean z) {
        return Trends.constructTrendsList(get(String.valueOf(this.searchBaseURL) + "trends/weekly.json?date=" + toDateStr(date) + (z ? "&exclude=hashtags" : ""), false));
    }

    public void setToken(AccessToken accessToken) {
        setToken(accessToken.getToken(), accessToken.getTokenSecret());
    }

    public List gettags(String str) {
        return Tag.constructTags(this.http.get(String.valueOf(getBaseURL()) + "tags.json?user_id=" + str, true));
    }

    public List getSuggestions() {
        return Tag.constructTags(get(String.valueOf(getBaseURL()) + "tags/suggestions.json", true));
    }

    public List getFavorites() {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "favorites.json", new PostParameter[0], true));
    }

    public List getFavorites(String str) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "favorites/" + str + ".json", new PostParameter[0], true));
    }

    public List getFavorites(String str, int i) {
        return Status.constructStatuses(get(String.valueOf(getBaseURL()) + "favorites/" + str + ".json", "page", String.valueOf(i), true));
    }

    public IDs getFriendsListIDS_test(String str, int i) {
        return new IDs(get(String.valueOf(getBaseURL()) + "friends/ids.json", new PostParameter[]{new PostParameter("uid", str), new PostParameter("cursor", i)}, true), this);
    }

    public IDs getFriendsListIDS_test2(String str, int i, int i2) {
        return new IDs(get(String.valueOf(getBaseURL()) + "friends/ids.json", new PostParameter[]{new PostParameter("uid", str), new PostParameter("cursor", i), new PostParameter("count", i2)}, true), this);
    }
}
