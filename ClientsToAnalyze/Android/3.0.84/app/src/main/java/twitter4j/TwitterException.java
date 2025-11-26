package twitter4j;

import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.http.HttpResponseCode;
import twitter4j.internal.json.z_T4JInternalJSONImplFactory;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
public class TwitterException extends Exception implements TwitterResponse, HttpResponseCode {
    private static final String[] FILTER = {"twitter4j"};
    private static final long serialVersionUID = -2623309261327598087L;
    private String errorMessage;
    private ExceptionDiagnosis exceptionDiagnosis;
    boolean nested;
    private String requestPath;
    private HttpResponse response;
    private int statusCode;

    public TwitterException(String str, Throwable th) {
        super(str, th);
        this.statusCode = -1;
        this.exceptionDiagnosis = null;
        this.errorMessage = null;
        this.requestPath = null;
        this.nested = false;
        decode(str);
    }

    public TwitterException(String str) {
        this(str, (Throwable) null);
    }

    public TwitterException(Exception exc) {
        this(exc.getMessage(), exc);
        if (exc instanceof TwitterException) {
            ((TwitterException) exc).setNested();
        }
    }

    public TwitterException(String str, HttpResponse httpResponse) {
        this(str);
        this.response = httpResponse;
        this.statusCode = httpResponse.getStatusCode();
    }

    public TwitterException(String str, Exception exc, int i) {
        this(str, exc);
        this.statusCode = i;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.errorMessage != null && this.requestPath != null) {
            stringBuffer.append("error - ").append(this.errorMessage).append("\n");
            stringBuffer.append("request - ").append(this.requestPath).append("\n");
        } else {
            stringBuffer.append(super.getMessage());
        }
        if (this.statusCode != -1) {
            return new StringBuffer().append(getCause(this.statusCode)).append("\n").append(stringBuffer.toString()).toString();
        }
        return stringBuffer.toString();
    }

    private void decode(String str) {
        if (str != null && str.startsWith("{")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("error")) {
                    this.errorMessage = jSONObject.getString("error");
                }
                if (!jSONObject.isNull("request")) {
                    this.requestPath = jSONObject.getString("request");
                }
            } catch (JSONException e) {
            }
        }
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getResponseHeader(String str) {
        if (this.response != null) {
            List<String> list = this.response.getResponseHeaderFields().get(str);
            if (list.size() > 0) {
                return list.get(0);
            }
        }
        return null;
    }

    @Override // twitter4j.TwitterResponse
    public RateLimitStatus getRateLimitStatus() {
        if (this.response == null) {
            return null;
        }
        return z_T4JInternalJSONImplFactory.createRateLimitStatusFromResponseHeader(this.response);
    }

    @Override // twitter4j.TwitterResponse
    public int getAccessLevel() {
        return z_T4JInternalParseUtil.toAccessLevel(this.response);
    }

    public RateLimitStatus getFeatureSpecificRateLimitStatus() {
        if (this.response == null) {
            return null;
        }
        return z_T4JInternalJSONImplFactory.createFeatureSpecificRateLimitStatusFromResponseHeader(this.response);
    }

    public int getRetryAfter() {
        if (this.statusCode == 400) {
            RateLimitStatus rateLimitStatus = getRateLimitStatus();
            if (rateLimitStatus == null) {
                return -1;
            }
            return rateLimitStatus.getSecondsUntilReset();
        }
        if (this.statusCode != 420) {
            return -1;
        }
        try {
            String responseHeader = this.response.getResponseHeader("Retry-After");
            if (responseHeader == null) {
                return -1;
            }
            return Integer.valueOf(responseHeader).intValue();
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public boolean isCausedByNetworkIssue() {
        return getCause() instanceof IOException;
    }

    public boolean exceededRateLimitation() {
        return (this.statusCode == 400 && getRateLimitStatus() != null) || this.statusCode == 420;
    }

    public boolean resourceNotFound() {
        return this.statusCode == 404;
    }

    public String getExceptionCode() {
        return getExceptionDiagnosis().asHexString();
    }

    private ExceptionDiagnosis getExceptionDiagnosis() {
        if (this.exceptionDiagnosis == null) {
            this.exceptionDiagnosis = new ExceptionDiagnosis(this, FILTER);
        }
        return this.exceptionDiagnosis;
    }

    void setNested() {
        this.nested = true;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getRequestPath() {
        return this.requestPath;
    }

    public boolean isErrorMessageAvailable() {
        return this.errorMessage != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TwitterException)) {
            return false;
        }
        TwitterException twitterException = (TwitterException) obj;
        if (this.nested == twitterException.nested && this.statusCode == twitterException.statusCode) {
            if (this.errorMessage == null ? twitterException.errorMessage != null : !this.errorMessage.equals(twitterException.errorMessage)) {
                return false;
            }
            if (this.exceptionDiagnosis == null ? twitterException.exceptionDiagnosis != null : !this.exceptionDiagnosis.equals(twitterException.exceptionDiagnosis)) {
                return false;
            }
            if (this.requestPath == null ? twitterException.requestPath != null : !this.requestPath.equals(twitterException.requestPath)) {
                return false;
            }
            if (this.response != null) {
                if (this.response.equals(twitterException.response)) {
                    return true;
                }
            } else if (twitterException.response == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.requestPath != null ? this.requestPath.hashCode() : 0) + (((this.errorMessage != null ? this.errorMessage.hashCode() : 0) + (((this.response != null ? this.response.hashCode() : 0) + (((this.exceptionDiagnosis != null ? this.exceptionDiagnosis.hashCode() : 0) + (this.statusCode * 31)) * 31)) * 31)) * 31)) * 31) + (this.nested ? 1 : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return new StringBuffer().append(getMessage()).append(this.nested ? "" : new StringBuffer().append("Relevant discussions can be on the Internet at:\n\thttp://www.google.co.jp/search?q=").append(getExceptionDiagnosis().getStackLineHashAsHex()).append(" or\n\thttp://www.google.co.jp/search?q=").append(getExceptionDiagnosis().getLineNumberHashAsHex()).toString()).append("\nTwitterException{").append(this.nested ? "" : new StringBuffer().append("exceptionCode=[").append(getExceptionCode()).append("], ").toString()).append("statusCode=").append(this.statusCode).append(", retryAfter=").append(getRetryAfter()).append(", rateLimitStatus=").append(getRateLimitStatus()).append(", featureSpecificRateLimitStatus=").append(getFeatureSpecificRateLimitStatus()).append(", version=").append(Version.getVersion()).append('}').toString();
    }

    private static String getCause(int i) {
        String str;
        switch (i) {
            case HttpResponseCode.NOT_MODIFIED /* 304 */:
                str = "There was no new data to return.";
                break;
            case 400:
                str = "The request was invalid. An accompanying error message will explain why. This is the status code will be returned during rate limiting (https://dev.twitter.com/pages/rate-limiting).";
                break;
            case HttpResponseCode.UNAUTHORIZED /* 401 */:
                str = "Authentication credentials (https://dev.twitter.com/docs/auth) were missing or incorrect. Ensure that you have set valid conumer key/secret, access token/secret, and the system clock in in sync.";
                break;
            case HttpResponseCode.FORBIDDEN /* 403 */:
                str = "The request is understood, but it has been refused. An accompanying error message will explain why. This code is used when requests are being denied due to update limits (https://support.twitter.com/articles/15364-about-twitter-limits-update-api-dm-and-following).";
                break;
            case HttpResponseCode.NOT_FOUND /* 404 */:
                str = "The URI requested is invalid or the resource requested, such as a user, does not exist.";
                break;
            case HttpResponseCode.NOT_ACCEPTABLE /* 406 */:
                str = "Returned by the Search API when an invalid format is specified in the request.\nReturned by the Streaming API when one or more of the parameters are not suitable for the resource. The track parameter, for example, would throw this error if:\n The track keyword is too long or too short.\n The bounding box specified is invalid.\n No predicates defined for filtered resource, for example, neither track nor follow parameter defined.\n Follow userid cannot be read.";
                break;
            case HttpResponseCode.TOO_LONG /* 413 */:
                str = "A parameter list is too long. The track parameter, for example, would throw this error if:\n Too many track tokens specified for role; contact API team for increased access.\n Too many bounding boxes specified for role; contact API team for increased access.\n Too many follow userids specified for role; contact API team for increased access.";
                break;
            case HttpResponseCode.ENHANCE_YOUR_CLAIM /* 420 */:
                str = "Returned by the Search and Trends API when you are being rate limited (https://dev.twitter.com/docs/rate-limiting).\nReturned by the Streaming API:\n Too many login attempts in a short period of time.\n Running too many copies of the same application authenticating with the same account name.";
                break;
            case HttpResponseCode.INTERNAL_SERVER_ERROR /* 500 */:
                str = "Something is broken. Please post to the group (https://dev.twitter.com/docs/support) so the Twitter team can investigate.";
                break;
            case HttpResponseCode.BAD_GATEWAY /* 502 */:
                str = "Twitter is down or being upgraded.";
                break;
            case HttpResponseCode.SERVICE_UNAVAILABLE /* 503 */:
                str = "The Twitter servers are up, but overloaded with requests. Try again later.";
                break;
            default:
                str = "";
                break;
        }
        return new StringBuffer().append(i).append(":").append(str).toString();
    }
}
