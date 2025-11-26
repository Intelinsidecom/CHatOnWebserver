package twitter4j.auth;

/* loaded from: classes.dex */
public interface OAuthSupport {
    AccessToken getOAuthAccessToken();

    AccessToken getOAuthAccessToken(String str);

    AccessToken getOAuthAccessToken(String str, String str2);

    AccessToken getOAuthAccessToken(RequestToken requestToken);

    AccessToken getOAuthAccessToken(RequestToken requestToken, String str);

    RequestToken getOAuthRequestToken();

    RequestToken getOAuthRequestToken(String str);

    RequestToken getOAuthRequestToken(String str, String str2);

    void setOAuthAccessToken(AccessToken accessToken);

    void setOAuthConsumer(String str, String str2);
}
