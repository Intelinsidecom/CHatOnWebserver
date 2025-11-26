package twitter4j.internal.json;

import java.lang.reflect.InvocationTargetException;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class LocationJSONImpl implements Location {
    private static final long serialVersionUID = 7095092358530897222L;
    private final String countryCode;
    private final String countryName;
    private final String name;
    private final int placeCode;
    private final String placeName;
    private final String url;
    private final int woeid;

    LocationJSONImpl(JSONObject jSONObject) throws JSONException, TwitterException {
        try {
            this.woeid = z_T4JInternalParseUtil.getInt("woeid", jSONObject);
            this.countryName = z_T4JInternalParseUtil.getUnescapedString("country", jSONObject);
            this.countryCode = z_T4JInternalParseUtil.getRawString("countryCode", jSONObject);
            if (!jSONObject.isNull("placeType")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("placeType");
                this.placeName = z_T4JInternalParseUtil.getUnescapedString("name", jSONObject2);
                this.placeCode = z_T4JInternalParseUtil.getInt("code", jSONObject2);
            } else {
                this.placeName = null;
                this.placeCode = -1;
            }
            this.name = z_T4JInternalParseUtil.getUnescapedString("name", jSONObject);
            this.url = z_T4JInternalParseUtil.getUnescapedString(RtspHeaders.Values.URL, jSONObject);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    static ResponseList createLocationList(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
        }
        return createLocationList(httpResponse.asJSONArray(), configuration.isJSONStoreEnabled());
    }

    static ResponseList createLocationList(JSONArray jSONArray, boolean z) throws JSONException, TwitterException {
        try {
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, null);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                LocationJSONImpl locationJSONImpl = new LocationJSONImpl(jSONObject);
                responseListImpl.add(locationJSONImpl);
                if (z) {
                    DataObjectFactoryUtil.registerJSONObject(locationJSONImpl, jSONObject);
                }
            }
            if (z) {
                DataObjectFactoryUtil.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        } catch (TwitterException e2) {
            throw e2;
        }
    }

    @Override // twitter4j.Location
    public int getWoeid() {
        return this.woeid;
    }

    @Override // twitter4j.Location
    public String getCountryName() {
        return this.countryName;
    }

    @Override // twitter4j.Location
    public String getCountryCode() {
        return this.countryCode;
    }

    @Override // twitter4j.Location
    public String getPlaceName() {
        return this.placeName;
    }

    @Override // twitter4j.Location
    public int getPlaceCode() {
        return this.placeCode;
    }

    @Override // twitter4j.Location
    public String getName() {
        return this.name;
    }

    @Override // twitter4j.Location
    public String getURL() {
        return this.url;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocationJSONImpl) && this.woeid == ((LocationJSONImpl) obj).woeid;
    }

    public int hashCode() {
        return this.woeid;
    }

    public String toString() {
        return new StringBuffer().append("LocationJSONImpl{woeid=").append(this.woeid).append(", countryName='").append(this.countryName).append('\'').append(", countryCode='").append(this.countryCode).append('\'').append(", placeName='").append(this.placeName).append('\'').append(", placeCode='").append(this.placeCode).append('\'').append(", name='").append(this.name).append('\'').append(", url='").append(this.url).append('\'').append('}').toString();
    }
}
