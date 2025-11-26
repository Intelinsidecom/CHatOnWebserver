package twitter4j;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public interface SavedSearch extends Serializable, Comparable, TwitterResponse {
    Date getCreatedAt();

    int getId();

    String getName();

    int getPosition();

    String getQuery();
}
