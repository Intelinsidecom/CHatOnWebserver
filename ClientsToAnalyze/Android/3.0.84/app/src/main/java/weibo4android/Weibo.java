package weibo4android;

import com.sec.chaton.settings2.PrefFragmentChats;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import twitter4j.conf.PropertyConfiguration;
import weibo4android.http.AccessToken;
import weibo4android.http.HttpClient;
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
    public static String CONSUMER_KEY = "1552112022";
    public static String CONSUMER_SECRET = "bd9e3b147ece106f9cee159758a28ec1";

    /* renamed from: IM */
    public static final Device f13759IM = new Device("im");
    public static final Device SMS = new Device("sms");
    public static final Device NONE = new Device("none");

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void forceUsePost(boolean z) {
        super.forceUsePost(z);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ String getClientURL() {
        return super.getClientURL();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ String getClientVersion() {
        return super.getClientVersion();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ String getPassword() {
        return super.getPassword();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ String getSource() {
        return super.getSource();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ String getUserAgent() {
        return super.getUserAgent();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ String getUserId() {
        return super.getUserId();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ boolean isUsePostForced() {
        return super.isUsePostForced();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setClientURL(String str) {
        super.setClientURL(str);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setClientVersion(String str) {
        super.setClientVersion(str);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setHttpConnectionTimeout(int i) {
        super.setHttpConnectionTimeout(i);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setHttpProxy(String str, int i) {
        super.setHttpProxy(str, i);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setHttpProxyAuth(String str, String str2) {
        super.setHttpProxyAuth(str, str2);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setHttpReadTimeout(int i) {
        super.setHttpReadTimeout(i);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setPassword(String str) {
        super.setPassword(str);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setRequestHeader(String str, String str2) {
        super.setRequestHeader(str, str2);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setRetryCount(int i) {
        super.setRetryCount(i);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setRetryIntervalSecs(int i) {
        super.setRetryIntervalSecs(i);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setSource(String str) {
        super.setSource(str);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setUserAgent(String str) {
        super.setUserAgent(str);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setUserId(String str) {
        super.setUserId(str);
    }

    class Device {
        final String DEVICE;

        public Device(String str) {
            this.DEVICE = str;
        }
    }

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

    public List<Status> getFavorites(int i) {
        return Status.constructStatuses(get(getBaseURL() + "favorites.json", "page", String.valueOf(i), true));
    }

    public Status createFavorite(long j) {
        return new Status(this.http.post(getBaseURL() + "favorites/create/" + j + ".json", true));
    }

    public Status destroyFavorite(long j) {
        return new Status(this.http.post(getBaseURL() + "favorites/destroy/" + j + ".json", true));
    }

    public List<Status> destroyFavorites(String str) {
        return Status.constructStatuses(this.http.post(getBaseURL() + "favorites/destroy_batch.json", new PostParameter[]{new PostParameter("ids", str)}, true));
    }

    public List<Status> destroyFavorites(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return Status.constructStatuses(this.http.post(getBaseURL() + "favorites/destroy_batch.json", new PostParameter[]{new PostParameter("ids", sb.toString())}, true));
    }

    public User verifyCredentials() {
        return new User(get(getBaseURL() + "account/verify_credentials.json", true).asJSONObject());
    }

    public User updateProfile(String str, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList(5);
        addParameterToList(arrayList, "name", str);
        addParameterToList(arrayList, "email", str2);
        addParameterToList(arrayList, "url", str3);
        addParameterToList(arrayList, "location", str4);
        addParameterToList(arrayList, "description", str5);
        return new User(this.http.post(getBaseURL() + "account/update_profile.json", (PostParameter[]) arrayList.toArray(new PostParameter[arrayList.size()]), true).asJSONObject());
    }

    public RateLimitStatus rateLimitStatus() {
        return new RateLimitStatus(this.http.get(getBaseURL() + "account/rate_limit_status.json", true), this);
    }

    public User endSession() {
        return new User(get(getBaseURL() + "account/end_session.json", true).asJSONObject());
    }

    public List<Tag> getTags(String str, Paging paging) {
        return Tag.constructTags(get(getBaseURL() + "tags.json", new PostParameter[]{new PostParameter("user_id", str)}, paging, true));
    }

    public List<Tag> createTags(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strArr) {
            stringBuffer.append(str).append(",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return createTags(stringBuffer.toString());
    }

    public List<Tag> createTags(String str) {
        return Tag.constructTags(this.http.post(getBaseURL() + "tags/create.json", new PostParameter[]{new PostParameter("tags", str)}, true));
    }

    public List<Tag> getSuggestionsTags() {
        return Tag.constructTags(get(getBaseURL() + "tags/suggestions.json", true));
    }

    public boolean destoryTag(String str) throws WeiboException {
        try {
            return this.http.post(new StringBuilder().append(getBaseURL()).append("tags/destroy.json").toString(), new PostParameter[]{new PostParameter("tag_id", str)}, true).asJSONObject().getInt("result") == 0;
        } catch (JSONException e) {
            throw new WeiboException(e);
        }
    }

    public List<Tag> destory_batchTags(String str) {
        return Tag.constructTags(this.http.post(getBaseURL() + "tags/destroy_batch.json", new PostParameter[]{new PostParameter("ids", str)}, true));
    }

    public User createBlock(String str) {
        return new User(this.http.post(getBaseURL() + "blocks/create.json", new PostParameter[]{new PostParameter("user_id", str)}, true).asJSONObject());
    }

    public User createBlockByScreenName(String str) {
        return new User(this.http.post(getBaseURL() + "blocks/create.json", new PostParameter[]{new PostParameter("screen_name", str)}, true).asJSONObject());
    }

    public User destroyBlock(String str) {
        return new User(this.http.post(getBaseURL() + "blocks/destroy.json", new PostParameter[]{new PostParameter("id", str)}, true).asJSONObject());
    }

    public boolean existsBlock(String str) throws WeiboException {
        try {
            return -1 == get(new StringBuilder().append(getBaseURL()).append("blocks/exists.json?user_id=").append(str).toString(), true).asString().indexOf("<error>You are not blocking this user.</error>");
        } catch (WeiboException e) {
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }

    public List<User> getBlockingUsers() {
        return User.constructUsers(get(getBaseURL() + "blocks/blocking.json", true));
    }

    public List<User> getBlockingUsers(int i) {
        return User.constructUsers(get(getBaseURL() + "blocks/blocking.json?page=" + i, true));
    }

    public IDs getBlockingUsersIDs() {
        return new IDs(get(getBaseURL() + "blocks/blocking/ids.json", true), this);
    }

    public IDs getFriendsIDSByUserId(String str, Paging paging) {
        return new IDs(get(this.baseURL + "friends/ids.json", new PostParameter[]{new PostParameter("user_id", str)}, paging, true), this);
    }

    public IDs getFriendsIDSByScreenName(String str, Paging paging) {
        return new IDs(get(this.baseURL + "friends/ids.json", new PostParameter[]{new PostParameter("screen_name", str)}, paging, true), this);
    }

    public IDs getFollowersIDSByUserId(String str, Paging paging) {
        return new IDs(get(this.baseURL + "followers/ids.json", new PostParameter[]{new PostParameter("user_id", str)}, paging, true), this);
    }

    public IDs getFollowersIDSByScreenName(String str, Paging paging) {
        return new IDs(get(this.baseURL + "followers/ids.json", new PostParameter[]{new PostParameter("screen_name", str)}, paging, true), this);
    }

    public List<Status> getTrendStatus(String str, Paging paging) {
        return Status.constructStatuses(get(this.baseURL + "trends/statuses.json", new PostParameter[]{new PostParameter("trend_name", str)}, paging, true));
    }

    public boolean trendsDestroy(String str) throws WeiboException {
        try {
            return this.http.delete(this.baseURL + "trends/destroy.json?trend_id=" + str + "&source=" + CONSUMER_KEY, true).asJSONObject().getBoolean("result");
        } catch (JSONException e) {
            throw new WeiboException("e");
        }
    }

    public List<Trends> getTrendsHourly(Integer num) {
        if (num == null) {
            num = 0;
        }
        return Trends.constructTrendsList(get(this.baseURL + "trends/hourly.json", "base_app", num.toString(), true));
    }

    public List<Trends> getTrendsDaily(Integer num) {
        if (num == null) {
            num = 0;
        }
        return Trends.constructTrendsList(get(this.baseURL + "trends/daily.json", "base_app", num.toString(), true));
    }

    public List<Trends> getTrendsWeekly(Integer num) {
        if (num == null) {
            num = 0;
        }
        return Trends.constructTrendsList(get(this.baseURL + "trends/weekly.json", "base_app", num.toString(), true));
    }

    private String toDateStr(Date date) {
        if (date == null) {
            date = new Date();
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public User createFriendship(String str) {
        return new User(get(getBaseURL() + "friendships/create.json", "id", str, true).asJSONObject());
    }

    public User createFriendshipByScreenName(String str) {
        return new User(this.http.post(getBaseURL() + "friendships/create.json", new PostParameter[]{new PostParameter("screen_name", str)}, true).asJSONObject());
    }

    public User createFriendshipByUserid(String str) {
        return new User(this.http.post(getBaseURL() + "friendships/create.json", new PostParameter[]{new PostParameter("user_id", str)}, true).asJSONObject());
    }

    public List<DirectMessage> getDirectMessages() {
        return DirectMessage.constructDirectMessages(get(getBaseURL() + "direct_messages.json", true));
    }

    public List<DirectMessage> getDirectMessages(Paging paging) {
        return DirectMessage.constructDirectMessages(get(getBaseURL() + "direct_messages.json", (PostParameter[]) null, paging, true));
    }

    public List<DirectMessage> getSentDirectMessages() {
        return DirectMessage.constructDirectMessages(get(getBaseURL() + "direct_messages/sent.json", new PostParameter[0], true));
    }

    public List<DirectMessage> getSentDirectMessages(Paging paging) {
        return DirectMessage.constructDirectMessages(get(getBaseURL() + "direct_messages/sent.json", new PostParameter[0], paging, true));
    }

    public DirectMessage sendDirectMessage(String str, String str2) {
        return new DirectMessage(this.http.post(getBaseURL() + "direct_messages/new.json", new PostParameter[]{new PostParameter("user_id", str), new PostParameter("text", str2), new PostParameter("source", this.source)}, true).asJSONObject());
    }

    public DirectMessage sendDirectMessageByScreenName(String str, String str2) {
        return new DirectMessage(this.http.post(getBaseURL() + "direct_messages/new.json", new PostParameter[]{new PostParameter("screen_name", str), new PostParameter("text", str2), new PostParameter("source", this.source)}, true).asJSONObject());
    }

    public DirectMessage destroyDirectMessage(long j) {
        return new DirectMessage(this.http.post(getBaseURL() + "direct_messages/destroy/" + j + ".json", new PostParameter[0], true).asJSONObject());
    }

    public List<DirectMessage> destroyDirectMessages(String str) {
        return DirectMessage.constructDirectMessages(this.http.post(getBaseURL() + "direct_messages/destroy_batch.json", new PostParameter[]{new PostParameter("ids", str)}, true));
    }

    public List<DirectMessage> destroyDirectMessages(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return DirectMessage.constructDirectMessages(this.http.post(getBaseURL() + "direct_messages/destroy_batch.json", new PostParameter[]{new PostParameter("ids", sb.toString())}, true));
    }

    public User showUser(String str) {
        return new User(get(getBaseURL() + "users/show.json", new PostParameter[]{new PostParameter("user_id", str)}, this.http.isAuthenticationEnabled()).asJSONObject());
    }

    public List<User> getFriendsStatuses() {
        return User.constructResult(get(getBaseURL() + "statuses/friends.json", true));
    }

    public UserWapper getFriendsStatuses2(String str, int i, int i2) {
        return User.constructWapperUsers(get(getBaseURL() + "statuses/friends.json", new PostParameter[]{new PostParameter("uid", str), new PostParameter("cursor", i), new PostParameter("count", i2)}, true));
    }

    public List<User> getFriendsStatuses(String str, Paging paging) {
        return User.constructUsers(get(getBaseURL() + "statuses/friends.json", new PostParameter[]{new PostParameter("id", str)}, paging, true));
    }

    public List<User> getFriendsStatuses(Paging paging) {
        return User.constructUsers(get(getBaseURL() + "statuses/friends.json", (PostParameter[]) null, paging, true));
    }

    public List<User> getFriendsStatuses(String str) {
        return User.constructUsers(get(getBaseURL() + "statuses/friends.json", new PostParameter[]{new PostParameter("id", str)}, false));
    }

    public List<User> getFollowersStatuses() {
        return User.constructResult(get(getBaseURL() + "statuses/followers.json", true));
    }

    public List<User> getFollowersStatuses(String str, Paging paging) {
        return User.constructUsers(get(getBaseURL() + "statuses/followers.json", new PostParameter[]{new PostParameter("id", str)}, paging, true));
    }

    public List<User> getFollowersStatuses(Paging paging) {
        return User.constructUsers(get(getBaseURL() + "statuses/followers.json", (PostParameter[]) null, paging, true));
    }

    public List<User> getFollowersStatuses(String str) {
        return User.constructUsers(get(getBaseURL() + "statuses/followers.json", new PostParameter[]{new PostParameter("id", str)}, true));
    }

    public List<User> getHotUsers(String str) {
        return User.constructUsers(get(getBaseURL() + "users/hot.json", "category", str, true));
    }

    public User updateRemark(String str, String str2) {
        if (!URLEncodeUtils.isURLEncoded(str2)) {
            str2 = URLEncodeUtils.encodeURL(str2);
        }
        return new User(this.http.post(getBaseURL() + "user/friends/update_remark.json", new PostParameter[]{new PostParameter("user_id", str), new PostParameter("remark", str2)}, true).asJSONObject());
    }

    public User updateRemark(Long l, String str) {
        return updateRemark(Long.toString(l.longValue()), str);
    }

    public List<User> getSuggestionUsers() {
        return User.constructUsers(get(getBaseURL() + "users/suggestions.json", "with_reason", "0", true));
    }

    public List<Status> getPublicTimeline() {
        return Status.constructStatuses(get(getBaseURL() + "statuses/public_timeline.json", true));
    }

    public List<Status> getPublicTimeline(int i, int i2) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/public_timeline.json", new PostParameter[]{new PostParameter("count", i), new PostParameter("base_app", i2)}, false));
    }

    public List<Status> getFriendsTimeline() {
        return Status.constructStatuses(get(getBaseURL() + "statuses/friends_timeline.json", true));
    }

    public List<Status> getFriendsTimeline(Paging paging) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/friends_timeline.json", (PostParameter[]) null, paging, true));
    }

    public List<Status> getHomeTimeline() {
        return Status.constructStatuses(get(getBaseURL() + "statuses/home_timeline.json", true));
    }

    public List<Status> getHomeTimeline(Paging paging) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/home_timeline.json", (PostParameter[]) null, paging, true));
    }

    public List<Status> getUserTimeline(String str, Paging paging) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/user_timeline.json", new PostParameter[]{new PostParameter("id", str)}, paging, this.http.isAuthenticationEnabled()));
    }

    public List<Status> getUserTimeline(String str, Integer num, Integer num2, Paging paging) {
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
        return Status.constructStatuses(get(getBaseURL() + "statuses/user_timeline.json", generateParameterArray(map), paging, this.http.isAuthenticationEnabled()));
    }

    public List<Status> getUserTimeline(String str) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/user_timeline.json", new PostParameter[]{new PostParameter("id", str)}, this.http.isAuthenticationEnabled()));
    }

    public List<Status> getUserTimeline() {
        return Status.constructStatuses(get(getBaseURL() + "statuses/user_timeline.json", true));
    }

    public List<Status> getUserTimeline(Paging paging) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/user_timeline.json", (PostParameter[]) null, paging, true));
    }

    public List<Status> getUserTimeline(Integer num, Integer num2, Paging paging) {
        return getUserTimeline(null, num, num2, paging);
    }

    public List<Status> getMentions() {
        return Status.constructStatuses(get(getBaseURL() + "statuses/mentions.json", null, true));
    }

    public List<Status> getMentions(Paging paging) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/mentions.json", (PostParameter[]) null, paging, true));
    }

    public List<Comment> getCommentsTimeline() {
        return Comment.constructComments(get(getBaseURL() + "statuses/comments_timeline.json", true));
    }

    public List<Comment> getCommentsTimeline(Paging paging) {
        return Comment.constructComments(get(getBaseURL() + "statuses/comments_timeline.json", (PostParameter[]) null, paging, true));
    }

    public List<Comment> getCommentsByMe() {
        return Comment.constructComments(get(getBaseURL() + "statuses/comments_by_me.json", true));
    }

    public List<Comment> getCommentsByMe(Paging paging) {
        return Comment.constructComments(get(getBaseURL() + "statuses/comments_by_me.json", (PostParameter[]) null, paging, true));
    }

    public List<Comment> getCommentsToMe() {
        return Comment.constructComments(get(getBaseURL() + "statuses/comments_to_me.json", true));
    }

    public List<Comment> getCommentsToMe(Paging paging) {
        return Comment.constructComments(get(getBaseURL() + "statuses/comments_to_me.json", (PostParameter[]) null, paging, true));
    }

    public List<Status> getrepostbyme(String str) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/repost_by_me.json", "id", str, true));
    }

    public List<Status> getrepostbyme(String str, Paging paging) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/repost_by_me.json", new PostParameter[]{new PostParameter("id", str)}, paging, true));
    }

    public List<Status> getreposttimeline(String str) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/repost_timeline.json", "id", str, true));
    }

    public List<Status> getreposttimeline(String str, Paging paging) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/repost_timeline.json", new PostParameter[]{new PostParameter("id", str)}, paging, true));
    }

    public List<Comment> getComments(String str) {
        return Comment.constructComments(get(getBaseURL() + "statuses/comments.json", "id", str, true));
    }

    public List<Comment> getComments(String str, Paging paging) {
        return Comment.constructComments(get(getBaseURL() + "statuses/comments.json", new PostParameter[]{new PostParameter("id", str)}, paging, true));
    }

    public List<Count> getCounts(String str) {
        return Count.constructCounts(get(getBaseURL() + "statuses/counts.json", "ids", str, true));
    }

    public Count getUnread(Integer num, Long l) {
        HashMap map = new HashMap();
        if (num != null) {
            map.put("with_new_status", Integer.toString(num.intValue()));
        }
        if (l != null) {
            map.put("since_id", Long.toString(l.longValue()));
        }
        return new Count(get(getBaseURL() + "statuses/unread.json", generateParameterArray(map), true).asJSONObject());
    }

    public Boolean resetCount(int i) throws WeiboException {
        JSONObject jSONObjectAsJSONObject = null;
        try {
            jSONObjectAsJSONObject = this.http.post(getBaseURL() + "statuses/reset_count.json", new PostParameter[]{new PostParameter(PrefFragmentChats.TYPE, i)}, true).asJSONObject();
            return Boolean.valueOf(jSONObjectAsJSONObject.getBoolean("result"));
        } catch (JSONException e) {
            throw new WeiboException(e.getMessage() + ":" + jSONObjectAsJSONObject, e);
        }
    }

    public Status showStatus(String str) {
        return new Status(get(getBaseURL() + "statuses/show/" + str + ".json", true));
    }

    public Status showStatus(long j) {
        return showStatus(Long.toString(j));
    }

    public Status updateStatus(String str) {
        return new Status(this.http.post(getBaseURL() + "statuses/update.json", new PostParameter[]{new PostParameter("status", str)}, true));
    }

    public Status updateStatus(String str, double d, double d2) {
        return new Status(this.http.post(getBaseURL() + "statuses/update.json", new PostParameter[]{new PostParameter("status", str), new PostParameter("lat", d), new PostParameter("long", d2)}, true));
    }

    public Status updateStatus(String str, long j) {
        return new Status(this.http.post(getBaseURL() + "statuses/update.json", new PostParameter[]{new PostParameter("status", str), new PostParameter("in_reply_to_status_id", String.valueOf(j)), new PostParameter("source", this.source)}, true));
    }

    public Status updateStatus(String str, long j, double d, double d2) {
        return new Status(this.http.post(getBaseURL() + "statuses/update.json", new PostParameter[]{new PostParameter("status", str), new PostParameter("lat", d), new PostParameter("long", d2), new PostParameter("in_reply_to_status_id", String.valueOf(j)), new PostParameter("source", this.source)}, true));
    }

    public Status destroyStatus(long j) {
        return destroyStatus(Long.toString(j));
    }

    public Status destroyStatus(String str) {
        return new Status(this.http.post(getBaseURL() + "statuses/destroy/" + str + ".json", new PostParameter[0], true));
    }

    public Status repost(String str, String str2) {
        return repost(str, str2, 0);
    }

    public Status repost(String str, String str2, int i) {
        return new Status(this.http.post(getBaseURL() + "statuses/repost.json", new PostParameter[]{new PostParameter("id", str), new PostParameter("status", str2), new PostParameter("is_comment", i)}, true));
    }

    public Comment updateComment(String str, String str2, String str3) {
        PostParameter[] postParameterArr;
        if (str3 == null) {
            postParameterArr = new PostParameter[]{new PostParameter("comment", str), new PostParameter("id", str2)};
        } else {
            postParameterArr = new PostParameter[]{new PostParameter("comment", str), new PostParameter("cid", str3), new PostParameter("id", str2)};
        }
        return new Comment(this.http.post(getBaseURL() + "statuses/comment.json", postParameterArr, true));
    }

    public Comment destroyComment(long j) {
        return new Comment(this.http.delete(getBaseURL() + "statuses/comment_destroy/" + j + ".json?source=" + CONSUMER_KEY, true));
    }

    public List<Comment> destroyComments(String str) {
        return Comment.constructComments(this.http.post(getBaseURL() + "statuses/comment/destroy_batch.json", new PostParameter[]{new PostParameter("ids", str)}, true));
    }

    public List<Comment> destroyComments(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return Comment.constructComments(this.http.post(getBaseURL() + "statuses/comment/destroy_batch.json", new PostParameter[]{new PostParameter("ids", sb.toString())}, true));
    }

    public Comment reply(String str, String str2, String str3) {
        return new Comment(this.http.post(getBaseURL() + "statuses/reply.json", new PostParameter[]{new PostParameter("id", str), new PostParameter("cid", str2), new PostParameter("comment", str3)}, true));
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
        return getXAuthAccessToken(str, str2, "client_auth");
    }

    public void setOAuthAccessToken(AccessToken accessToken) {
        this.http.setOAuthAccessToken(accessToken);
    }

    public void setOAuthAccessToken(String str, String str2) {
        setOAuthAccessToken(new AccessToken(str, str2));
    }

    public RateLimitStatus getRateLimitStatus() {
        return new RateLimitStatus(get(getBaseURL() + "account/rate_limit_status.json", true), this);
    }

    public List<Status> getRetweetedByMe() {
        return Status.constructStatuses(get(getBaseURL() + "statuses/retweeted_by_me.json", null, true));
    }

    public List<Status> getRetweetedByMe(Paging paging) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/retweeted_by_me.json", null, true));
    }

    public List<Status> getRetweetedToMe() {
        return Status.constructStatuses(get(getBaseURL() + "statuses/retweeted_to_me.json", null, true));
    }

    public List<Status> getRetweetedToMe(Paging paging) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/retweeted_to_me.json", (PostParameter[]) null, paging, true));
    }

    public List<Status> getRetweetsOfMe() {
        return Status.constructStatuses(get(getBaseURL() + "statuses/retweets_of_me.json", null, true));
    }

    public List<Status> getRetweetsOfMe(Paging paging) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/retweets_of_me.json", (PostParameter[]) null, paging, true));
    }

    public Status retweetStatus(long j) {
        return new Status(this.http.post(getBaseURL() + "statuses/retweet/" + j + ".json", new PostParameter[0], true));
    }

    public List<RetweetDetails> getRetweets(long j) {
        return RetweetDetails.createRetweetDetails(get(getBaseURL() + "statuses/retweets/" + j + ".json", true));
    }

    @Deprecated
    public User updatePrivacy(String str) {
        return new User(this.http.post(getBaseURL() + "account/update_privacy.json", new PostParameter[]{new PostParameter("comment", str)}, true).asJSONObject());
    }

    public List<User> getFeatured() {
        return User.constructUsers(get(getBaseURL() + "statuses/featured.json", true));
    }

    public boolean existsFriendship(String str, String str2) {
        return -1 != get(new StringBuilder().append(getBaseURL()).append("friendships/exists.json").toString(), "user_a", str, "user_b", str2, true).asString().indexOf("true");
    }

    @Deprecated
    public IDs getFriendsIDs() {
        return getFriendsIDs(-1L);
    }

    @Deprecated
    public IDs getFriendsIDs(long j) {
        return new IDs(get(getBaseURL() + "friends/ids.xml?cursor=" + j, true));
    }

    @Deprecated
    public IDs getFriendsIDs(int i) {
        return getFriendsIDs(i, -1L);
    }

    @Deprecated
    public IDs getFriendsIDs(int i, long j) {
        return new IDs(get(getBaseURL() + "friends/ids.json?user_id=" + i + "&cursor=" + j, true), this);
    }

    @Deprecated
    public IDs getFriendsIDs(String str) {
        return getFriendsIDs(str, -1L);
    }

    @Deprecated
    public IDs getFriendsIDs(String str, long j) {
        return new IDs(get(getBaseURL() + "friends/ids.json?screen_name=" + str + "&cursor=" + j, true), this);
    }

    @Deprecated
    public IDs getFollowersIDs() {
        return getFollowersIDs(-1L);
    }

    @Deprecated
    public IDs getFollowersIDs(long j) {
        return new IDs(get(getBaseURL() + "followers/ids.json?cursor=" + j, true), this);
    }

    @Deprecated
    public IDs getFollowersIDs(int i) {
        return getFollowersIDs(i, -1L);
    }

    @Deprecated
    public IDs getFollowersIDs(int i, long j) {
        return new IDs(get(getBaseURL() + "followers/ids.xml?user_id=" + i + "&cursor=" + j, true));
    }

    @Deprecated
    public IDs getFollowersIDs(String str) {
        return getFollowersIDs(str, -1L);
    }

    @Deprecated
    public IDs getFollowersIDs(String str, long j) {
        return new IDs(get(getBaseURL() + "followers/ids.json?screen_name=" + str + "&cursor=" + j, true), this);
    }

    private void addParameterToList(List<PostParameter> list, String str, String str2) {
        if (str2 != null) {
            list.add(new PostParameter(str, str2));
        }
    }

    public User enableNotification(String str) {
        return new User(this.http.post(getBaseURL() + "notifications/follow/" + str + ".json", true).asJSONObject());
    }

    public User disableNotification(String str) {
        return new User(this.http.post(getBaseURL() + "notifications/leave/" + str + ".json", true).asJSONObject());
    }

    public List<SavedSearch> getSavedSearches() {
        return SavedSearch.constructSavedSearches(get(getBaseURL() + "saved_searches.json", true));
    }

    public SavedSearch showSavedSearch(int i) {
        return new SavedSearch(get(getBaseURL() + "saved_searches/show/" + i + ".json", true));
    }

    public SavedSearch createSavedSearch(String str) {
        return new SavedSearch(this.http.post(getBaseURL() + "saved_searches/create.json", new PostParameter[]{new PostParameter("query", str)}, true));
    }

    public SavedSearch destroySavedSearch(int i) {
        return new SavedSearch(this.http.post(getBaseURL() + "saved_searches/destroy/" + i + ".json", true));
    }

    public List<Status> getListStatuses(String str, String str2, boolean z) {
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
        return -1 != get(new StringBuilder().append(getBaseURL()).append("help/test.json").toString(), false).asString().indexOf("ok");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Weibo weibo = (Weibo) obj;
        if (this.baseURL.equals(weibo.baseURL) && this.format.equals(weibo.format) && this.http.equals(weibo.http) && this.searchBaseURL.equals(weibo.searchBaseURL)) {
            return this.source.equals(weibo.source);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.http.hashCode() * 31) + this.baseURL.hashCode()) * 31) + this.searchBaseURL.hashCode()) * 31) + this.source.hashCode()) * 31) + this.format.hashCode();
    }

    public String toString() {
        return "Weibo{http=" + this.http + ", baseURL='" + this.baseURL + "', searchBaseURL='" + this.searchBaseURL + "', source='" + this.source + "', format=" + this.format + '}';
    }

    public JSONObject showFriendships(String str) {
        return get(getBaseURL() + "friendships/show.json?target_id=" + str, true).asJSONObject();
    }

    public JSONObject showFriendships(String str, String str2) {
        return get(getBaseURL() + "friendships/show.json?target_id=" + str2 + "&source_id=" + str + "&source=" + CONSUMER_KEY, true).asJSONObject();
    }

    public JSONObject register(String str, String[] strArr) {
        return this.http.post(getBaseURL() + "account/register.json", new PostParameter[]{new PostParameter("nick", strArr[2]), new PostParameter("gender", strArr[3]), new PostParameter(PropertyConfiguration.PASSWORD, strArr[4]), new PostParameter("email", strArr[5]), new PostParameter("ip", str)}, true).asJSONObject();
    }

    public Weibo() {
        this.baseURL = Configuration.getScheme() + "api.t.sina.com.cn/";
        this.searchBaseURL = Configuration.getScheme() + "api.t.sina.com.cn/";
        this.format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        this.format.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.http.setRequestTokenURL(Configuration.getScheme() + "api.t.sina.com.cn/oauth/request_token");
        this.http.setAuthorizationURL(Configuration.getScheme() + "api.t.sina.com.cn/oauth/authorize");
        this.http.setAccessTokenURL(Configuration.getScheme() + "api.t.sina.com.cn/oauth/access_token");
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
            str2 = str + "?source=" + CONSUMER_KEY;
        } else {
            str2 = str.indexOf("source") == -1 ? str + "&source=" + CONSUMER_KEY : str;
        }
        if (postParameterArr != null && postParameterArr.length > 0) {
            str2 = str2 + "&" + HttpClient.encodeParameters(postParameterArr);
        }
        return this.http.get(str2, z);
    }

    protected Response get(String str, PostParameter[] postParameterArr, Paging paging, boolean z) {
        PostParameter[] postParameterArr2;
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
            PostParameter[] postParameterArr3 = (PostParameter[]) arrayList.toArray(new PostParameter[arrayList.size()]);
            if (postParameterArr != null) {
                PostParameter[] postParameterArr4 = new PostParameter[postParameterArr.length + arrayList.size()];
                System.arraycopy(postParameterArr, 0, postParameterArr4, 0, postParameterArr.length);
                System.arraycopy(postParameterArr3, 0, postParameterArr4, postParameterArr.length, arrayList.size());
                postParameterArr2 = postParameterArr4;
            } else if (postParameterArr3.length == 0) {
                postParameterArr2 = null;
            } else {
                String strEncodeParameters = HttpClient.encodeParameters(postParameterArr3);
                if (-1 != str.indexOf("?")) {
                    str = str + "&source=" + CONSUMER_KEY + "&" + strEncodeParameters;
                    postParameterArr2 = null;
                } else {
                    str = str + "?source=" + CONSUMER_KEY + "&" + strEncodeParameters;
                    postParameterArr2 = null;
                }
            }
            return get(str, postParameterArr2, z);
        }
        return get(str, postParameterArr, z);
    }

    private PostParameter[] generateParameterArray(Map<String, String> map) {
        PostParameter[] postParameterArr = new PostParameter[map.size()];
        int i = 0;
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                String next = it.next();
                if (map.get(next) != null) {
                    postParameterArr[i2] = new PostParameter(next, map.get(next));
                    i = i2 + 1;
                } else {
                    i = i2;
                }
            } else {
                return postParameterArr;
            }
        }
    }

    @Deprecated
    public List<User> getFriends(String str, Paging paging) {
        return getFriendsStatuses(str, paging);
    }

    @Deprecated
    public List<User> getFriends(String str, int i) {
        return getFriendsStatuses(str, new Paging(i));
    }

    @Deprecated
    public List<User> getFriends(int i) {
        return getFriendsStatuses(new Paging(i));
    }

    @Deprecated
    public List<User> getFriends() {
        return getFriendsStatuses();
    }

    @Deprecated
    public List<User> getFriends(Paging paging) {
        return getFriendsStatuses(paging);
    }

    @Deprecated
    public List<User> getFriends(String str) {
        return getFriendsStatuses(str);
    }

    @Deprecated
    public List<User> getFollowers(String str, Paging paging) {
        return getFollowersStatuses(str, paging);
    }

    @Deprecated
    public List<User> getFollowers(String str, int i) {
        return getFollowersStatuses(str, new Paging(i));
    }

    @Deprecated
    public List<User> getFollowers() {
        return getFollowersStatuses();
    }

    @Deprecated
    public List<User> getFollowers(Paging paging) {
        return getFollowersStatuses(paging);
    }

    @Deprecated
    public List<User> getFollowers(int i) {
        return getFollowersStatuses(new Paging(i));
    }

    @Deprecated
    public List<User> getFollowers(String str) {
        return getFollowersStatuses(str);
    }

    @Deprecated
    public List<Status> getPublicTimeline(int i) {
        return getPublicTimeline(i);
    }

    @Deprecated
    public List<Status> getPublicTimeline(long j) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/public_timeline.json", (PostParameter[]) null, new Paging(j), false));
    }

    @Deprecated
    public List<Status> getFriendsTimelineByPage(int i) {
        return getFriendsTimeline(new Paging(i));
    }

    @Deprecated
    public List<Status> getFriendsTimeline(int i) {
        return getFriendsTimeline(new Paging(i));
    }

    @Deprecated
    public List<Status> getFriendsTimeline(long j, int i) {
        return getFriendsTimeline(new Paging(i).sinceId(j));
    }

    @Deprecated
    public List<Status> getFriendsTimeline(String str) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public List<Status> getFriendsTimelineByPage(String str, int i) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public List<Status> getFriendsTimeline(String str, int i) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public List<Status> getFriendsTimeline(long j, String str, int i) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public List<Status> getFriendsTimeline(String str, Paging paging) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public List<Status> getFriendsTimeline(Date date) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/friends_timeline.xml", "since", this.format.format(date), true), this);
    }

    @Deprecated
    public List<Status> getFriendsTimeline(long j) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/friends_timeline.xml", "since_id", String.valueOf(j), true), this);
    }

    @Deprecated
    public List<Status> getFriendsTimeline(String str, Date date) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public List<Status> getFriendsTimeline(String str, long j) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public List<Status> getUserTimeline(String str, int i, Date date) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/user_timeline/" + str + ".xml", "since", this.format.format(date), "count", String.valueOf(i), this.http.isAuthenticationEnabled()), this);
    }

    @Deprecated
    public List<Status> getUserTimeline(String str, int i, long j) {
        return getUserTimeline(str, new Paging(j).count(i));
    }

    @Deprecated
    public List<Status> getUserTimeline(String str, Date date) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/user_timeline/" + str + ".xml", "since", this.format.format(date), this.http.isAuthenticationEnabled()), this);
    }

    @Deprecated
    public List<Status> getUserTimeline(String str, int i) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/user_timeline/" + str + ".xml", "count", String.valueOf(i), this.http.isAuthenticationEnabled()), this);
    }

    @Deprecated
    public List<Status> getUserTimeline(int i, Date date) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/user_timeline.xml", "since", this.format.format(date), "count", String.valueOf(i), true), this);
    }

    @Deprecated
    public List<Status> getUserTimeline(int i, long j) {
        return getUserTimeline(new Paging(j).count(i));
    }

    @Deprecated
    public List<Status> getUserTimeline(String str, long j) {
        return getUserTimeline(str, new Paging(j));
    }

    @Deprecated
    public List<Status> getUserTimeline(long j) {
        return getUserTimeline(new Paging(j));
    }

    @Deprecated
    public Status update(String str) {
        return updateStatus(str);
    }

    @Deprecated
    public Status update(String str, long j) {
        return updateStatus(str, j);
    }

    @Deprecated
    public List<Status> getReplies() {
        return Status.constructStatuses(get(getBaseURL() + "statuses/replies.xml", true), this);
    }

    @Deprecated
    public List<Status> getReplies(long j) {
        return Status.constructStatuses(get(getBaseURL() + "statuses/replies.xml", "since_id", String.valueOf(j), true), this);
    }

    @Deprecated
    public List<Status> getRepliesByPage(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("page should be positive integer. passed:" + i);
        }
        return Status.constructStatuses(get(getBaseURL() + "statuses/replies.xml", "page", String.valueOf(i), true), this);
    }

    @Deprecated
    public List<Status> getReplies(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("page should be positive integer. passed:" + i);
        }
        return Status.constructStatuses(get(getBaseURL() + "statuses/replies.xml", "page", String.valueOf(i), true), this);
    }

    @Deprecated
    public List<Status> getReplies(long j, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("page should be positive integer. passed:" + i);
        }
        return Status.constructStatuses(get(getBaseURL() + "statuses/replies.xml", "since_id", String.valueOf(j), "page", String.valueOf(i), true), this);
    }

    @Deprecated
    public Status show(int i) {
        return showStatus(i);
    }

    @Deprecated
    public Status show(long j) {
        return new Status(get(getBaseURL() + "statuses/show/" + j + ".xml", false), this);
    }

    @Deprecated
    public User getUserDetail(String str) {
        return showUser(str);
    }

    @Deprecated
    public List<DirectMessage> getDirectMessagesByPage(int i) {
        return getDirectMessages(new Paging(i));
    }

    @Deprecated
    public List<DirectMessage> getDirectMessages(int i, int i2) {
        return getDirectMessages(new Paging(i).sinceId(i2));
    }

    @Deprecated
    public List<DirectMessage> getDirectMessages(int i) {
        return getDirectMessages(new Paging(i));
    }

    @Deprecated
    public List<DirectMessage> getDirectMessages(Date date) {
        return DirectMessage.constructDirectMessages(get(getBaseURL() + "direct_messages.xml", "since", this.format.format(date), true), this);
    }

    @Deprecated
    public List<DirectMessage> getSentDirectMessages(Date date) {
        return DirectMessage.constructDirectMessages(get(getBaseURL() + "direct_messages/sent.xml", "since", this.format.format(date), true), this);
    }

    @Deprecated
    public List<DirectMessage> getSentDirectMessages(int i) {
        return getSentDirectMessages(new Paging(i));
    }

    @Deprecated
    public List<DirectMessage> getSentDirectMessages(int i, int i2) {
        return getSentDirectMessages(new Paging(i, i2));
    }

    @Deprecated
    public DirectMessage deleteDirectMessage(int i) {
        return destroyDirectMessage(i);
    }

    @Deprecated
    public User create(String str) {
        return createFriendship(str);
    }

    @Deprecated
    public boolean exists(String str, String str2) {
        return existsFriendship(str, str2);
    }

    @Deprecated
    public IDs getFriendsIDs(Paging paging) {
        return new IDs(get(getBaseURL() + "friends/ids.xml", (PostParameter[]) null, paging, true));
    }

    @Deprecated
    public IDs getFriendsIDs(int i, Paging paging) {
        return new IDs(get(getBaseURL() + "friends/ids.xml?user_id=" + i, (PostParameter[]) null, paging, true));
    }

    @Deprecated
    public IDs getFriendsIDs(String str, Paging paging) {
        return new IDs(get(getBaseURL() + "friends/ids.xml?screen_name=" + str, (PostParameter[]) null, paging, true));
    }

    @Deprecated
    public IDs getFollowersIDs(Paging paging) {
        return new IDs(get(getBaseURL() + "followers/ids.xml", (PostParameter[]) null, paging, true));
    }

    @Deprecated
    public IDs getFollowersIDs(int i, Paging paging) {
        return new IDs(get(getBaseURL() + "followers/ids.xml?user_id=" + i, (PostParameter[]) null, paging, true));
    }

    @Deprecated
    public IDs getFollowersIDs(String str, Paging paging) {
        return new IDs(get(getBaseURL() + "followers/ids.xml?screen_name=" + str, (PostParameter[]) null, paging, true));
    }

    @Deprecated
    public User updateLocation(String str) {
        return new User(this.http.post(getBaseURL() + "account/update_location.xml", new PostParameter[]{new PostParameter("location", str)}, true), this);
    }

    @Deprecated
    public List<Status> favorites() {
        return getFavorites();
    }

    @Deprecated
    public List<Status> favorites(int i) {
        return getFavorites(i);
    }

    @Deprecated
    public List<Status> favorites(String str) {
        return getFavorites(str);
    }

    @Deprecated
    public List<Status> favorites(String str, int i) {
        return getFavorites(str, i);
    }

    @Deprecated
    public User follow(String str) {
        return enableNotification(str);
    }

    @Deprecated
    public User leave(String str) {
        return disableNotification(str);
    }

    @Deprecated
    public User block(String str) {
        return new User(this.http.post(getBaseURL() + "blocks/create/" + str + ".xml", true), this);
    }

    @Deprecated
    public User unblock(String str) {
        return new User(this.http.post(getBaseURL() + "blocks/destroy/" + str + ".xml", true), this);
    }

    @Deprecated
    public User getAuthenticatedUser() {
        return new User(get(getBaseURL() + "account/verify_credentials.xml", true), this);
    }

    @Deprecated
    public String getDowntimeSchedule() throws WeiboException {
        throw new WeiboException("this method is not supported by the Weibo API anymore", new NoSuchMethodException("this method is not supported by the Weibo API anymore"));
    }

    @Deprecated
    public List<Trends> getDailyTrends() {
        return Trends.constructTrendsList(get(this.searchBaseURL + "trends/daily.json", false));
    }

    @Deprecated
    public List<Trends> getDailyTrends(Date date, boolean z) {
        return Trends.constructTrendsList(get(this.searchBaseURL + "trends/daily.json?date=" + toDateStr(date) + (z ? "&exclude=hashtags" : ""), false));
    }

    @Deprecated
    public List<Trends> getWeeklyTrends() {
        return Trends.constructTrendsList(get(this.searchBaseURL + "trends/weekly.json", false));
    }

    @Deprecated
    public List<Trends> getWeeklyTrends(Date date, boolean z) {
        return Trends.constructTrendsList(get(this.searchBaseURL + "trends/weekly.json?date=" + toDateStr(date) + (z ? "&exclude=hashtags" : ""), false));
    }

    public void setToken(AccessToken accessToken) {
        setToken(accessToken.getToken(), accessToken.getTokenSecret());
    }

    @Deprecated
    public List<Tag> gettags(String str) {
        return Tag.constructTags(this.http.get(getBaseURL() + "tags.json?user_id=" + str, true));
    }

    @Deprecated
    public List<Tag> getSuggestions() {
        return Tag.constructTags(get(getBaseURL() + "tags/suggestions.json", true));
    }

    @Deprecated
    public List<Status> getFavorites() {
        return Status.constructStatuses(get(getBaseURL() + "favorites.json", new PostParameter[0], true));
    }

    @Deprecated
    public List<Status> getFavorites(String str) {
        return Status.constructStatuses(get(getBaseURL() + "favorites/" + str + ".json", new PostParameter[0], true));
    }

    @Deprecated
    public List<Status> getFavorites(String str, int i) {
        return Status.constructStatuses(get(getBaseURL() + "favorites/" + str + ".json", "page", String.valueOf(i), true));
    }

    public IDs getFriendsListIDS_test(String str, int i) {
        return new IDs(get(getBaseURL() + "friends/ids.json", new PostParameter[]{new PostParameter("uid", str), new PostParameter("cursor", i)}, true), this);
    }

    public IDs getFriendsListIDS_test2(String str, int i, int i2) {
        return new IDs(get(getBaseURL() + "friends/ids.json", new PostParameter[]{new PostParameter("uid", str), new PostParameter("cursor", i), new PostParameter("count", i2)}, true), this);
    }
}
