package twitter4j.api;

import twitter4j.GeoLocation;
import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trends;

/* loaded from: classes.dex */
public interface LocalTrendsMethods {
    ResponseList<Location> getAvailableTrends();

    ResponseList<Location> getAvailableTrends(GeoLocation geoLocation);

    Trends getLocationTrends(int i);
}
