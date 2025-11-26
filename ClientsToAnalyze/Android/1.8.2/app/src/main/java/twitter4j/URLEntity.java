package twitter4j;

import java.io.Serializable;
import java.net.URL;

/* loaded from: classes.dex */
public interface URLEntity extends Serializable {
    String getDisplayURL();

    int getEnd();

    URL getExpandedURL();

    int getStart();

    URL getURL();
}
