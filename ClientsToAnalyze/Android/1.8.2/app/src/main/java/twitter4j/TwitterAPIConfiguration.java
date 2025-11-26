package twitter4j;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes.dex */
public interface TwitterAPIConfiguration extends Serializable, TwitterResponse {
    int getCharactersReservedPerMedia();

    int getMaxMediaPerUpload();

    String[] getNonUsernamePaths();

    int getPhotoSizeLimit();

    Map getPhotoSizes();

    int getShortURLLength();

    int getShortURLLengthHttps();
}
