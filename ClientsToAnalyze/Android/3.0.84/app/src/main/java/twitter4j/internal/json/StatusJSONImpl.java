package twitter4j.internal.json;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Annotations;
import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserMentionEntity;
import twitter4j.conf.Configuration;
import twitter4j.conf.PropertyConfiguration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.logging.Logger;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class StatusJSONImpl extends TwitterResponseImpl implements Serializable, Status {
    static Class class$twitter4j$internal$json$StatusJSONImpl = null;
    private static final Logger logger;
    private static final long serialVersionUID = 7548618898682727465L;
    private Annotations annotations;
    private String[] contributors;
    private long[] contributorsIDs;
    private Date createdAt;
    private GeoLocation geoLocation;
    private HashtagEntity[] hashtagEntities;

    /* renamed from: id */
    private long f13739id;
    private String inReplyToScreenName;
    private long inReplyToStatusId;
    private long inReplyToUserId;
    private boolean isFavorited;
    private boolean isTruncated;
    private MediaEntity[] mediaEntities;
    private Status myRetweetedStatus;
    private Place place;
    private long retweetCount;
    private Status retweetedStatus;
    private String source;
    private String text;
    private URLEntity[] urlEntities;
    private User user;
    private UserMentionEntity[] userMentionEntities;
    private boolean wasRetweetedByMe;

    @Override // java.lang.Comparable
    public int compareTo(Status status) {
        return compareTo2(status);
    }

    static {
        Class clsClass$;
        if (class$twitter4j$internal$json$StatusJSONImpl == null) {
            clsClass$ = class$("twitter4j.internal.json.StatusJSONImpl");
            class$twitter4j$internal$json$StatusJSONImpl = clsClass$;
        } else {
            clsClass$ = class$twitter4j$internal$json$StatusJSONImpl;
        }
        logger = Logger.getLogger(clsClass$);
    }

    static Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    StatusJSONImpl(HttpResponse httpResponse, Configuration configuration) throws JSONException, IllegalAccessException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        super(httpResponse);
        this.geoLocation = null;
        this.place = null;
        this.contributors = null;
        this.annotations = null;
        this.user = null;
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        init(jSONObjectAsJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, jSONObjectAsJSONObject);
        }
    }

    StatusJSONImpl(JSONObject jSONObject) throws JSONException, TwitterException {
        this.geoLocation = null;
        this.place = null;
        this.contributors = null;
        this.annotations = null;
        this.user = null;
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws JSONException, TwitterException {
        this.f13739id = z_T4JInternalParseUtil.getLong("id", jSONObject);
        this.text = z_T4JInternalParseUtil.getUnescapedString("text", jSONObject);
        this.source = z_T4JInternalParseUtil.getUnescapedString("source", jSONObject);
        this.createdAt = z_T4JInternalParseUtil.getDate("created_at", jSONObject);
        this.isTruncated = z_T4JInternalParseUtil.getBoolean("truncated", jSONObject);
        this.inReplyToStatusId = z_T4JInternalParseUtil.getLong("in_reply_to_status_id", jSONObject);
        this.inReplyToUserId = z_T4JInternalParseUtil.getLong("in_reply_to_user_id", jSONObject);
        this.isFavorited = z_T4JInternalParseUtil.getBoolean("favorited", jSONObject);
        this.inReplyToScreenName = z_T4JInternalParseUtil.getUnescapedString("in_reply_to_screen_name", jSONObject);
        this.retweetCount = z_T4JInternalParseUtil.getLong("retweet_count", jSONObject);
        try {
            if (!jSONObject.isNull(PropertyConfiguration.USER)) {
                this.user = new UserJSONImpl(jSONObject.getJSONObject(PropertyConfiguration.USER));
            }
            this.geoLocation = z_T4JInternalJSONImplFactory.createGeoLocation(jSONObject);
            if (!jSONObject.isNull("place")) {
                try {
                    this.place = new PlaceJSONImpl(jSONObject.getJSONObject("place"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    logger.warn(new StringBuffer().append("failed to parse place:").append(jSONObject).toString());
                }
            }
            if (!jSONObject.isNull("retweeted_status")) {
                try {
                    this.retweetedStatus = new StatusJSONImpl(jSONObject.getJSONObject("retweeted_status"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    logger.warn(new StringBuffer().append("failed to parse retweeted_status:").append(jSONObject).toString());
                }
            }
            if (!jSONObject.isNull("contributors")) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("contributors");
                    this.contributorsIDs = new long[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.contributorsIDs[i] = Long.parseLong(jSONArray.getString(i));
                    }
                } catch (NumberFormatException e3) {
                    e3.printStackTrace();
                    logger.warn(new StringBuffer().append("failed to parse contributors:").append(jSONObject).toString());
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    logger.warn(new StringBuffer().append("failed to parse contributors:").append(jSONObject).toString());
                }
            } else {
                this.contributors = null;
            }
            if (!jSONObject.isNull("entities")) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("entities");
                    if (!jSONObject2.isNull("user_mentions")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("user_mentions");
                        int length = jSONArray2.length();
                        this.userMentionEntities = new UserMentionEntity[length];
                        for (int i2 = 0; i2 < length; i2++) {
                            this.userMentionEntities[i2] = new UserMentionEntityJSONImpl(jSONArray2.getJSONObject(i2));
                        }
                    }
                    if (!jSONObject2.isNull("urls")) {
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("urls");
                        int length2 = jSONArray3.length();
                        this.urlEntities = new URLEntity[length2];
                        for (int i3 = 0; i3 < length2; i3++) {
                            this.urlEntities[i3] = new URLEntityJSONImpl(jSONArray3.getJSONObject(i3));
                        }
                    }
                    if (!jSONObject2.isNull("hashtags")) {
                        JSONArray jSONArray4 = jSONObject2.getJSONArray("hashtags");
                        int length3 = jSONArray4.length();
                        this.hashtagEntities = new HashtagEntity[length3];
                        for (int i4 = 0; i4 < length3; i4++) {
                            this.hashtagEntities[i4] = new HashtagEntityJSONImpl(jSONArray4.getJSONObject(i4));
                        }
                    }
                    if (!jSONObject2.isNull("media")) {
                        JSONArray jSONArray5 = jSONObject2.getJSONArray("media");
                        int length4 = jSONArray5.length();
                        this.mediaEntities = new MediaEntity[length4];
                        for (int i5 = 0; i5 < length4; i5++) {
                            this.mediaEntities[i5] = new MediaEntityJSONImpl(jSONArray5.getJSONObject(i5));
                        }
                    }
                } catch (JSONException e5) {
                    throw new TwitterException(e5);
                }
            }
            if (!jSONObject.isNull("annotations")) {
                try {
                    this.annotations = new Annotations(jSONObject.getJSONArray("annotations"));
                } catch (JSONException e6) {
                }
            }
            if (!jSONObject.isNull("current_user_retweet")) {
                try {
                    this.myRetweetedStatus = new StatusJSONImpl(jSONObject.getJSONObject("current_user_retweet"));
                    this.wasRetweetedByMe = true;
                } catch (JSONException e7) {
                    e7.printStackTrace();
                    logger.warn(new StringBuffer().append("failed to parse current_user_retweet:").append(jSONObject).toString());
                }
            }
        } catch (JSONException e8) {
            throw new TwitterException(e8);
        }
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Status status) {
        long id = this.f13739id - status.getId();
        if (id < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (id > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) id;
    }

    @Override // twitter4j.Status
    public Date getCreatedAt() {
        return this.createdAt;
    }

    @Override // twitter4j.Status
    public long getId() {
        return this.f13739id;
    }

    @Override // twitter4j.Status
    public String getText() {
        return this.text;
    }

    @Override // twitter4j.Status
    public String getSource() {
        return this.source;
    }

    @Override // twitter4j.Status
    public boolean isTruncated() {
        return this.isTruncated;
    }

    @Override // twitter4j.Status
    public long getInReplyToStatusId() {
        return this.inReplyToStatusId;
    }

    @Override // twitter4j.Status
    public long getInReplyToUserId() {
        return this.inReplyToUserId;
    }

    @Override // twitter4j.Status
    public String getInReplyToScreenName() {
        return this.inReplyToScreenName;
    }

    @Override // twitter4j.Status
    public GeoLocation getGeoLocation() {
        return this.geoLocation;
    }

    @Override // twitter4j.Status
    public Place getPlace() {
        return this.place;
    }

    @Override // twitter4j.Status
    public long[] getContributors() {
        if (this.contributors != null) {
            this.contributorsIDs = new long[this.contributors.length];
            for (int i = 0; i < this.contributors.length; i++) {
                try {
                    this.contributorsIDs[i] = Long.parseLong(this.contributors[i]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    logger.warn(new StringBuffer().append("failed to parse contributors:").append(e).toString());
                }
            }
            this.contributors = null;
        }
        return this.contributorsIDs;
    }

    @Override // twitter4j.Status
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // twitter4j.Status
    public boolean isFavorited() {
        return this.isFavorited;
    }

    @Override // twitter4j.Status
    public User getUser() {
        return this.user;
    }

    @Override // twitter4j.Status
    public boolean isRetweet() {
        return this.retweetedStatus != null;
    }

    @Override // twitter4j.Status
    public Status getRetweetedStatus() {
        return this.retweetedStatus;
    }

    @Override // twitter4j.Status
    public long getRetweetCount() {
        return this.retweetCount;
    }

    @Override // twitter4j.Status
    public boolean isRetweetedByMe() {
        return this.wasRetweetedByMe;
    }

    @Override // twitter4j.EntitySupport
    public UserMentionEntity[] getUserMentionEntities() {
        return this.userMentionEntities;
    }

    @Override // twitter4j.EntitySupport
    public URLEntity[] getURLEntities() {
        return this.urlEntities;
    }

    @Override // twitter4j.EntitySupport
    public HashtagEntity[] getHashtagEntities() {
        return this.hashtagEntities;
    }

    @Override // twitter4j.EntitySupport
    public MediaEntity[] getMediaEntities() {
        return this.mediaEntities;
    }

    static ResponseList<Status> createStatusList(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            JSONArray jSONArrayAsJSONArray = httpResponse.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArrayAsJSONArray.getJSONObject(i);
                StatusJSONImpl statusJSONImpl = new StatusJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(statusJSONImpl, jSONObject);
                }
                responseListImpl.add(statusJSONImpl);
            }
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.registerJSONObject(responseListImpl, jSONArrayAsJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        } catch (TwitterException e2) {
            throw e2;
        }
    }

    public int hashCode() {
        return (int) this.f13739id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof Status) && ((Status) obj).getId() == this.f13739id;
        }
        return true;
    }

    public String toString() {
        return new StringBuffer().append("StatusJSONImpl{createdAt=").append(this.createdAt).append(", id=").append(this.f13739id).append(", text='").append(this.text).append('\'').append(", source='").append(this.source).append('\'').append(", isTruncated=").append(this.isTruncated).append(", inReplyToStatusId=").append(this.inReplyToStatusId).append(", inReplyToUserId=").append(this.inReplyToUserId).append(", isFavorited=").append(this.isFavorited).append(", inReplyToScreenName='").append(this.inReplyToScreenName).append('\'').append(", geoLocation=").append(this.geoLocation).append(", place=").append(this.place).append(", retweetCount=").append(this.retweetCount).append(", wasRetweetedByMe=").append(this.wasRetweetedByMe).append(", contributors=").append(this.contributorsIDs == null ? null : Arrays.asList(this.contributorsIDs)).append(", annotations=").append(this.annotations).append(", retweetedStatus=").append(this.retweetedStatus).append(", userMentionEntities=").append(this.userMentionEntities == null ? null : Arrays.asList(this.userMentionEntities)).append(", urlEntities=").append(this.urlEntities == null ? null : Arrays.asList(this.urlEntities)).append(", hashtagEntities=").append(this.hashtagEntities != null ? Arrays.asList(this.hashtagEntities) : null).append(", user=").append(this.user).append('}').toString();
    }
}
