package twitter4j;

import java.io.Serializable;
import java.util.Map;
import twitter4j.MediaEntity;

/* loaded from: classes.dex */
public interface TwitterAPIConfiguration extends Serializable, TwitterResponse {
    int getCharactersReservedPerMedia();

    int getMaxMediaPerUpload();

    String[] getNonUsernamePaths();

    int getPhotoSizeLimit();

    Map<Integer, MediaEntity.Size> getPhotoSizes();

    int getShortURLLength();

    int getShortURLLengthHttps();
}
