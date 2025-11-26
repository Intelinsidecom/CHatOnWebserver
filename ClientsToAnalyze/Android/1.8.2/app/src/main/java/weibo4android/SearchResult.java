package weibo4android;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class SearchResult extends WeiboResponse implements Serializable {
    private static final long serialVersionUID = 8227371192527300467L;
    private Date createdAt;
    private String from_user;
    private long from_user_id;

    /* renamed from: id */
    private long f7915id;
    private String iso_language_code;
    private String profileImageUrl;
    private String source;
    private String text;
    private String to_user;
    private long to_user_id;

    public SearchResult(JSONObject jSONObject) {
        this.createdAt = parseDate(jSONObject.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
        this.to_user_id = jSONObject.getLong("to_user_id");
        this.to_user = jSONObject.getString("to_user");
        this.text = jSONObject.getString("text");
        this.source = jSONObject.getString("source");
        this.f7915id = jSONObject.getLong("id");
        this.from_user_id = jSONObject.getLong("from_user_id");
        this.from_user = jSONObject.getString("from_user");
        this.iso_language_code = jSONObject.getString("iso_language_code");
        this.profileImageUrl = jSONObject.getString("profile_image_url");
    }

    public static List constructResults(Response response) throws WeiboException {
        try {
            JSONArray jSONArray = response.asJSONObject().getJSONArray("results");
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new SearchResult(jSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            throw new WeiboException(e);
        }
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public long getToUserId() {
        return this.to_user_id;
    }

    public long getId() {
        return this.f7915id;
    }

    public long getFromUserId() {
        return this.from_user_id;
    }

    public String getText() {
        return this.text;
    }

    public String getSource() {
        return this.source;
    }

    public String getFromUser() {
        return this.from_user;
    }

    public String getToUser() {
        return this.to_user;
    }

    public String getName() {
        return this.iso_language_code;
    }

    public URL getProfileImageURL() {
        try {
            return new URL(this.profileImageUrl);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public int hashCode() {
        return (((((((((this.from_user == null ? 0 : this.from_user.hashCode()) + 31) * 31) + ((int) (this.from_user_id ^ (this.from_user_id >>> 32)))) * 31) + ((int) (this.f7915id ^ (this.f7915id >>> 32)))) * 31) + (this.to_user != null ? this.to_user.hashCode() : 0)) * 31) + ((int) (this.to_user_id ^ (this.to_user_id >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SearchResult searchResult = (SearchResult) obj;
            if (this.from_user == null) {
                if (searchResult.from_user != null) {
                    return false;
                }
            } else if (!this.from_user.equals(searchResult.from_user)) {
                return false;
            }
            if (this.from_user_id == searchResult.from_user_id && this.f7915id == searchResult.f7915id) {
                if (this.to_user == null) {
                    if (searchResult.to_user != null) {
                        return false;
                    }
                } else if (!this.to_user.equals(searchResult.to_user)) {
                    return false;
                }
                return this.to_user_id == searchResult.to_user_id;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return "Result{ " + this.to_user_id + "," + this.to_user + "," + this.text + "," + this.f7915id + "," + this.from_user_id + "," + this.from_user + "," + this.iso_language_code + "," + this.source + "," + this.profileImageUrl + "," + this.createdAt + '}';
    }
}
