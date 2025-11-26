package twitter4j.internal.json;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import org.json.JSONObject;
import twitter4j.RateLimitStatus;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class RateLimitStatusJSONImpl implements Serializable, RateLimitStatus {
    private static final long serialVersionUID = 832355052293658614L;
    private int hourlyLimit;
    private int remainingHits;
    private Date resetTime;
    private int resetTimeInSeconds;
    private int secondsUntilReset;

    private RateLimitStatusJSONImpl(int i, int i2, int i3, Date date) {
        this.hourlyLimit = i;
        this.remainingHits = i2;
        this.resetTime = date;
        this.resetTimeInSeconds = i3;
        this.secondsUntilReset = (int) ((date.getTime() - System.currentTimeMillis()) / 1000);
    }

    RateLimitStatusJSONImpl(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        init(jSONObjectAsJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, jSONObjectAsJSONObject);
        }
    }

    RateLimitStatusJSONImpl(JSONObject jSONObject) {
        init(jSONObject);
    }

    void init(JSONObject jSONObject) {
        this.hourlyLimit = z_T4JInternalParseUtil.getInt("hourly_limit", jSONObject);
        this.remainingHits = z_T4JInternalParseUtil.getInt("remaining_hits", jSONObject);
        this.resetTime = z_T4JInternalParseUtil.getDate("reset_time", jSONObject, "EEE MMM d HH:mm:ss Z yyyy");
        this.resetTimeInSeconds = z_T4JInternalParseUtil.getInt("reset_time_in_seconds", jSONObject);
        this.secondsUntilReset = (int) ((this.resetTime.getTime() - System.currentTimeMillis()) / 1000);
    }

    static RateLimitStatus createFromResponseHeader(HttpResponse httpResponse) throws NumberFormatException {
        String responseHeader;
        if (httpResponse == null || (responseHeader = httpResponse.getResponseHeader("X-RateLimit-Limit")) == null) {
            return null;
        }
        int i = Integer.parseInt(responseHeader);
        String responseHeader2 = httpResponse.getResponseHeader("X-RateLimit-Remaining");
        if (responseHeader2 == null) {
            return null;
        }
        int i2 = Integer.parseInt(responseHeader2);
        String responseHeader3 = httpResponse.getResponseHeader("X-RateLimit-Reset");
        if (responseHeader3 == null) {
            return null;
        }
        long j = Long.parseLong(responseHeader3);
        return new RateLimitStatusJSONImpl(i, i2, (int) (j / 1000), new Date(j * 1000));
    }

    static RateLimitStatus createFeatureSpecificRateLimitStatusFromResponseHeader(HttpResponse httpResponse) throws NumberFormatException {
        String responseHeader;
        if (httpResponse == null || (responseHeader = httpResponse.getResponseHeader("X-FeatureRateLimit-Limit")) == null) {
            return null;
        }
        int i = Integer.parseInt(responseHeader);
        String responseHeader2 = httpResponse.getResponseHeader("X-FeatureRateLimit-Remaining");
        if (responseHeader2 == null) {
            return null;
        }
        int i2 = Integer.parseInt(responseHeader2);
        String responseHeader3 = httpResponse.getResponseHeader("X-FeatureRateLimit-Reset");
        if (responseHeader3 == null) {
            return null;
        }
        long j = Long.parseLong(responseHeader3);
        return new RateLimitStatusJSONImpl(i, i2, (int) (j / 1000), new Date(j * 1000));
    }

    @Override // twitter4j.RateLimitStatus
    public int getRemainingHits() {
        return this.remainingHits;
    }

    @Override // twitter4j.RateLimitStatus
    public int getHourlyLimit() {
        return this.hourlyLimit;
    }

    @Override // twitter4j.RateLimitStatus
    public int getResetTimeInSeconds() {
        return this.resetTimeInSeconds;
    }

    @Override // twitter4j.RateLimitStatus
    public int getSecondsUntilReset() {
        return this.secondsUntilReset;
    }

    @Override // twitter4j.RateLimitStatus
    public Date getResetTime() {
        return this.resetTime;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RateLimitStatusJSONImpl)) {
            return false;
        }
        RateLimitStatusJSONImpl rateLimitStatusJSONImpl = (RateLimitStatusJSONImpl) obj;
        if (this.hourlyLimit == rateLimitStatusJSONImpl.hourlyLimit && this.remainingHits == rateLimitStatusJSONImpl.remainingHits && this.resetTimeInSeconds == rateLimitStatusJSONImpl.resetTimeInSeconds && this.secondsUntilReset == rateLimitStatusJSONImpl.secondsUntilReset) {
            if (this.resetTime != null) {
                if (this.resetTime.equals(rateLimitStatusJSONImpl.resetTime)) {
                    return true;
                }
            } else if (rateLimitStatusJSONImpl.resetTime == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.resetTime != null ? this.resetTime.hashCode() : 0) + (((((((this.remainingHits * 31) + this.hourlyLimit) * 31) + this.resetTimeInSeconds) * 31) + this.secondsUntilReset) * 31);
    }

    public String toString() {
        return new StringBuffer().append("RateLimitStatusJSONImpl{remainingHits=").append(this.remainingHits).append(", hourlyLimit=").append(this.hourlyLimit).append(", resetTimeInSeconds=").append(this.resetTimeInSeconds).append(", secondsUntilReset=").append(this.secondsUntilReset).append(", resetTime=").append(this.resetTime).append('}').toString();
    }
}
