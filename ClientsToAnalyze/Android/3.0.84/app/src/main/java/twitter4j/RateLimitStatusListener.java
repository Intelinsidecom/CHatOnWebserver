package twitter4j;

/* loaded from: classes.dex */
public interface RateLimitStatusListener {
    void onRateLimitReached(RateLimitStatusEvent rateLimitStatusEvent);

    void onRateLimitStatus(RateLimitStatusEvent rateLimitStatusEvent);
}
