package twitter4j;

import java.util.List;

/* loaded from: classes.dex */
public interface ResponseList<T> extends List<T>, TwitterResponse {
    RateLimitStatus getFeatureSpecificRateLimitStatus();

    @Override // twitter4j.TwitterResponse
    RateLimitStatus getRateLimitStatus();
}
