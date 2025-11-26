package twitter4j.conf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import twitter4j.Version;

/* loaded from: classes.dex */
class ConfigurationBase implements Serializable, Configuration {
    public static final String DALVIK = "twitter4j.dalvik";
    private static final String DEFAULT_OAUTH_ACCESS_TOKEN_URL = "http://api.twitter.com/oauth/access_token";
    private static final String DEFAULT_OAUTH_AUTHENTICATION_URL = "http://api.twitter.com/oauth/authenticate";
    private static final String DEFAULT_OAUTH_AUTHORIZATION_URL = "http://api.twitter.com/oauth/authorize";
    private static final String DEFAULT_OAUTH_REQUEST_TOKEN_URL = "http://api.twitter.com/oauth/request_token";
    private static final String DEFAULT_REST_BASE_URL = "http://api.twitter.com/1/";
    private static final String DEFAULT_SEARCH_BASE_URL = "http://search.twitter.com/";
    private static final String DEFAULT_SITE_STREAM_BASE_URL = "https://sitestream.twitter.com/2b/";
    private static final String DEFAULT_STREAM_BASE_URL = "https://stream.twitter.com/1/";
    private static final String DEFAULT_UPLOAD_BASE_URL = "http://upload.twitter.com/1/";
    private static final String DEFAULT_USER_STREAM_BASE_URL = "https://userstream.twitter.com/2/";
    public static final String GAE = "twitter4j.gae";
    static String dalvikDetected = null;
    static String gaeDetected = null;
    private static final List<ConfigurationBase> instances;
    private static final long serialVersionUID = -6610497517837844232L;
    private boolean IS_DALVIK;
    private boolean IS_GAE;
    private int asyncNumThreads;
    private String clientURL;
    private String clientVersion;
    private boolean debug;
    private int defaultMaxPerRoute;
    private String dispatcherImpl;
    private boolean gzipEnabled;
    private int httpConnectionTimeout;
    private String httpProxyHost;
    private String httpProxyPassword;
    private int httpProxyPort;
    private String httpProxyUser;
    private int httpReadTimeout;
    private int httpRetryCount;
    private int httpRetryIntervalSeconds;
    private int httpStreamingReadTimeout;
    private boolean includeEntitiesEnabled;
    private boolean includeRTsEnabled;
    private boolean jsonStoreEnabled;
    private int maxTotalConnections;
    private boolean mbeanEnabled;
    private String mediaProvider;
    private String mediaProviderAPIKey;
    private Properties mediaProviderParameters;
    private String oAuthAccessToken;
    private String oAuthAccessTokenSecret;
    private String oAuthAccessTokenURL;
    private String oAuthAuthenticationURL;
    private String oAuthAuthorizationURL;
    private String oAuthConsumerKey;
    private String oAuthConsumerSecret;
    private String oAuthRequestTokenURL;
    private String password;
    private boolean prettyDebug;
    Map<String, String> requestHeaders;
    private String restBaseURL;
    private String searchBaseURL;
    private String siteStreamBaseURL;
    private String streamBaseURL;
    private String uploadBaseURL;
    private boolean useSSL;
    private String user;
    private String userAgent;
    private String userStreamBaseURL;
    private boolean userStreamRepliesAllEnabled;

    static {
        try {
            Class.forName("dalvik.system.VMRuntime");
            dalvikDetected = "true";
        } catch (ClassNotFoundException e) {
            dalvikDetected = "false";
        }
        try {
            Class.forName("com.google.appengine.api.urlfetch.URLFetchService");
            gaeDetected = "true";
        } catch (ClassNotFoundException e2) {
            gaeDetected = "false";
        }
        instances = new ArrayList();
    }

    protected ConfigurationBase() {
        String property;
        String property2;
        setDebug(false);
        setUser(null);
        setPassword(null);
        setUseSSL(false);
        setPrettyDebugEnabled(false);
        setGZIPEnabled(true);
        setHttpProxyHost(null);
        setHttpProxyUser(null);
        setHttpProxyPassword(null);
        setHttpProxyPort(-1);
        setHttpConnectionTimeout(20000);
        setHttpReadTimeout(120000);
        setHttpStreamingReadTimeout(40000);
        setHttpRetryCount(0);
        setHttpRetryIntervalSeconds(5);
        setHttpMaxTotalConnections(20);
        setHttpDefaultMaxPerRoute(2);
        setOAuthConsumerKey(null);
        setOAuthConsumerSecret(null);
        setOAuthAccessToken(null);
        setOAuthAccessTokenSecret(null);
        setAsyncNumThreads(1);
        setClientVersion(Version.getVersion());
        setClientURL(new StringBuffer().append("http://twitter4j.org/en/twitter4j-").append(Version.getVersion()).append(".xml").toString());
        setUserAgent(new StringBuffer().append("twitter4j http://twitter4j.org/ /").append(Version.getVersion()).toString());
        setIncludeRTsEnbled(true);
        setIncludeEntitiesEnbled(true);
        setJSONStoreEnabled(false);
        setMBeanEnabled(false);
        setOAuthRequestTokenURL(DEFAULT_OAUTH_REQUEST_TOKEN_URL);
        setOAuthAuthorizationURL(DEFAULT_OAUTH_AUTHORIZATION_URL);
        setOAuthAccessTokenURL(DEFAULT_OAUTH_ACCESS_TOKEN_URL);
        setOAuthAuthenticationURL(DEFAULT_OAUTH_AUTHENTICATION_URL);
        setRestBaseURL(DEFAULT_REST_BASE_URL);
        setSearchBaseURL(DEFAULT_SEARCH_BASE_URL);
        setStreamBaseURL(DEFAULT_STREAM_BASE_URL);
        setUserStreamBaseURL(DEFAULT_USER_STREAM_BASE_URL);
        setSiteStreamBaseURL(DEFAULT_SITE_STREAM_BASE_URL);
        setUploadBaseURL(DEFAULT_UPLOAD_BASE_URL);
        setDispatcherImpl("twitter4j.internal.async.DispatcherImpl");
        setIncludeRTsEnbled(true);
        setUserStreamRepliesAllEnabled(true);
        try {
            property = System.getProperty(DALVIK, dalvikDetected);
        } catch (SecurityException e) {
            property = dalvikDetected;
        }
        this.IS_DALVIK = Boolean.valueOf(property).booleanValue();
        try {
            property2 = System.getProperty(GAE, gaeDetected);
        } catch (SecurityException e2) {
            property2 = gaeDetected;
        }
        this.IS_GAE = Boolean.valueOf(property2).booleanValue();
        setMediaProvider("TWITTER");
        setMediaProviderAPIKey(null);
        setMediaProviderParameters(null);
    }

    @Override // twitter4j.conf.Configuration
    public final boolean isDalvik() {
        return this.IS_DALVIK;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isGAE() {
        return this.IS_GAE;
    }

    @Override // twitter4j.conf.Configuration
    public final boolean isDebugEnabled() {
        return this.debug;
    }

    protected final void setDebug(boolean z) {
        this.debug = z;
    }

    @Override // twitter4j.conf.Configuration
    public final String getUserAgent() {
        return this.userAgent;
    }

    protected final void setUserAgent(String str) {
        this.userAgent = str;
        initRequestHeaders();
    }

    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public final String getUser() {
        return this.user;
    }

    protected final void setUser(String str) {
        this.user = str;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public final String getPassword() {
        return this.password;
    }

    protected final void setPassword(String str) {
        this.password = str;
    }

    @Override // twitter4j.internal.http.HttpClientConfiguration
    public boolean isPrettyDebugEnabled() {
        return this.prettyDebug;
    }

    protected final void setUseSSL(boolean z) {
        this.useSSL = z;
        fixRestBaseURL();
    }

    protected final void setPrettyDebugEnabled(boolean z) {
        this.prettyDebug = z;
    }

    protected final void setGZIPEnabled(boolean z) {
        this.gzipEnabled = z;
        initRequestHeaders();
    }

    @Override // twitter4j.internal.http.HttpClientConfiguration
    public boolean isGZIPEnabled() {
        return this.gzipEnabled;
    }

    private void initRequestHeaders() {
        this.requestHeaders = new HashMap();
        this.requestHeaders.put("X-Twitter-Client-Version", getClientVersion());
        this.requestHeaders.put("X-Twitter-Client-URL", getClientURL());
        this.requestHeaders.put("X-Twitter-Client", "Twitter4J");
        this.requestHeaders.put("User-Agent", getUserAgent());
        if (this.gzipEnabled) {
            this.requestHeaders.put("Accept-Encoding", "gzip");
        }
        if (this.IS_DALVIK) {
            this.requestHeaders.put("Connection", "close");
        }
    }

    @Override // twitter4j.conf.Configuration, twitter4j.internal.http.HttpClientWrapperConfiguration
    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.internal.http.HttpClientConfiguration
    public final String getHttpProxyHost() {
        return this.httpProxyHost;
    }

    protected final void setHttpProxyHost(String str) {
        this.httpProxyHost = str;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.internal.http.HttpClientConfiguration
    public final String getHttpProxyUser() {
        return this.httpProxyUser;
    }

    protected final void setHttpProxyUser(String str) {
        this.httpProxyUser = str;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.internal.http.HttpClientConfiguration
    public final String getHttpProxyPassword() {
        return this.httpProxyPassword;
    }

    protected final void setHttpProxyPassword(String str) {
        this.httpProxyPassword = str;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.internal.http.HttpClientConfiguration
    public final int getHttpProxyPort() {
        return this.httpProxyPort;
    }

    protected final void setHttpProxyPort(int i) {
        this.httpProxyPort = i;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.internal.http.HttpClientConfiguration
    public final int getHttpConnectionTimeout() {
        return this.httpConnectionTimeout;
    }

    protected final void setHttpConnectionTimeout(int i) {
        this.httpConnectionTimeout = i;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.internal.http.HttpClientConfiguration
    public final int getHttpReadTimeout() {
        return this.httpReadTimeout;
    }

    protected final void setHttpReadTimeout(int i) {
        this.httpReadTimeout = i;
    }

    @Override // twitter4j.conf.Configuration
    public int getHttpStreamingReadTimeout() {
        return this.httpStreamingReadTimeout;
    }

    protected final void setHttpStreamingReadTimeout(int i) {
        this.httpStreamingReadTimeout = i;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.internal.http.HttpClientConfiguration
    public final int getHttpRetryCount() {
        return this.httpRetryCount;
    }

    protected final void setHttpRetryCount(int i) {
        this.httpRetryCount = i;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.internal.http.HttpClientConfiguration
    public final int getHttpRetryIntervalSeconds() {
        return this.httpRetryIntervalSeconds;
    }

    protected final void setHttpRetryIntervalSeconds(int i) {
        this.httpRetryIntervalSeconds = i;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.internal.http.HttpClientConfiguration
    public final int getHttpMaxTotalConnections() {
        return this.maxTotalConnections;
    }

    protected final void setHttpMaxTotalConnections(int i) {
        this.maxTotalConnections = i;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.internal.http.HttpClientConfiguration
    public final int getHttpDefaultMaxPerRoute() {
        return this.defaultMaxPerRoute;
    }

    protected final void setHttpDefaultMaxPerRoute(int i) {
        this.defaultMaxPerRoute = i;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public final String getOAuthConsumerKey() {
        return this.oAuthConsumerKey;
    }

    protected final void setOAuthConsumerKey(String str) {
        this.oAuthConsumerKey = str;
        fixRestBaseURL();
    }

    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public final String getOAuthConsumerSecret() {
        return this.oAuthConsumerSecret;
    }

    protected final void setOAuthConsumerSecret(String str) {
        this.oAuthConsumerSecret = str;
        fixRestBaseURL();
    }

    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public String getOAuthAccessToken() {
        return this.oAuthAccessToken;
    }

    protected final void setOAuthAccessToken(String str) {
        this.oAuthAccessToken = str;
    }

    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public String getOAuthAccessTokenSecret() {
        return this.oAuthAccessTokenSecret;
    }

    protected final void setOAuthAccessTokenSecret(String str) {
        this.oAuthAccessTokenSecret = str;
    }

    @Override // twitter4j.conf.Configuration
    public final int getAsyncNumThreads() {
        return this.asyncNumThreads;
    }

    protected final void setAsyncNumThreads(int i) {
        this.asyncNumThreads = i;
    }

    @Override // twitter4j.conf.Configuration
    public final String getClientVersion() {
        return this.clientVersion;
    }

    protected final void setClientVersion(String str) {
        this.clientVersion = str;
        initRequestHeaders();
    }

    @Override // twitter4j.conf.Configuration
    public final String getClientURL() {
        return this.clientURL;
    }

    protected final void setClientURL(String str) {
        this.clientURL = str;
        initRequestHeaders();
    }

    @Override // twitter4j.conf.Configuration
    public String getRestBaseURL() {
        return this.restBaseURL;
    }

    protected final void setRestBaseURL(String str) {
        this.restBaseURL = str;
        fixRestBaseURL();
    }

    private void fixRestBaseURL() {
        if (DEFAULT_REST_BASE_URL.equals(fixURL(false, this.restBaseURL))) {
            this.restBaseURL = fixURL(this.useSSL, this.restBaseURL);
        }
        if (DEFAULT_OAUTH_ACCESS_TOKEN_URL.equals(fixURL(false, this.oAuthAccessTokenURL))) {
            this.oAuthAccessTokenURL = fixURL(this.useSSL, this.oAuthAccessTokenURL);
        }
        if (DEFAULT_OAUTH_AUTHENTICATION_URL.equals(fixURL(false, this.oAuthAuthenticationURL))) {
            this.oAuthAuthenticationURL = fixURL(this.useSSL, this.oAuthAuthenticationURL);
        }
        if (DEFAULT_OAUTH_AUTHORIZATION_URL.equals(fixURL(false, this.oAuthAuthorizationURL))) {
            this.oAuthAuthorizationURL = fixURL(this.useSSL, this.oAuthAuthorizationURL);
        }
        if (DEFAULT_OAUTH_REQUEST_TOKEN_URL.equals(fixURL(false, this.oAuthRequestTokenURL))) {
            this.oAuthRequestTokenURL = fixURL(this.useSSL, this.oAuthRequestTokenURL);
        }
        if (DEFAULT_SEARCH_BASE_URL.equals(fixURL(false, this.searchBaseURL))) {
            this.searchBaseURL = fixURL(this.useSSL, this.searchBaseURL);
        }
    }

    @Override // twitter4j.conf.Configuration
    public String getSearchBaseURL() {
        return this.searchBaseURL;
    }

    protected final void setSearchBaseURL(String str) {
        this.searchBaseURL = str;
    }

    @Override // twitter4j.conf.Configuration
    public String getStreamBaseURL() {
        return this.streamBaseURL;
    }

    protected final void setStreamBaseURL(String str) {
        this.streamBaseURL = str;
    }

    @Override // twitter4j.conf.Configuration
    public String getUserStreamBaseURL() {
        return this.userStreamBaseURL;
    }

    protected final void setUserStreamBaseURL(String str) {
        this.userStreamBaseURL = str;
    }

    @Override // twitter4j.conf.Configuration
    public String getSiteStreamBaseURL() {
        return this.siteStreamBaseURL;
    }

    protected final void setSiteStreamBaseURL(String str) {
        this.siteStreamBaseURL = str;
    }

    @Override // twitter4j.conf.Configuration
    public String getUploadBaseURL() {
        return this.uploadBaseURL;
    }

    protected final void setUploadBaseURL(String str) {
        this.uploadBaseURL = str;
        fixUploadBaseURL();
    }

    private void fixUploadBaseURL() {
        if (DEFAULT_UPLOAD_BASE_URL.equals(fixURL(false, this.uploadBaseURL))) {
            this.uploadBaseURL = fixURL(this.useSSL, this.uploadBaseURL);
        }
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuthRequestTokenURL() {
        return this.oAuthRequestTokenURL;
    }

    protected final void setOAuthRequestTokenURL(String str) {
        this.oAuthRequestTokenURL = str;
        fixRestBaseURL();
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuthAuthorizationURL() {
        return this.oAuthAuthorizationURL;
    }

    protected final void setOAuthAuthorizationURL(String str) {
        this.oAuthAuthorizationURL = str;
        fixRestBaseURL();
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuthAccessTokenURL() {
        return this.oAuthAccessTokenURL;
    }

    protected final void setOAuthAccessTokenURL(String str) {
        this.oAuthAccessTokenURL = str;
        fixRestBaseURL();
    }

    @Override // twitter4j.conf.Configuration
    public String getOAuthAuthenticationURL() {
        return this.oAuthAuthenticationURL;
    }

    protected final void setOAuthAuthenticationURL(String str) {
        this.oAuthAuthenticationURL = str;
        fixRestBaseURL();
    }

    @Override // twitter4j.conf.Configuration
    public String getDispatcherImpl() {
        return this.dispatcherImpl;
    }

    protected final void setDispatcherImpl(String str) {
        this.dispatcherImpl = str;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isIncludeRTsEnabled() {
        return this.includeRTsEnabled;
    }

    protected final void setIncludeRTsEnbled(boolean z) {
        this.includeRTsEnabled = z;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isIncludeEntitiesEnabled() {
        return this.includeEntitiesEnabled;
    }

    protected final void setIncludeEntitiesEnbled(boolean z) {
        this.includeEntitiesEnabled = z;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isJSONStoreEnabled() {
        return this.jsonStoreEnabled;
    }

    protected final void setJSONStoreEnabled(boolean z) {
        this.jsonStoreEnabled = z;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isMBeanEnabled() {
        return this.mbeanEnabled;
    }

    protected final void setMBeanEnabled(boolean z) {
        this.mbeanEnabled = z;
    }

    @Override // twitter4j.conf.Configuration
    public boolean isUserStreamRepliesAllEnabled() {
        return this.userStreamRepliesAllEnabled;
    }

    protected final void setUserStreamRepliesAllEnabled(boolean z) {
        this.userStreamRepliesAllEnabled = z;
    }

    @Override // twitter4j.conf.Configuration
    public String getMediaProvider() {
        return this.mediaProvider;
    }

    protected final void setMediaProvider(String str) {
        this.mediaProvider = str;
    }

    @Override // twitter4j.conf.Configuration
    public String getMediaProviderAPIKey() {
        return this.mediaProviderAPIKey;
    }

    protected final void setMediaProviderAPIKey(String str) {
        this.mediaProviderAPIKey = str;
    }

    @Override // twitter4j.conf.Configuration
    public Properties getMediaProviderParameters() {
        return this.mediaProviderParameters;
    }

    protected final void setMediaProviderParameters(Properties properties) {
        this.mediaProviderParameters = properties;
    }

    static String fixURL(boolean z, String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf("://");
        if (-1 == iIndexOf) {
            throw new IllegalArgumentException("url should contain '://'");
        }
        String strSubstring = str.substring(iIndexOf + 3);
        if (z) {
            return new StringBuffer().append("https://").append(strSubstring).toString();
        }
        return new StringBuffer().append("http://").append(strSubstring).toString();
    }

    public int hashCode() {
        return (((((this.IS_DALVIK ? 1 : 0) + (((this.clientURL != null ? this.clientURL.hashCode() : 0) + (((this.clientVersion != null ? this.clientVersion.hashCode() : 0) + (((this.mediaProviderParameters != null ? this.mediaProviderParameters.hashCode() : 0) + (((this.mediaProviderAPIKey != null ? this.mediaProviderAPIKey.hashCode() : 0) + (((this.mediaProvider != null ? this.mediaProvider.hashCode() : 0) + (((this.userStreamRepliesAllEnabled ? 1 : 0) + (((this.mbeanEnabled ? 1 : 0) + (((this.jsonStoreEnabled ? 1 : 0) + (((this.includeEntitiesEnabled ? 1 : 0) + (((this.includeRTsEnabled ? 1 : 0) + (((((this.dispatcherImpl != null ? this.dispatcherImpl.hashCode() : 0) + (((this.uploadBaseURL != null ? this.uploadBaseURL.hashCode() : 0) + (((this.siteStreamBaseURL != null ? this.siteStreamBaseURL.hashCode() : 0) + (((this.userStreamBaseURL != null ? this.userStreamBaseURL.hashCode() : 0) + (((this.streamBaseURL != null ? this.streamBaseURL.hashCode() : 0) + (((this.searchBaseURL != null ? this.searchBaseURL.hashCode() : 0) + (((this.restBaseURL != null ? this.restBaseURL.hashCode() : 0) + (((this.oAuthAuthenticationURL != null ? this.oAuthAuthenticationURL.hashCode() : 0) + (((this.oAuthAccessTokenURL != null ? this.oAuthAccessTokenURL.hashCode() : 0) + (((this.oAuthAuthorizationURL != null ? this.oAuthAuthorizationURL.hashCode() : 0) + (((this.oAuthRequestTokenURL != null ? this.oAuthRequestTokenURL.hashCode() : 0) + (((this.oAuthAccessTokenSecret != null ? this.oAuthAccessTokenSecret.hashCode() : 0) + (((this.oAuthAccessToken != null ? this.oAuthAccessToken.hashCode() : 0) + (((this.oAuthConsumerSecret != null ? this.oAuthConsumerSecret.hashCode() : 0) + (((this.oAuthConsumerKey != null ? this.oAuthConsumerKey.hashCode() : 0) + (((((((((((((((((((this.httpProxyPassword != null ? this.httpProxyPassword.hashCode() : 0) + (((this.httpProxyUser != null ? this.httpProxyUser.hashCode() : 0) + (((this.httpProxyHost != null ? this.httpProxyHost.hashCode() : 0) + (((this.gzipEnabled ? 1 : 0) + (((this.prettyDebug ? 1 : 0) + (((this.useSSL ? 1 : 0) + (((this.password != null ? this.password.hashCode() : 0) + (((this.user != null ? this.user.hashCode() : 0) + (((this.userAgent != null ? this.userAgent.hashCode() : 0) + ((this.debug ? 1 : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + this.httpProxyPort) * 31) + this.httpConnectionTimeout) * 31) + this.httpReadTimeout) * 31) + this.httpStreamingReadTimeout) * 31) + this.httpRetryCount) * 31) + this.httpRetryIntervalSeconds) * 31) + this.maxTotalConnections) * 31) + this.defaultMaxPerRoute) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + this.asyncNumThreads) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (this.IS_GAE ? 1 : 0)) * 31) + (this.requestHeaders != null ? this.requestHeaders.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigurationBase)) {
            return false;
        }
        ConfigurationBase configurationBase = (ConfigurationBase) obj;
        if (this.asyncNumThreads == configurationBase.asyncNumThreads && this.debug == configurationBase.debug && this.defaultMaxPerRoute == configurationBase.defaultMaxPerRoute && this.gzipEnabled == configurationBase.gzipEnabled && this.httpConnectionTimeout == configurationBase.httpConnectionTimeout && this.httpProxyPort == configurationBase.httpProxyPort && this.httpReadTimeout == configurationBase.httpReadTimeout && this.httpRetryCount == configurationBase.httpRetryCount && this.httpRetryIntervalSeconds == configurationBase.httpRetryIntervalSeconds && this.httpStreamingReadTimeout == configurationBase.httpStreamingReadTimeout && this.includeEntitiesEnabled == configurationBase.includeEntitiesEnabled && this.includeRTsEnabled == configurationBase.includeRTsEnabled && this.jsonStoreEnabled == configurationBase.jsonStoreEnabled && this.maxTotalConnections == configurationBase.maxTotalConnections && this.mbeanEnabled == configurationBase.mbeanEnabled && this.prettyDebug == configurationBase.prettyDebug && this.useSSL == configurationBase.useSSL && this.userStreamRepliesAllEnabled == configurationBase.userStreamRepliesAllEnabled) {
            if (this.clientURL == null ? configurationBase.clientURL != null : !this.clientURL.equals(configurationBase.clientURL)) {
                return false;
            }
            if (this.clientVersion == null ? configurationBase.clientVersion != null : !this.clientVersion.equals(configurationBase.clientVersion)) {
                return false;
            }
            if (this.dispatcherImpl == null ? configurationBase.dispatcherImpl != null : !this.dispatcherImpl.equals(configurationBase.dispatcherImpl)) {
                return false;
            }
            if (this.httpProxyHost == null ? configurationBase.httpProxyHost != null : !this.httpProxyHost.equals(configurationBase.httpProxyHost)) {
                return false;
            }
            if (this.httpProxyPassword == null ? configurationBase.httpProxyPassword != null : !this.httpProxyPassword.equals(configurationBase.httpProxyPassword)) {
                return false;
            }
            if (this.httpProxyUser == null ? configurationBase.httpProxyUser != null : !this.httpProxyUser.equals(configurationBase.httpProxyUser)) {
                return false;
            }
            if (this.mediaProvider == null ? configurationBase.mediaProvider != null : !this.mediaProvider.equals(configurationBase.mediaProvider)) {
                return false;
            }
            if (this.mediaProviderAPIKey == null ? configurationBase.mediaProviderAPIKey != null : !this.mediaProviderAPIKey.equals(configurationBase.mediaProviderAPIKey)) {
                return false;
            }
            if (this.mediaProviderParameters == null ? configurationBase.mediaProviderParameters != null : !this.mediaProviderParameters.equals(configurationBase.mediaProviderParameters)) {
                return false;
            }
            if (this.oAuthAccessToken == null ? configurationBase.oAuthAccessToken != null : !this.oAuthAccessToken.equals(configurationBase.oAuthAccessToken)) {
                return false;
            }
            if (this.oAuthAccessTokenSecret == null ? configurationBase.oAuthAccessTokenSecret != null : !this.oAuthAccessTokenSecret.equals(configurationBase.oAuthAccessTokenSecret)) {
                return false;
            }
            if (this.oAuthAccessTokenURL == null ? configurationBase.oAuthAccessTokenURL != null : !this.oAuthAccessTokenURL.equals(configurationBase.oAuthAccessTokenURL)) {
                return false;
            }
            if (this.oAuthAuthenticationURL == null ? configurationBase.oAuthAuthenticationURL != null : !this.oAuthAuthenticationURL.equals(configurationBase.oAuthAuthenticationURL)) {
                return false;
            }
            if (this.oAuthAuthorizationURL == null ? configurationBase.oAuthAuthorizationURL != null : !this.oAuthAuthorizationURL.equals(configurationBase.oAuthAuthorizationURL)) {
                return false;
            }
            if (this.oAuthConsumerKey == null ? configurationBase.oAuthConsumerKey != null : !this.oAuthConsumerKey.equals(configurationBase.oAuthConsumerKey)) {
                return false;
            }
            if (this.oAuthConsumerSecret == null ? configurationBase.oAuthConsumerSecret != null : !this.oAuthConsumerSecret.equals(configurationBase.oAuthConsumerSecret)) {
                return false;
            }
            if (this.oAuthRequestTokenURL == null ? configurationBase.oAuthRequestTokenURL != null : !this.oAuthRequestTokenURL.equals(configurationBase.oAuthRequestTokenURL)) {
                return false;
            }
            if (this.password == null ? configurationBase.password != null : !this.password.equals(configurationBase.password)) {
                return false;
            }
            if (this.requestHeaders == null ? configurationBase.requestHeaders != null : !this.requestHeaders.equals(configurationBase.requestHeaders)) {
                return false;
            }
            if (this.restBaseURL == null ? configurationBase.restBaseURL != null : !this.restBaseURL.equals(configurationBase.restBaseURL)) {
                return false;
            }
            if (this.searchBaseURL == null ? configurationBase.searchBaseURL != null : !this.searchBaseURL.equals(configurationBase.searchBaseURL)) {
                return false;
            }
            if (this.siteStreamBaseURL == null ? configurationBase.siteStreamBaseURL != null : !this.siteStreamBaseURL.equals(configurationBase.siteStreamBaseURL)) {
                return false;
            }
            if (this.streamBaseURL == null ? configurationBase.streamBaseURL != null : !this.streamBaseURL.equals(configurationBase.streamBaseURL)) {
                return false;
            }
            if (this.uploadBaseURL == null ? configurationBase.uploadBaseURL != null : !this.uploadBaseURL.equals(configurationBase.uploadBaseURL)) {
                return false;
            }
            if (this.user == null ? configurationBase.user != null : !this.user.equals(configurationBase.user)) {
                return false;
            }
            if (this.userAgent == null ? configurationBase.userAgent != null : !this.userAgent.equals(configurationBase.userAgent)) {
                return false;
            }
            if (this.userStreamBaseURL != null) {
                if (this.userStreamBaseURL.equals(configurationBase.userStreamBaseURL)) {
                    return true;
                }
            } else if (configurationBase.userStreamBaseURL == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return new StringBuffer().append("ConfigurationBase{debug=").append(this.debug).append(", userAgent='").append(this.userAgent).append('\'').append(", user='").append(this.user).append('\'').append(", password='").append(this.password).append('\'').append(", useSSL=").append(this.useSSL).append(", prettyDebug=").append(this.prettyDebug).append(", gzipEnabled=").append(this.gzipEnabled).append(", httpProxyHost='").append(this.httpProxyHost).append('\'').append(", httpProxyUser='").append(this.httpProxyUser).append('\'').append(", httpProxyPassword='").append(this.httpProxyPassword).append('\'').append(", httpProxyPort=").append(this.httpProxyPort).append(", httpConnectionTimeout=").append(this.httpConnectionTimeout).append(", httpReadTimeout=").append(this.httpReadTimeout).append(", httpStreamingReadTimeout=").append(this.httpStreamingReadTimeout).append(", httpRetryCount=").append(this.httpRetryCount).append(", httpRetryIntervalSeconds=").append(this.httpRetryIntervalSeconds).append(", maxTotalConnections=").append(this.maxTotalConnections).append(", defaultMaxPerRoute=").append(this.defaultMaxPerRoute).append(", oAuthConsumerKey='").append(this.oAuthConsumerKey).append('\'').append(", oAuthConsumerSecret='").append(this.oAuthConsumerSecret).append('\'').append(", oAuthAccessToken='").append(this.oAuthAccessToken).append('\'').append(", oAuthAccessTokenSecret='").append(this.oAuthAccessTokenSecret).append('\'').append(", oAuthRequestTokenURL='").append(this.oAuthRequestTokenURL).append('\'').append(", oAuthAuthorizationURL='").append(this.oAuthAuthorizationURL).append('\'').append(", oAuthAccessTokenURL='").append(this.oAuthAccessTokenURL).append('\'').append(", oAuthAuthenticationURL='").append(this.oAuthAuthenticationURL).append('\'').append(", restBaseURL='").append(this.restBaseURL).append('\'').append(", searchBaseURL='").append(this.searchBaseURL).append('\'').append(", streamBaseURL='").append(this.streamBaseURL).append('\'').append(", userStreamBaseURL='").append(this.userStreamBaseURL).append('\'').append(", siteStreamBaseURL='").append(this.siteStreamBaseURL).append('\'').append(", uploadBaseURL='").append(this.uploadBaseURL).append('\'').append(", dispatcherImpl='").append(this.dispatcherImpl).append('\'').append(", asyncNumThreads=").append(this.asyncNumThreads).append(", includeRTsEnabled=").append(this.includeRTsEnabled).append(", includeEntitiesEnabled=").append(this.includeEntitiesEnabled).append(", jsonStoreEnabled=").append(this.jsonStoreEnabled).append(", mbeanEnabled=").append(this.mbeanEnabled).append(", userStreamRepliesAllEnabled=").append(this.userStreamRepliesAllEnabled).append(", mediaProvider='").append(this.mediaProvider).append('\'').append(", mediaProviderAPIKey='").append(this.mediaProviderAPIKey).append('\'').append(", mediaProviderParameters=").append(this.mediaProviderParameters).append(", clientVersion='").append(this.clientVersion).append('\'').append(", clientURL='").append(this.clientURL).append('\'').append(", IS_DALVIK=").append(this.IS_DALVIK).append(", IS_GAE=").append(this.IS_GAE).append(", requestHeaders=").append(this.requestHeaders).append('}').toString();
    }

    private static void cacheInstance(ConfigurationBase configurationBase) {
        if (!instances.contains(configurationBase)) {
            instances.add(configurationBase);
        }
    }

    protected void cacheInstance() {
        cacheInstance(this);
    }

    private static ConfigurationBase getInstance(ConfigurationBase configurationBase) {
        int iIndexOf = instances.indexOf(configurationBase);
        if (iIndexOf != -1) {
            return instances.get(iIndexOf);
        }
        instances.add(configurationBase);
        return configurationBase;
    }

    protected Object readResolve() {
        return getInstance(this);
    }
}
