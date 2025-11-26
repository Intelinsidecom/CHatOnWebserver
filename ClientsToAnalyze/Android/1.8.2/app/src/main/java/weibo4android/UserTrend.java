package weibo4android;

import java.util.ArrayList;
import java.util.List;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class UserTrend extends WeiboResponse {
    private static final long serialVersionUID = 1925956704460743946L;
    private String hotword;
    private String num;
    private String trend_id;

    public UserTrend() {
        this.hotword = null;
        this.trend_id = null;
    }

    public UserTrend(Response response) throws WeiboException {
        super(response);
        this.hotword = null;
        this.trend_id = null;
        JSONObject jSONObjectAsJSONObject = response.asJSONObject();
        try {
            this.num = jSONObjectAsJSONObject.getString("num");
            this.hotword = jSONObjectAsJSONObject.getString("hotword");
            this.trend_id = jSONObjectAsJSONObject.getString("trend_id");
            if (jSONObjectAsJSONObject.getString("topicid") != null) {
                this.trend_id = jSONObjectAsJSONObject.getString("topicid");
            }
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + jSONObjectAsJSONObject.toString(), e);
        }
    }

    public UserTrend(JSONObject jSONObject) throws WeiboException {
        this.hotword = null;
        this.trend_id = null;
        try {
            this.num = jSONObject.getString("num");
            this.hotword = jSONObject.getString("hotword");
            this.trend_id = jSONObject.getString("trend_id");
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + jSONObject.toString(), e);
        }
    }

    static List constructTrendList(Response response) throws WeiboException {
        try {
            JSONArray jSONArrayAsJSONArray = response.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new UserTrend(jSONArrayAsJSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (WeiboException e) {
            throw e;
        } catch (JSONException e2) {
            throw new WeiboException(e2);
        }
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String str) {
        this.num = str;
    }

    public String getHotword() {
        return this.hotword;
    }

    public void setHotword(String str) {
        this.hotword = str;
    }

    public String getTrend_id() {
        return this.trend_id;
    }

    public void setTrend_id(String str) {
        this.trend_id = str;
    }

    public String toString() {
        return "Trend [num=" + this.num + ", hotword=" + this.hotword + ", trend_id=" + this.trend_id + "]";
    }
}
