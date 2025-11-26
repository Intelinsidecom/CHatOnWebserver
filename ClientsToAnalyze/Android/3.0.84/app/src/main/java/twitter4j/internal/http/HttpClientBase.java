package twitter4j.internal.http;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import twitter4j.internal.logging.Logger;

/* loaded from: classes.dex */
public class HttpClientBase implements Serializable {
    static Class class$twitter4j$internal$http$HttpClientBase;
    private static final Logger logger;
    protected final HttpClientConfiguration CONF;

    static {
        Class clsClass$;
        if (class$twitter4j$internal$http$HttpClientBase == null) {
            clsClass$ = class$("twitter4j.internal.http.HttpClientBase");
            class$twitter4j$internal$http$HttpClientBase = clsClass$;
        } else {
            clsClass$ = class$twitter4j$internal$http$HttpClientBase;
        }
        logger = Logger.getLogger(clsClass$);
    }

    static Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public HttpClientBase(HttpClientConfiguration httpClientConfiguration) {
        this.CONF = httpClientConfiguration;
    }

    public void shutdown() {
    }

    protected boolean isProxyConfigured() {
        return (this.CONF.getHttpProxyHost() == null || this.CONF.getHttpProxyHost().equals("")) ? false : true;
    }

    public void write(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        logger.debug(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HttpClientBase) && this.CONF.equals(((HttpClientBase) obj).CONF);
    }

    public int hashCode() {
        return this.CONF.hashCode();
    }

    public String toString() {
        return new StringBuffer().append("HttpClientBase{CONF=").append(this.CONF).append('}').toString();
    }
}
