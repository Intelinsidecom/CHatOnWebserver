package twitter4j.internal.json;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class UserJSONImpl extends TwitterResponseImpl implements Serializable, User {
    private static final long serialVersionUID = -6345893237975349030L;
    private Date createdAt;
    private String description;
    private int favouritesCount;
    private int followersCount;
    private int friendsCount;

    /* renamed from: id */
    private long f7905id;
    private boolean isContributorsEnabled;
    private boolean isFollowRequestSent;
    private boolean isGeoEnabled;
    private boolean isProtected;
    private boolean isVerified;
    private String lang;
    private int listedCount;
    private String location;
    private String name;
    private String profileBackgroundColor;
    private String profileBackgroundImageUrl;
    private String profileBackgroundImageUrlHttps;
    private boolean profileBackgroundTiled;
    private String profileImageUrl;
    private String profileImageUrlHttps;
    private String profileLinkColor;
    private String profileSidebarBorderColor;
    private String profileSidebarFillColor;
    private String profileTextColor;
    private boolean profileUseBackgroundImage;
    private String screenName;
    private boolean showAllInlineMedia;
    private Status status;
    private int statusesCount;
    private String timeZone;
    private boolean translator;
    private String url;
    private int utcOffset;

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return compareTo((User) obj);
    }

    UserJSONImpl(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        super(httpResponse);
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
        }
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        init(jSONObjectAsJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(this, jSONObjectAsJSONObject);
        }
    }

    UserJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            this.f7905id = z_T4JInternalParseUtil.getLong("id", jSONObject);
            this.name = z_T4JInternalParseUtil.getRawString("name", jSONObject);
            this.screenName = z_T4JInternalParseUtil.getRawString("screen_name", jSONObject);
            this.location = z_T4JInternalParseUtil.getRawString("location", jSONObject);
            this.description = z_T4JInternalParseUtil.getRawString("description", jSONObject);
            this.isContributorsEnabled = z_T4JInternalParseUtil.getBoolean("contributors_enabled", jSONObject);
            this.profileImageUrl = z_T4JInternalParseUtil.getRawString("profile_image_url", jSONObject);
            this.profileImageUrlHttps = z_T4JInternalParseUtil.getRawString("profile_image_url_https", jSONObject);
            this.url = z_T4JInternalParseUtil.getRawString(RtspHeaders.Values.URL, jSONObject);
            this.isProtected = z_T4JInternalParseUtil.getBoolean("protected", jSONObject);
            this.isGeoEnabled = z_T4JInternalParseUtil.getBoolean("geo_enabled", jSONObject);
            this.isVerified = z_T4JInternalParseUtil.getBoolean("verified", jSONObject);
            this.translator = z_T4JInternalParseUtil.getBoolean("is_translator", jSONObject);
            this.followersCount = z_T4JInternalParseUtil.getInt("followers_count", jSONObject);
            this.profileBackgroundColor = z_T4JInternalParseUtil.getRawString("profile_background_color", jSONObject);
            this.profileTextColor = z_T4JInternalParseUtil.getRawString("profile_text_color", jSONObject);
            this.profileLinkColor = z_T4JInternalParseUtil.getRawString("profile_link_color", jSONObject);
            this.profileSidebarFillColor = z_T4JInternalParseUtil.getRawString("profile_sidebar_fill_color", jSONObject);
            this.profileSidebarBorderColor = z_T4JInternalParseUtil.getRawString("profile_sidebar_border_color", jSONObject);
            this.profileUseBackgroundImage = z_T4JInternalParseUtil.getBoolean("profile_use_background_image", jSONObject);
            this.showAllInlineMedia = z_T4JInternalParseUtil.getBoolean("show_all_inline_media", jSONObject);
            this.friendsCount = z_T4JInternalParseUtil.getInt("friends_count", jSONObject);
            this.createdAt = z_T4JInternalParseUtil.getDate("created_at", jSONObject, "EEE MMM dd HH:mm:ss z yyyy");
            this.favouritesCount = z_T4JInternalParseUtil.getInt("favourites_count", jSONObject);
            this.utcOffset = z_T4JInternalParseUtil.getInt("utc_offset", jSONObject);
            this.timeZone = z_T4JInternalParseUtil.getRawString("time_zone", jSONObject);
            this.profileBackgroundImageUrl = z_T4JInternalParseUtil.getRawString("profile_background_image_url", jSONObject);
            this.profileBackgroundImageUrlHttps = z_T4JInternalParseUtil.getRawString("profile_background_image_url_https", jSONObject);
            this.profileBackgroundTiled = z_T4JInternalParseUtil.getBoolean("profile_background_tile", jSONObject);
            this.lang = z_T4JInternalParseUtil.getRawString("lang", jSONObject);
            this.statusesCount = z_T4JInternalParseUtil.getInt("statuses_count", jSONObject);
            this.listedCount = z_T4JInternalParseUtil.getInt("listed_count", jSONObject);
            this.isFollowRequestSent = z_T4JInternalParseUtil.getBoolean("follow_request_sent", jSONObject);
            if (!jSONObject.isNull("status")) {
                this.status = new StatusJSONImpl(jSONObject.getJSONObject("status"));
            }
        } catch (JSONException e) {
            throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(jSONObject.toString()).toString(), e);
        }
    }

    public int compareTo(User user) {
        return (int) (this.f7905id - user.getId());
    }

    @Override // twitter4j.User
    public long getId() {
        return this.f7905id;
    }

    @Override // twitter4j.User
    public String getName() {
        return this.name;
    }

    @Override // twitter4j.User
    public String getScreenName() {
        return this.screenName;
    }

    @Override // twitter4j.User
    public String getLocation() {
        return this.location;
    }

    @Override // twitter4j.User
    public String getDescription() {
        return this.description;
    }

    @Override // twitter4j.User
    public boolean isContributorsEnabled() {
        return this.isContributorsEnabled;
    }

    @Override // twitter4j.User
    public URL getProfileImageURL() {
        try {
            return new URL(this.profileImageUrl);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    @Override // twitter4j.User
    public URL getProfileImageUrlHttps() {
        if (this.profileImageUrlHttps == null) {
            return null;
        }
        try {
            return new URL(this.profileImageUrlHttps);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    @Override // twitter4j.User
    public URL getURL() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    @Override // twitter4j.User
    public boolean isProtected() {
        return this.isProtected;
    }

    @Override // twitter4j.User
    public int getFollowersCount() {
        return this.followersCount;
    }

    @Override // twitter4j.User
    public String getProfileBackgroundColor() {
        return this.profileBackgroundColor;
    }

    @Override // twitter4j.User
    public String getProfileTextColor() {
        return this.profileTextColor;
    }

    @Override // twitter4j.User
    public String getProfileLinkColor() {
        return this.profileLinkColor;
    }

    @Override // twitter4j.User
    public String getProfileSidebarFillColor() {
        return this.profileSidebarFillColor;
    }

    @Override // twitter4j.User
    public String getProfileSidebarBorderColor() {
        return this.profileSidebarBorderColor;
    }

    @Override // twitter4j.User
    public boolean isProfileUseBackgroundImage() {
        return this.profileUseBackgroundImage;
    }

    @Override // twitter4j.User
    public boolean isShowAllInlineMedia() {
        return this.showAllInlineMedia;
    }

    @Override // twitter4j.User
    public int getFriendsCount() {
        return this.friendsCount;
    }

    @Override // twitter4j.User
    public Status getStatus() {
        return this.status;
    }

    @Override // twitter4j.User
    public Date getCreatedAt() {
        return this.createdAt;
    }

    @Override // twitter4j.User
    public int getFavouritesCount() {
        return this.favouritesCount;
    }

    @Override // twitter4j.User
    public int getUtcOffset() {
        return this.utcOffset;
    }

    @Override // twitter4j.User
    public String getTimeZone() {
        return this.timeZone;
    }

    @Override // twitter4j.User
    public String getProfileBackgroundImageUrl() {
        return this.profileBackgroundImageUrl;
    }

    @Override // twitter4j.User
    public String getProfileBackgroundImageUrlHttps() {
        return this.profileBackgroundImageUrlHttps;
    }

    @Override // twitter4j.User
    public boolean isProfileBackgroundTiled() {
        return this.profileBackgroundTiled;
    }

    @Override // twitter4j.User
    public String getLang() {
        return this.lang;
    }

    @Override // twitter4j.User
    public int getStatusesCount() {
        return this.statusesCount;
    }

    @Override // twitter4j.User
    public boolean isGeoEnabled() {
        return this.isGeoEnabled;
    }

    @Override // twitter4j.User
    public boolean isVerified() {
        return this.isVerified;
    }

    @Override // twitter4j.User
    public boolean isTranslator() {
        return this.translator;
    }

    @Override // twitter4j.User
    public int getListedCount() {
        return this.listedCount;
    }

    @Override // twitter4j.User
    public boolean isFollowRequestSent() {
        return this.isFollowRequestSent;
    }

    static PagableResponseList createPagableUserList(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
            JSONArray jSONArray = jSONObjectAsJSONObject.getJSONArray("users");
            int length = jSONArray.length();
            PagableResponseListImpl pagableResponseListImpl = new PagableResponseListImpl(length, jSONObjectAsJSONObject, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UserJSONImpl userJSONImpl = new UserJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(userJSONImpl, jSONObject);
                }
                pagableResponseListImpl.add(userJSONImpl);
            }
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.registerJSONObject(pagableResponseListImpl, jSONObjectAsJSONObject);
            }
            return pagableResponseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        } catch (TwitterException e2) {
            throw e2;
        }
    }

    static ResponseList createUserList(HttpResponse httpResponse, Configuration configuration) {
        return createUserList(httpResponse.asJSONArray(), httpResponse, configuration);
    }

    static ResponseList createUserList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IllegalArgumentException, InvocationTargetException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UserJSONImpl userJSONImpl = new UserJSONImpl(jSONObject);
                responseListImpl.add(userJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(userJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        } catch (TwitterException e2) {
            throw e2;
        }
    }

    public int hashCode() {
        return (int) this.f7905id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof User) && ((User) obj).getId() == this.f7905id;
        }
        return true;
    }

    public String toString() {
        return new StringBuffer().append("UserJSONImpl{id=").append(this.f7905id).append(", name='").append(this.name).append('\'').append(", screenName='").append(this.screenName).append('\'').append(", location='").append(this.location).append('\'').append(", description='").append(this.description).append('\'').append(", isContributorsEnabled=").append(this.isContributorsEnabled).append(", profileImageUrl='").append(this.profileImageUrl).append('\'').append(", profileImageUrlHttps='").append(this.profileImageUrlHttps).append('\'').append(", url='").append(this.url).append('\'').append(", isProtected=").append(this.isProtected).append(", followersCount=").append(this.followersCount).append(", status=").append(this.status).append(", profileBackgroundColor='").append(this.profileBackgroundColor).append('\'').append(", profileTextColor='").append(this.profileTextColor).append('\'').append(", profileLinkColor='").append(this.profileLinkColor).append('\'').append(", profileSidebarFillColor='").append(this.profileSidebarFillColor).append('\'').append(", profileSidebarBorderColor='").append(this.profileSidebarBorderColor).append('\'').append(", profileUseBackgroundImage=").append(this.profileUseBackgroundImage).append(", showAllInlineMedia=").append(this.showAllInlineMedia).append(", friendsCount=").append(this.friendsCount).append(", createdAt=").append(this.createdAt).append(", favouritesCount=").append(this.favouritesCount).append(", utcOffset=").append(this.utcOffset).append(", timeZone='").append(this.timeZone).append('\'').append(", profileBackgroundImageUrl='").append(this.profileBackgroundImageUrl).append('\'').append(", profileBackgroundImageUrlHttps='").append(this.profileBackgroundImageUrlHttps).append('\'').append(", profileBackgroundTiled=").append(this.profileBackgroundTiled).append(", lang='").append(this.lang).append('\'').append(", statusesCount=").append(this.statusesCount).append(", isGeoEnabled=").append(this.isGeoEnabled).append(", isVerified=").append(this.isVerified).append(", translator=").append(this.translator).append(", listedCount=").append(this.listedCount).append(", isFollowRequestSent=").append(this.isFollowRequestSent).append('}').toString();
    }
}
