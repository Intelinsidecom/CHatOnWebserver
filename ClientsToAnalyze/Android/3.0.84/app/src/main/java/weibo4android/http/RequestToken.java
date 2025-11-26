package weibo4android.http;

/* loaded from: classes.dex */
public class RequestToken extends OAuthToken {
    private static final long serialVersionUID = -8214365845469757952L;
    private HttpClient httpClient;

    @Override // weibo4android.http.OAuthToken
    public /* bridge */ /* synthetic */ String getParameter(String str) {
        return super.getParameter(str);
    }

    @Override // weibo4android.http.OAuthToken
    public /* bridge */ /* synthetic */ String getToken() {
        return super.getToken();
    }

    @Override // weibo4android.http.OAuthToken
    public /* bridge */ /* synthetic */ String getTokenSecret() {
        return super.getTokenSecret();
    }

    @Override // weibo4android.http.OAuthToken
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    RequestToken(Response response, HttpClient httpClient) {
        super(response);
        this.httpClient = httpClient;
    }

    RequestToken(String str, String str2) {
        super(str, str2);
    }

    public String getAuthorizationURL() {
        return this.httpClient.getAuthorizationURL() + "?oauth_token=" + getToken();
    }

    public String getAuthenticationURL() {
        return this.httpClient.getAuthenticationRL() + "?oauth_token=" + getToken();
    }

    public AccessToken getAccessToken(String str) {
        return this.httpClient.getOAuthAccessToken(this, str);
    }

    @Override // weibo4android.http.OAuthToken
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        RequestToken requestToken = (RequestToken) obj;
        if (this.httpClient != null) {
            if (this.httpClient.equals(requestToken.httpClient)) {
                return true;
            }
        } else if (requestToken.httpClient == null) {
            return true;
        }
        return false;
    }

    @Override // weibo4android.http.OAuthToken
    public int hashCode() {
        return (this.httpClient != null ? this.httpClient.hashCode() : 0) + (super.hashCode() * 31);
    }
}
