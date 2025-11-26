package twitter4j.conf;

import java.io.Serializable;
import java.util.Map;
import java.util.Properties;
import twitter4j.auth.AuthorizationConfiguration;
import twitter4j.internal.http.HttpClientConfiguration;
import twitter4j.internal.http.HttpClientWrapperConfiguration;

/* loaded from: classes.dex */
public interface Configuration extends Serializable, AuthorizationConfiguration, HttpClientConfiguration, HttpClientWrapperConfiguration {
    int getAsyncNumThreads();

    String getClientURL();

    String getClientVersion();

    String getDispatcherImpl();

    @Override // twitter4j.internal.http.HttpClientConfiguration
    int getHttpConnectionTimeout();

    @Override // twitter4j.internal.http.HttpClientConfiguration
    int getHttpDefaultMaxPerRoute();

    @Override // twitter4j.internal.http.HttpClientConfiguration
    int getHttpMaxTotalConnections();

    @Override // twitter4j.internal.http.HttpClientConfiguration
    String getHttpProxyHost();

    @Override // twitter4j.internal.http.HttpClientConfiguration
    String getHttpProxyPassword();

    @Override // twitter4j.internal.http.HttpClientConfiguration
    int getHttpProxyPort();

    @Override // twitter4j.internal.http.HttpClientConfiguration
    String getHttpProxyUser();

    @Override // twitter4j.internal.http.HttpClientConfiguration
    int getHttpReadTimeout();

    @Override // twitter4j.internal.http.HttpClientConfiguration
    int getHttpRetryCount();

    @Override // twitter4j.internal.http.HttpClientConfiguration
    int getHttpRetryIntervalSeconds();

    int getHttpStreamingReadTimeout();

    String getMediaProvider();

    String getMediaProviderAPIKey();

    Properties getMediaProviderParameters();

    @Override // twitter4j.auth.AuthorizationConfiguration
    String getOAuthAccessToken();

    @Override // twitter4j.auth.AuthorizationConfiguration
    String getOAuthAccessTokenSecret();

    String getOAuthAccessTokenURL();

    String getOAuthAuthenticationURL();

    String getOAuthAuthorizationURL();

    @Override // twitter4j.auth.AuthorizationConfiguration
    String getOAuthConsumerKey();

    @Override // twitter4j.auth.AuthorizationConfiguration
    String getOAuthConsumerSecret();

    String getOAuthRequestTokenURL();

    @Override // twitter4j.auth.AuthorizationConfiguration
    String getPassword();

    @Override // twitter4j.internal.http.HttpClientWrapperConfiguration
    Map<String, String> getRequestHeaders();

    String getRestBaseURL();

    String getSearchBaseURL();

    String getSiteStreamBaseURL();

    String getStreamBaseURL();

    String getUploadBaseURL();

    @Override // twitter4j.auth.AuthorizationConfiguration
    String getUser();

    String getUserAgent();

    String getUserStreamBaseURL();

    boolean isDalvik();

    boolean isDebugEnabled();

    boolean isGAE();

    boolean isIncludeEntitiesEnabled();

    boolean isIncludeRTsEnabled();

    boolean isJSONStoreEnabled();

    boolean isMBeanEnabled();

    boolean isUserStreamRepliesAllEnabled();
}
