package weibo4android;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class Count implements Serializable {
    private static final long serialVersionUID = 9076424494907778181L;
    private long comments;

    /* renamed from: dm */
    private long f7909dm;
    private long followers;

    /* renamed from: id */
    private long f7910id;
    private long mentions;

    /* renamed from: rt */
    private long f7911rt;

    public Count(JSONObject jSONObject) {
        this.f7910id = jSONObject.getLong("id");
        this.comments = jSONObject.getLong("comments");
        this.f7911rt = jSONObject.getLong("rt");
        this.f7909dm = jSONObject.getLong("dm");
        this.mentions = jSONObject.getLong("mentions");
        this.followers = jSONObject.getLong("followers");
    }

    Count(Response response) throws WeiboException {
        JSONObject jSONObjectAsJSONObject = response.asJSONObject();
        try {
            this.f7910id = jSONObjectAsJSONObject.getLong("id");
            this.comments = jSONObjectAsJSONObject.getLong("comments");
            this.f7911rt = jSONObjectAsJSONObject.getLong("rt");
            this.f7909dm = jSONObjectAsJSONObject.getLong("dm");
            this.mentions = jSONObjectAsJSONObject.getLong("mentions");
            this.followers = jSONObjectAsJSONObject.getLong("followers");
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + jSONObjectAsJSONObject.toString(), e);
        }
    }

    static List constructCounts(Response response) throws WeiboException {
        try {
            System.out.println(response.asString());
            JSONArray jSONArrayAsJSONArray = response.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new Count(jSONArrayAsJSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (WeiboException e) {
            throw e;
        } catch (JSONException e2) {
            throw new WeiboException(e2);
        }
    }

    public int hashCode() {
        return (int) this.f7910id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof Count) && ((Count) obj).f7910id == this.f7910id;
    }

    public long getComments() {
        return this.comments;
    }

    public long getRt() {
        return this.f7911rt;
    }

    public long getDm() {
        return this.f7909dm;
    }

    public long getMentions() {
        return this.mentions;
    }

    public long getFollowers() {
        return this.followers;
    }

    public String toString() {
        return "Count{ id=" + this.f7910id + ", comments=" + this.comments + ", rt=" + this.f7911rt + ", dm=" + this.f7909dm + ", mentions=" + this.mentions + ", followers=" + this.followers + '}';
    }
}
