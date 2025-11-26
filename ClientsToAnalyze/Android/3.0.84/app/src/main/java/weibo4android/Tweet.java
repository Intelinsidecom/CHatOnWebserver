package weibo4android;

import java.util.Date;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class Tweet extends WeiboResponse {
    private static final long serialVersionUID = 4299736733993211587L;
    private Date createdAt;
    private String fromUser;
    private int fromUserId;

    /* renamed from: id */
    private long f13757id;
    private String isoLanguageCode;
    private String profileImageUrl;
    private String source;
    private String text;
    private String toUser;
    private int toUserId;

    Tweet(JSONObject jSONObject, WeiboSupport weiboSupport) throws WeiboException {
        this.toUserId = -1;
        this.toUser = null;
        this.isoLanguageCode = null;
        try {
            this.text = getString("text", jSONObject, false);
            try {
                this.toUserId = jSONObject.getInt("to_user_id");
                this.toUser = jSONObject.getString("to_user");
            } catch (JSONException e) {
            }
            this.fromUser = jSONObject.getString("from_user");
            this.f13757id = jSONObject.getLong("id");
            this.fromUserId = jSONObject.getInt("from_user_id");
            try {
                this.isoLanguageCode = jSONObject.getString("iso_language_code");
            } catch (JSONException e2) {
            }
            this.source = getString("source", jSONObject, true);
            this.profileImageUrl = getString("profile_image_url", jSONObject, true);
            this.createdAt = parseDate(jSONObject.getString("created_at"), "E MMM dd hh:mm:ss z yyyy");
        } catch (JSONException e3) {
            throw new WeiboException(e3.getMessage() + ":" + jSONObject.toString(), e3);
        }
    }

    public String getText() {
        return this.text;
    }

    public int getToUserId() {
        return this.toUserId;
    }

    public String getToUser() {
        return this.toUser;
    }

    public String getFromUser() {
        return this.fromUser;
    }

    public long getId() {
        return this.f13757id;
    }

    public int getFromUserId() {
        return this.fromUserId;
    }

    public String getIsoLanguageCode() {
        return this.isoLanguageCode;
    }

    public String getSource() {
        return this.source;
    }

    public String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tweet tweet = (Tweet) obj;
        if (this.fromUserId == tweet.fromUserId && this.f13757id == tweet.f13757id && this.toUserId == tweet.toUserId) {
            if (this.createdAt == null ? tweet.createdAt != null : !this.createdAt.equals(tweet.createdAt)) {
                return false;
            }
            if (this.fromUser == null ? tweet.fromUser != null : !this.fromUser.equals(tweet.fromUser)) {
                return false;
            }
            if (this.isoLanguageCode == null ? tweet.isoLanguageCode != null : !this.isoLanguageCode.equals(tweet.isoLanguageCode)) {
                return false;
            }
            if (this.profileImageUrl == null ? tweet.profileImageUrl != null : !this.profileImageUrl.equals(tweet.profileImageUrl)) {
                return false;
            }
            if (this.source == null ? tweet.source != null : !this.source.equals(tweet.source)) {
                return false;
            }
            if (this.text == null ? tweet.text != null : !this.text.equals(tweet.text)) {
                return false;
            }
            if (this.toUser != null) {
                if (this.toUser.equals(tweet.toUser)) {
                    return true;
                }
            } else if (tweet.toUser == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.profileImageUrl != null ? this.profileImageUrl.hashCode() : 0) + (((this.source != null ? this.source.hashCode() : 0) + (((this.isoLanguageCode != null ? this.isoLanguageCode.hashCode() : 0) + (((((((this.fromUser != null ? this.fromUser.hashCode() : 0) + (((this.toUser != null ? this.toUser.hashCode() : 0) + ((((this.text != null ? this.text.hashCode() : 0) * 31) + (this.toUserId ^ (this.toUserId >>> 32))) * 31)) * 31)) * 31) + ((int) (this.f13757id ^ (this.f13757id >>> 32)))) * 31) + (this.fromUserId ^ (this.fromUserId >>> 32))) * 31)) * 31)) * 31)) * 31) + (this.createdAt != null ? this.createdAt.hashCode() : 0);
    }

    public String toString() {
        return "Tweet{text='" + this.text + "', toUserId=" + this.toUserId + ", toUser='" + this.toUser + "', fromUser='" + this.fromUser + "', id=" + this.f13757id + ", fromUserId=" + this.fromUserId + ", isoLanguageCode='" + this.isoLanguageCode + "', source='" + this.source + "', profileImageUrl='" + this.profileImageUrl + "', createdAt=" + this.createdAt + '}';
    }
}
