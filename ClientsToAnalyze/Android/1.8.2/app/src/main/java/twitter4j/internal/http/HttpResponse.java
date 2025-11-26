package twitter4j.internal.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationContext;
import twitter4j.internal.logging.Logger;

/* loaded from: classes.dex */
public abstract class HttpResponse {
    static Class class$twitter4j$internal$http$HttpResponseImpl;
    private static final Logger logger;
    protected final HttpClientConfiguration CONF;

    /* renamed from: is */
    protected InputStream f7896is;
    private JSONObject json;
    private JSONArray jsonArray;
    protected String responseAsString;
    protected int statusCode;
    private boolean streamConsumed;

    public abstract void disconnect();

    public abstract String getResponseHeader(String str);

    public abstract Map getResponseHeaderFields();

    static {
        Class clsClass$;
        if (class$twitter4j$internal$http$HttpResponseImpl == null) {
            clsClass$ = class$("twitter4j.internal.http.HttpResponseImpl");
            class$twitter4j$internal$http$HttpResponseImpl = clsClass$;
        } else {
            clsClass$ = class$twitter4j$internal$http$HttpResponseImpl;
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

    HttpResponse() {
        this.responseAsString = null;
        this.streamConsumed = false;
        this.json = null;
        this.jsonArray = null;
        this.CONF = ConfigurationContext.getInstance();
    }

    public HttpResponse(HttpClientConfiguration httpClientConfiguration) {
        this.responseAsString = null;
        this.streamConsumed = false;
        this.json = null;
        this.jsonArray = null;
        this.CONF = httpClientConfiguration;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public InputStream asStream() {
        if (this.streamConsumed) {
            throw new IllegalStateException("Stream has already been consumed.");
        }
        return this.f7896is;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String asString() throws java.lang.Throwable {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = r6.responseAsString
            if (r1 != 0) goto L7b
            r1 = 0
            java.io.InputStream r2 = r6.asStream()     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L97
            if (r2 != 0) goto L1a
            if (r2 == 0) goto L11
            r2.close()     // Catch: java.io.IOException -> L7e
        L11:
            if (r0 == 0) goto L16
            r1.close()     // Catch: java.io.IOException -> L80
        L16:
            r6.disconnectForcibly()
        L19:
            return r0
        L1a:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9d
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9d
            java.lang.String r4 = "UTF-8"
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9d
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9d
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L95
            r0.<init>()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L95
        L2b:
            java.lang.String r3 = r1.readLine()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L95
            if (r3 == 0) goto L5b
            java.lang.StringBuffer r3 = r0.append(r3)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L95
            java.lang.String r4 = "\n"
            r3.append(r4)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L95
            goto L2b
        L3b:
            r0 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L3f:
            twitter4j.TwitterException r3 = new twitter4j.TwitterException     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = r0.getMessage()     // Catch: java.lang.Throwable -> L49
            r3.<init>(r4, r0)     // Catch: java.lang.Throwable -> L49
            throw r3     // Catch: java.lang.Throwable -> L49
        L49:
            r0 = move-exception
            r5 = r1
            r1 = r2
            r2 = r5
        L4d:
            if (r2 == 0) goto L52
            r2.close()     // Catch: java.io.IOException -> L86
        L52:
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.io.IOException -> L88
        L57:
            r6.disconnectForcibly()
            throw r0
        L5b:
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L95
            r6.responseAsString = r0     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L95
            twitter4j.internal.logging.Logger r0 = twitter4j.internal.http.HttpResponse.logger     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L95
            java.lang.String r3 = r6.responseAsString     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L95
            r0.debug(r3)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L95
            r2.close()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L95
            r0 = 1
            r6.streamConsumed = r0     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L95
            if (r2 == 0) goto L73
            r2.close()     // Catch: java.io.IOException -> L82
        L73:
            if (r1 == 0) goto L78
            r1.close()     // Catch: java.io.IOException -> L84
        L78:
            r6.disconnectForcibly()
        L7b:
            java.lang.String r0 = r6.responseAsString
            goto L19
        L7e:
            r2 = move-exception
            goto L11
        L80:
            r1 = move-exception
            goto L16
        L82:
            r0 = move-exception
            goto L73
        L84:
            r0 = move-exception
            goto L78
        L86:
            r2 = move-exception
            goto L52
        L88:
            r1 = move-exception
            goto L57
        L8a:
            r1 = move-exception
            r2 = r0
            r5 = r1
            r1 = r0
            r0 = r5
            goto L4d
        L90:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L4d
        L95:
            r0 = move-exception
            goto L4d
        L97:
            r1 = move-exception
            r2 = r0
            r5 = r0
            r0 = r1
            r1 = r5
            goto L3f
        L9d:
            r1 = move-exception
            r5 = r1
            r1 = r2
            r2 = r0
            r0 = r5
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.internal.http.HttpResponse.asString():java.lang.String");
    }

    public JSONObject asJSONObject() throws IOException {
        if (this.json == null) {
            Reader reader = null;
            try {
                try {
                    if (this.responseAsString == null) {
                        this.json = new JSONObject(asString());
                    } else {
                        this.json = new JSONObject(this.responseAsString);
                    }
                    if (this.CONF.isPrettyDebugEnabled()) {
                        logger.debug(this.json.toString(1));
                    }
                } catch (JSONException e) {
                    if (this.responseAsString == null) {
                        throw new TwitterException(e.getMessage(), e);
                    }
                    throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(this.responseAsString).toString(), e);
                }
            } finally {
                if (0 != 0) {
                    try {
                        reader.close();
                    } catch (IOException e2) {
                    }
                }
                disconnectForcibly();
            }
        }
        return this.json;
    }

    public JSONArray asJSONArray() throws IOException {
        if (this.jsonArray == null) {
            Reader reader = null;
            try {
                try {
                    if (this.responseAsString == null) {
                        this.jsonArray = new JSONArray(asString());
                    } else {
                        this.jsonArray = new JSONArray(this.responseAsString);
                    }
                    if (this.CONF.isPrettyDebugEnabled()) {
                        logger.debug(this.jsonArray.toString(1));
                    }
                } catch (JSONException e) {
                    if (logger.isDebugEnabled()) {
                        throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(this.responseAsString).toString(), e);
                    }
                    throw new TwitterException(e.getMessage(), e);
                }
            } finally {
                if (0 != 0) {
                    try {
                        reader.close();
                    } catch (IOException e2) {
                    }
                }
                disconnectForcibly();
            }
        }
        return this.jsonArray;
    }

    public Reader asReader() {
        try {
            return new BufferedReader(new InputStreamReader(this.f7896is, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return new InputStreamReader(this.f7896is);
        }
    }

    private void disconnectForcibly() {
        try {
            disconnect();
        } catch (Exception e) {
        }
    }

    public String toString() {
        return new StringBuffer().append("HttpResponse{statusCode=").append(this.statusCode).append(", responseAsString='").append(this.responseAsString).append('\'').append(", is=").append(this.f7896is).append(", streamConsumed=").append(this.streamConsumed).append('}').toString();
    }
}
