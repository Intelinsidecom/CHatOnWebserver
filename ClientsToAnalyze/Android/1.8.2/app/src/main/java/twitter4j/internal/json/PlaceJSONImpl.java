package twitter4j.internal.json;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.GeoLocation;
import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class PlaceJSONImpl extends TwitterResponseImpl implements Serializable, Place {
    private static final long serialVersionUID = -2873364341474633812L;
    private GeoLocation[][] boundingBoxCoordinates;
    private String boundingBoxType;
    private Place[] containedWithIn;
    private String country;
    private String countryCode;
    private String fullName;
    private GeoLocation[][] geometryCoordinates;
    private String geometryType;

    /* renamed from: id */
    private String f7901id;
    private String name;
    private String placeType;
    private String streetAddress;
    private String url;

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return compareTo((Place) obj);
    }

    PlaceJSONImpl(HttpResponse httpResponse, Configuration configuration) throws JSONException, IllegalAccessException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        super(httpResponse);
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        init(jSONObjectAsJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, jSONObjectAsJSONObject);
        }
    }

    PlaceJSONImpl(JSONObject jSONObject, HttpResponse httpResponse) throws JSONException, TwitterException {
        super(httpResponse);
        init(jSONObject);
    }

    PlaceJSONImpl(JSONObject jSONObject) throws JSONException, TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws JSONException, TwitterException {
        try {
            this.name = z_T4JInternalParseUtil.getUnescapedString("name", jSONObject);
            this.streetAddress = z_T4JInternalParseUtil.getUnescapedString("street_address", jSONObject);
            this.countryCode = z_T4JInternalParseUtil.getRawString("country_code", jSONObject);
            this.f7901id = z_T4JInternalParseUtil.getRawString("id", jSONObject);
            this.country = z_T4JInternalParseUtil.getRawString("country", jSONObject);
            if (!jSONObject.isNull("place_type")) {
                this.placeType = z_T4JInternalParseUtil.getRawString("place_type", jSONObject);
            } else {
                this.placeType = z_T4JInternalParseUtil.getRawString("type", jSONObject);
            }
            this.url = z_T4JInternalParseUtil.getRawString(RtspHeaders.Values.URL, jSONObject);
            this.fullName = z_T4JInternalParseUtil.getRawString("full_name", jSONObject);
            if (!jSONObject.isNull("bounding_box")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("bounding_box");
                this.boundingBoxType = z_T4JInternalParseUtil.getRawString("type", jSONObject2);
                this.boundingBoxCoordinates = z_T4JInternalJSONImplFactory.coordinatesAsGeoLocationArray(jSONObject2.getJSONArray("coordinates"));
            } else {
                this.boundingBoxType = null;
                this.boundingBoxCoordinates = (GeoLocation[][]) null;
            }
            if (!jSONObject.isNull("geometry")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("geometry");
                this.geometryType = z_T4JInternalParseUtil.getRawString("type", jSONObject3);
                JSONArray jSONArray = jSONObject3.getJSONArray("coordinates");
                if (this.geometryType.equals("Point")) {
                    this.geometryCoordinates = (GeoLocation[][]) Array.newInstance((Class<?>) GeoLocation.class, 1, 1);
                    this.geometryCoordinates[0][0] = new GeoLocation(jSONArray.getDouble(0), jSONArray.getDouble(1));
                } else if (this.geometryType.equals("Polygon")) {
                    this.geometryCoordinates = z_T4JInternalJSONImplFactory.coordinatesAsGeoLocationArray(jSONArray);
                } else {
                    this.geometryType = null;
                    this.geometryCoordinates = (GeoLocation[][]) null;
                }
            } else {
                this.geometryType = null;
                this.geometryCoordinates = (GeoLocation[][]) null;
            }
            if (!jSONObject.isNull("contained_within")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("contained_within");
                this.containedWithIn = new Place[jSONArray2.length()];
                for (int i = 0; i < jSONArray2.length(); i++) {
                    this.containedWithIn[i] = new PlaceJSONImpl(jSONArray2.getJSONObject(i));
                }
                return;
            }
            this.containedWithIn = null;
        } catch (JSONException e) {
            throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(jSONObject.toString()).toString(), e);
        }
    }

    public int compareTo(Place place) {
        return this.f7901id.compareTo(place.getId());
    }

    static ResponseList createPlaceList(HttpResponse httpResponse, Configuration configuration) throws TwitterException, IOException {
        JSONObject jSONObjectAsJSONObject = null;
        try {
            jSONObjectAsJSONObject = httpResponse.asJSONObject();
            return createPlaceList(jSONObjectAsJSONObject.getJSONObject("result").getJSONArray("places"), httpResponse, configuration);
        } catch (JSONException e) {
            throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(jSONObjectAsJSONObject.toString()).toString(), e);
        }
    }

    static ResponseList createPlaceList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IllegalArgumentException, InvocationTargetException {
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
        }
        try {
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                PlaceJSONImpl placeJSONImpl = new PlaceJSONImpl(jSONObject);
                responseListImpl.add(placeJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(placeJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        } catch (TwitterException e2) {
            throw e2;
        }
    }

    @Override // twitter4j.Place
    public String getName() {
        return this.name;
    }

    @Override // twitter4j.Place
    public String getStreetAddress() {
        return this.streetAddress;
    }

    @Override // twitter4j.Place
    public String getCountryCode() {
        return this.countryCode;
    }

    @Override // twitter4j.Place
    public String getId() {
        return this.f7901id;
    }

    @Override // twitter4j.Place
    public String getCountry() {
        return this.country;
    }

    @Override // twitter4j.Place
    public String getPlaceType() {
        return this.placeType;
    }

    @Override // twitter4j.Place
    public String getURL() {
        return this.url;
    }

    @Override // twitter4j.Place
    public String getFullName() {
        return this.fullName;
    }

    @Override // twitter4j.Place
    public String getBoundingBoxType() {
        return this.boundingBoxType;
    }

    @Override // twitter4j.Place
    public GeoLocation[][] getBoundingBoxCoordinates() {
        return this.boundingBoxCoordinates;
    }

    @Override // twitter4j.Place
    public String getGeometryType() {
        return this.geometryType;
    }

    @Override // twitter4j.Place
    public GeoLocation[][] getGeometryCoordinates() {
        return this.geometryCoordinates;
    }

    @Override // twitter4j.Place
    public Place[] getContainedWithIn() {
        return this.containedWithIn;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof Place) && ((Place) obj).getId().equals(this.f7901id);
        }
        return true;
    }

    public int hashCode() {
        return this.f7901id.hashCode();
    }

    public String toString() {
        return new StringBuffer().append("PlaceJSONImpl{name='").append(this.name).append('\'').append(", streetAddress='").append(this.streetAddress).append('\'').append(", countryCode='").append(this.countryCode).append('\'').append(", id='").append(this.f7901id).append('\'').append(", country='").append(this.country).append('\'').append(", placeType='").append(this.placeType).append('\'').append(", url='").append(this.url).append('\'').append(", fullName='").append(this.fullName).append('\'').append(", boundingBoxType='").append(this.boundingBoxType).append('\'').append(", boundingBoxCoordinates=").append(this.boundingBoxCoordinates == null ? null : Arrays.asList(this.boundingBoxCoordinates)).append(", geometryType='").append(this.geometryType).append('\'').append(", geometryCoordinates=").append(this.geometryCoordinates == null ? null : Arrays.asList(this.geometryCoordinates)).append(", containedWithIn=").append(this.containedWithIn != null ? Arrays.asList(this.containedWithIn) : null).append('}').toString();
    }
}
