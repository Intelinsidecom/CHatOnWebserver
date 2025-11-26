package weibo4android;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class SavedSearch extends WeiboResponse {
    private static final long serialVersionUID = 3083819860391598212L;
    private Date createdAt;

    /* renamed from: id */
    private int f13752id;
    private String name;
    private int position;
    private String query;

    SavedSearch(Response response) throws WeiboException {
        super(response);
        init(response.asJSONObject());
    }

    SavedSearch(Response response, JSONObject jSONObject) throws WeiboException {
        super(response);
        init(jSONObject);
    }

    SavedSearch(JSONObject jSONObject) throws WeiboException {
        init(jSONObject);
    }

    static List<SavedSearch> constructSavedSearches(Response response) throws WeiboException {
        JSONArray jSONArrayAsJSONArray = response.asJSONArray();
        try {
            ArrayList arrayList = new ArrayList(jSONArrayAsJSONArray.length());
            for (int i = 0; i < jSONArrayAsJSONArray.length(); i++) {
                arrayList.add(new SavedSearch(response, jSONArrayAsJSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            throw new WeiboException(e.getMessage() + ":" + response.asString(), e);
        }
    }

    private void init(JSONObject jSONObject) throws WeiboException {
        try {
            this.createdAt = parseDate(jSONObject.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
            this.query = getString("query", jSONObject, true);
            this.position = getInt("position", jSONObject);
            this.name = getString("name", jSONObject, true);
            this.f13752id = getInt("id", jSONObject);
        } catch (JSONException e) {
            throw new WeiboException(e.getMessage() + ":" + jSONObject.toString(), e);
        }
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getQuery() {
        return this.query;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.f13752id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SavedSearch)) {
            return false;
        }
        SavedSearch savedSearch = (SavedSearch) obj;
        return this.f13752id == savedSearch.f13752id && this.position == savedSearch.position && this.createdAt.equals(savedSearch.createdAt) && this.name.equals(savedSearch.name) && this.query.equals(savedSearch.query);
    }

    public int hashCode() {
        return (((((((this.createdAt.hashCode() * 31) + this.query.hashCode()) * 31) + this.position) * 31) + this.name.hashCode()) * 31) + this.f13752id;
    }

    public String toString() {
        return "SavedSearch{createdAt=" + this.createdAt + ", query='" + this.query + "', position=" + this.position + ", name='" + this.name + "', id=" + this.f13752id + '}';
    }
}
