package twitter4j;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public interface Trends extends Serializable, Comparable, TwitterResponse {
    Date getAsOf();

    Location getLocation();

    Date getTrendAt();

    Trend[] getTrends();
}
