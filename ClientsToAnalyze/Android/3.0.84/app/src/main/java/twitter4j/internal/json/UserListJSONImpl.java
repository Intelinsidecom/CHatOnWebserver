package twitter4j.internal.json;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.conf.Configuration;
import twitter4j.conf.PropertyConfiguration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
class UserListJSONImpl extends TwitterResponseImpl implements Serializable, UserList {
    private static final long serialVersionUID = -6345893237975349030L;
    private String description;
    private boolean following;
    private String fullName;

    /* renamed from: id */
    private int f13742id;
    private int memberCount;
    private boolean mode;
    private String name;
    private String slug;
    private int subscriberCount;
    private String uri;
    private User user;

    @Override // java.lang.Comparable
    public int compareTo(UserList userList) {
        return compareTo2(userList);
    }

    UserListJSONImpl(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
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

    UserListJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        this.f13742id = z_T4JInternalParseUtil.getInt("id", jSONObject);
        this.name = z_T4JInternalParseUtil.getRawString("name", jSONObject);
        this.fullName = z_T4JInternalParseUtil.getRawString("full_name", jSONObject);
        this.slug = z_T4JInternalParseUtil.getRawString("slug", jSONObject);
        this.description = z_T4JInternalParseUtil.getRawString("description", jSONObject);
        this.subscriberCount = z_T4JInternalParseUtil.getInt("subscriber_count", jSONObject);
        this.memberCount = z_T4JInternalParseUtil.getInt("member_count", jSONObject);
        this.uri = z_T4JInternalParseUtil.getRawString("uri", jSONObject);
        this.mode = "public".equals(z_T4JInternalParseUtil.getRawString(RtspHeaders.Values.MODE, jSONObject));
        this.following = z_T4JInternalParseUtil.getBoolean("following", jSONObject);
        try {
            if (!jSONObject.isNull(PropertyConfiguration.USER)) {
                this.user = new UserJSONImpl(jSONObject.getJSONObject(PropertyConfiguration.USER));
            }
        } catch (JSONException e) {
            throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(jSONObject.toString()).toString(), e);
        }
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UserList userList) {
        return this.f13742id - userList.getId();
    }

    @Override // twitter4j.UserList
    public int getId() {
        return this.f13742id;
    }

    @Override // twitter4j.UserList
    public String getName() {
        return this.name;
    }

    @Override // twitter4j.UserList
    public String getFullName() {
        return this.fullName;
    }

    @Override // twitter4j.UserList
    public String getSlug() {
        return this.slug;
    }

    @Override // twitter4j.UserList
    public String getDescription() {
        return this.description;
    }

    @Override // twitter4j.UserList
    public int getSubscriberCount() {
        return this.subscriberCount;
    }

    @Override // twitter4j.UserList
    public int getMemberCount() {
        return this.memberCount;
    }

    @Override // twitter4j.UserList
    public URI getURI() {
        try {
            return new URI(this.uri);
        } catch (URISyntaxException e) {
            return null;
        }
    }

    @Override // twitter4j.UserList
    public boolean isPublic() {
        return this.mode;
    }

    @Override // twitter4j.UserList
    public boolean isFollowing() {
        return this.following;
    }

    @Override // twitter4j.UserList
    public User getUser() {
        return this.user;
    }

    static PagableResponseList<UserList> createPagableUserListList(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
            JSONArray jSONArray = jSONObjectAsJSONObject.getJSONArray("lists");
            int length = jSONArray.length();
            PagableResponseListImpl pagableResponseListImpl = new PagableResponseListImpl(length, jSONObjectAsJSONObject, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UserListJSONImpl userListJSONImpl = new UserListJSONImpl(jSONObject);
                pagableResponseListImpl.add(userListJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(userListJSONImpl, jSONObject);
                }
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

    static ResponseList<UserList> createUserListList(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            JSONArray jSONArrayAsJSONArray = httpResponse.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArrayAsJSONArray.getJSONObject(i);
                UserListJSONImpl userListJSONImpl = new UserListJSONImpl(jSONObject);
                responseListImpl.add(userListJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(userListJSONImpl, jSONObject);
                }
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
        return this.f13742id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof UserList) && ((UserList) obj).getId() == this.f13742id;
        }
        return true;
    }

    public String toString() {
        return new StringBuffer().append("UserListJSONImpl{id=").append(this.f13742id).append(", name='").append(this.name).append('\'').append(", fullName='").append(this.fullName).append('\'').append(", slug='").append(this.slug).append('\'').append(", description='").append(this.description).append('\'').append(", subscriberCount=").append(this.subscriberCount).append(", memberCount=").append(this.memberCount).append(", uri='").append(this.uri).append('\'').append(", mode=").append(this.mode).append(", user=").append(this.user).append(", following=").append(this.following).append('}').toString();
    }
}
