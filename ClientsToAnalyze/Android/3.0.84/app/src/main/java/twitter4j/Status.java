package twitter4j;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public interface Status extends Serializable, Comparable<Status>, EntitySupport, TwitterResponse {
    Annotations getAnnotations();

    long[] getContributors();

    Date getCreatedAt();

    GeoLocation getGeoLocation();

    long getId();

    String getInReplyToScreenName();

    long getInReplyToStatusId();

    long getInReplyToUserId();

    Place getPlace();

    long getRetweetCount();

    Status getRetweetedStatus();

    String getSource();

    String getText();

    User getUser();

    boolean isFavorited();

    boolean isRetweet();

    boolean isRetweetedByMe();

    boolean isTruncated();
}
