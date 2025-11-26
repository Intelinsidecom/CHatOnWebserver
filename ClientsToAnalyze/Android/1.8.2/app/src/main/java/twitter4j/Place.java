package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface Place extends Serializable, Comparable, TwitterResponse {
    GeoLocation[][] getBoundingBoxCoordinates();

    String getBoundingBoxType();

    Place[] getContainedWithIn();

    String getCountry();

    String getCountryCode();

    String getFullName();

    GeoLocation[][] getGeometryCoordinates();

    String getGeometryType();

    String getId();

    String getName();

    String getPlaceType();

    String getStreetAddress();

    String getURL();
}
