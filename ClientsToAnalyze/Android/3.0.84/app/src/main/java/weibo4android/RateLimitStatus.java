package weibo4android;

import java.util.Date;
import org.w3c.dom.Element;
import weibo4android.http.Response;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class RateLimitStatus extends WeiboResponse {
    private static final long serialVersionUID = 933996804168952707L;
    private int hourlyLimit;
    private int remainingHits;
    private Date resetTime;
    private int resetTimeInSeconds;

    RateLimitStatus(Response response) {
        super(response);
        Element documentElement = response.asDocument().getDocumentElement();
        this.remainingHits = getChildInt("remaining-hits", documentElement);
        this.hourlyLimit = getChildInt("hourly-limit", documentElement);
        this.resetTimeInSeconds = getChildInt("reset-time-in-seconds", documentElement);
        this.resetTime = getChildDate("reset-time", documentElement, "EEE MMM d HH:mm:ss z yyyy");
    }

    RateLimitStatus(Response response, Weibo weibo) throws WeiboException {
        super(response);
        JSONObject jSONObjectAsJSONObject = response.asJSONObject();
        try {
            this.remainingHits = jSONObjectAsJSONObject.getInt("remaining_hits");
            this.hourlyLimit = jSONObjectAsJSONObject.getInt("hourly_limit");
            this.resetTimeInSeconds = jSONObjectAsJSONObject.getInt("reset_time_in_seconds");
            this.resetTime = parseDate(jSONObjectAsJSONObject.getString("reset_time"), "EEE MMM dd HH:mm:ss z yyyy");
        } catch (JSONException e) {
            throw new WeiboException(e.getMessage() + ":" + jSONObjectAsJSONObject.toString(), e);
        }
    }

    public int getRemainingHits() {
        return this.remainingHits;
    }

    public int getHourlyLimit() {
        return this.hourlyLimit;
    }

    public int getResetTimeInSeconds() {
        return this.resetTimeInSeconds;
    }

    @Deprecated
    public Date getDateTime() {
        return this.resetTime;
    }

    public Date getResetTime() {
        return this.resetTime;
    }

    public String toString() {
        return "RateLimitStatus{remainingHits:" + this.remainingHits + ";hourlyLimit:" + this.hourlyLimit + ";resetTimeInSeconds:" + this.resetTimeInSeconds + ";resetTime:" + this.resetTime + "}";
    }
}
