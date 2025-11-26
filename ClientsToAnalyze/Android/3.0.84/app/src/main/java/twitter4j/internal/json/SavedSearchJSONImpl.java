package twitter4j.internal.json;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.ResponseList;
import twitter4j.SavedSearch;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class SavedSearchJSONImpl extends TwitterResponseImpl implements SavedSearch {
    private static final long serialVersionUID = 3083819860391598212L;
    private Date createdAt;

    /* renamed from: id */
    private int f13738id;
    private String name;
    private int position;
    private String query;

    @Override // java.lang.Comparable
    public int compareTo(SavedSearch savedSearch) {
        return compareTo2(savedSearch);
    }

    SavedSearchJSONImpl(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
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

    SavedSearchJSONImpl(JSONObject jSONObject) {
        init(jSONObject);
    }

    static ResponseList<SavedSearch> createSavedSearchList(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
        }
        JSONArray jSONArrayAsJSONArray = httpResponse.asJSONArray();
        try {
            ResponseListImpl responseListImpl = new ResponseListImpl(jSONArrayAsJSONArray.length(), httpResponse);
            for (int i = 0; i < jSONArrayAsJSONArray.length(); i++) {
                JSONObject jSONObject = jSONArrayAsJSONArray.getJSONObject(i);
                SavedSearchJSONImpl savedSearchJSONImpl = new SavedSearchJSONImpl(jSONObject);
                responseListImpl.add(savedSearchJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(savedSearchJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.registerJSONObject(responseListImpl, jSONArrayAsJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(httpResponse.asString()).toString(), e);
        }
    }

    private void init(JSONObject jSONObject) {
        this.createdAt = z_T4JInternalParseUtil.getDate("created_at", jSONObject, "EEE MMM dd HH:mm:ss z yyyy");
        this.query = z_T4JInternalParseUtil.getUnescapedString("query", jSONObject);
        this.position = z_T4JInternalParseUtil.getInt("position", jSONObject);
        this.name = z_T4JInternalParseUtil.getUnescapedString("name", jSONObject);
        this.f13738id = z_T4JInternalParseUtil.getInt("id", jSONObject);
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(SavedSearch savedSearch) {
        return this.f13738id - savedSearch.getId();
    }

    @Override // twitter4j.SavedSearch
    public Date getCreatedAt() {
        return this.createdAt;
    }

    @Override // twitter4j.SavedSearch
    public String getQuery() {
        return this.query;
    }

    @Override // twitter4j.SavedSearch
    public int getPosition() {
        return this.position;
    }

    @Override // twitter4j.SavedSearch
    public String getName() {
        return this.name;
    }

    @Override // twitter4j.SavedSearch
    public int getId() {
        return this.f13738id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SavedSearch) && this.f13738id == ((SavedSearch) obj).getId();
    }

    public int hashCode() {
        return (((((((this.createdAt.hashCode() * 31) + this.query.hashCode()) * 31) + this.position) * 31) + this.name.hashCode()) * 31) + this.f13738id;
    }

    public String toString() {
        return new StringBuffer().append("SavedSearchJSONImpl{createdAt=").append(this.createdAt).append(", query='").append(this.query).append('\'').append(", position=").append(this.position).append(", name='").append(this.name).append('\'').append(", id=").append(this.f13738id).append('}').toString();
    }
}
