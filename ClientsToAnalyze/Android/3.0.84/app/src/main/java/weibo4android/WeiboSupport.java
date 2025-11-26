package weibo4android;

import weibo4android.http.HttpClient;

/* loaded from: classes.dex */
class WeiboSupport {
    protected final boolean USE_SSL;
    protected HttpClient http;
    protected String source;

    WeiboSupport() {
        this(null, null);
    }

    WeiboSupport(String str, String str2) {
        this.http = new HttpClient();
        this.source = Configuration.getSource();
        this.USE_SSL = Configuration.useSSL();
        setClientVersion(null);
        setClientURL(null);
        setUserId(str);
        setPassword(str2);
    }

    public void setUserAgent(String str) {
        this.http.setUserAgent(str);
    }

    public String getUserAgent() {
        return this.http.getUserAgent();
    }

    public void setClientVersion(String str) {
        setRequestHeader("X-Weibo-Client-Version", Configuration.getCilentVersion(str));
    }

    public String getClientVersion() {
        return this.http.getRequestHeader("X-Weibo-Client-Version");
    }

    public void setClientURL(String str) {
        setRequestHeader("X-Weibo-Client-URL", Configuration.getClientURL(str));
    }

    public String getClientURL() {
        return this.http.getRequestHeader("X-Weibo-Client-URL");
    }

    public synchronized void setUserId(String str) {
        this.http.setUserId(Configuration.getUser(str));
    }

    public String getUserId() {
        return this.http.getUserId();
    }

    public synchronized void setPassword(String str) {
        this.http.setPassword(Configuration.getPassword(str));
    }

    public String getPassword() {
        return this.http.getPassword();
    }

    public void setHttpProxy(String str, int i) {
        this.http.setProxyHost(str);
        this.http.setProxyPort(i);
    }

    public void setHttpProxyAuth(String str, String str2) {
        this.http.setProxyAuthUser(str);
        this.http.setProxyAuthPassword(str2);
    }

    public void setHttpConnectionTimeout(int i) {
        this.http.setConnectionTimeout(i);
    }

    public void setHttpReadTimeout(int i) {
        this.http.setReadTimeout(i);
    }

    public void setSource(String str) {
        this.source = Configuration.getSource(str);
        setRequestHeader("X-Weibo-Client", this.source);
    }

    public String getSource() {
        return this.source;
    }

    public void setRequestHeader(String str, String str2) {
        this.http.setRequestHeader(str, str2);
    }

    @Deprecated
    public void forceUsePost(boolean z) {
    }

    public boolean isUsePostForced() {
        return false;
    }

    public void setRetryCount(int i) {
        this.http.setRetryCount(i);
    }

    public void setRetryIntervalSecs(int i) {
        this.http.setRetryIntervalSecs(i);
    }
}
