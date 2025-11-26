package twitter4j.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import twitter4j.internal.util.z_T4JInternalStringUtil;

/* loaded from: classes.dex */
public final class PropertyConfiguration extends ConfigurationBase implements Serializable {
    public static final String ASYNC_DISPATCHER_IMPL = "async.dispatcherImpl";
    public static final String ASYNC_NUM_THREADS = "async.numThreads";
    public static final String CLIENT_URL = "clientURL";
    public static final String CLIENT_VERSION = "clientVersion";
    public static final String DEBUG = "debug";
    public static final String HTTP_CONNECTION_TIMEOUT = "http.connectionTimeout";
    public static final String HTTP_DEFAULT_MAX_PER_ROUTE = "http.defaultMaxPerRoute";
    public static final String HTTP_GZIP = "http.gzip";
    public static final String HTTP_MAX_TOTAL_CONNECTIONS = "http.maxTotalConnections";
    public static final String HTTP_PRETTY_DEBUG = "http.prettyDebug";
    public static final String HTTP_PROXY_HOST = "http.proxyHost";
    public static final String HTTP_PROXY_HOST_FALLBACK = "http.proxyHost";
    public static final String HTTP_PROXY_PASSWORD = "http.proxyPassword";
    public static final String HTTP_PROXY_PORT = "http.proxyPort";
    public static final String HTTP_PROXY_PORT_FALLBACK = "http.proxyPort";
    public static final String HTTP_PROXY_USER = "http.proxyUser";
    public static final String HTTP_READ_TIMEOUT = "http.readTimeout";
    public static final String HTTP_RETRY_COUNT = "http.retryCount";
    public static final String HTTP_RETRY_INTERVAL_SECS = "http.retryIntervalSecs";
    public static final String HTTP_STREAMING_READ_TIMEOUT = "http.streamingReadTimeout";
    public static final String HTTP_USER_AGENT = "http.userAgent";
    public static final String HTTP_USE_SSL = "http.useSSL";
    public static final String INCLUDE_ENTITIES = "includeEntities";
    public static final String INCLUDE_RTS = "includeRTs";
    public static final String JSON_STORE_ENABLED = "jsonStoreEnabled";
    public static final String MBEAN_ENABLED = "mbeanEnabled";
    public static final String MEDIA_PROVIDER = "media.provider";
    public static final String MEDIA_PROVIDER_API_KEY = "media.providerAPIKey";
    public static final String MEDIA_PROVIDER_PARAMETERS = "media.providerParameters";
    public static final String OAUTH_ACCESS_TOKEN = "oauth.accessToken";
    public static final String OAUTH_ACCESS_TOKEN_SECRET = "oauth.accessTokenSecret";
    public static final String OAUTH_ACCESS_TOKEN_URL = "oauth.accessTokenURL";
    public static final String OAUTH_AUTHENTICATION_URL = "oauth.authenticationURL";
    public static final String OAUTH_AUTHORIZATION_URL = "oauth.authorizationURL";
    public static final String OAUTH_CONSUMER_KEY = "oauth.consumerKey";
    public static final String OAUTH_CONSUMER_SECRET = "oauth.consumerSecret";
    public static final String OAUTH_REQUEST_TOKEN_URL = "oauth.requestTokenURL";
    public static final String PASSWORD = "password";
    public static final String REST_BASE_URL = "restBaseURL";
    public static final String SEARCH_BASE_URL = "searchBaseURL";
    public static final String SITE_STREAM_BASE_URL = "siteStreamBaseURL";
    public static final String STREAM_BASE_URL = "streamBaseURL";
    public static final String STREAM_USER_REPLIES_ALL = "stream.user.repliesAll";
    public static final String UPLOAD_BASE_URL = "uploadBaseURL";
    public static final String USER = "user";
    public static final String USER_STREAM_BASE_URL = "userStreamBaseURL";
    static Class class$twitter4j$conf$Configuration = null;
    private static final long serialVersionUID = 6458764415636588373L;

    @Override // twitter4j.conf.ConfigurationBase
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getDispatcherImpl() {
        return super.getDispatcherImpl();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public int getHttpStreamingReadTimeout() {
        return super.getHttpStreamingReadTimeout();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getMediaProvider() {
        return super.getMediaProvider();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getMediaProviderAPIKey() {
        return super.getMediaProviderAPIKey();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public Properties getMediaProviderParameters() {
        return super.getMediaProviderParameters();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public String getOAuthAccessToken() {
        return super.getOAuthAccessToken();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public String getOAuthAccessTokenSecret() {
        return super.getOAuthAccessTokenSecret();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getOAuthAccessTokenURL() {
        return super.getOAuthAccessTokenURL();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getOAuthAuthenticationURL() {
        return super.getOAuthAuthenticationURL();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getOAuthAuthorizationURL() {
        return super.getOAuthAuthorizationURL();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getOAuthRequestTokenURL() {
        return super.getOAuthRequestTokenURL();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration, twitter4j.internal.http.HttpClientWrapperConfiguration
    public Map getRequestHeaders() {
        return super.getRequestHeaders();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getRestBaseURL() {
        return super.getRestBaseURL();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getSearchBaseURL() {
        return super.getSearchBaseURL();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getSiteStreamBaseURL() {
        return super.getSiteStreamBaseURL();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getStreamBaseURL() {
        return super.getStreamBaseURL();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getUploadBaseURL() {
        return super.getUploadBaseURL();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public String getUserStreamBaseURL() {
        return super.getUserStreamBaseURL();
    }

    @Override // twitter4j.conf.ConfigurationBase
    public int hashCode() {
        return super.hashCode();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public boolean isGAE() {
        return super.isGAE();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.internal.http.HttpClientConfiguration
    public boolean isGZIPEnabled() {
        return super.isGZIPEnabled();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public boolean isIncludeEntitiesEnabled() {
        return super.isIncludeEntitiesEnabled();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public boolean isIncludeRTsEnabled() {
        return super.isIncludeRTsEnabled();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public boolean isJSONStoreEnabled() {
        return super.isJSONStoreEnabled();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public boolean isMBeanEnabled() {
        return super.isMBeanEnabled();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.internal.http.HttpClientConfiguration
    public boolean isPrettyDebugEnabled() {
        return super.isPrettyDebugEnabled();
    }

    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public boolean isUserStreamRepliesAllEnabled() {
        return super.isUserStreamRepliesAllEnabled();
    }

    @Override // twitter4j.conf.ConfigurationBase
    public String toString() {
        return super.toString();
    }

    public PropertyConfiguration(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        loadProperties(properties, inputStream);
        setFieldsWithTreePath(properties, "/");
    }

    public PropertyConfiguration(Properties properties) {
        this(properties, "/");
    }

    public PropertyConfiguration(Properties properties, String str) {
        setFieldsWithTreePath(properties, str);
    }

    PropertyConfiguration(String str) throws Throwable {
        Properties properties;
        Class clsClass$;
        Class clsClass$2;
        try {
            properties = (Properties) System.getProperties().clone();
            normalize(properties);
        } catch (SecurityException e) {
            properties = new Properties();
        }
        loadProperties(properties, new StringBuffer().append(".").append(File.separatorChar).append("twitter4j.properties").toString());
        if (class$twitter4j$conf$Configuration == null) {
            clsClass$ = class$("twitter4j.conf.Configuration");
            class$twitter4j$conf$Configuration = clsClass$;
        } else {
            clsClass$ = class$twitter4j$conf$Configuration;
        }
        loadProperties(properties, clsClass$.getResourceAsStream("/twitter4j.properties"));
        if (class$twitter4j$conf$Configuration == null) {
            clsClass$2 = class$("twitter4j.conf.Configuration");
            class$twitter4j$conf$Configuration = clsClass$2;
        } else {
            clsClass$2 = class$twitter4j$conf$Configuration;
        }
        loadProperties(properties, clsClass$2.getResourceAsStream("/WEB-INF/twitter4j.properties"));
        try {
            loadProperties(properties, new FileInputStream("WEB-INF/twitter4j.properties"));
        } catch (FileNotFoundException e2) {
        } catch (SecurityException e3) {
        }
        setFieldsWithTreePath(properties, str);
    }

    static Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    PropertyConfiguration() {
        this("/");
    }

    private boolean notNull(Properties properties, String str, String str2) {
        return properties.getProperty(new StringBuffer().append(str).append(str2).toString()) != null;
    }

    private boolean loadProperties(Properties properties, String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        File file;
        FileInputStream fileInputStream2 = null;
        try {
            file = new File(str);
        } catch (Exception e) {
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        if (!file.exists() || !file.isFile()) {
            if (0 != 0) {
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                }
            }
            return false;
        }
        fileInputStream = new FileInputStream(file);
        try {
            properties.load(fileInputStream);
            normalize(properties);
            if (fileInputStream == null) {
                return true;
            }
            try {
                fileInputStream.close();
                return true;
            } catch (IOException e3) {
                return true;
            }
        } catch (Exception e4) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                }
            }
            throw th;
        }
    }

    private boolean loadProperties(Properties properties, InputStream inputStream) throws IOException {
        try {
            properties.load(inputStream);
            normalize(properties);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void normalize(Properties properties) {
        Set<String> setKeySet = properties.keySet();
        ArrayList arrayList = new ArrayList(10);
        for (String str : setKeySet) {
            if (-1 != str.indexOf("twitter4j.")) {
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            String property = properties.getProperty(str2);
            int iIndexOf = str2.indexOf("twitter4j.");
            properties.setProperty(new StringBuffer().append(str2.substring(0, iIndexOf)).append(str2.substring(iIndexOf + 10)).toString(), property);
        }
    }

    private void setFieldsWithTreePath(Properties properties, String str) {
        setFieldsWithPrefix(properties, "");
        String string = null;
        for (String str2 : z_T4JInternalStringUtil.split(str, "/")) {
            if (!"".equals(str2)) {
                if (string == null) {
                    string = new StringBuffer().append(str2).append(".").toString();
                } else {
                    string = new StringBuffer().append(string).append(str2).append(".").toString();
                }
                setFieldsWithPrefix(properties, string);
            }
        }
    }

    private void setFieldsWithPrefix(Properties properties, String str) {
        if (notNull(properties, str, DEBUG)) {
            setDebug(getBoolean(properties, str, DEBUG));
        }
        if (notNull(properties, str, USER)) {
            setUser(getString(properties, str, USER));
        }
        if (notNull(properties, str, PASSWORD)) {
            setPassword(getString(properties, str, PASSWORD));
        }
        if (notNull(properties, str, HTTP_USE_SSL)) {
            setUseSSL(getBoolean(properties, str, HTTP_USE_SSL));
        }
        if (notNull(properties, str, HTTP_PRETTY_DEBUG)) {
            setPrettyDebugEnabled(getBoolean(properties, str, HTTP_PRETTY_DEBUG));
        }
        if (notNull(properties, str, HTTP_GZIP)) {
            setGZIPEnabled(getBoolean(properties, str, HTTP_GZIP));
        }
        if (notNull(properties, str, "http.proxyHost") || notNull(properties, str, "http.proxyHost")) {
            setHttpProxyHost(getString(properties, str, "http.proxyHost"));
        }
        if (notNull(properties, str, HTTP_PROXY_USER)) {
            setHttpProxyUser(getString(properties, str, HTTP_PROXY_USER));
        }
        if (notNull(properties, str, HTTP_PROXY_PASSWORD)) {
            setHttpProxyPassword(getString(properties, str, HTTP_PROXY_PASSWORD));
        }
        if (notNull(properties, str, "http.proxyPort") || notNull(properties, str, "http.proxyPort")) {
            setHttpProxyPort(getIntProperty(properties, str, "http.proxyPort"));
        }
        if (notNull(properties, str, HTTP_CONNECTION_TIMEOUT)) {
            setHttpConnectionTimeout(getIntProperty(properties, str, HTTP_CONNECTION_TIMEOUT));
        }
        if (notNull(properties, str, HTTP_READ_TIMEOUT)) {
            setHttpReadTimeout(getIntProperty(properties, str, HTTP_READ_TIMEOUT));
        }
        if (notNull(properties, str, HTTP_STREAMING_READ_TIMEOUT)) {
            setHttpStreamingReadTimeout(getIntProperty(properties, str, HTTP_STREAMING_READ_TIMEOUT));
        }
        if (notNull(properties, str, HTTP_RETRY_COUNT)) {
            setHttpRetryCount(getIntProperty(properties, str, HTTP_RETRY_COUNT));
        }
        if (notNull(properties, str, HTTP_RETRY_INTERVAL_SECS)) {
            setHttpRetryIntervalSeconds(getIntProperty(properties, str, HTTP_RETRY_INTERVAL_SECS));
        }
        if (notNull(properties, str, HTTP_MAX_TOTAL_CONNECTIONS)) {
            setHttpMaxTotalConnections(getIntProperty(properties, str, HTTP_MAX_TOTAL_CONNECTIONS));
        }
        if (notNull(properties, str, HTTP_DEFAULT_MAX_PER_ROUTE)) {
            setHttpDefaultMaxPerRoute(getIntProperty(properties, str, HTTP_DEFAULT_MAX_PER_ROUTE));
        }
        if (notNull(properties, str, OAUTH_CONSUMER_KEY)) {
            setOAuthConsumerKey(getString(properties, str, OAUTH_CONSUMER_KEY));
        }
        if (notNull(properties, str, OAUTH_CONSUMER_SECRET)) {
            setOAuthConsumerSecret(getString(properties, str, OAUTH_CONSUMER_SECRET));
        }
        if (notNull(properties, str, OAUTH_ACCESS_TOKEN)) {
            setOAuthAccessToken(getString(properties, str, OAUTH_ACCESS_TOKEN));
        }
        if (notNull(properties, str, OAUTH_ACCESS_TOKEN_SECRET)) {
            setOAuthAccessTokenSecret(getString(properties, str, OAUTH_ACCESS_TOKEN_SECRET));
        }
        if (notNull(properties, str, ASYNC_NUM_THREADS)) {
            setAsyncNumThreads(getIntProperty(properties, str, ASYNC_NUM_THREADS));
        }
        if (notNull(properties, str, ASYNC_DISPATCHER_IMPL)) {
            setDispatcherImpl(getString(properties, str, ASYNC_DISPATCHER_IMPL));
        }
        if (notNull(properties, str, CLIENT_VERSION)) {
            setClientVersion(getString(properties, str, CLIENT_VERSION));
        }
        if (notNull(properties, str, CLIENT_URL)) {
            setClientURL(getString(properties, str, CLIENT_URL));
        }
        if (notNull(properties, str, HTTP_USER_AGENT)) {
            setUserAgent(getString(properties, str, HTTP_USER_AGENT));
        }
        if (notNull(properties, str, OAUTH_REQUEST_TOKEN_URL)) {
            setOAuthRequestTokenURL(getString(properties, str, OAUTH_REQUEST_TOKEN_URL));
        }
        if (notNull(properties, str, OAUTH_AUTHORIZATION_URL)) {
            setOAuthAuthorizationURL(getString(properties, str, OAUTH_AUTHORIZATION_URL));
        }
        if (notNull(properties, str, OAUTH_ACCESS_TOKEN_URL)) {
            setOAuthAccessTokenURL(getString(properties, str, OAUTH_ACCESS_TOKEN_URL));
        }
        if (notNull(properties, str, OAUTH_AUTHENTICATION_URL)) {
            setOAuthAuthenticationURL(getString(properties, str, OAUTH_AUTHENTICATION_URL));
        }
        if (notNull(properties, str, REST_BASE_URL)) {
            setRestBaseURL(getString(properties, str, REST_BASE_URL));
        }
        if (notNull(properties, str, SEARCH_BASE_URL)) {
            setSearchBaseURL(getString(properties, str, SEARCH_BASE_URL));
        }
        if (notNull(properties, str, STREAM_BASE_URL)) {
            setStreamBaseURL(getString(properties, str, STREAM_BASE_URL));
        }
        if (notNull(properties, str, USER_STREAM_BASE_URL)) {
            setUserStreamBaseURL(getString(properties, str, USER_STREAM_BASE_URL));
        }
        if (notNull(properties, str, SITE_STREAM_BASE_URL)) {
            setSiteStreamBaseURL(getString(properties, str, SITE_STREAM_BASE_URL));
        }
        if (notNull(properties, str, UPLOAD_BASE_URL)) {
            setUploadBaseURL(getString(properties, str, UPLOAD_BASE_URL));
        }
        if (notNull(properties, str, INCLUDE_RTS)) {
            setIncludeRTsEnbled(getBoolean(properties, str, INCLUDE_RTS));
        }
        if (notNull(properties, str, INCLUDE_ENTITIES)) {
            setIncludeEntitiesEnbled(getBoolean(properties, str, INCLUDE_ENTITIES));
        }
        if (notNull(properties, str, JSON_STORE_ENABLED)) {
            setJSONStoreEnabled(getBoolean(properties, str, JSON_STORE_ENABLED));
        }
        if (notNull(properties, str, MBEAN_ENABLED)) {
            setMBeanEnabled(getBoolean(properties, str, MBEAN_ENABLED));
        }
        if (notNull(properties, str, STREAM_USER_REPLIES_ALL)) {
            setUserStreamRepliesAllEnabled(getBoolean(properties, str, STREAM_USER_REPLIES_ALL));
        }
        if (notNull(properties, str, MEDIA_PROVIDER)) {
            setMediaProvider(getString(properties, str, MEDIA_PROVIDER));
        }
        if (notNull(properties, str, MEDIA_PROVIDER_API_KEY)) {
            setMediaProviderAPIKey(getString(properties, str, MEDIA_PROVIDER_API_KEY));
        }
        if (notNull(properties, str, MEDIA_PROVIDER_PARAMETERS)) {
            String[] strArrSplit = z_T4JInternalStringUtil.split(getString(properties, str, MEDIA_PROVIDER_PARAMETERS), "&");
            Properties properties2 = new Properties();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = z_T4JInternalStringUtil.split(str2, "=");
                properties2.setProperty(strArrSplit2[0], strArrSplit2[1]);
            }
            setMediaProviderParameters(properties2);
        }
        cacheInstance();
    }

    protected boolean getBoolean(Properties properties, String str, String str2) {
        return Boolean.valueOf(properties.getProperty(new StringBuffer().append(str).append(str2).toString())).booleanValue();
    }

    protected int getIntProperty(Properties properties, String str, String str2) {
        try {
            return Integer.parseInt(properties.getProperty(new StringBuffer().append(str).append(str2).toString()));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    protected String getString(Properties properties, String str, String str2) {
        return properties.getProperty(new StringBuffer().append(str).append(str2).toString());
    }

    @Override // twitter4j.conf.ConfigurationBase
    protected Object readResolve() {
        return super.readResolve();
    }
}
