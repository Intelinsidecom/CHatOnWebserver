package twitter4j;

import java.util.EventObject;

/* loaded from: classes.dex */
public final class RateLimitStatusEvent extends EventObject {
    private static final long serialVersionUID = -2332507741769177298L;
    private boolean isAccountRateLimitStatus;
    private RateLimitStatus rateLimitStatus;

    RateLimitStatusEvent(Object obj, RateLimitStatus rateLimitStatus, boolean z) {
        super(obj);
        this.rateLimitStatus = rateLimitStatus;
        this.isAccountRateLimitStatus = z;
    }

    public RateLimitStatus getRateLimitStatus() {
        return this.rateLimitStatus;
    }

    public boolean isAccountRateLimitStatus() {
        return this.isAccountRateLimitStatus;
    }

    public boolean isIPRateLimitStatus() {
        return !this.isAccountRateLimitStatus;
    }
}
