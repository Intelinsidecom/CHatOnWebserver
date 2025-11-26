package twitter4j;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public interface RateLimitStatus extends Serializable {
    int getHourlyLimit();

    int getRemainingHits();

    Date getResetTime();

    int getResetTimeInSeconds();

    int getSecondsUntilReset();
}
