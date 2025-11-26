package twitter4j;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public interface Tweet extends Serializable, Comparable<Tweet>, EntitySupport {
    Annotations getAnnotations();

    Date getCreatedAt();

    String getFromUser();

    long getFromUserId();

    GeoLocation getGeoLocation();

    long getId();

    String getIsoLanguageCode();

    String getLocation();

    Place getPlace();

    String getProfileImageUrl();

    String getSource();

    String getText();

    String getToUser();

    long getToUserId();
}
