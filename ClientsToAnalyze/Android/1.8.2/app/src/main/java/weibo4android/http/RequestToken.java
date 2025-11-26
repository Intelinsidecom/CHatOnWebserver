package weibo4android.http;

/* loaded from: classes.dex */
public class RequestToken extends OAuthToken {
    private static final long serialVersionUID = -8214365845469757952L;
    private HttpClient httpClient;

    RequestToken(Response response, HttpClient httpClient) {
        super(response);
        this.httpClient = httpClient;
    }

    RequestToken(String str, String str2) {
        super(str, str2);
    }

    public String getAuthorizationURL() {
        return String.valueOf(this.httpClient.getAuthorizationURL()) + "?oauth_token=" + getToken();
    }

    public String getAuthenticationURL() {
        return String.valueOf(this.httpClient.getAuthenticationRL()) + "?oauth_token=" + getToken();
    }

    public AccessToken getAccessToken(String str) {
        return this.httpClient.getOAuthAccessToken(this, str);
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
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
