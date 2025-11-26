package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface TimeZone extends Serializable {
    String getName();

    String tzinfoName();

    int utcOffset();
}
