package com.vlingo.sdk.internal.http.custom;

import android.util.Log;
import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.ConnectionManager;
import com.vlingo.sdk.internal.net.ConnectionResult;
import com.vlingo.sdk.internal.net.HttpConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AndroidVStreamConnection implements HttpConnection, VStreamConnection {
    private static Logger log = Logger.getLogger(AndroidVStreamConnection.class);
    private HttpURLConnection m_Connection;
    private DataInputStream m_DataInputStream;
    private DataOutputStream m_DataOutputStream;
    private Boolean m_InputStatus;
    private InputStream m_InputStream;
    private Boolean m_OutputStatus;
    private OutputStream m_OutputStream;
    private URL m_URL;

    public AndroidVStreamConnection(URL url) throws IOException {
        this.m_Connection = null;
        this.m_URL = null;
        this.m_InputStream = null;
        this.m_OutputStream = null;
        this.m_DataInputStream = null;
        this.m_DataOutputStream = null;
        this.m_InputStatus = null;
        this.m_OutputStatus = null;
        if (url == null) {
            throw new IOException("url is null");
        }
        try {
            this.m_URL = url;
            this.m_Connection = (HttpURLConnection) this.m_URL.openConnection();
            this.m_Connection.setDoInput(true);
            this.m_Connection.setDoOutput(true);
            if (ConnectionManager.isSlowNetwork()) {
                this.m_Connection.setReadTimeout(ConnectionManager.DEFAULT_TIMEOUT_SLOW_NETWORK);
            } else {
                this.m_Connection.setReadTimeout(20000);
            }
        } catch (Exception e) {
            log.error(getClass().getCanonicalName(), Log.getStackTraceString(e));
        }
    }

    public AndroidVStreamConnection(String url) throws IOException {
        this(new URL(url));
    }

    public AndroidVStreamConnection(com.vlingo.sdk.internal.http.URL v_url) throws IOException {
        this(new URL(v_url.getProtocol(), v_url.host, v_url.port, v_url.path));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b A[Catch: all -> 0x0069, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000f, B:9:0x0013, B:10:0x001b, B:12:0x001f, B:13:0x0027, B:15:0x002b, B:16:0x0033, B:18:0x0039, B:19:0x0041, B:20:0x0054, B:32:0x0093, B:30:0x0080, B:28:0x006d, B:23:0x0057), top: B:38:0x0003, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027 A[Catch: all -> 0x0069, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000f, B:9:0x0013, B:10:0x001b, B:12:0x001f, B:13:0x0027, B:15:0x002b, B:16:0x0033, B:18:0x0039, B:19:0x0041, B:20:0x0054, B:32:0x0093, B:30:0x0080, B:28:0x006d, B:23:0x0057), top: B:38:0x0003, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033 A[Catch: all -> 0x0069, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000f, B:9:0x0013, B:10:0x001b, B:12:0x001f, B:13:0x0027, B:15:0x002b, B:16:0x0033, B:18:0x0039, B:19:0x0041, B:20:0x0054, B:32:0x0093, B:30:0x0080, B:28:0x006d, B:23:0x0057), top: B:38:0x0003, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039 A[Catch: all -> 0x0069, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000f, B:9:0x0013, B:10:0x001b, B:12:0x001f, B:13:0x0027, B:15:0x002b, B:16:0x0033, B:18:0x0039, B:19:0x0041, B:20:0x0054, B:32:0x0093, B:30:0x0080, B:28:0x006d, B:23:0x0057), top: B:38:0x0003, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0013 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.vlingo.sdk.internal.net.HttpConnection, com.vlingo.sdk.internal.http.custom.VStreamConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void close() throws java.io.IOException {
        /*
            r5 = this;
            java.net.URL r2 = r5.m_URL
            monitor-enter(r2)
            java.io.DataInputStream r1 = r5.m_DataInputStream     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto Lf
            java.io.DataInputStream r1 = r5.m_DataInputStream     // Catch: java.io.IOException -> L56 java.lang.Throwable -> L69
            r1.close()     // Catch: java.io.IOException -> L56 java.lang.Throwable -> L69
            r1 = 0
            r5.m_DataInputStream = r1     // Catch: java.io.IOException -> L56 java.lang.Throwable -> L69
        Lf:
            java.io.InputStream r1 = r5.m_InputStream     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L1b
            java.io.InputStream r1 = r5.m_InputStream     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c
            r1.close()     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c
            r1 = 0
            r5.m_InputStream = r1     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c
        L1b:
            java.io.DataOutputStream r1 = r5.m_DataOutputStream     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L27
            java.io.DataOutputStream r1 = r5.m_DataOutputStream     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L7f
            r1.close()     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L7f
            r1 = 0
            r5.m_DataOutputStream = r1     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L7f
        L27:
            java.io.OutputStream r1 = r5.m_OutputStream     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L33
            java.io.OutputStream r1 = r5.m_OutputStream     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L92
            r1.close()     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L92
            r1 = 0
            r5.m_OutputStream = r1     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L92
        L33:
            boolean r1 = r5.isOpen()     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L41
            java.net.HttpURLConnection r1 = r5.m_Connection     // Catch: java.lang.Throwable -> L69
            r1.disconnect()     // Catch: java.lang.Throwable -> L69
            r1 = 0
            r5.m_Connection = r1     // Catch: java.lang.Throwable -> L69
        L41:
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L69
            r5.m_InputStatus = r1     // Catch: java.lang.Throwable -> L69
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L69
            r5.m_OutputStatus = r1     // Catch: java.lang.Throwable -> L69
            java.net.URL r1 = r5.m_URL     // Catch: java.lang.Throwable -> L69
            r1.notifyAll()     // Catch: java.lang.Throwable -> L69
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L69
            return
        L56:
            r0 = move-exception
            com.vlingo.sdk.internal.logging.Logger r1 = com.vlingo.sdk.internal.http.custom.AndroidVStreamConnection.log     // Catch: java.lang.Throwable -> L69
            java.lang.Class r3 = r5.getClass()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = r3.getCanonicalName()     // Catch: java.lang.Throwable -> L69
            java.lang.String r4 = android.util.Log.getStackTraceString(r0)     // Catch: java.lang.Throwable -> L69
            r1.error(r3, r4)     // Catch: java.lang.Throwable -> L69
            goto Lf
        L69:
            r1 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L69
            throw r1
        L6c:
            r0 = move-exception
            com.vlingo.sdk.internal.logging.Logger r1 = com.vlingo.sdk.internal.http.custom.AndroidVStreamConnection.log     // Catch: java.lang.Throwable -> L69
            java.lang.Class r3 = r5.getClass()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = r3.getCanonicalName()     // Catch: java.lang.Throwable -> L69
            java.lang.String r4 = android.util.Log.getStackTraceString(r0)     // Catch: java.lang.Throwable -> L69
            r1.error(r3, r4)     // Catch: java.lang.Throwable -> L69
            goto L1b
        L7f:
            r0 = move-exception
            com.vlingo.sdk.internal.logging.Logger r1 = com.vlingo.sdk.internal.http.custom.AndroidVStreamConnection.log     // Catch: java.lang.Throwable -> L69
            java.lang.Class r3 = r5.getClass()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = r3.getCanonicalName()     // Catch: java.lang.Throwable -> L69
            java.lang.String r4 = android.util.Log.getStackTraceString(r0)     // Catch: java.lang.Throwable -> L69
            r1.error(r3, r4)     // Catch: java.lang.Throwable -> L69
            goto L27
        L92:
            r0 = move-exception
            com.vlingo.sdk.internal.logging.Logger r1 = com.vlingo.sdk.internal.http.custom.AndroidVStreamConnection.log     // Catch: java.lang.Throwable -> L69
            java.lang.Class r3 = r5.getClass()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = r3.getCanonicalName()     // Catch: java.lang.Throwable -> L69
            java.lang.String r4 = android.util.Log.getStackTraceString(r0)     // Catch: java.lang.Throwable -> L69
            r1.error(r3, r4)     // Catch: java.lang.Throwable -> L69
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlingo.sdk.internal.http.custom.AndroidVStreamConnection.close():void");
    }

    @Override // com.vlingo.sdk.internal.http.custom.VStreamConnection
    public ConnectionResult getConnectionDetails() {
        ConnectionResult r = new ConnectionResult();
        r.connectionType = 0;
        r.connection = this;
        return r;
    }

    @Override // com.vlingo.sdk.internal.http.custom.VStreamConnection
    public DataInputStream getInputStream() throws IOException {
        if (!isOpen()) {
            throw new IOException("m_Connection is null");
        }
        synchronized (this.m_Connection) {
            if (this.m_DataInputStream == null) {
                openInputStream();
                if (this.m_InputStream == null) {
                    throw new IOException("m_InputStream is null");
                }
                this.m_DataInputStream = new DataInputStream(this.m_InputStream);
            }
        }
        return this.m_DataInputStream;
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection
    public DataInputStream openDataInputStream() throws IOException {
        return getInputStream();
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection
    public InputStream openInputStream() throws IOException {
        if (!isOpen()) {
            throw new IOException("m_Connection is null");
        }
        synchronized (this.m_URL) {
            if (this.m_InputStream == null) {
                if (this.m_InputStatus == null) {
                    throw new IOException("m_InputStatus is null");
                }
                while (!this.m_InputStatus.booleanValue() && this.m_Connection != null) {
                    try {
                        this.m_URL.wait(this.m_Connection.getReadTimeout());
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
        return this.m_InputStream;
    }

    @Override // com.vlingo.sdk.internal.http.custom.VStreamConnection
    public DataOutputStream getOutputStream() throws IOException {
        if (!isOpen()) {
            throw new IOException("m_Connection is null");
        }
        synchronized (this.m_URL) {
            if (this.m_DataOutputStream == null) {
                if (this.m_OutputStatus == null) {
                    throw new IOException("m_OutputStatus is null");
                }
                while (!this.m_OutputStatus.booleanValue() && this.m_Connection != null) {
                    try {
                        this.m_URL.wait(this.m_Connection.getReadTimeout());
                    } catch (InterruptedException e) {
                    }
                }
                if (this.m_OutputStream == null) {
                    throw new IOException("m_OutputStream is null");
                }
                this.m_DataOutputStream = new DataOutputStream(this.m_OutputStream);
            }
        }
        return this.m_DataOutputStream;
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection
    public DataOutputStream openDataOutputStream() throws IOException {
        return getOutputStream();
    }

    @Override // com.vlingo.sdk.internal.http.custom.VStreamConnection
    public boolean isOpen() {
        return this.m_Connection != null;
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection
    public String getHeaderField(int index) {
        return this.m_Connection.getHeaderField(index);
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection
    public String getHeaderFieldKey(int index) throws IOException {
        return this.m_Connection.getHeaderFieldKey(index);
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection
    public String getHost() {
        return this.m_URL.getHost();
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection
    public int getLength() {
        return this.m_Connection.getContentLength();
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection
    public int getResponseCode() {
        try {
            return this.m_Connection.getResponseCode();
        } catch (IOException e) {
            log.error(getClass().getCanonicalName(), Log.getStackTraceString(e));
            return -1;
        } catch (Exception e2) {
            return -1;
        }
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection
    public void setRequestMethod(String method) throws ProtocolException {
        if (isOpen()) {
            try {
                this.m_Connection.setRequestMethod(method);
                this.m_Connection.setRequestProperty(HttpUtil.HEADER_CONNECTION, "CLOSE");
            } catch (ProtocolException e) {
                log.error(getClass().getCanonicalName(), Log.getStackTraceString(e));
            }
        }
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection
    public void setRequestProperty(String name, String value) {
        if (isOpen()) {
            this.m_Connection.setRequestProperty(name, value);
        }
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection
    public String getFile() {
        return this.m_URL.getPath();
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection, com.vlingo.sdk.internal.http.custom.VStreamConnection
    public void startRequest(HttpRequest request) {
        log.debug("** startRequest " + request);
        try {
            synchronized (this.m_URL) {
                if (request != null) {
                    if (isOpen()) {
                        Hashtable<?, ?> headers = request.sendHeaders();
                        Enumeration<?> iter = headers.keys();
                        while (iter.hasMoreElements()) {
                            String key = (String) iter.nextElement();
                            String value = (String) headers.get(key);
                            this.m_Connection.setRequestProperty(key, value);
                        }
                        this.m_Connection.setChunkedStreamingMode(1024);
                    }
                }
            }
            this.m_OutputStatus = false;
            synchronized (this.m_URL) {
                if (isOpen()) {
                    this.m_OutputStream = this.m_Connection.getOutputStream();
                }
            }
        } catch (Exception e) {
            log.error(getClass().getCanonicalName(), Log.getStackTraceString(e));
        }
        synchronized (this.m_URL) {
            this.m_OutputStatus = true;
            this.m_URL.notifyAll();
        }
    }

    @Override // com.vlingo.sdk.internal.net.HttpConnection, com.vlingo.sdk.internal.http.custom.VStreamConnection
    public void startResponse(HttpResponse response) {
        List<String> cookies;
        log.debug("** startResponse " + response);
        try {
            synchronized (this.m_URL) {
                if (response != null) {
                    if (isOpen()) {
                        Hashtable<String, String> headers = response.readHeaders();
                        log.debug("getHeaderFields");
                        Map<String, List<String>> fields = this.m_Connection.getHeaderFields();
                        log.debug("got header fields");
                        if (fields != null && (cookies = fields.get("set-cookie")) != null) {
                            log.debug("** has set-cookie");
                            String cookieStr = null;
                            Iterator<String> i = cookies.iterator();
                            while (i.hasNext()) {
                                if (cookieStr == null) {
                                    String cookieStr2 = i.next();
                                    cookieStr = cookieStr2;
                                } else {
                                    cookieStr = String.valueOf(cookieStr) + "," + i.next();
                                }
                            }
                            log.debug("** set-cookie: " + cookieStr);
                            headers.put(HttpUtil.HEADER_SET_COOKIE, cookieStr);
                        }
                    }
                }
            }
            this.m_InputStatus = false;
            log.debug("getInputStream");
            synchronized (this.m_URL) {
                if (isOpen()) {
                    this.m_InputStream = this.m_Connection.getInputStream();
                }
            }
        } catch (Exception e) {
            log.error(getClass().getCanonicalName(), Log.getStackTraceString(e));
        }
        synchronized (this.m_URL) {
            this.m_InputStatus = true;
            this.m_URL.notifyAll();
        }
    }
}
