package com.vlingo.sdk.internal.http;

import android.util.Log;
import com.vlingo.sdk.internal.http.cookies.CookieHandler;
import com.vlingo.sdk.internal.http.cookies.CookieJar;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.HttpConnection;
import com.vlingo.sdk.internal.recognizer.ClientMeta;
import com.vlingo.sdk.internal.recognizer.SoftwareMeta;
import com.vlingo.sdk.internal.util.CompressUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class HttpRequest {
    protected static final int DEFAULT_RETRY_COUNT = 0;
    protected static final Logger log = Logger.getLogger(HttpRequest.class);
    protected HttpCallback callback;
    private volatile Object cookie;
    protected byte[] data;
    private volatile long startTime;
    protected String taskName;
    protected String url;
    private volatile boolean flagForRetry = false;
    private volatile int countRetries = 0;
    private volatile boolean m_Canceled = false;
    protected volatile String method = HttpUtil.METHOD_POST;
    protected volatile Hashtable<String, String> cookies = null;
    protected volatile Hashtable<String, String> extraHeaders = null;
    protected volatile ClientMeta client = ClientMeta.getInstance();
    protected volatile SoftwareMeta software = SoftwareMeta.getInstance();
    protected volatile int timeout = 0;
    protected volatile int maxRetry = 0;
    protected volatile boolean gzipPostData = false;

    public static synchronized HttpRequest createRequest(String taskName, HttpCallback callback, String url) {
        return createRequest(taskName, callback, url, null);
    }

    public static synchronized HttpRequest createRequest(String taskName, HttpCallback callback, String url, byte[] data) {
        HttpRequest request;
        request = new HttpRequest(taskName, callback, url, data);
        return request;
    }

    protected HttpRequest(String taskName, HttpCallback callback, String url, byte[] data) {
        this.taskName = taskName;
        this.callback = callback;
        this.url = url;
        this.data = data;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void cancel() {
        this.m_Canceled = true;
        HttpManager.getInstance().cancelRequest(this);
    }

    public void start() {
        HttpManager.getInstance().doRequestNow(this);
    }

    public void schedule() {
        HttpManager.getInstance().doBackgroundRequest(this, false, false);
    }

    public void schedule(long delay, boolean highPriority, boolean ordered) {
        HttpManager.getInstance().doBackgroundRequestLater(this, delay, highPriority, ordered);
    }

    boolean isRetry() {
        return this.flagForRetry;
    }

    HttpCallback getCallback() {
        return this.callback;
    }

    int getTimeout() {
        return this.timeout;
    }

    protected HttpResponse fetchResponse() {
        log.info("** Executing HttpRequest: " + getTaskName() + " url=" + this.url + " cookies=" + this.cookies + " extra-headers=" + this.extraHeaders);
        this.flagForRetry = false;
        this.startTime = System.currentTimeMillis();
        HttpConnection hc = null;
        InputStream inputstream = null;
        DataOutputStream dos = null;
        byte[] respData = (byte[]) null;
        CookieJar responseCookies = null;
        int responseCode = -1;
        try {
            try {
            } catch (Exception ex) {
                log.error(getClass().getCanonicalName(), Log.getStackTraceString(ex));
                if (0 != 0) {
                    try {
                        inputstream.close();
                    } catch (Throwable t) {
                        log.error(getClass().getCanonicalName(), Log.getStackTraceString(t));
                    }
                }
                if (0 != 0) {
                    try {
                        dos.close();
                    } catch (Throwable t2) {
                        log.error(getClass().getCanonicalName(), Log.getStackTraceString(t2));
                    }
                }
                if (0 != 0) {
                    try {
                        hc.close();
                    } catch (Throwable t3) {
                        log.error(getClass().getCanonicalName(), Log.getStackTraceString(t3));
                    }
                }
            }
            if (this.m_Canceled) {
                throw new IOException("Cancelled");
            }
            HttpConnection hc2 = HttpUtil.newHttpConnection(this.method, this.url, false, this.cookies, this.extraHeaders, this.client, this.software);
            log.debug("** Getting new http connection.  method " + this.method + " hc " + hc2);
            if (this.m_Canceled) {
                throw new IOException("Cancelled");
            }
            if (this.method.equals(HttpUtil.METHOD_POST) && this.data != null) {
                log.debug("** postData=" + new String(this.data, "UTF-8"));
                if (this.gzipPostData) {
                    log.debug("** GZip compressing post data...");
                    byte[] compressedData = CompressUtils.deflate(this.data);
                    if (compressedData != null) {
                        log.debug("Adding gzip content-encoding header");
                        hc2.setRequestProperty("Content-Encoding", "deflate");
                        this.data = compressedData;
                    }
                }
                hc2.setRequestProperty(HttpUtil.HEADER_CONTENT_LENGTH, String.valueOf(this.data.length));
                hc2.startRequest(null);
                dos = hc2.openDataOutputStream();
                if (this.m_Canceled) {
                    throw new IOException("Cancelled");
                }
                dos.write(this.data);
            }
            responseCode = hc2.getResponseCode();
            int length = hc2.getLength();
            if (this.m_Canceled) {
                throw new IOException("Cancelled");
            }
            log.debug("** len: " + length);
            log.debug("** response code: " + responseCode);
            hc2.startResponse(null);
            InputStream inputstream2 = hc2.openInputStream();
            if (inputstream2 == null) {
                throw new IOException("InputStream does not exist (check response code for error)");
            }
            if (length != -1) {
                respData = new byte[length];
                int offset = 0;
                do {
                    int bytesRead = inputstream2.read(respData, offset, length - offset);
                    if (this.m_Canceled) {
                        throw new IOException("Cancelled");
                    }
                    if (bytesRead == -1) {
                        break;
                    }
                    offset += bytesRead;
                } while (length > offset);
            } else {
                respData = HttpUtil.readData(inputstream2);
            }
            if (this.m_Canceled) {
                throw new IOException("Cancelled");
            }
            responseCookies = CookieHandler.extractCookies(hc2);
            if (inputstream2 != null) {
                try {
                    inputstream2.close();
                } catch (Throwable t4) {
                    log.error(getClass().getCanonicalName(), Log.getStackTraceString(t4));
                }
            }
            if (dos != null) {
                try {
                    dos.close();
                } catch (Throwable t5) {
                    log.error(getClass().getCanonicalName(), Log.getStackTraceString(t5));
                }
            }
            if (hc2 != null) {
                try {
                    hc2.close();
                } catch (Throwable t6) {
                    log.error(getClass().getCanonicalName(), Log.getStackTraceString(t6));
                }
            }
            if (respData != null) {
                log.debug("data len: " + respData.length);
                log.debug("data: " + HttpUtil.byteArrayToString(respData));
            } else {
                log.debug("data is null");
            }
            log.debug("** finished");
            return new HttpResponse(responseCode, respData, responseCookies);
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputstream.close();
                } catch (Throwable t7) {
                    log.error(getClass().getCanonicalName(), Log.getStackTraceString(t7));
                }
            }
            if (0 != 0) {
                try {
                    dos.close();
                } catch (Throwable t8) {
                    log.error(getClass().getCanonicalName(), Log.getStackTraceString(t8));
                }
            }
            if (0 != 0) {
                try {
                    hc.close();
                    throw th;
                } catch (Throwable t9) {
                    log.error(getClass().getCanonicalName(), Log.getStackTraceString(t9));
                    throw th;
                }
            }
            throw th;
        }
    }

    protected void notifyWillExecute() {
        log.debug("notifyWillExecute");
        this.callback.onWillExecuteRequest(this);
    }

    protected void notifyCancelled() {
        log.debug("notifyCancelled");
        this.callback.onCancelled(this);
    }

    protected void notifyFailure() {
        log.debug("notifyFailure");
        this.callback.onFailure(this);
    }

    protected boolean notifyTimeout() {
        log.debug("notifyTimeout");
        return this.callback.onTimeout(this);
    }

    protected void notifyResponse(HttpResponse response) {
        log.debug("notifyResponse");
        this.callback.onResponse(this, response);
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - this.startTime;
    }

    public void markRetry() {
        int i = this.countRetries;
        this.countRetries = i + 1;
        if (i < this.maxRetry) {
            this.flagForRetry = true;
        } else {
            this.flagForRetry = false;
            notifyFailure();
        }
    }

    public boolean reachedMaxRetryCount() {
        return this.countRetries >= this.maxRetry;
    }

    public int getMaxRetry() {
        return this.maxRetry;
    }

    public Object getCookie() {
        return this.cookie;
    }

    public void setCookie(Object cookie) {
        this.cookie = cookie;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setCookies(Hashtable<String, String> cookies) {
        this.cookies = cookies;
    }

    public void setExtraHeaders(Hashtable<String, String> extraHeaders) {
        this.extraHeaders = extraHeaders;
    }

    public void setClientMeta(ClientMeta client) {
        this.client = client;
    }

    public void setSoftwareMeta(SoftwareMeta software) {
        this.software = software;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setMaxRetry(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    public boolean isGzipPostDataEnabled() {
        return this.gzipPostData;
    }

    public void setGzipPostData(boolean gzipPostData) {
        this.gzipPostData = gzipPostData;
    }
}
