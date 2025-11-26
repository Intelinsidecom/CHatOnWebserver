package twitter4j.internal.json;

import java.io.Serializable;
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
import twitter4j.Tweet;
import twitter4j.TwitterException;
import twitter4j.URLEntity;
import twitter4j.UserMentionEntity;
import twitter4j.conf.Configuration;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class TweetJSONImpl implements Serializable, Tweet {
    private static final long serialVersionUID = 3019285230338056113L;
    private Annotations annotations;
    private Date createdAt;
    private String fromUser;
    private long fromUserId;
    private GeoLocation geoLocation;
    private HashtagEntity[] hashtagEntities;

    /* renamed from: id */
    private long f13740id;
    private String isoLanguageCode;
    private String location;
    private MediaEntity[] mediaEntities;
    private Place place;
    private String profileImageUrl;
    private String source;
    private String text;
    private String toUser;
    private long toUserId;
    private URLEntity[] urlEntities;
    private UserMentionEntity[] userMentionEntities;

    @Override // java.lang.Comparable
    public int compareTo(Tweet tweet) {
        return compareTo2(tweet);
    }

    TweetJSONImpl(JSONObject jSONObject) throws JSONException, TwitterException {
        this.toUserId = -1L;
        this.toUser = null;
        this.isoLanguageCode = null;
        this.geoLocation = null;
        this.annotations = null;
        this.text = z_T4JInternalParseUtil.getUnescapedString("text", jSONObject);
        this.toUserId = z_T4JInternalParseUtil.getLong("to_user_id", jSONObject);
        this.toUser = z_T4JInternalParseUtil.getRawString("to_user", jSONObject);
        this.fromUser = z_T4JInternalParseUtil.getRawString("from_user", jSONObject);
        this.f13740id = z_T4JInternalParseUtil.getLong("id", jSONObject);
        this.fromUserId = z_T4JInternalParseUtil.getLong("from_user_id", jSONObject);
        this.isoLanguageCode = z_T4JInternalParseUtil.getRawString("iso_language_code", jSONObject);
        this.source = z_T4JInternalParseUtil.getUnescapedString("source", jSONObject);
        this.profileImageUrl = z_T4JInternalParseUtil.getUnescapedString("profile_image_url", jSONObject);
        this.createdAt = z_T4JInternalParseUtil.getDate("created_at", jSONObject, "EEE, dd MMM yyyy HH:mm:ss z");
        this.location = z_T4JInternalParseUtil.getRawString("location", jSONObject);
        this.geoLocation = z_T4JInternalJSONImplFactory.createGeoLocation(jSONObject);
        if (!jSONObject.isNull("annotations")) {
            try {
                this.annotations = new Annotations(jSONObject.getJSONArray("annotations"));
            } catch (JSONException e) {
            }
        }
        if (!jSONObject.isNull("place")) {
            try {
                this.place = new PlaceJSONImpl(jSONObject.getJSONObject("place"));
            } catch (JSONException e2) {
                throw new TwitterException(e2);
            }
        } else {
            this.place = null;
        }
        if (!jSONObject.isNull("entities")) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("entities");
                if (!jSONObject2.isNull("user_mentions")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("user_mentions");
                    int length = jSONArray.length();
                    this.userMentionEntities = new UserMentionEntity[length];
                    for (int i = 0; i < length; i++) {
                        this.userMentionEntities[i] = new UserMentionEntityJSONImpl(jSONArray.getJSONObject(i));
                    }
                }
                if (!jSONObject2.isNull("urls")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("urls");
                    int length2 = jSONArray2.length();
                    this.urlEntities = new URLEntity[length2];
                    for (int i2 = 0; i2 < length2; i2++) {
                        this.urlEntities[i2] = new URLEntityJSONImpl(jSONArray2.getJSONObject(i2));
                    }
                }
                if (!jSONObject2.isNull("hashtags")) {
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("hashtags");
                    int length3 = jSONArray3.length();
                    this.hashtagEntities = new HashtagEntity[length3];
                    for (int i3 = 0; i3 < length3; i3++) {
                        this.hashtagEntities[i3] = new HashtagEntityJSONImpl(jSONArray3.getJSONObject(i3));
                    }
                }
                if (!jSONObject2.isNull("media")) {
                    JSONArray jSONArray4 = jSONObject2.getJSONArray("media");
                    int length4 = jSONArray4.length();
                    this.mediaEntities = new MediaEntity[length4];
                    for (int i4 = 0; i4 < length4; i4++) {
                        this.mediaEntities[i4] = new MediaEntityJSONImpl(jSONArray4.getJSONObject(i4));
                    }
                }
            } catch (JSONException e3) {
                throw new TwitterException(e3);
            }
        }
    }

    TweetJSONImpl(JSONObject jSONObject, Configuration configuration) {
        this(jSONObject);
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(this, jSONObject);
        }
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Tweet tweet) {
        long id = this.f13740id - tweet.getId();
        if (id < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (id > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) id;
    }

    @Override // twitter4j.Tweet
    public String getText() {
        return this.text;
    }

    @Override // twitter4j.Tweet
    public long getToUserId() {
        return this.toUserId;
    }

    @Override // twitter4j.Tweet
    public String getToUser() {
        return this.toUser;
    }

    @Override // twitter4j.Tweet
    public String getFromUser() {
        return this.fromUser;
    }

    @Override // twitter4j.Tweet
    public long getId() {
        return this.f13740id;
    }

    @Override // twitter4j.Tweet
    public long getFromUserId() {
        return this.fromUserId;
    }

    @Override // twitter4j.Tweet
    public String getIsoLanguageCode() {
        return this.isoLanguageCode;
    }

    @Override // twitter4j.Tweet
    public String getSource() {
        return this.source;
    }

    @Override // twitter4j.Tweet
    public String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    @Override // twitter4j.Tweet
    public Date getCreatedAt() {
        return this.createdAt;
    }

    @Override // twitter4j.Tweet
    public GeoLocation getGeoLocation() {
        return this.geoLocation;
    }

    @Override // twitter4j.Tweet
    public String getLocation() {
        return this.location;
    }

    @Override // twitter4j.Tweet
    public Place getPlace() {
        return this.place;
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

    @Override // twitter4j.Tweet
    public Annotations getAnnotations() {
        return this.annotations;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Tweet) && this.f13740id == ((Tweet) obj).getId();
    }

    public int hashCode() {
        return (((this.hashtagEntities != null ? Arrays.hashCode(this.hashtagEntities) : 0) + (((this.urlEntities != null ? Arrays.hashCode(this.urlEntities) : 0) + (((this.userMentionEntities != null ? Arrays.hashCode(this.userMentionEntities) : 0) + (((this.annotations != null ? this.annotations.hashCode() : 0) + (((this.geoLocation != null ? this.geoLocation.hashCode() : 0) + (((this.place != null ? this.place.hashCode() : 0) + (((this.location != null ? this.location.hashCode() : 0) + (((this.createdAt != null ? this.createdAt.hashCode() : 0) + (((this.profileImageUrl != null ? this.profileImageUrl.hashCode() : 0) + (((this.source != null ? this.source.hashCode() : 0) + (((this.isoLanguageCode != null ? this.isoLanguageCode.hashCode() : 0) + (((((((this.fromUser != null ? this.fromUser.hashCode() : 0) + (((this.toUser != null ? this.toUser.hashCode() : 0) + ((((this.text != null ? this.text.hashCode() : 0) * 31) + ((int) (this.toUserId ^ (this.toUserId >>> 32)))) * 31)) * 31)) * 31) + ((int) (this.f13740id ^ (this.f13740id >>> 32)))) * 31) + ((int) (this.fromUserId ^ (this.fromUserId >>> 32)))) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (this.mediaEntities != null ? Arrays.hashCode(this.mediaEntities) : 0);
    }

    public String toString() {
        return new StringBuffer().append("TweetJSONImpl{text='").append(this.text).append('\'').append(", toUserId=").append(this.toUserId).append(", toUser='").append(this.toUser).append('\'').append(", fromUser='").append(this.fromUser).append('\'').append(", id=").append(this.f13740id).append(", fromUserId=").append(this.fromUserId).append(", isoLanguageCode='").append(this.isoLanguageCode).append('\'').append(", source='").append(this.source).append('\'').append(", profileImageUrl='").append(this.profileImageUrl).append('\'').append(", createdAt=").append(this.createdAt).append(", location='").append(this.location).append('\'').append(", place=").append(this.place).append(", geoLocation=").append(this.geoLocation).append(", annotations=").append(this.annotations).append(", userMentionEntities=").append(this.userMentionEntities == null ? null : Arrays.asList(this.userMentionEntities)).append(", urlEntities=").append(this.urlEntities == null ? null : Arrays.asList(this.urlEntities)).append(", hashtagEntities=").append(this.hashtagEntities == null ? null : Arrays.asList(this.hashtagEntities)).append(", mediaEntities=").append(this.mediaEntities != null ? Arrays.asList(this.mediaEntities) : null).append('}').toString();
    }
}
