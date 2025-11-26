package twitter4j.auth;

import java.io.Serializable;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;
import twitter4j.internal.http.HttpResponse;

/* loaded from: classes.dex */
public final class RequestToken extends OAuthToken implements Serializable {
    private static final long serialVersionUID = -8214365845469757952L;
    private final Configuration conf;
    private OAuthSupport oauth;

    @Override // twitter4j.auth.OAuthToken
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // twitter4j.auth.OAuthToken
    public String getParameter(String str) {
        return super.getParameter(str);
    }

    @Override // twitter4j.auth.OAuthToken
    public String getToken() {
        return super.getToken();
    }

    @Override // twitter4j.auth.OAuthToken
    public String getTokenSecret() {
        return super.getTokenSecret();
    }

    @Override // twitter4j.auth.OAuthToken
    public int hashCode() {
        return super.hashCode();
    }

    @Override // twitter4j.auth.OAuthToken
    public String toString() {
        return super.toString();
    }

    RequestToken(HttpResponse httpResponse, OAuthSupport oAuthSupport) {
        super(httpResponse);
        this.conf = ConfigurationContext.getInstance();
        this.oauth = oAuthSupport;
    }

    public RequestToken(String str, String str2) {
        super(str, str2);
        this.conf = ConfigurationContext.getInstance();
    }

    RequestToken(String str, String str2, OAuthSupport oAuthSupport) {
        super(str, str2);
        this.conf = ConfigurationContext.getInstance();
        this.oauth = oAuthSupport;
    }

    public String getAuthorizationURL() {
        return new StringBuffer().append(this.conf.getOAuthAuthorizationURL()).append("?oauth_token=").append(getToken()).toString();
    }

    public String getAuthenticationURL() {
        return new StringBuffer().append(this.conf.getOAuthAuthenticationURL()).append("?oauth_token=").append(getToken()).toString();
    }
}
