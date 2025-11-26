package twitter4j.conf;

import java.util.Properties;

/* loaded from: classes.dex */
public final class ConfigurationBuilder {
    private ConfigurationBase configurationBean = new PropertyConfiguration();

    public ConfigurationBuilder setUseSSL(boolean z) {
        checkNotBuilt();
        this.configurationBean.setUseSSL(z);
        return this;
    }

    public ConfigurationBuilder setPrettyDebugEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setPrettyDebugEnabled(z);
        return this;
    }

    public ConfigurationBuilder setGZIPEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setGZIPEnabled(z);
        return this;
    }

    public ConfigurationBuilder setDebugEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setDebug(z);
        return this;
    }

    public ConfigurationBuilder setUser(String str) {
        checkNotBuilt();
        this.configurationBean.setUser(str);
        return this;
    }

    public ConfigurationBuilder setPassword(String str) {
        checkNotBuilt();
        this.configurationBean.setPassword(str);
        return this;
    }

    public ConfigurationBuilder setHttpProxyHost(String str) {
        checkNotBuilt();
        this.configurationBean.setHttpProxyHost(str);
        return this;
    }

    public ConfigurationBuilder setHttpProxyUser(String str) {
        checkNotBuilt();
        this.configurationBean.setHttpProxyUser(str);
        return this;
    }

    public ConfigurationBuilder setHttpProxyPassword(String str) {
        checkNotBuilt();
        this.configurationBean.setHttpProxyPassword(str);
        return this;
    }

    public ConfigurationBuilder setHttpProxyPort(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpProxyPort(i);
        return this;
    }

    public ConfigurationBuilder setHttpConnectionTimeout(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpConnectionTimeout(i);
        return this;
    }

    public ConfigurationBuilder setHttpReadTimeout(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpReadTimeout(i);
        return this;
    }

    public ConfigurationBuilder setHttpStreamingReadTimeout(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpStreamingReadTimeout(i);
        return this;
    }

    public ConfigurationBuilder setHttpRetryCount(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpRetryCount(i);
        return this;
    }

    public ConfigurationBuilder setHttpMaxTotalConnections(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpMaxTotalConnections(i);
        return this;
    }

    public ConfigurationBuilder setHttpDefaultMaxPerRoute(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpDefaultMaxPerRoute(i);
        return this;
    }

    public ConfigurationBuilder setHttpRetryIntervalSeconds(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpRetryIntervalSeconds(i);
        return this;
    }

    public ConfigurationBuilder setOAuthConsumerKey(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthConsumerKey(str);
        return this;
    }

    public ConfigurationBuilder setOAuthConsumerSecret(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthConsumerSecret(str);
        return this;
    }

    public ConfigurationBuilder setOAuthAccessToken(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAccessToken(str);
        return this;
    }

    public ConfigurationBuilder setOAuthAccessTokenSecret(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAccessTokenSecret(str);
        return this;
    }

    public ConfigurationBuilder setOAuthRequestTokenURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthRequestTokenURL(str);
        return this;
    }

    public ConfigurationBuilder setOAuthAuthorizationURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAuthorizationURL(str);
        return this;
    }

    public ConfigurationBuilder setOAuthAccessTokenURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAccessTokenURL(str);
        return this;
    }

    public ConfigurationBuilder setOAuthAuthenticationURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAuthenticationURL(str);
        return this;
    }

    public ConfigurationBuilder setRestBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setRestBaseURL(str);
        return this;
    }

    public ConfigurationBuilder setSearchBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setSearchBaseURL(str);
        return this;
    }

    public ConfigurationBuilder setStreamBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setStreamBaseURL(str);
        return this;
    }

    public ConfigurationBuilder setUserStreamBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setUserStreamBaseURL(str);
        return this;
    }

    public ConfigurationBuilder setSiteStreamBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setSiteStreamBaseURL(str);
        return this;
    }

    public ConfigurationBuilder setAsyncNumThreads(int i) {
        checkNotBuilt();
        this.configurationBean.setAsyncNumThreads(i);
        return this;
    }

    public ConfigurationBuilder setClientVersion(String str) {
        checkNotBuilt();
        this.configurationBean.setClientVersion(str);
        return this;
    }

    public ConfigurationBuilder setClientURL(String str) {
        checkNotBuilt();
        this.configurationBean.setClientURL(str);
        return this;
    }

    public ConfigurationBuilder setDispatcherImpl(String str) {
        checkNotBuilt();
        this.configurationBean.setDispatcherImpl(str);
        return this;
    }

    public ConfigurationBuilder setIncludeRTsEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setIncludeRTsEnbled(z);
        return this;
    }

    public ConfigurationBuilder setIncludeEntitiesEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setIncludeEntitiesEnbled(z);
        return this;
    }

    public ConfigurationBuilder setJSONStoreEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setJSONStoreEnabled(z);
        return this;
    }

    public ConfigurationBuilder setMBeanEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setMBeanEnabled(z);
        return this;
    }

    public ConfigurationBuilder setUserStreamRepliesAllEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setUserStreamRepliesAllEnabled(z);
        return this;
    }

    public ConfigurationBuilder setMediaProvider(String str) {
        checkNotBuilt();
        this.configurationBean.setMediaProvider(str);
        return this;
    }

    public ConfigurationBuilder setMediaProviderAPIKey(String str) {
        checkNotBuilt();
        this.configurationBean.setMediaProviderAPIKey(str);
        return this;
    }

    public ConfigurationBuilder setMediaProviderParameters(Properties properties) {
        checkNotBuilt();
        this.configurationBean.setMediaProviderParameters(properties);
        return this;
    }

    public Configuration build() {
        checkNotBuilt();
        this.configurationBean.cacheInstance();
        try {
            return this.configurationBean;
        } finally {
            this.configurationBean = null;
        }
    }

    private void checkNotBuilt() {
        if (this.configurationBean == null) {
            throw new IllegalStateException("Cannot use this builder any longer, build() has already been called");
        }
    }
}
