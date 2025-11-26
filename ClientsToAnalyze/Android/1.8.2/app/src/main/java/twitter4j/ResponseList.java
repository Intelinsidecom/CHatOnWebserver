package twitter4j;

import java.util.List;

/* loaded from: classes.dex */
public interface ResponseList extends List, TwitterResponse {
    RateLimitStatus getFeatureSpecificRateLimitStatus();

    @Override // twitter4j.TwitterResponse
    RateLimitStatus getRateLimitStatus();
}
