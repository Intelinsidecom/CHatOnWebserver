package weibo4android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class Trends extends WeiboResponse implements Comparable {
    private static final long serialVersionUID = -7151479143843312309L;
    private Date asOf;
    private Date trendAt;
    private Trend[] trends;

    @Override // java.lang.Comparable
    public int compareTo(Trends trends) {
        return this.trendAt.compareTo(trends.trendAt);
    }

    Trends(Response response, Date date, Date date2, Trend[] trendArr) {
        super(response);
        this.asOf = date;
        this.trendAt = date2;
        this.trends = trendArr;
    }

    static List constructTrendsList(Response response) throws WeiboException {
        JSONObject jSONObjectAsJSONObject = response.asJSONObject();
        try {
            Date date = parseDate(jSONObjectAsJSONObject.getString("as_of"));
            JSONObject jSONObject = jSONObjectAsJSONObject.getJSONObject("trends");
            ArrayList arrayList = new ArrayList(jSONObject.length());
            Iterator itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String str = (String) itKeys.next();
                Trend[] trendArrJsonArrayToTrendArray = jsonArrayToTrendArray(jSONObject.getJSONArray(str));
                if (str.length() == 19) {
                    arrayList.add(new Trends(response, date, parseDate(str, "yyyy-MM-dd HH:mm:ss"), trendArrJsonArrayToTrendArray));
                } else if (str.length() == 16) {
                    arrayList.add(new Trends(response, date, parseDate(str, "yyyy-MM-dd HH:mm"), trendArrJsonArrayToTrendArray));
                } else if (str.length() == 10) {
                    arrayList.add(new Trends(response, date, parseDate(str, "yyyy-MM-dd"), trendArrJsonArrayToTrendArray));
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + response.asString(), e);
        }
    }

    static Trends constructTrends(Response response) throws WeiboException {
        JSONObject jSONObjectAsJSONObject = response.asJSONObject();
        try {
            Date date = parseDate(jSONObjectAsJSONObject.getString("as_of"));
            return new Trends(response, date, date, jsonArrayToTrendArray(jSONObjectAsJSONObject.getJSONArray("trends")));
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + response.asString(), e);
        }
    }

    private static Date parseDate(String str) {
        if (str.length() == 10) {
            return new Date(Long.parseLong(str) * 1000);
        }
        return WeiboResponse.parseDate(str, "EEE, d MMM yyyy HH:mm:ss z");
    }

    private static Trend[] jsonArrayToTrendArray(JSONArray jSONArray) {
        Trend[] trendArr = new Trend[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            trendArr[i] = new Trend(jSONArray.getJSONObject(i));
        }
        return trendArr;
    }

    public Trend[] getTrends() {
        return this.trends;
    }

    public Date getAsOf() {
        return this.asOf;
    }

    public Date getTrendAt() {
        return this.trendAt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trends)) {
            return false;
        }
        Trends trends = (Trends) obj;
        if (this.asOf == null ? trends.asOf != null : !this.asOf.equals(trends.asOf)) {
            return false;
        }
        if (this.trendAt == null ? trends.trendAt != null : !this.trendAt.equals(trends.trendAt)) {
            return false;
        }
        return Arrays.equals(this.trends, trends.trends);
    }

    public int hashCode() {
        return (((this.trendAt != null ? this.trendAt.hashCode() : 0) + ((this.asOf != null ? this.asOf.hashCode() : 0) * 31)) * 31) + (this.trends != null ? Arrays.hashCode(this.trends) : 0);
    }

    public String toString() {
        return "Trends{asOf=" + this.asOf + ", trendAt=" + this.trendAt + ", trends=" + (this.trends == null ? null : Arrays.asList(this.trends)) + '}';
    }
}
