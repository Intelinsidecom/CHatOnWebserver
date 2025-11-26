package twitter4j.internal.json;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Friendship;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
class FriendshipJSONImpl implements Friendship {
    private static final long serialVersionUID = 7724410837770709741L;
    private boolean followedBy;
    private boolean following;

    /* renamed from: id */
    private final long f7899id;
    private final String name;
    private final String screenName;

    FriendshipJSONImpl(JSONObject jSONObject) throws JSONException, TwitterException {
        this.following = false;
        this.followedBy = false;
        try {
            this.f7899id = z_T4JInternalParseUtil.getLong("id", jSONObject);
            this.name = jSONObject.getString("name");
            this.screenName = jSONObject.getString("screen_name");
            JSONArray jSONArray = jSONObject.getJSONArray("connections");
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if ("following".equals(string)) {
                    this.following = true;
                } else if ("followed_by".equals(string)) {
                    this.followedBy = true;
                }
            }
        } catch (JSONException e) {
            throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(jSONObject.toString()).toString(), e);
        }
    }

    static ResponseList createFriendshipList(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            JSONArray jSONArrayAsJSONArray = httpResponse.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArrayAsJSONArray.getJSONObject(i);
                FriendshipJSONImpl friendshipJSONImpl = new FriendshipJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(friendshipJSONImpl, jSONObject);
                }
                responseListImpl.add(friendshipJSONImpl);
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

    @Override // twitter4j.Friendship
    public long getId() {
        return this.f7899id;
    }

    @Override // twitter4j.Friendship
    public String getName() {
        return this.name;
    }

    @Override // twitter4j.Friendship
    public String getScreenName() {
        return this.screenName;
    }

    @Override // twitter4j.Friendship
    public boolean isFollowing() {
        return this.following;
    }

    @Override // twitter4j.Friendship
    public boolean isFollowedBy() {
        return this.followedBy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FriendshipJSONImpl friendshipJSONImpl = (FriendshipJSONImpl) obj;
        return this.followedBy == friendshipJSONImpl.followedBy && this.following == friendshipJSONImpl.following && this.f7899id == friendshipJSONImpl.f7899id && this.name.equals(friendshipJSONImpl.name) && this.screenName.equals(friendshipJSONImpl.screenName);
    }

    public int hashCode() {
        return (((this.following ? 1 : 0) + (((this.screenName != null ? this.screenName.hashCode() : 0) + (((this.name != null ? this.name.hashCode() : 0) + (((int) (this.f7899id ^ (this.f7899id >>> 32))) * 31)) * 31)) * 31)) * 31) + (this.followedBy ? 1 : 0);
    }

    public String toString() {
        return new StringBuffer().append("FriendshipJSONImpl{id=").append(this.f7899id).append(", name='").append(this.name).append('\'').append(", screenName='").append(this.screenName).append('\'').append(", following=").append(this.following).append(", followedBy=").append(this.followedBy).append('}').toString();
    }
}
