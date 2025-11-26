package twitter4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONException;
import twitter4j.ProfileImage;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalStringUtil;

/* loaded from: classes.dex */
class TwitterImpl extends TwitterBaseImpl implements Twitter {
    private static final long serialVersionUID = -1486360080128882436L;
    private final HttpParameter INCLUDE_ENTITIES;
    private final HttpParameter INCLUDE_MY_RETWEET;
    private final HttpParameter INCLUDE_RTS;

    TwitterImpl(Configuration configuration, Authorization authorization) {
        super(configuration, authorization);
        this.INCLUDE_ENTITIES = new HttpParameter("include_entities", configuration.isIncludeEntitiesEnabled());
        this.INCLUDE_RTS = new HttpParameter("include_rts", configuration.isIncludeRTsEnabled());
        this.INCLUDE_MY_RETWEET = new HttpParameter("include_my_retweet", 1);
    }

    private HttpParameter[] mergeParameters(HttpParameter[] httpParameterArr, HttpParameter[] httpParameterArr2) {
        if (httpParameterArr != null && httpParameterArr2 != null) {
            HttpParameter[] httpParameterArr3 = new HttpParameter[httpParameterArr.length + httpParameterArr2.length];
            System.arraycopy(httpParameterArr, 0, httpParameterArr3, 0, httpParameterArr.length);
            System.arraycopy(httpParameterArr2, 0, httpParameterArr3, httpParameterArr.length, httpParameterArr2.length);
            return httpParameterArr3;
        }
        if (httpParameterArr == null && httpParameterArr2 == null) {
            return new HttpParameter[0];
        }
        return httpParameterArr == null ? httpParameterArr2 : httpParameterArr;
    }

    private HttpParameter[] mergeParameters(HttpParameter[] httpParameterArr, HttpParameter httpParameter) {
        if (httpParameterArr != null && httpParameter != null) {
            HttpParameter[] httpParameterArr2 = new HttpParameter[httpParameterArr.length + 1];
            System.arraycopy(httpParameterArr, 0, httpParameterArr2, 0, httpParameterArr.length);
            httpParameterArr2[httpParameterArr2.length - 1] = httpParameter;
            return httpParameterArr2;
        }
        if (httpParameterArr == null && httpParameter == null) {
            return new HttpParameter[0];
        }
        return httpParameterArr == null ? new HttpParameter[]{httpParameter} : httpParameterArr;
    }

    @Override // twitter4j.api.SearchMethods
    public QueryResult search(Query query) {
        return this.factory.createQueryResult(get(new StringBuffer().append(this.conf.getSearchBaseURL()).append("search.json").toString(), query.asHttpParameterArray(this.INCLUDE_ENTITIES)), query);
    }

    @Override // twitter4j.api.TrendsMethods
    public ResponseList getDailyTrends() {
        return this.factory.createTrendsList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("trends/daily.json").toString()));
    }

    @Override // twitter4j.api.TrendsMethods
    public ResponseList getDailyTrends(Date date, boolean z) {
        return this.factory.createTrendsList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("trends/daily.json?date=").append(toDateStr(date)).append(z ? "&exclude=hashtags" : "").toString()));
    }

    private String toDateStr(Date date) {
        if (date == null) {
            date = new Date();
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    @Override // twitter4j.api.TrendsMethods
    public ResponseList getWeeklyTrends() {
        return this.factory.createTrendsList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("trends/weekly.json").toString()));
    }

    @Override // twitter4j.api.TrendsMethods
    public ResponseList getWeeklyTrends(Date date, boolean z) {
        return this.factory.createTrendsList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("trends/weekly.json?date=").append(toDateStr(date)).append(z ? "&exclude=hashtags" : "").toString()));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getPublicTimeline() {
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/public_timeline.json?include_my_retweet=1&include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&include_rts=").append(this.conf.isIncludeRTsEnabled()).toString()));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getHomeTimeline() {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/home_timeline.json?include_my_retweet=1&include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getHomeTimeline(Paging paging) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/home_timeline.json").toString(), mergeParameters(paging.asPostParameterArray(), new HttpParameter[]{this.INCLUDE_ENTITIES, this.INCLUDE_MY_RETWEET})));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getFriendsTimeline() {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/friends_timeline.json?include_my_retweet=1&include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&include_rts=").append(this.conf.isIncludeRTsEnabled()).toString()));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getFriendsTimeline(Paging paging) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/friends_timeline.json").toString(), mergeParameters(new HttpParameter[]{this.INCLUDE_RTS, this.INCLUDE_ENTITIES, this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getUserTimeline(String str, Paging paging) {
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/user_timeline.json").toString(), mergeParameters(new HttpParameter[]{new HttpParameter("screen_name", str), this.INCLUDE_RTS, this.INCLUDE_ENTITIES, this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getUserTimeline(long j, Paging paging) {
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/user_timeline.json").toString(), mergeParameters(new HttpParameter[]{new HttpParameter("user_id", j), this.INCLUDE_RTS, this.INCLUDE_ENTITIES, this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getUserTimeline(String str) {
        return getUserTimeline(str, new Paging());
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getUserTimeline(long j) {
        return getUserTimeline(j, new Paging());
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getUserTimeline() {
        return getUserTimeline(new Paging());
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getUserTimeline(Paging paging) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/user_timeline.json").toString(), mergeParameters(new HttpParameter[]{this.INCLUDE_RTS, this.INCLUDE_ENTITIES, this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getMentions() {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/mentions.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&include_rts=").append(this.conf.isIncludeRTsEnabled()).toString()));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getMentions(Paging paging) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/mentions.json").toString(), mergeParameters(new HttpParameter[]{this.INCLUDE_RTS, this.INCLUDE_ENTITIES}, paging.asPostParameterArray())));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getRetweetedByMe() {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/retweeted_by_me.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getRetweetedByMe(Paging paging) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/retweeted_by_me.json").toString(), mergeParameters(paging.asPostParameterArray(), this.INCLUDE_ENTITIES)));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getRetweetedToMe() {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/retweeted_to_me.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getRetweetedToMe(Paging paging) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/retweeted_to_me.json").toString(), mergeParameters(paging.asPostParameterArray(), this.INCLUDE_ENTITIES)));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getRetweetsOfMe() {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/retweets_of_me.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getRetweetsOfMe(Paging paging) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/retweets_of_me.json").toString(), mergeParameters(paging.asPostParameterArray(), this.INCLUDE_ENTITIES)));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getRetweetedToUser(String str, Paging paging) {
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/retweeted_to_user.json").toString(), mergeParameters(paging.asPostParameterArray(), new HttpParameter[]{new HttpParameter("screen_name", str), this.INCLUDE_ENTITIES})));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getRetweetedToUser(long j, Paging paging) {
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/retweeted_to_user.json").toString(), mergeParameters(paging.asPostParameterArray(), new HttpParameter[]{new HttpParameter("user_id", j), this.INCLUDE_ENTITIES})));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getRetweetedByUser(String str, Paging paging) {
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/retweeted_by_user.json").toString(), mergeParameters(paging.asPostParameterArray(), new HttpParameter[]{new HttpParameter("screen_name", str), this.INCLUDE_ENTITIES})));
    }

    @Override // twitter4j.api.TimelineMethods
    public ResponseList getRetweetedByUser(long j, Paging paging) {
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/retweeted_by_user.json").toString(), mergeParameters(paging.asPostParameterArray(), new HttpParameter[]{new HttpParameter("user_id", j), this.INCLUDE_ENTITIES})));
    }

    @Override // twitter4j.api.StatusMethods
    public ResponseList getRetweetedBy(long j) {
        return getRetweetedBy(j, new Paging(1, 100));
    }

    @Override // twitter4j.api.StatusMethods
    public ResponseList getRetweetedBy(long j, Paging paging) {
        return this.factory.createUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/").append(j).append("/retweeted_by.json").toString(), paging.asPostParameterArray()));
    }

    @Override // twitter4j.api.StatusMethods
    public IDs getRetweetedByIDs(long j) {
        return getRetweetedByIDs(j, new Paging(1, 100));
    }

    @Override // twitter4j.api.StatusMethods
    public IDs getRetweetedByIDs(long j, Paging paging) {
        ensureAuthorizationEnabled();
        return this.factory.createIDs(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/").append(j).append("/retweeted_by/ids.json").toString(), paging.asPostParameterArray()));
    }

    @Override // twitter4j.api.StatusMethods
    public Status showStatus(long j) {
        return this.factory.createStatus(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/show/").append(j).append(".json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.StatusMethods
    public Status updateStatus(String str) {
        ensureAuthorizationEnabled();
        return this.factory.createStatus(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/update.json").toString(), new HttpParameter[]{new HttpParameter("status", str), this.INCLUDE_ENTITIES}));
    }

    @Override // twitter4j.api.StatusMethods
    public Status updateStatus(StatusUpdate statusUpdate) {
        ensureAuthorizationEnabled();
        return this.factory.createStatus(post(statusUpdate.isWithMedia() ? new StringBuffer().append(this.conf.getUploadBaseURL()).append("statuses/update_with_media.json").toString() : new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/update.json").toString(), statusUpdate.asHttpParameterArray(this.INCLUDE_ENTITIES)));
    }

    @Override // twitter4j.api.StatusMethods
    public Status destroyStatus(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createStatus(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/destroy/").append(j).append(".json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.StatusMethods
    public Status retweetStatus(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createStatus(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/retweet/").append(j).append(".json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.StatusMethods
    public ResponseList getRetweets(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/retweets/").append(j).append(".json?count=100&include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.UserMethods
    public User showUser(String str) {
        return this.factory.createUser(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("users/show.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&screen_name=").append(str).toString()));
    }

    @Override // twitter4j.api.UserMethods
    public User showUser(long j) {
        return this.factory.createUser(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("users/show.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&user_id=").append(j).toString()));
    }

    @Override // twitter4j.api.UserMethods
    public ResponseList lookupUsers(String[] strArr) {
        ensureAuthorizationEnabled();
        return this.factory.createUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("users/lookup.json").toString(), new HttpParameter[]{new HttpParameter("screen_name", z_T4JInternalStringUtil.join(strArr)), this.INCLUDE_ENTITIES}));
    }

    @Override // twitter4j.api.UserMethods
    public ResponseList lookupUsers(long[] jArr) {
        ensureAuthorizationEnabled();
        return this.factory.createUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("users/lookup.json").toString(), new HttpParameter[]{new HttpParameter("user_id", z_T4JInternalStringUtil.join(jArr)), this.INCLUDE_ENTITIES}));
    }

    @Override // twitter4j.api.UserMethods
    public ResponseList searchUsers(String str, int i) {
        ensureAuthorizationEnabled();
        return this.factory.createUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("users/search.json").toString(), new HttpParameter[]{new HttpParameter("q", str), new HttpParameter("per_page", 20), new HttpParameter("page", i), this.INCLUDE_ENTITIES}));
    }

    @Override // twitter4j.api.UserMethods
    public ResponseList getSuggestedUserCategories() {
        return this.factory.createCategoryList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("users/suggestions.json").toString()));
    }

    @Override // twitter4j.api.UserMethods
    public ResponseList getUserSuggestions(String str) {
        return this.factory.createUserListFromJSONArray_Users(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("users/suggestions/").append(str).append(".json").toString()));
    }

    @Override // twitter4j.api.UserMethods
    public ResponseList getMemberSuggestions(String str) {
        return this.factory.createUserListFromJSONArray(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("users/suggestions/").append(str).append("/members.json").toString()));
    }

    @Override // twitter4j.api.UserMethods
    public ProfileImage getProfileImage(String str, ProfileImage.ImageSize imageSize) {
        return this.factory.createProfileImage(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("users/profile_image/").append(str).append(".json?size=").append(imageSize.getName()).toString()));
    }

    @Override // twitter4j.api.UserMethods
    public PagableResponseList getFriendsStatuses(long j) {
        return this.factory.createPagableUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/friends.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.UserMethods
    public PagableResponseList getFriendsStatuses(String str, long j) {
        return this.factory.createPagableUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/friends.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&screen_name=").append(str).append("&cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.UserMethods
    public PagableResponseList getFriendsStatuses(long j, long j2) {
        return this.factory.createPagableUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/friends.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&user_id=").append(j).append("&cursor=").append(j2).toString()));
    }

    @Override // twitter4j.api.UserMethods
    public PagableResponseList getFollowersStatuses(long j) {
        return this.factory.createPagableUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/followers.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.UserMethods
    public PagableResponseList getFollowersStatuses(String str, long j) {
        return this.factory.createPagableUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/followers.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&screen_name=").append(str).append("&cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.UserMethods
    public PagableResponseList getFollowersStatuses(long j, long j2) {
        return this.factory.createPagableUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("statuses/followers.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&user_id=").append(j).append("&cursor=").append(j2).toString()));
    }

    @Override // twitter4j.api.ListMethods
    public UserList createUserList(String str, boolean z, String str2) {
        ensureAuthorizationEnabled();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HttpParameter("name", str));
        arrayList.add(new HttpParameter(RtspHeaders.Values.MODE, z ? "public" : "private"));
        if (str2 != null) {
            arrayList.add(new HttpParameter("description", str2));
        }
        return this.factory.createAUserList(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/create.json").toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    @Override // twitter4j.api.ListMethods
    public UserList updateUserList(int i, String str, boolean z, String str2) {
        ensureAuthorizationEnabled();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HttpParameter("list_id", i));
        if (str != null) {
            arrayList.add(new HttpParameter("name", str));
        }
        arrayList.add(new HttpParameter(RtspHeaders.Values.MODE, z ? "public" : "private"));
        if (str2 != null) {
            arrayList.add(new HttpParameter("description", str2));
        }
        return this.factory.createAUserList(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/update.json").toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    @Override // twitter4j.api.ListMethods
    public PagableResponseList getUserLists(String str, long j) {
        return this.factory.createPagableUserListList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists.json?screen_name=").append(str).append("&cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.ListMethods
    public PagableResponseList getUserLists(long j, long j2) {
        return this.factory.createPagableUserListList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists.json?user_id=").append(j).append("&cursor=").append(j2).toString()));
    }

    @Override // twitter4j.api.ListMethods
    public UserList showUserList(String str, int i) {
        return showUserList(i);
    }

    @Override // twitter4j.api.ListMethods
    public UserList showUserList(int i) {
        return this.factory.createAUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/show.json?list_id=").append(i).toString()));
    }

    @Override // twitter4j.api.ListMethods
    public UserList destroyUserList(int i) {
        ensureAuthorizationEnabled();
        return this.factory.createAUserList(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/destroy.json").toString(), new HttpParameter[]{new HttpParameter("list_id", i)}));
    }

    @Override // twitter4j.api.ListMethods
    public ResponseList getUserListStatuses(String str, int i, Paging paging) {
        return getUserListStatuses(i, paging);
    }

    @Override // twitter4j.api.ListMethods
    public ResponseList getUserListStatuses(long j, int i, Paging paging) {
        return getUserListStatuses(i, paging);
    }

    @Override // twitter4j.api.ListMethods
    public ResponseList getUserListStatuses(int i, Paging paging) {
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/statuses.json").toString(), mergeParameters(paging.asPostParameterArray(Paging.SMCP, "per_page"), new HttpParameter[]{new HttpParameter("list_id", i), this.INCLUDE_ENTITIES, this.INCLUDE_RTS})));
    }

    @Override // twitter4j.api.ListMethods
    public PagableResponseList getUserListMemberships(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createPagableUserListList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/memberships.json?cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.ListMethods
    public PagableResponseList getUserListMemberships(String str, long j) {
        return getUserListMemberships(str, j, false);
    }

    @Override // twitter4j.api.ListMethods
    public PagableResponseList getUserListMemberships(long j, long j2) {
        return getUserListMemberships(j, j2, false);
    }

    @Override // twitter4j.api.ListMethods
    public PagableResponseList getUserListMemberships(long j, long j2, boolean z) {
        if (z) {
            ensureAuthorizationEnabled();
        }
        return this.factory.createPagableUserListList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/memberships.json?user_id=").append(j).append("&cursor=").append(j2).append("&filter_to_owned_lists=").append(z).toString()));
    }

    @Override // twitter4j.api.ListMethods
    public PagableResponseList getUserListMemberships(String str, long j, boolean z) {
        if (z) {
            ensureAuthorizationEnabled();
        }
        return this.factory.createPagableUserListList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/memberships.json?screen_name=").append(str).append("&cursor=").append(j).append("&filter_to_owned_lists=").append(z).toString()));
    }

    @Override // twitter4j.api.ListMethods
    public PagableResponseList getUserListSubscriptions(String str, long j) {
        return this.factory.createPagableUserListList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/subscriptions.json?screen_name=").append(str).append("&cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.ListMethods
    public ResponseList getAllUserLists(String str) {
        return this.factory.createUserListList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/all.json?screen_name=").append(str).toString()));
    }

    @Override // twitter4j.api.ListMethods
    public ResponseList getAllUserLists(long j) {
        return this.factory.createUserListList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/all.json?user_id=").append(j).toString()));
    }

    @Override // twitter4j.api.ListMembersMethods
    public PagableResponseList getUserListMembers(String str, int i, long j) {
        return getUserListMembers(i, j);
    }

    @Override // twitter4j.api.ListMembersMethods
    public PagableResponseList getUserListMembers(long j, int i, long j2) {
        return getUserListMembers(i, j2);
    }

    @Override // twitter4j.api.ListMembersMethods
    public PagableResponseList getUserListMembers(int i, long j) {
        return this.factory.createPagableUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/members.json?list_id=").append(i).append("&include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.ListMembersMethods
    public UserList addUserListMember(int i, long j) {
        ensureAuthorizationEnabled();
        return this.factory.createAUserList(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/members/create.json").toString(), new HttpParameter[]{new HttpParameter("user_id", j), new HttpParameter("list_id", i)}));
    }

    @Override // twitter4j.api.ListMembersMethods
    public UserList addUserListMembers(int i, long[] jArr) {
        ensureAuthorizationEnabled();
        return this.factory.createAUserList(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/members/create_all.json").toString(), new HttpParameter[]{new HttpParameter("list_id", i), new HttpParameter("user_id", z_T4JInternalStringUtil.join(jArr))}));
    }

    @Override // twitter4j.api.ListMembersMethods
    public UserList addUserListMembers(int i, String[] strArr) {
        ensureAuthorizationEnabled();
        return this.factory.createAUserList(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/members/create_all.json").toString(), new HttpParameter[]{new HttpParameter("list_id", i), new HttpParameter("screen_name", z_T4JInternalStringUtil.join(strArr))}));
    }

    @Override // twitter4j.api.ListMembersMethods
    public UserList deleteUserListMember(int i, long j) {
        ensureAuthorizationEnabled();
        return this.factory.createAUserList(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/members/destroy.json").toString(), new HttpParameter[]{new HttpParameter("list_id", i), new HttpParameter("user_id", j)}));
    }

    @Override // twitter4j.api.ListMembersMethods
    public User checkUserListMembership(String str, int i, long j) {
        return showUserListMembership(i, j);
    }

    @Override // twitter4j.api.ListMembersMethods
    public User showUserListMembership(int i, long j) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/members/show.json?list_id=").append(i).append("&user_id=").append(j).append("&include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.ListSubscribersMethods
    public PagableResponseList getUserListSubscribers(String str, int i, long j) {
        return getUserListSubscribers(i, j);
    }

    @Override // twitter4j.api.ListSubscribersMethods
    public PagableResponseList getUserListSubscribers(int i, long j) {
        return this.factory.createPagableUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/subscribers.json?list_id=").append(i).append("&include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.ListSubscribersMethods
    public UserList subscribeUserList(String str, int i) {
        ensureAuthorizationEnabled();
        return this.factory.createAUserList(post(new StringBuffer().append(this.conf.getRestBaseURL()).append(str).append("/").append(i).append("/subscribers.json").toString()));
    }

    @Override // twitter4j.api.ListSubscribersMethods
    public UserList createUserListSubscription(int i) {
        ensureAuthorizationEnabled();
        return this.factory.createAUserList(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/subscribers/create.json").toString(), new HttpParameter[]{new HttpParameter("list_id", i)}));
    }

    @Override // twitter4j.api.ListSubscribersMethods
    public UserList unsubscribeUserList(String str, int i) {
        return destroyUserListSubscription(i);
    }

    @Override // twitter4j.api.ListSubscribersMethods
    public UserList destroyUserListSubscription(int i) {
        ensureAuthorizationEnabled();
        return this.factory.createAUserList(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/subscribers/destroy.json").toString(), new HttpParameter[]{new HttpParameter("list_id", i)}));
    }

    @Override // twitter4j.api.ListSubscribersMethods
    public User checkUserListSubscription(String str, int i, long j) {
        return showUserListSubscription(i, j);
    }

    @Override // twitter4j.api.ListSubscribersMethods
    public User showUserListSubscription(int i, long j) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("lists/subscribers/show.json?list_id=").append(i).append("&user_id=").append(j).append("&include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.DirectMessageMethods
    public ResponseList getDirectMessages() {
        ensureAuthorizationEnabled();
        return this.factory.createDirectMessageList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("direct_messages.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.DirectMessageMethods
    public ResponseList getDirectMessages(Paging paging) {
        ensureAuthorizationEnabled();
        return this.factory.createDirectMessageList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("direct_messages.json").toString(), mergeParameters(paging.asPostParameterArray(), this.INCLUDE_ENTITIES)));
    }

    @Override // twitter4j.api.DirectMessageMethods
    public ResponseList getSentDirectMessages() {
        ensureAuthorizationEnabled();
        return this.factory.createDirectMessageList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("direct_messages/sent.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.DirectMessageMethods
    public ResponseList getSentDirectMessages(Paging paging) {
        ensureAuthorizationEnabled();
        return this.factory.createDirectMessageList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("direct_messages/sent.json").toString(), mergeParameters(paging.asPostParameterArray(), this.INCLUDE_ENTITIES)));
    }

    @Override // twitter4j.api.DirectMessageMethods
    public DirectMessage sendDirectMessage(String str, String str2) {
        ensureAuthorizationEnabled();
        return this.factory.createDirectMessage(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("direct_messages/new.json").toString(), new HttpParameter[]{new HttpParameter("screen_name", str), new HttpParameter("text", str2), this.INCLUDE_ENTITIES}));
    }

    @Override // twitter4j.api.DirectMessageMethods
    public DirectMessage sendDirectMessage(long j, String str) {
        ensureAuthorizationEnabled();
        return this.factory.createDirectMessage(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("direct_messages/new.json").toString(), new HttpParameter[]{new HttpParameter("user_id", j), new HttpParameter("text", str), this.INCLUDE_ENTITIES}));
    }

    @Override // twitter4j.api.DirectMessageMethods
    public DirectMessage destroyDirectMessage(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createDirectMessage(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("direct_messages/destroy/").append(j).append(".json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.DirectMessageMethods
    public DirectMessage showDirectMessage(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createDirectMessage(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("direct_messages/show/").append(j).append(".json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.FriendshipMethods
    public User createFriendship(String str) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/create.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&screen_name=").append(str).toString()));
    }

    @Override // twitter4j.api.FriendshipMethods
    public User createFriendship(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/create.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&user_id=").append(j).toString()));
    }

    @Override // twitter4j.api.FriendshipMethods
    public User createFriendship(String str, boolean z) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/create.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&screen_name=").append(str).append("&follow=").append(z).toString()));
    }

    @Override // twitter4j.api.FriendshipMethods
    public User createFriendship(long j, boolean z) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/create.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&user_id=").append(j).append("&follow=").append(z).toString()));
    }

    @Override // twitter4j.api.FriendshipMethods
    public User destroyFriendship(String str) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/destroy.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&screen_name=").append(str).toString()));
    }

    @Override // twitter4j.api.FriendshipMethods
    public User destroyFriendship(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/destroy.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&user_id=").append(j).toString()));
    }

    @Override // twitter4j.api.FriendshipMethods
    public boolean existsFriendship(String str, String str2) {
        return -1 != get(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/exists.json").toString(), HttpParameter.getParameterArray("user_a", str, "user_b", str2)).asString().indexOf("true");
    }

    @Override // twitter4j.api.FriendshipMethods
    public Relationship showFriendship(String str, String str2) {
        return this.factory.createRelationship(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/show.json").toString(), HttpParameter.getParameterArray("source_screen_name", str, "target_screen_name", str2)));
    }

    @Override // twitter4j.api.FriendshipMethods
    public Relationship showFriendship(long j, long j2) {
        return this.factory.createRelationship(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/show.json").toString(), new HttpParameter[]{new HttpParameter("source_id", j), new HttpParameter("target_id", j2)}));
    }

    @Override // twitter4j.api.FriendshipMethods
    public IDs getIncomingFriendships(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createIDs(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/incoming.json?cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.FriendshipMethods
    public IDs getOutgoingFriendships(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createIDs(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/outgoing.json?cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.FriendshipMethods
    public ResponseList lookupFriendships(String[] strArr) {
        ensureAuthorizationEnabled();
        return this.factory.createFriendshipList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/lookup.json?screen_name=").append(z_T4JInternalStringUtil.join(strArr)).toString()));
    }

    @Override // twitter4j.api.FriendshipMethods
    public ResponseList lookupFriendships(long[] jArr) {
        ensureAuthorizationEnabled();
        return this.factory.createFriendshipList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/lookup.json?user_id=").append(z_T4JInternalStringUtil.join(jArr)).toString()));
    }

    @Override // twitter4j.api.FriendshipMethods
    public Relationship updateFriendship(String str, boolean z, boolean z2) {
        ensureAuthorizationEnabled();
        return this.factory.createRelationship(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/update.json").toString(), new HttpParameter[]{new HttpParameter("screen_name", str), new HttpParameter("device", z), new HttpParameter("retweets", z)}));
    }

    @Override // twitter4j.api.FriendshipMethods
    public Relationship updateFriendship(long j, boolean z, boolean z2) {
        ensureAuthorizationEnabled();
        return this.factory.createRelationship(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/update.json").toString(), new HttpParameter[]{new HttpParameter("user_id", j), new HttpParameter("device", z), new HttpParameter("retweets", z)}));
    }

    @Override // twitter4j.api.FriendshipMethods
    public IDs getNoRetweetIds() {
        ensureAuthorizationEnabled();
        return this.factory.createIDs(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("friendships/no_retweet_ids.json").toString()));
    }

    @Override // twitter4j.api.FriendsFollowersMethods
    public IDs getFriendsIDs(long j) {
        return this.factory.createIDs(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("friends/ids.json?cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.FriendsFollowersMethods
    public IDs getFriendsIDs(long j, long j2) {
        return this.factory.createIDs(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("friends/ids.json?user_id=").append(j).append("&cursor=").append(j2).toString()));
    }

    @Override // twitter4j.api.FriendsFollowersMethods
    public IDs getFriendsIDs(String str, long j) {
        return this.factory.createIDs(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("friends/ids.json?screen_name=").append(str).append("&cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.FriendsFollowersMethods
    public IDs getFollowersIDs(long j) {
        return this.factory.createIDs(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("followers/ids.json?cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.FriendsFollowersMethods
    public IDs getFollowersIDs(long j, long j2) {
        return this.factory.createIDs(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("followers/ids.json?user_id=").append(j).append("&cursor=").append(j2).toString()));
    }

    @Override // twitter4j.api.FriendsFollowersMethods
    public IDs getFollowersIDs(String str, long j) {
        return this.factory.createIDs(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("followers/ids.json?screen_name=").append(str).append("&cursor=").append(j).toString()));
    }

    @Override // twitter4j.api.AccountMethods
    public User verifyCredentials() {
        return super.fillInIDAndScreenName();
    }

    @Override // twitter4j.api.AccountMethods
    public RateLimitStatus getRateLimitStatus() {
        return this.factory.createRateLimitStatus(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("account/rate_limit_status.json").toString()));
    }

    @Override // twitter4j.api.AccountMethods
    public User updateProfile(String str, String str2, String str3, String str4) {
        ensureAuthorizationEnabled();
        ArrayList arrayList = new ArrayList(4);
        addParameterToList(arrayList, "name", str);
        addParameterToList(arrayList, RtspHeaders.Values.URL, str2);
        addParameterToList(arrayList, "location", str3);
        addParameterToList(arrayList, "description", str4);
        arrayList.add(this.INCLUDE_ENTITIES);
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("account/update_profile.json").toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    @Override // twitter4j.api.AccountMethods
    public AccountTotals getAccountTotals() {
        ensureAuthorizationEnabled();
        return this.factory.createAccountTotals(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("account/totals.json").toString()));
    }

    @Override // twitter4j.api.AccountMethods
    public AccountSettings getAccountSettings() {
        ensureAuthorizationEnabled();
        return this.factory.createAccountSettings(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("account/settings.json").toString()));
    }

    @Override // twitter4j.api.AccountMethods
    public AccountSettings updateAccountSettings(Integer num, Boolean bool, String str, String str2, String str3, String str4) {
        ensureAuthorizationEnabled();
        ArrayList arrayList = new ArrayList(6);
        if (num != null) {
            arrayList.add(new HttpParameter("trend_location_woeid", num.intValue()));
        }
        if (bool != null) {
            arrayList.add(new HttpParameter("sleep_time_enabled", bool.toString()));
        }
        if (str != null) {
            arrayList.add(new HttpParameter("start_sleep_time", str));
        }
        if (str2 != null) {
            arrayList.add(new HttpParameter("end_sleep_time", str2));
        }
        if (str3 != null) {
            arrayList.add(new HttpParameter("time_zone", str3));
        }
        if (str4 != null) {
            arrayList.add(new HttpParameter("lang", str4));
        }
        arrayList.add(this.INCLUDE_ENTITIES);
        return this.factory.createAccountSettings(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("account/settings.json").toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    @Override // twitter4j.api.AccountMethods
    public User updateProfileColors(String str, String str2, String str3, String str4, String str5) {
        ensureAuthorizationEnabled();
        ArrayList arrayList = new ArrayList(6);
        addParameterToList(arrayList, "profile_background_color", str);
        addParameterToList(arrayList, "profile_text_color", str2);
        addParameterToList(arrayList, "profile_link_color", str3);
        addParameterToList(arrayList, "profile_sidebar_fill_color", str4);
        addParameterToList(arrayList, "profile_sidebar_border_color", str5);
        arrayList.add(this.INCLUDE_ENTITIES);
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("account/update_profile_colors.json").toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    private void addParameterToList(List list, String str, String str2) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    @Override // twitter4j.api.AccountMethods
    public User updateProfileImage(File file) throws TwitterException {
        checkFileValidity(file);
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("account/update_profile_image.json").toString(), new HttpParameter[]{new HttpParameter("image", file), this.INCLUDE_ENTITIES}));
    }

    @Override // twitter4j.api.AccountMethods
    public User updateProfileImage(InputStream inputStream) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("account/update_profile_image.json").toString(), new HttpParameter[]{new HttpParameter("image", "image", inputStream), this.INCLUDE_ENTITIES}));
    }

    @Override // twitter4j.api.AccountMethods
    public User updateProfileBackgroundImage(File file, boolean z) throws TwitterException {
        ensureAuthorizationEnabled();
        checkFileValidity(file);
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("account/update_profile_background_image.json").toString(), new HttpParameter[]{new HttpParameter("image", file), new HttpParameter("tile", z), this.INCLUDE_ENTITIES}));
    }

    @Override // twitter4j.api.AccountMethods
    public User updateProfileBackgroundImage(InputStream inputStream, boolean z) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("account/update_profile_background_image.json").toString(), new HttpParameter[]{new HttpParameter("image", "image", inputStream), new HttpParameter("tile", z), this.INCLUDE_ENTITIES}));
    }

    private void checkFileValidity(File file) throws TwitterException {
        if (!file.exists()) {
            throw new TwitterException(new FileNotFoundException(new StringBuffer().append(file).append(" is not found.").toString()));
        }
        if (!file.isFile()) {
            throw new TwitterException(new IOException(new StringBuffer().append(file).append(" is not a file.").toString()));
        }
    }

    @Override // twitter4j.api.FavoriteMethods
    public ResponseList getFavorites() {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("favorites.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.FavoriteMethods
    public ResponseList getFavorites(int i) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("favorites.json").toString(), new HttpParameter[]{new HttpParameter("page", i), this.INCLUDE_ENTITIES}));
    }

    @Override // twitter4j.api.FavoriteMethods
    public ResponseList getFavorites(String str) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("favorites/").append(str).append(".json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.FavoriteMethods
    public ResponseList getFavorites(String str, int i) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("favorites/").append(str).append(".json").toString(), mergeParameters(HttpParameter.getParameterArray("page", i), this.INCLUDE_ENTITIES)));
    }

    @Override // twitter4j.api.FavoriteMethods
    public ResponseList getFavorites(Paging paging) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("favorites.json").toString(), mergeParameters(paging.asPostParameterArray(), this.INCLUDE_ENTITIES)));
    }

    @Override // twitter4j.api.FavoriteMethods
    public ResponseList getFavorites(String str, Paging paging) {
        ensureAuthorizationEnabled();
        return this.factory.createStatusList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("favorites/").append(str).append(".json").toString(), mergeParameters(paging.asPostParameterArray(), this.INCLUDE_ENTITIES)));
    }

    @Override // twitter4j.api.FavoriteMethods
    public Status createFavorite(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createStatus(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("favorites/create/").append(j).append(".json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.FavoriteMethods
    public Status destroyFavorite(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createStatus(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("favorites/destroy/").append(j).append(".json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.NotificationMethods
    public User enableNotification(String str) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("notifications/follow.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&screen_name=").append(str).toString()));
    }

    @Override // twitter4j.api.NotificationMethods
    public User enableNotification(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("notifications/follow.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&user_id=").append(j).toString()));
    }

    @Override // twitter4j.api.NotificationMethods
    public User disableNotification(String str) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("notifications/leave.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&screen_name=").append(str).toString()));
    }

    @Override // twitter4j.api.NotificationMethods
    public User disableNotification(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("notifications/leave.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&user_id=").append(j).toString()));
    }

    @Override // twitter4j.api.BlockMethods
    public User createBlock(String str) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("blocks/create.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&screen_name=").append(str).toString()));
    }

    @Override // twitter4j.api.BlockMethods
    public User createBlock(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("blocks/create.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&user_id=").append(j).toString()));
    }

    @Override // twitter4j.api.BlockMethods
    public User destroyBlock(String str) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("blocks/destroy.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&screen_name=").append(str).toString()));
    }

    @Override // twitter4j.api.BlockMethods
    public User destroyBlock(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("blocks/destroy.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&user_id=").append(j).toString()));
    }

    @Override // twitter4j.api.BlockMethods
    public boolean existsBlock(String str) throws TwitterException {
        ensureAuthorizationEnabled();
        try {
            return -1 == get(new StringBuffer().append(this.conf.getRestBaseURL()).append("blocks/exists.json?screen_name=").append(str).toString()).asString().indexOf("You are not blocking this user.");
        } catch (TwitterException e) {
            if (e.getStatusCode() != 404) {
                throw e;
            }
            return false;
        }
    }

    @Override // twitter4j.api.BlockMethods
    public boolean existsBlock(long j) throws TwitterException {
        ensureAuthorizationEnabled();
        try {
            return -1 == get(new StringBuffer().append(this.conf.getRestBaseURL()).append("blocks/exists.json?user_id=").append(j).toString()).asString().indexOf("<error>You are not blocking this user.</error>");
        } catch (TwitterException e) {
            if (e.getStatusCode() != 404) {
                throw e;
            }
            return false;
        }
    }

    @Override // twitter4j.api.BlockMethods
    public ResponseList getBlockingUsers() {
        ensureAuthorizationEnabled();
        return this.factory.createUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("blocks/blocking.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString()));
    }

    @Override // twitter4j.api.BlockMethods
    public ResponseList getBlockingUsers(int i) {
        ensureAuthorizationEnabled();
        return this.factory.createUserList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("blocks/blocking.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&page=").append(i).toString()));
    }

    @Override // twitter4j.api.BlockMethods
    public IDs getBlockingUsersIDs() {
        ensureAuthorizationEnabled();
        return this.factory.createIDs(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("blocks/blocking/ids.json").toString()));
    }

    @Override // twitter4j.api.SpamReportingMethods
    public User reportSpam(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("report_spam.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&user_id=").append(j).toString()));
    }

    @Override // twitter4j.api.SpamReportingMethods
    public User reportSpam(String str) {
        ensureAuthorizationEnabled();
        return this.factory.createUser(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("report_spam.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).append("&screen_name=").append(str).toString()));
    }

    @Override // twitter4j.api.SavedSearchesMethods
    public ResponseList getSavedSearches() {
        ensureAuthorizationEnabled();
        return this.factory.createSavedSearchList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("saved_searches.json").toString()));
    }

    @Override // twitter4j.api.SavedSearchesMethods
    public SavedSearch showSavedSearch(int i) {
        ensureAuthorizationEnabled();
        return this.factory.createSavedSearch(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("saved_searches/show/").append(i).append(".json").toString()));
    }

    @Override // twitter4j.api.SavedSearchesMethods
    public SavedSearch createSavedSearch(String str) {
        ensureAuthorizationEnabled();
        return this.factory.createSavedSearch(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("saved_searches/create.json").toString(), new HttpParameter[]{new HttpParameter("query", str)}));
    }

    @Override // twitter4j.api.SavedSearchesMethods
    public SavedSearch destroySavedSearch(int i) {
        ensureAuthorizationEnabled();
        return this.factory.createSavedSearch(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("saved_searches/destroy/").append(i).append(".json").toString()));
    }

    @Override // twitter4j.api.LocalTrendsMethods
    public ResponseList getAvailableTrends() {
        return this.factory.createLocationList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("trends/available.json").toString()));
    }

    @Override // twitter4j.api.LocalTrendsMethods
    public ResponseList getAvailableTrends(GeoLocation geoLocation) {
        return this.factory.createLocationList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("trends/available.json").toString(), new HttpParameter[]{new HttpParameter("lat", geoLocation.getLatitude()), new HttpParameter("long", geoLocation.getLongitude())}));
    }

    @Override // twitter4j.api.LocalTrendsMethods
    public Trends getLocationTrends(int i) {
        return this.factory.createTrends(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("trends/").append(i).append(".json").toString()));
    }

    @Override // twitter4j.api.GeoMethods
    public ResponseList searchPlaces(GeoQuery geoQuery) {
        return this.factory.createPlaceList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("geo/search.json").toString(), geoQuery.asHttpParameterArray()));
    }

    @Override // twitter4j.api.GeoMethods
    public SimilarPlaces getSimilarPlaces(GeoLocation geoLocation, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new HttpParameter("lat", geoLocation.getLatitude()));
        arrayList.add(new HttpParameter("long", geoLocation.getLongitude()));
        arrayList.add(new HttpParameter("name", str));
        if (str2 != null) {
            arrayList.add(new HttpParameter("contained_within", str2));
        }
        if (str3 != null) {
            arrayList.add(new HttpParameter("attribute:street_address", str3));
        }
        return this.factory.createSimilarPlaces(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("geo/similar_places.json").toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    @Override // twitter4j.api.GeoMethods
    public ResponseList reverseGeoCode(GeoQuery geoQuery) throws TwitterException {
        try {
            return this.factory.createPlaceList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("geo/reverse_geocode.json").toString(), geoQuery.asHttpParameterArray()));
        } catch (TwitterException e) {
            if (e.getStatusCode() == 404) {
                return this.factory.createEmptyResponseList();
            }
            throw e;
        }
    }

    @Override // twitter4j.api.GeoMethods
    public Place getGeoDetails(String str) {
        return this.factory.createPlace(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("geo/id/").append(str).append(".json").toString()));
    }

    @Override // twitter4j.api.GeoMethods
    public Place createPlace(String str, String str2, String str3, GeoLocation geoLocation, String str4) {
        ensureAuthorizationEnabled();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new HttpParameter("name", str));
        arrayList.add(new HttpParameter("contained_within", str2));
        arrayList.add(new HttpParameter("token", str3));
        arrayList.add(new HttpParameter("lat", geoLocation.getLatitude()));
        arrayList.add(new HttpParameter("long", geoLocation.getLongitude()));
        if (str4 != null) {
            arrayList.add(new HttpParameter("attribute:street_address", str4));
        }
        return this.factory.createPlace(post(new StringBuffer().append(this.conf.getRestBaseURL()).append("geo/place.json").toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    @Override // twitter4j.api.LegalResources
    public String getTermsOfService() throws TwitterException {
        try {
            return get(new StringBuffer().append(this.conf.getRestBaseURL()).append("legal/tos.json").toString()).asJSONObject().getString("tos");
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    @Override // twitter4j.api.LegalResources
    public String getPrivacyPolicy() throws TwitterException {
        try {
            return get(new StringBuffer().append(this.conf.getRestBaseURL()).append("legal/privacy.json").toString()).asJSONObject().getString("privacy");
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    @Override // twitter4j.api.NewTwitterMethods
    public RelatedResults getRelatedResults(long j) {
        ensureAuthorizationEnabled();
        return this.factory.createRelatedResults(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("related_results/show/").append(Long.toString(j)).append(".json").toString()));
    }

    @Override // twitter4j.api.HelpMethods
    public boolean test() {
        return -1 != get(new StringBuffer().append(this.conf.getRestBaseURL()).append("help/test.json").toString()).asString().indexOf("ok");
    }

    @Override // twitter4j.api.HelpMethods
    public TwitterAPIConfiguration getAPIConfiguration() {
        return this.factory.createTwitterAPIConfiguration(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("help/configuration.json").toString()));
    }

    @Override // twitter4j.api.HelpMethods
    public ResponseList getLanguages() {
        return this.factory.createLanguageList(get(new StringBuffer().append(this.conf.getRestBaseURL()).append("help/languages.json").toString()));
    }

    @Override // twitter4j.TwitterBaseImpl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        TwitterImpl twitterImpl = (TwitterImpl) obj;
        return this.INCLUDE_ENTITIES.equals(twitterImpl.INCLUDE_ENTITIES) && this.INCLUDE_RTS.equals(twitterImpl.INCLUDE_RTS);
    }

    private HttpResponse get(String str) {
        if (!this.conf.isMBeanEnabled()) {
            return this.http.get(str, this.auth);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse httpResponse = this.http.get(str, this.auth);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(httpResponse));
            return httpResponse;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(null));
            throw th;
        }
    }

    private HttpResponse get(String str, HttpParameter[] httpParameterArr) {
        if (!this.conf.isMBeanEnabled()) {
            return this.http.get(str, httpParameterArr, this.auth);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse httpResponse = this.http.get(str, httpParameterArr, this.auth);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(httpResponse));
            return httpResponse;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(null));
            throw th;
        }
    }

    private HttpResponse post(String str) {
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(str, this.auth);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse httpResponsePost = this.http.post(str, this.auth);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(httpResponsePost));
            return httpResponsePost;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(null));
            throw th;
        }
    }

    private HttpResponse post(String str, HttpParameter[] httpParameterArr) {
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(str, httpParameterArr, this.auth);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse httpResponsePost = this.http.post(str, httpParameterArr, this.auth);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(httpResponsePost));
            return httpResponsePost;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(null));
            throw th;
        }
    }

    private HttpResponse delete(String str) {
        if (!this.conf.isMBeanEnabled()) {
            return this.http.delete(str, this.auth);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse httpResponseDelete = this.http.delete(str, this.auth);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(httpResponseDelete));
            return httpResponseDelete;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(null));
            throw th;
        }
    }

    private boolean isOk(HttpResponse httpResponse) {
        return httpResponse != null && httpResponse.getStatusCode() < 300;
    }

    @Override // twitter4j.TwitterBaseImpl
    public int hashCode() {
        return (((super.hashCode() * 31) + this.INCLUDE_ENTITIES.hashCode()) * 31) + this.INCLUDE_RTS.hashCode();
    }

    @Override // twitter4j.TwitterBaseImpl
    public String toString() {
        return new StringBuffer().append("TwitterImpl{INCLUDE_ENTITIES=").append(this.INCLUDE_ENTITIES).append(", INCLUDE_RTS=").append(this.INCLUDE_RTS).append('}').toString();
    }
}
