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
    private long f13745dm;
    private long followers;

    /* renamed from: id */
    private long f13746id;
    private long mentions;

    /* renamed from: rt */
    private long f13747rt;

    public Count(JSONObject jSONObject) {
        this.f13746id = jSONObject.getLong("id");
        this.comments = jSONObject.getLong("comments");
        this.f13747rt = jSONObject.getLong("rt");
        this.f13745dm = jSONObject.getLong("dm");
        this.mentions = jSONObject.getLong("mentions");
        this.followers = jSONObject.getLong("followers");
    }

    static List<Count> constructCounts(Response response) throws WeiboException {
        try {
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
        return (int) this.f13746id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof Count) && ((Count) obj).f13746id == this.f13746id;
        }
        return true;
    }

    public long getComments() {
        return this.comments;
    }

    public long getRt() {
        return this.f13747rt;
    }

    public long getDm() {
        return this.f13745dm;
    }

    public long getMentions() {
        return this.mentions;
    }

    public long getFollowers() {
        return this.followers;
    }

    public String toString() {
        return "Count{ id=" + this.f13746id + ", comments=" + this.comments + ", rt=" + this.f13747rt + ", dm=" + this.f13745dm + ", mentions=" + this.mentions + ", followers=" + this.followers + '}';
    }
}
