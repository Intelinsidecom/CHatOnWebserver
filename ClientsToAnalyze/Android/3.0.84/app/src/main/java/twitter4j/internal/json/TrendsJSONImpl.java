package twitter4j.internal.json;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class TrendsJSONImpl extends TwitterResponseImpl implements Serializable, Trends {
    private static final long serialVersionUID = -7151479143843312309L;
    private Date asOf;
    private Location location;
    private Date trendAt;
    private Trend[] trends;

    @Override // java.lang.Comparable
    public int compareTo(Trends trends) {
        return compareTo2(trends);
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Trends trends) {
        return this.trendAt.compareTo(trends.getTrendAt());
    }

    TrendsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws JSONException, IllegalAccessException, TwitterException, IllegalArgumentException, InvocationTargetException {
        super(httpResponse);
        init(httpResponse.asString(), configuration.isJSONStoreEnabled());
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, httpResponse.asString());
        }
    }

    TrendsJSONImpl(String str) {
        this(str, false);
    }

    TrendsJSONImpl(String str, boolean z) throws JSONException, TwitterException {
        init(str, z);
    }

    void init(String str, boolean z) throws JSONException, TwitterException {
        JSONObject jSONObject;
        try {
            if (str.startsWith("[")) {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    jSONObject = jSONArray.getJSONObject(0);
                } else {
                    throw new TwitterException("No trends found on the specified woeid");
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            this.asOf = z_T4JInternalParseUtil.parseTrendsDate(jSONObject.getString("as_of"));
            this.location = extractLocation(jSONObject, z);
            JSONArray jSONArray2 = jSONObject.getJSONArray("trends");
            this.trendAt = this.asOf;
            this.trends = jsonArrayToTrendArray(jSONArray2, z);
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage(), e);
        }
    }

    TrendsJSONImpl(Date date, Location location, Date date2, Trend[] trendArr) {
        this.asOf = date;
        this.location = location;
        this.trendAt = date2;
        this.trends = trendArr;
    }

    static ResponseList<Trends> createTrendsList(HttpResponse httpResponse, boolean z) throws JSONException, TwitterException, IOException {
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        try {
            Date trendsDate = z_T4JInternalParseUtil.parseTrendsDate(jSONObjectAsJSONObject.getString("as_of"));
            JSONObject jSONObject = jSONObjectAsJSONObject.getJSONObject("trends");
            Location locationExtractLocation = extractLocation(jSONObjectAsJSONObject, z);
            ResponseListImpl responseListImpl = new ResponseListImpl(jSONObject.length(), httpResponse);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Trend[] trendArrJsonArrayToTrendArray = jsonArrayToTrendArray(jSONObject.getJSONArray(next), z);
                if (next.length() == 19) {
                    responseListImpl.add(new TrendsJSONImpl(trendsDate, locationExtractLocation, z_T4JInternalParseUtil.getDate(next, "yyyy-MM-dd HH:mm:ss"), trendArrJsonArrayToTrendArray));
                } else if (next.length() == 16) {
                    responseListImpl.add(new TrendsJSONImpl(trendsDate, locationExtractLocation, z_T4JInternalParseUtil.getDate(next, "yyyy-MM-dd HH:mm"), trendArrJsonArrayToTrendArray));
                } else if (next.length() == 10) {
                    responseListImpl.add(new TrendsJSONImpl(trendsDate, locationExtractLocation, z_T4JInternalParseUtil.getDate(next, "yyyy-MM-dd"), trendArrJsonArrayToTrendArray));
                }
            }
            Collections.sort(responseListImpl);
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(httpResponse.asString()).toString(), e);
        }
    }

    private static Location extractLocation(JSONObject jSONObject, boolean z) throws TwitterException {
        if (jSONObject.isNull("locations")) {
            return null;
        }
        try {
            ResponseList<Location> responseListCreateLocationList = LocationJSONImpl.createLocationList(jSONObject.getJSONArray("locations"), z);
            if (responseListCreateLocationList.size() != 0) {
                return responseListCreateLocationList.get(0);
            }
            return null;
        } catch (JSONException e) {
            throw new AssertionError("locations can't be null");
        }
    }

    private static Trend[] jsonArrayToTrendArray(JSONArray jSONArray, boolean z) {
        Trend[] trendArr = new Trend[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            trendArr[i] = new TrendJSONImpl(jSONArray.getJSONObject(i), z);
        }
        return trendArr;
    }

    @Override // twitter4j.Trends
    public Trend[] getTrends() {
        return this.trends;
    }

    @Override // twitter4j.Trends
    public Location getLocation() {
        return this.location;
    }

    @Override // twitter4j.Trends
    public Date getAsOf() {
        return this.asOf;
    }

    @Override // twitter4j.Trends
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
        if (this.asOf == null ? trends.getAsOf() != null : !this.asOf.equals(trends.getAsOf())) {
            return false;
        }
        if (this.trendAt == null ? trends.getTrendAt() != null : !this.trendAt.equals(trends.getTrendAt())) {
            return false;
        }
        return Arrays.equals(this.trends, trends.getTrends());
    }

    public int hashCode() {
        return (((this.trendAt != null ? this.trendAt.hashCode() : 0) + ((this.asOf != null ? this.asOf.hashCode() : 0) * 31)) * 31) + (this.trends != null ? Arrays.hashCode(this.trends) : 0);
    }

    public String toString() {
        return new StringBuffer().append("TrendsJSONImpl{asOf=").append(this.asOf).append(", trendAt=").append(this.trendAt).append(", trends=").append(this.trends == null ? null : Arrays.asList(this.trends)).append('}').toString();
    }
}
