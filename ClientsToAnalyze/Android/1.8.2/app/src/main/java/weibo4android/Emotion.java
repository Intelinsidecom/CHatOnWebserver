package weibo4android;

import java.util.ArrayList;
import java.util.List;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class Emotion extends WeiboResponse {
    private static final long serialVersionUID = -4096813631691846494L;
    private String category;
    private boolean is_common;
    private boolean is_hot;
    private int order_number;
    private String phrase;
    private String type;
    private String url;

    public Emotion(Response response) throws WeiboException {
        super(response);
        JSONObject jSONObjectAsJSONObject = response.asJSONObject();
        try {
            this.phrase = jSONObjectAsJSONObject.getString("phrase");
            this.type = jSONObjectAsJSONObject.getString("type");
            this.url = jSONObjectAsJSONObject.getString(RtspHeaders.Values.URL);
            this.is_hot = jSONObjectAsJSONObject.getBoolean("is_hot");
            this.order_number = jSONObjectAsJSONObject.getInt("order_number");
            this.category = jSONObjectAsJSONObject.getString("category");
            this.is_common = jSONObjectAsJSONObject.getBoolean("is_common");
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + jSONObjectAsJSONObject.toString(), e);
        }
    }

    public Emotion(JSONObject jSONObject) throws WeiboException {
        try {
            this.phrase = jSONObject.getString("phrase");
            this.type = jSONObject.getString("type");
            this.url = jSONObject.getString(RtspHeaders.Values.URL);
            this.is_hot = jSONObject.getBoolean("is_hot");
            this.order_number = jSONObject.getInt("order_number");
            this.category = jSONObject.getString("category");
            this.is_common = jSONObject.getBoolean("is_common");
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + jSONObject.toString(), e);
        }
    }

    static List constructEmotions(Response response) throws WeiboException {
        try {
            JSONArray jSONArrayAsJSONArray = response.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new Emotion(jSONArrayAsJSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (WeiboException e) {
            throw e;
        } catch (JSONException e2) {
            throw new WeiboException(e2);
        }
    }

    public Emotion() {
    }

    public String getPhrase() {
        return this.phrase;
    }

    public void setPhrase(String str) {
        this.phrase = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public boolean isIs_hot() {
        return this.is_hot;
    }

    public void setIs_hot(boolean z) {
        this.is_hot = z;
    }

    public boolean isIs_common() {
        return this.is_common;
    }

    public void setIs_common(boolean z) {
        this.is_common = z;
    }

    public int getOrder_number() {
        return this.order_number;
    }

    public void setOrder_number(int i) {
        this.order_number = i;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String toString() {
        return "Emotion [phrase=" + this.phrase + ", type=" + this.type + ", url=" + this.url + ", is_hot=" + this.is_hot + ", is_common=" + this.is_common + ", order_number=" + this.order_number + ", category=" + this.category + "]";
    }
}
