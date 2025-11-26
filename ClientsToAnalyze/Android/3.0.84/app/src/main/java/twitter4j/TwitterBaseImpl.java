package twitter4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.BasicAuthorization;
import twitter4j.auth.NullAuthorization;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.OAuthSupport;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpClientWrapper;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.http.HttpResponseEvent;
import twitter4j.internal.http.HttpResponseListener;
import twitter4j.internal.http.XAuthAuthorization;
import twitter4j.internal.json.z_T4JInternalFactory;
import twitter4j.internal.json.z_T4JInternalJSONImplFactory;

/* loaded from: classes.dex */
abstract class TwitterBaseImpl implements Serializable, OAuthSupport, HttpResponseListener {
    private static final long serialVersionUID = -3812176145960812140L;
    protected Authorization auth;
    protected Configuration conf;
    protected z_T4JInternalFactory factory;
    protected transient HttpClientWrapper http;
    protected transient String screenName = null;

    /* renamed from: id */
    protected transient long f13729id = 0;
    private List<RateLimitStatusListener> rateLimitStatusListeners = new ArrayList(0);

    TwitterBaseImpl(Configuration configuration, Authorization authorization) {
        this.conf = configuration;
        this.auth = authorization;
        init();
    }

    private void init() {
        if (this.auth == null) {
            String oAuthConsumerKey = this.conf.getOAuthConsumerKey();
            String oAuthConsumerSecret = this.conf.getOAuthConsumerSecret();
            if (oAuthConsumerKey != null && oAuthConsumerSecret != null) {
                OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
                String oAuthAccessToken = this.conf.getOAuthAccessToken();
                String oAuthAccessTokenSecret = this.conf.getOAuthAccessTokenSecret();
                if (oAuthAccessToken != null && oAuthAccessTokenSecret != null) {
                    oAuthAuthorization.setOAuthAccessToken(new AccessToken(oAuthAccessToken, oAuthAccessTokenSecret));
                }
                this.auth = oAuthAuthorization;
            } else {
                this.auth = NullAuthorization.getInstance();
            }
        }
        this.http = new HttpClientWrapper(this.conf);
        this.http.setHttpResponseListener(this);
        setFactory();
    }

    protected void setFactory() {
        this.factory = new z_T4JInternalJSONImplFactory(this.conf);
    }

    public String getScreenName() {
        if (!this.auth.isEnabled()) {
            throw new IllegalStateException("Neither user ID/password combination nor OAuth consumer key/secret combination supplied");
        }
        if (this.screenName == null) {
            if (this.auth instanceof BasicAuthorization) {
                this.screenName = ((BasicAuthorization) this.auth).getUserId();
                if (-1 != this.screenName.indexOf("@")) {
                    this.screenName = null;
                }
            }
            if (this.screenName == null) {
                fillInIDAndScreenName();
            }
        }
        return this.screenName;
    }

    public long getId() {
        if (!this.auth.isEnabled()) {
            throw new IllegalStateException("Neither user ID/password combination nor OAuth consumer key/secret combination supplied");
        }
        if (0 == this.f13729id) {
            fillInIDAndScreenName();
        }
        return this.f13729id;
    }

    protected User fillInIDAndScreenName() {
        ensureAuthorizationEnabled();
        User userCreateUser = this.factory.createUser(this.http.get(new StringBuffer().append(this.conf.getRestBaseURL()).append("account/verify_credentials.json?include_entities=").append(this.conf.isIncludeEntitiesEnabled()).toString(), this.auth));
        this.screenName = userCreateUser.getScreenName();
        this.f13729id = userCreateUser.getId();
        return userCreateUser;
    }

    public void addRateLimitStatusListener(RateLimitStatusListener rateLimitStatusListener) {
        this.rateLimitStatusListeners.add(rateLimitStatusListener);
    }

    @Override // twitter4j.internal.http.HttpResponseListener
    public void httpResponseReceived(HttpResponseEvent httpResponseEvent) {
        RateLimitStatus rateLimitStatusCreateRateLimitStatusFromResponseHeader;
        int statusCode;
        if (this.rateLimitStatusListeners.size() != 0) {
            HttpResponse response = httpResponseEvent.getResponse();
            TwitterException twitterException = httpResponseEvent.getTwitterException();
            if (twitterException != null) {
                rateLimitStatusCreateRateLimitStatusFromResponseHeader = twitterException.getRateLimitStatus();
                statusCode = twitterException.getStatusCode();
            } else {
                rateLimitStatusCreateRateLimitStatusFromResponseHeader = z_T4JInternalJSONImplFactory.createRateLimitStatusFromResponseHeader(response);
                statusCode = response.getStatusCode();
            }
            if (rateLimitStatusCreateRateLimitStatusFromResponseHeader != null) {
                RateLimitStatusEvent rateLimitStatusEvent = new RateLimitStatusEvent(this, rateLimitStatusCreateRateLimitStatusFromResponseHeader, httpResponseEvent.isAuthenticated());
                if (statusCode == 420 || statusCode == 503) {
                    for (RateLimitStatusListener rateLimitStatusListener : this.rateLimitStatusListeners) {
                        rateLimitStatusListener.onRateLimitStatus(rateLimitStatusEvent);
                        rateLimitStatusListener.onRateLimitReached(rateLimitStatusEvent);
                    }
                    return;
                }
                Iterator<RateLimitStatusListener> it = this.rateLimitStatusListeners.iterator();
                while (it.hasNext()) {
                    it.next().onRateLimitStatus(rateLimitStatusEvent);
                }
            }
        }
    }

    public final Authorization getAuthorization() {
        return this.auth;
    }

    public Configuration getConfiguration() {
        return this.conf;
    }

    public void shutdown() {
        if (this.http != null) {
            this.http.shutdown();
        }
    }

    protected final void ensureAuthorizationEnabled() {
        if (!this.auth.isEnabled()) {
            throw new IllegalStateException("Authentication credentials are missing. See http://twitter4j.org/configuration.html for the detail.");
        }
    }

    protected final void ensureOAuthEnabled() {
        if (!(this.auth instanceof OAuthAuthorization)) {
            throw new IllegalStateException("OAuth required. Authentication credentials are missing. See http://twitter4j.org/configuration.html for the detail.");
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.conf);
        objectOutputStream.writeObject(this.auth);
        ArrayList arrayList = new ArrayList(0);
        for (RateLimitStatusListener rateLimitStatusListener : this.rateLimitStatusListeners) {
            if (rateLimitStatusListener instanceof Serializable) {
                arrayList.add(rateLimitStatusListener);
            }
        }
        objectOutputStream.writeObject(arrayList);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.conf = (Configuration) objectInputStream.readObject();
        this.auth = (Authorization) objectInputStream.readObject();
        this.rateLimitStatusListeners = (List) objectInputStream.readObject();
        this.http = new HttpClientWrapper(this.conf);
        this.http.setHttpResponseListener(this);
        setFactory();
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized void setOAuthConsumer(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("consumer key is null");
        }
        if (str2 == null) {
            throw new NullPointerException("consumer secret is null");
        }
        if (this.auth instanceof NullAuthorization) {
            OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
            oAuthAuthorization.setOAuthConsumer(str, str2);
            this.auth = oAuthAuthorization;
        } else if (this.auth instanceof BasicAuthorization) {
            XAuthAuthorization xAuthAuthorization = new XAuthAuthorization((BasicAuthorization) this.auth);
            xAuthAuthorization.setOAuthConsumer(str, str2);
            this.auth = xAuthAuthorization;
        } else if (this.auth instanceof OAuthAuthorization) {
            throw new IllegalStateException("consumer key/secret pair already set.");
        }
    }

    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken() {
        return getOAuthRequestToken(null);
    }

    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str) {
        return getOAuth().getOAuthRequestToken(str);
    }

    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str, String str2) {
        return getOAuth().getOAuthRequestToken(str, str2);
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken() {
        AccessToken oAuthAccessToken;
        Authorization authorization = getAuthorization();
        if (authorization instanceof BasicAuthorization) {
            BasicAuthorization basicAuthorization = (BasicAuthorization) authorization;
            Authorization authorizationFactory = AuthorizationFactory.getInstance(this.conf);
            if (authorizationFactory instanceof OAuthAuthorization) {
                this.auth = authorizationFactory;
                oAuthAccessToken = ((OAuthAuthorization) authorizationFactory).getOAuthAccessToken(basicAuthorization.getUserId(), basicAuthorization.getPassword());
            } else {
                throw new IllegalStateException("consumer key / secret combination not supplied.");
            }
        } else if (authorization instanceof XAuthAuthorization) {
            XAuthAuthorization xAuthAuthorization = (XAuthAuthorization) authorization;
            this.auth = xAuthAuthorization;
            OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
            oAuthAuthorization.setOAuthConsumer(xAuthAuthorization.getConsumerKey(), xAuthAuthorization.getConsumerSecret());
            oAuthAccessToken = oAuthAuthorization.getOAuthAccessToken(xAuthAuthorization.getUserId(), xAuthAuthorization.getPassword());
        } else {
            oAuthAccessToken = getOAuth().getOAuthAccessToken();
        }
        this.screenName = oAuthAccessToken.getScreenName();
        this.f13729id = oAuthAccessToken.getUserId();
        return oAuthAccessToken;
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken(String str) {
        AccessToken oAuthAccessToken;
        oAuthAccessToken = getOAuth().getOAuthAccessToken(str);
        this.screenName = oAuthAccessToken.getScreenName();
        return oAuthAccessToken;
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken(RequestToken requestToken) {
        AccessToken oAuthAccessToken;
        oAuthAccessToken = getOAuth().getOAuthAccessToken(requestToken);
        this.screenName = oAuthAccessToken.getScreenName();
        return oAuthAccessToken;
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken(RequestToken requestToken, String str) {
        return getOAuth().getOAuthAccessToken(requestToken, str);
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized void setOAuthAccessToken(AccessToken accessToken) {
        getOAuth().setOAuthAccessToken(accessToken);
    }

    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken(String str, String str2) {
        return getOAuth().getOAuthAccessToken(str, str2);
    }

    private OAuthSupport getOAuth() {
        if (!(this.auth instanceof OAuthSupport)) {
            throw new IllegalStateException("OAuth consumer key/secret combination not supplied");
        }
        return (OAuthSupport) this.auth;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TwitterBaseImpl)) {
            return false;
        }
        TwitterBaseImpl twitterBaseImpl = (TwitterBaseImpl) obj;
        if (this.auth == null ? twitterBaseImpl.auth != null : !this.auth.equals(twitterBaseImpl.auth)) {
            return false;
        }
        if (!this.conf.equals(twitterBaseImpl.conf)) {
            return false;
        }
        if (this.http == null ? twitterBaseImpl.http != null : !this.http.equals(twitterBaseImpl.http)) {
            return false;
        }
        return this.rateLimitStatusListeners.equals(twitterBaseImpl.rateLimitStatusListeners);
    }

    public int hashCode() {
        return (((((this.http != null ? this.http.hashCode() : 0) + (this.conf.hashCode() * 31)) * 31) + this.rateLimitStatusListeners.hashCode()) * 31) + (this.auth != null ? this.auth.hashCode() : 0);
    }

    public String toString() {
        return new StringBuffer().append("TwitterBase{conf=").append(this.conf).append(", http=").append(this.http).append(", rateLimitStatusListeners=").append(this.rateLimitStatusListeners).append(", auth=").append(this.auth).append('}').toString();
    }
}
