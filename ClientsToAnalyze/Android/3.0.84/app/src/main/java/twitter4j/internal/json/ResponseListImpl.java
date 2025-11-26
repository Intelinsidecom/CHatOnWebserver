package twitter4j.internal.json;

import java.util.ArrayList;
import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
class ResponseListImpl<T> extends ArrayList<T> implements ResponseList<T> {
    private static final long serialVersionUID = 5646617841989265312L;
    private transient int accessLevel;
    private transient RateLimitStatus featureSpecificRateLimitStatus;
    private transient RateLimitStatus rateLimitStatus;

    ResponseListImpl(HttpResponse httpResponse) {
        this.rateLimitStatus = null;
        this.featureSpecificRateLimitStatus = null;
        init(httpResponse);
    }

    ResponseListImpl(int i, HttpResponse httpResponse) {
        super(i);
        this.rateLimitStatus = null;
        this.featureSpecificRateLimitStatus = null;
        init(httpResponse);
    }

    ResponseListImpl(RateLimitStatus rateLimitStatus, RateLimitStatus rateLimitStatus2, int i) {
        this.rateLimitStatus = null;
        this.featureSpecificRateLimitStatus = null;
        this.rateLimitStatus = rateLimitStatus;
        this.featureSpecificRateLimitStatus = rateLimitStatus2;
        this.accessLevel = i;
    }

    private void init(HttpResponse httpResponse) {
        this.rateLimitStatus = RateLimitStatusJSONImpl.createFromResponseHeader(httpResponse);
        this.featureSpecificRateLimitStatus = RateLimitStatusJSONImpl.createFeatureSpecificRateLimitStatusFromResponseHeader(httpResponse);
        this.accessLevel = z_T4JInternalParseUtil.toAccessLevel(httpResponse);
    }

    @Override // twitter4j.ResponseList, twitter4j.TwitterResponse
    public RateLimitStatus getRateLimitStatus() {
        return this.rateLimitStatus;
    }

    @Override // twitter4j.ResponseList
    public RateLimitStatus getFeatureSpecificRateLimitStatus() {
        return this.featureSpecificRateLimitStatus;
    }

    @Override // twitter4j.TwitterResponse
    public int getAccessLevel() {
        return this.accessLevel;
    }
}
