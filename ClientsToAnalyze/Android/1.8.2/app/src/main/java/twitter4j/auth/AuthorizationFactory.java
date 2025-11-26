package twitter4j.auth;

import twitter4j.conf.Configuration;

/* loaded from: classes.dex */
public final class AuthorizationFactory {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [twitter4j.auth.OAuthAuthorization] */
    public static Authorization getInstance(Configuration configuration) {
        BasicAuthorization basicAuthorization = null;
        basicAuthorization = null;
        String oAuthConsumerKey = configuration.getOAuthConsumerKey();
        String oAuthConsumerSecret = configuration.getOAuthConsumerSecret();
        if (oAuthConsumerKey != null && oAuthConsumerSecret != null) {
            ?? oAuthAuthorization = new OAuthAuthorization(configuration);
            String oAuthAccessToken = configuration.getOAuthAccessToken();
            String oAuthAccessTokenSecret = configuration.getOAuthAccessTokenSecret();
            basicAuthorization = oAuthAuthorization;
            basicAuthorization = oAuthAuthorization;
            if (oAuthAccessToken != null && oAuthAccessTokenSecret != null) {
                oAuthAuthorization.setOAuthAccessToken(new AccessToken(oAuthAccessToken, oAuthAccessTokenSecret));
                basicAuthorization = oAuthAuthorization;
            }
        } else {
            String user = configuration.getUser();
            String password = configuration.getPassword();
            if (user != null && password != null) {
                basicAuthorization = new BasicAuthorization(user, password);
            }
        }
        if (basicAuthorization == null) {
            return NullAuthorization.getInstance();
        }
        return basicAuthorization;
    }
}
