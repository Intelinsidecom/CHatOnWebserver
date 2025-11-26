package twitter4j.internal.json;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Relationship;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
class RelationshipJSONImpl extends TwitterResponseImpl implements Serializable, Relationship {
    private static final long serialVersionUID = 7725021608907856360L;
    private final boolean sourceBlockingTarget;
    private final boolean sourceFollowedByTarget;
    private final boolean sourceFollowingTarget;
    private final boolean sourceNotificationsEnabled;
    private final long sourceUserId;
    private final String sourceUserScreenName;
    private final long targetUserId;
    private final String targetUserScreenName;

    RelationshipJSONImpl(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this(httpResponse, httpResponse.asJSONObject());
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, httpResponse.asJSONObject());
        }
    }

    RelationshipJSONImpl(JSONObject jSONObject) {
        this((HttpResponse) null, jSONObject);
    }

    RelationshipJSONImpl(HttpResponse httpResponse, JSONObject jSONObject) throws JSONException, TwitterException {
        super(httpResponse);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("relationship");
            JSONObject jSONObject3 = jSONObject2.getJSONObject("source");
            JSONObject jSONObject4 = jSONObject2.getJSONObject("target");
            this.sourceUserId = z_T4JInternalParseUtil.getLong("id", jSONObject3);
            this.targetUserId = z_T4JInternalParseUtil.getLong("id", jSONObject4);
            this.sourceUserScreenName = z_T4JInternalParseUtil.getUnescapedString("screen_name", jSONObject3);
            this.targetUserScreenName = z_T4JInternalParseUtil.getUnescapedString("screen_name", jSONObject4);
            this.sourceBlockingTarget = z_T4JInternalParseUtil.getBoolean("blocking", jSONObject3);
            this.sourceFollowingTarget = z_T4JInternalParseUtil.getBoolean("following", jSONObject3);
            this.sourceFollowedByTarget = z_T4JInternalParseUtil.getBoolean("followed_by", jSONObject3);
            this.sourceNotificationsEnabled = z_T4JInternalParseUtil.getBoolean("notifications_enabled", jSONObject3);
        } catch (JSONException e) {
            throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(jSONObject.toString()).toString(), e);
        }
    }

    static ResponseList<Relationship> createRelationshipList(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            JSONArray jSONArrayAsJSONArray = httpResponse.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArrayAsJSONArray.getJSONObject(i);
                RelationshipJSONImpl relationshipJSONImpl = new RelationshipJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(relationshipJSONImpl, jSONObject);
                }
                responseListImpl.add(relationshipJSONImpl);
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

    @Override // twitter4j.Relationship
    public long getSourceUserId() {
        return this.sourceUserId;
    }

    @Override // twitter4j.Relationship
    public long getTargetUserId() {
        return this.targetUserId;
    }

    @Override // twitter4j.Relationship
    public boolean isSourceBlockingTarget() {
        return this.sourceBlockingTarget;
    }

    @Override // twitter4j.Relationship
    public String getSourceUserScreenName() {
        return this.sourceUserScreenName;
    }

    @Override // twitter4j.Relationship
    public String getTargetUserScreenName() {
        return this.targetUserScreenName;
    }

    @Override // twitter4j.Relationship
    public boolean isSourceFollowingTarget() {
        return this.sourceFollowingTarget;
    }

    @Override // twitter4j.Relationship
    public boolean isTargetFollowingSource() {
        return this.sourceFollowedByTarget;
    }

    @Override // twitter4j.Relationship
    public boolean isSourceFollowedByTarget() {
        return this.sourceFollowedByTarget;
    }

    @Override // twitter4j.Relationship
    public boolean isTargetFollowedBySource() {
        return this.sourceFollowingTarget;
    }

    @Override // twitter4j.Relationship
    public boolean isSourceNotificationsEnabled() {
        return this.sourceNotificationsEnabled;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Relationship)) {
            return false;
        }
        Relationship relationship = (Relationship) obj;
        return this.sourceUserId == relationship.getSourceUserId() && this.targetUserId == relationship.getTargetUserId() && this.sourceUserScreenName.equals(relationship.getSourceUserScreenName()) && this.targetUserScreenName.equals(relationship.getTargetUserScreenName());
    }

    public int hashCode() {
        return (((((((this.sourceFollowingTarget ? 1 : 0) + (((this.sourceNotificationsEnabled ? 1 : 0) + (((this.sourceBlockingTarget ? 1 : 0) + (((this.targetUserScreenName != null ? this.targetUserScreenName.hashCode() : 0) + (((int) (this.targetUserId ^ (this.targetUserId >>> 32))) * 31)) * 31)) * 31)) * 31)) * 31) + (this.sourceFollowedByTarget ? 1 : 0)) * 31) + ((int) (this.sourceUserId ^ (this.sourceUserId >>> 32)))) * 31) + (this.sourceUserScreenName != null ? this.sourceUserScreenName.hashCode() : 0);
    }

    public String toString() {
        return new StringBuffer().append("RelationshipJSONImpl{sourceUserId=").append(this.sourceUserId).append(", targetUserId=").append(this.targetUserId).append(", sourceUserScreenName='").append(this.sourceUserScreenName).append('\'').append(", targetUserScreenName='").append(this.targetUserScreenName).append('\'').append(", sourceFollowingTarget=").append(this.sourceFollowingTarget).append(", sourceFollowedByTarget=").append(this.sourceFollowedByTarget).append(", sourceNotificationsEnabled=").append(this.sourceNotificationsEnabled).append('}').toString();
    }
}
