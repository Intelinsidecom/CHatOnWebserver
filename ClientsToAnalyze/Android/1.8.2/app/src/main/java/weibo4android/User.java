package weibo4android;

import com.sec.spp.push.Config;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import twitter4j.conf.PropertyConfiguration;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class User extends WeiboResponse implements Serializable {
    static final String[] POSSIBLE_ROOT_NAMES = {PropertyConfiguration.USER, Config.NOTIFICATION_INTENT_SENDER, "recipient", "retweeting_user"};
    private static final long serialVersionUID = -6345893237975349030L;
    private Date createdAt;
    private String description;
    private int favouritesCount;
    private int followersCount;
    private boolean following;
    private int friendsCount;
    private boolean geoEnabled;

    /* renamed from: id */
    private long f7918id;
    private boolean isProtected;
    private String location;
    private String name;
    private boolean notificationEnabled;
    private String profileBackgroundColor;
    private String profileBackgroundImageUrl;
    private String profileBackgroundTile;
    private String profileImageUrl;
    private String profileLinkColor;
    private String profileSidebarBorderColor;
    private String profileSidebarFillColor;
    private String profileTextColor;
    private String screenName;
    private Date statusCreatedAt;
    private boolean statusFavorited;
    private long statusId;
    private String statusInReplyToScreenName;
    private long statusInReplyToStatusId;
    private int statusInReplyToUserId;
    private String statusSource;
    private String statusText;
    private boolean statusTruncated;
    private int statusesCount;
    private String timeZone;
    private String url;
    private String userDomain;
    private int utcOffset;
    private boolean verified;
    private Weibo weibo;

    User(Response response, Weibo weibo) {
        super(response);
        this.statusId = -1L;
        this.statusText = null;
        this.statusSource = null;
        this.statusTruncated = false;
        this.statusInReplyToStatusId = -1L;
        this.statusInReplyToUserId = -1;
        this.statusFavorited = false;
        this.statusInReplyToScreenName = null;
        init(response.asDocument().getDocumentElement(), weibo);
    }

    User(Response response, Element element, Weibo weibo) {
        super(response);
        this.statusId = -1L;
        this.statusText = null;
        this.statusSource = null;
        this.statusTruncated = false;
        this.statusInReplyToStatusId = -1L;
        this.statusInReplyToUserId = -1;
        this.statusFavorited = false;
        this.statusInReplyToScreenName = null;
        init(element, weibo);
    }

    User(JSONObject jSONObject) throws WeiboException {
        this.statusId = -1L;
        this.statusText = null;
        this.statusSource = null;
        this.statusTruncated = false;
        this.statusInReplyToStatusId = -1L;
        this.statusInReplyToUserId = -1;
        this.statusFavorited = false;
        this.statusInReplyToScreenName = null;
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws WeiboException {
        if (jSONObject != null) {
            try {
                this.f7918id = jSONObject.getLong("id");
                this.name = jSONObject.getString("name");
                this.screenName = jSONObject.getString("screen_name");
                this.location = jSONObject.getString("location");
                this.description = jSONObject.getString("description");
                this.profileImageUrl = jSONObject.getString("profile_image_url");
                this.url = jSONObject.getString(RtspHeaders.Values.URL);
                this.isProtected = jSONObject.getBoolean("protected");
                this.followersCount = jSONObject.getInt("followers_count");
                this.profileBackgroundColor = jSONObject.getString("profile_background_color");
                this.profileTextColor = jSONObject.getString("profile_text_color");
                this.profileLinkColor = jSONObject.getString("profile_link_color");
                this.profileSidebarFillColor = jSONObject.getString("profile_sidebar_fill_color");
                this.profileSidebarBorderColor = jSONObject.getString("profile_sidebar_border_color");
                this.friendsCount = jSONObject.getInt("friends_count");
                this.createdAt = parseDate(jSONObject.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
                this.favouritesCount = jSONObject.getInt("favourites_count");
                this.utcOffset = getInt("utc_offset", jSONObject);
                this.timeZone = jSONObject.getString("time_zone");
                this.profileBackgroundImageUrl = jSONObject.getString("profile_background_image_url");
                this.profileBackgroundTile = jSONObject.getString("profile_background_tile");
                this.following = getBoolean("following", jSONObject);
                this.notificationEnabled = getBoolean("notifications", jSONObject);
                this.verified = getBoolean("verified", jSONObject);
                this.statusesCount = jSONObject.getInt("statuses_count");
                this.userDomain = jSONObject.getString("domain");
                if (!jSONObject.isNull("status")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("status");
                    this.statusCreatedAt = parseDate(jSONObject2.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
                    this.statusId = jSONObject2.getLong("id");
                    this.statusText = jSONObject2.getString("text");
                    this.statusSource = jSONObject2.getString("source");
                    this.statusTruncated = jSONObject2.getBoolean("truncated");
                    this.statusInReplyToStatusId = jSONObject2.getLong("in_reply_to_status_id");
                    this.statusInReplyToUserId = jSONObject2.getInt("in_reply_to_user_id");
                    this.statusFavorited = jSONObject2.getBoolean("favorited");
                    this.statusInReplyToScreenName = jSONObject2.getString("in_reply_to_screen_name");
                }
            } catch (JSONException e) {
                throw new WeiboException(String.valueOf(e.getMessage()) + ":" + jSONObject.toString(), e);
            }
        }
    }

    private void init(Element element, Weibo weibo) {
        this.weibo = weibo;
        ensureRootNodeNameIs(POSSIBLE_ROOT_NAMES, element);
        this.f7918id = getChildLong("id", element);
        this.name = getChildText("name", element);
        this.screenName = getChildText("screen_name", element);
        this.location = getChildText("location", element);
        this.description = getChildText("description", element);
        this.profileImageUrl = getChildText("profile_image_url", element);
        this.url = getChildText(RtspHeaders.Values.URL, element);
        this.isProtected = getChildBoolean("protected", element);
        this.followersCount = getChildInt("followers_count", element);
        this.profileBackgroundColor = getChildText("profile_background_color", element);
        this.profileTextColor = getChildText("profile_text_color", element);
        this.profileLinkColor = getChildText("profile_link_color", element);
        this.profileSidebarFillColor = getChildText("profile_sidebar_fill_color", element);
        this.profileSidebarBorderColor = getChildText("profile_sidebar_border_color", element);
        this.friendsCount = getChildInt("friends_count", element);
        this.createdAt = getChildDate("created_at", element);
        this.favouritesCount = getChildInt("favourites_count", element);
        this.utcOffset = getChildInt("utc_offset", element);
        this.timeZone = getChildText("time_zone", element);
        this.profileBackgroundImageUrl = getChildText("profile_background_image_url", element);
        this.profileBackgroundTile = getChildText("profile_background_tile", element);
        this.following = getChildBoolean("following", element);
        this.notificationEnabled = getChildBoolean("notifications", element);
        this.statusesCount = getChildInt("statuses_count", element);
        this.geoEnabled = getChildBoolean("geo_enabled", element);
        this.verified = getChildBoolean("verified", element);
        NodeList elementsByTagName = element.getElementsByTagName("status");
        if (elementsByTagName.getLength() != 0) {
            Element element2 = (Element) elementsByTagName.item(0);
            this.statusCreatedAt = getChildDate("created_at", element2);
            this.statusId = getChildLong("id", element2);
            this.statusText = getChildText("text", element2);
            this.statusSource = getChildText("source", element2);
            this.statusTruncated = getChildBoolean("truncated", element2);
            this.statusInReplyToStatusId = getChildLong("in_reply_to_status_id", element2);
            this.statusInReplyToUserId = getChildInt("in_reply_to_user_id", element2);
            this.statusFavorited = getChildBoolean("favorited", element2);
            this.statusInReplyToScreenName = getChildText("in_reply_to_screen_name", element2);
        }
    }

    public long getId() {
        return this.f7918id;
    }

    public String getName() {
        return this.name;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public String getLocation() {
        return this.location;
    }

    public String getDescription() {
        return this.description;
    }

    public URL getProfileImageURL() {
        try {
            return new URL(this.profileImageUrl);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public String getProfileImageURL2() {
        return this.profileImageUrl;
    }

    public URL getURL() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public boolean isProtected() {
        return this.isProtected;
    }

    public String getUserDomain() {
        return this.userDomain;
    }

    public int getFollowersCount() {
        return this.followersCount;
    }

    public DirectMessage sendDirectMessage(String str) {
        return this.weibo.sendDirectMessage(getName(), str);
    }

    public static List constructUser(Response response) throws WeiboException {
        try {
            JSONArray jSONArray = response.asJSONObject().getJSONArray("users");
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new User(jSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            throw new WeiboException(e);
        }
    }

    public static List constructUsers(Response response, Weibo weibo) throws WeiboException {
        Document documentAsDocument = response.asDocument();
        if (isRootNodeNilClasses(documentAsDocument)) {
            return new ArrayList(0);
        }
        try {
            ensureRootNodeNameIs("users", documentAsDocument);
            NodeList childNodes = documentAsDocument.getDocumentElement().getChildNodes();
            ArrayList arrayList = new ArrayList(childNodes.getLength());
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node nodeItem = childNodes.item(i);
                if (nodeItem.getNodeName().equals(PropertyConfiguration.USER)) {
                    arrayList.add(new User(response, (Element) nodeItem, weibo));
                }
            }
            return arrayList;
        } catch (WeiboException e) {
            if (isRootNodeNilClasses(documentAsDocument)) {
                return new ArrayList(0);
            }
            throw e;
        }
    }

    public static UserWapper constructWapperUsers(Response response, Weibo weibo) throws WeiboException {
        Document documentAsDocument = response.asDocument();
        if (isRootNodeNilClasses(documentAsDocument)) {
            return new UserWapper(new ArrayList(0), 0L, 0L);
        }
        try {
            ensureRootNodeNameIs("users_list", documentAsDocument);
            Element documentElement = documentAsDocument.getDocumentElement();
            NodeList elementsByTagName = documentElement.getElementsByTagName("users");
            if (elementsByTagName.getLength() == 0) {
                return new UserWapper(new ArrayList(0), 0L, 0L);
            }
            NodeList childNodes = ((Element) elementsByTagName.item(0)).getChildNodes();
            ArrayList arrayList = new ArrayList(childNodes.getLength());
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node nodeItem = childNodes.item(i);
                if (nodeItem.getNodeName().equals(PropertyConfiguration.USER)) {
                    arrayList.add(new User(response, (Element) nodeItem, weibo));
                }
            }
            long childLong = getChildLong("previous_curosr", documentElement);
            long childLong2 = getChildLong("next_curosr", documentElement);
            if (childLong2 == -1) {
                childLong2 = getChildLong("nextCurosr", documentElement);
            }
            return new UserWapper(arrayList, childLong, childLong2);
        } catch (WeiboException e) {
            if (isRootNodeNilClasses(documentAsDocument)) {
                return new UserWapper(new ArrayList(0), 0L, 0L);
            }
            throw e;
        }
    }

    public static List constructUsers(Response response) throws WeiboException {
        try {
            JSONArray jSONArrayAsJSONArray = response.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new User(jSONArrayAsJSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (WeiboException e) {
            throw e;
        } catch (JSONException e2) {
            throw new WeiboException(e2);
        }
    }

    public static UserWapper constructWapperUsers(Response response) throws WeiboException {
        JSONObject jSONObjectAsJSONObject = response.asJSONObject();
        try {
            JSONArray jSONArray = jSONObjectAsJSONObject.getJSONArray("users");
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new User(jSONArray.getJSONObject(i)));
            }
            long j = jSONObjectAsJSONObject.getLong("previous_curosr");
            long j2 = jSONObjectAsJSONObject.getLong("next_cursor");
            if (j2 == -1) {
                j2 = jSONObjectAsJSONObject.getLong("nextCursor");
            }
            return new UserWapper(arrayList, j, j2);
        } catch (JSONException e) {
            throw new WeiboException(e);
        }
    }

    static List constructResult(Response response) throws WeiboException {
        JSONArray jSONArrayAsJSONArray = response.asJSONArray();
        try {
            int length = jSONArrayAsJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new User(jSONArrayAsJSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            return null;
        }
    }

    public Date getStatusCreatedAt() {
        return this.statusCreatedAt;
    }

    public long getStatusId() {
        return this.statusId;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public String getStatusSource() {
        return this.statusSource;
    }

    public boolean isStatusTruncated() {
        return this.statusTruncated;
    }

    public long getStatusInReplyToStatusId() {
        return this.statusInReplyToStatusId;
    }

    public int getStatusInReplyToUserId() {
        return this.statusInReplyToUserId;
    }

    public boolean isStatusFavorited() {
        return this.statusFavorited;
    }

    public String getStatusInReplyToScreenName() {
        if (-1 != this.statusInReplyToUserId) {
            return this.statusInReplyToScreenName;
        }
        return null;
    }

    public String getProfileBackgroundColor() {
        return this.profileBackgroundColor;
    }

    public String getProfileTextColor() {
        return this.profileTextColor;
    }

    public String getProfileLinkColor() {
        return this.profileLinkColor;
    }

    public String getProfileSidebarFillColor() {
        return this.profileSidebarFillColor;
    }

    public String getProfileSidebarBorderColor() {
        return this.profileSidebarBorderColor;
    }

    public int getFriendsCount() {
        return this.friendsCount;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public int getFavouritesCount() {
        return this.favouritesCount;
    }

    public int getUtcOffset() {
        return this.utcOffset;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public String getProfileBackgroundImageUrl() {
        return this.profileBackgroundImageUrl;
    }

    public String getProfileBackgroundTile() {
        return this.profileBackgroundTile;
    }

    public boolean isFollowing() {
        return this.following;
    }

    public boolean isNotifications() {
        return this.notificationEnabled;
    }

    public boolean isNotificationEnabled() {
        return this.notificationEnabled;
    }

    public int getStatusesCount() {
        return this.statusesCount;
    }

    public boolean isGeoEnabled() {
        return this.geoEnabled;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public int hashCode() {
        return ((int) (this.f7918id ^ (this.f7918id >>> 32))) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f7918id == ((User) obj).f7918id;
    }

    public String toString() {
        return "User{weibo=" + this.weibo + ", id=" + this.f7918id + ", name='" + this.name + "', screenName='" + this.screenName + "', location='" + this.location + "', description='" + this.description + "', profileImageUrl='" + this.profileImageUrl + "', url='" + this.url + "', isProtected=" + this.isProtected + ", followersCount=" + this.followersCount + ", statusCreatedAt=" + this.statusCreatedAt + ", statusId=" + this.statusId + ", statusText='" + this.statusText + "', statusSource='" + this.statusSource + "', statusTruncated=" + this.statusTruncated + ", statusInReplyToStatusId=" + this.statusInReplyToStatusId + ", statusInReplyToUserId=" + this.statusInReplyToUserId + ", statusFavorited=" + this.statusFavorited + ", statusInReplyToScreenName='" + this.statusInReplyToScreenName + "', profileBackgroundColor='" + this.profileBackgroundColor + "', profileTextColor='" + this.profileTextColor + "', profileLinkColor='" + this.profileLinkColor + "', profileSidebarFillColor='" + this.profileSidebarFillColor + "', profileSidebarBorderColor='" + this.profileSidebarBorderColor + "', friendsCount=" + this.friendsCount + ", createdAt=" + this.createdAt + ", favouritesCount=" + this.favouritesCount + ", utcOffset=" + this.utcOffset + ", timeZone='" + this.timeZone + "', profileBackgroundImageUrl='" + this.profileBackgroundImageUrl + "', profileBackgroundTile='" + this.profileBackgroundTile + "', following=" + this.following + ", notificationEnabled=" + this.notificationEnabled + ", statusesCount=" + this.statusesCount + ", geoEnabled=" + this.geoEnabled + ", verified=" + this.verified + '}';
    }
}
