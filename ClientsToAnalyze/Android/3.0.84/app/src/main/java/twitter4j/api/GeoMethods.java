package twitter4j.api;

import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.SimilarPlaces;

/* loaded from: classes.dex */
public interface GeoMethods {
    Place createPlace(String str, String str2, String str3, GeoLocation geoLocation, String str4);

    Place getGeoDetails(String str);

    SimilarPlaces getSimilarPlaces(GeoLocation geoLocation, String str, String str2, String str3);

    ResponseList<Place> reverseGeoCode(GeoQuery geoQuery);

    ResponseList<Place> searchPlaces(GeoQuery geoQuery);
}
