package twitter4j.internal.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.TwitterException;
import twitter4j.UserMentionEntity;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
class UserMentionEntityJSONImpl implements UserMentionEntity {
    private static final long serialVersionUID = 6580431141350059702L;

    /* renamed from: id */
    private long f13743id;
    private String name;
    private String screenName;
    private int start = -1;
    private int end = -1;

    UserMentionEntityJSONImpl(JSONObject jSONObject) throws JSONException, TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws JSONException, TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            this.start = jSONArray.getInt(0);
            this.end = jSONArray.getInt(1);
            if (!jSONObject.isNull("name")) {
                this.name = jSONObject.getString("name");
            }
            if (!jSONObject.isNull("screen_name")) {
                this.screenName = jSONObject.getString("screen_name");
            }
            this.f13743id = z_T4JInternalParseUtil.getLong("id", jSONObject);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    @Override // twitter4j.UserMentionEntity
    public String getName() {
        return this.name;
    }

    @Override // twitter4j.UserMentionEntity
    public String getScreenName() {
        return this.screenName;
    }

    @Override // twitter4j.UserMentionEntity
    public long getId() {
        return this.f13743id;
    }

    @Override // twitter4j.UserMentionEntity
    public int getStart() {
        return this.start;
    }

    @Override // twitter4j.UserMentionEntity
    public int getEnd() {
        return this.end;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserMentionEntityJSONImpl userMentionEntityJSONImpl = (UserMentionEntityJSONImpl) obj;
        if (this.end == userMentionEntityJSONImpl.end && this.f13743id == userMentionEntityJSONImpl.f13743id && this.start == userMentionEntityJSONImpl.start) {
            if (this.name == null ? userMentionEntityJSONImpl.name != null : !this.name.equals(userMentionEntityJSONImpl.name)) {
                return false;
            }
            if (this.screenName != null) {
                if (this.screenName.equals(userMentionEntityJSONImpl.screenName)) {
                    return true;
                }
            } else if (userMentionEntityJSONImpl.screenName == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name != null ? this.name.hashCode() : 0) + (((this.start * 31) + this.end) * 31)) * 31) + (this.screenName != null ? this.screenName.hashCode() : 0)) * 31) + ((int) (this.f13743id ^ (this.f13743id >>> 32)));
    }

    public String toString() {
        return new StringBuffer().append("UserMentionEntityJSONImpl{start=").append(this.start).append(", end=").append(this.end).append(", name='").append(this.name).append('\'').append(", screenName='").append(this.screenName).append('\'').append(", id=").append(this.f13743id).append('}').toString();
    }
}
