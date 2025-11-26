package twitter4j.internal.http;

import twitter4j.TwitterException;

/* loaded from: classes.dex */
public final class HttpResponseEvent {
    private HttpRequest request;
    private HttpResponse response;
    private TwitterException twitterException;

    HttpResponseEvent(HttpRequest httpRequest, HttpResponse httpResponse, TwitterException twitterException) {
        this.request = httpRequest;
        this.response = httpResponse;
        this.twitterException = twitterException;
    }

    public HttpRequest getRequest() {
        return this.request;
    }

    public HttpResponse getResponse() {
        return this.response;
    }

    public TwitterException getTwitterException() {
        return this.twitterException;
    }

    public boolean isAuthenticated() {
        return this.request.getAuthorization().isEnabled();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpResponseEvent httpResponseEvent = (HttpResponseEvent) obj;
        if (this.request == null ? httpResponseEvent.request != null : !this.request.equals(httpResponseEvent.request)) {
            return false;
        }
        if (this.response != null) {
            if (this.response.equals(httpResponseEvent.response)) {
                return true;
            }
        } else if (httpResponseEvent.response == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.request != null ? this.request.hashCode() : 0) * 31) + (this.response != null ? this.response.hashCode() : 0);
    }

    public String toString() {
        return new StringBuffer().append("HttpResponseEvent{request=").append(this.request).append(", response=").append(this.response).append('}').toString();
    }
}
