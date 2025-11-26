package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface Location extends Serializable {
    String getCountryCode();

    String getCountryName();

    String getName();

    int getPlaceCode();

    String getPlaceName();

    String getURL();

    int getWoeid();
}
