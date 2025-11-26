package com.vlingo.sdk.internal.http.custom;

import com.coolots.sso.util.ChatONVAPII;
import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.logging.Logger;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class HttpRequest {
    private static Logger log = Logger.getLogger(HttpRequest.class);
    private DataOutputStream ivClientDout;
    private OutputStream ivClientOut;
    private HttpInteraction ivInteraction;
    private String ivPath;
    private boolean ivFinished = false;
    private boolean ivHeadersSent = false;
    private Hashtable<Object, Object> ivHeaders = new Hashtable<>();
    private String ivMethod = HttpUtil.METHOD_POST;

    public HttpRequest(HttpInteraction interaction) {
        if (interaction == null) {
            throw new IllegalArgumentException("interaction may not be null");
        }
        this.ivInteraction = interaction;
        String host = interaction.getHTTPConnection().getHost();
        int port = interaction.getHTTPConnection().getPort();
        this.ivHeaders.put("Host", String.valueOf(host) + ChatONVAPII.USERID_DELEMETER + port);
        this.ivHeaders.put(HttpUtil.HEADER_USER_AGENT, "Vlingo HttpClient 2.0");
    }

    public void setPath(String path) {
        checkHeaderSent();
        this.ivPath = path;
    }

    public String getPath() {
        return this.ivPath;
    }

    public void setMethod(String val) {
        checkHeaderSent();
        this.ivMethod = val;
    }

    public String getMethod() {
        return this.ivMethod;
    }

    public boolean isFinished() {
        return this.ivFinished;
    }

    private void checkFinished() {
        if (this.ivFinished) {
            throw new RuntimeException("HttpRequest is closed");
        }
    }

    private void checkHeaderSent() {
        if (this.ivHeadersSent) {
            throw new RuntimeException("Headers already sent, too late to specify this information");
        }
    }

    private void ensureHeadersSent() throws IOException {
        if (!this.ivHeadersSent) {
            DataOutputStream dout = this.ivInteraction.getHTTPConnection().getOutputStream(this);
            if (this.ivPath == null) {
                throw new RuntimeException("Path is null");
            }
            initOutputStream(dout);
        }
    }

    private void initOutputStream(DataOutputStream out) throws IOException {
        String transferCoding = (String) this.ivHeaders.get(HttpUtil.HEADER_TRANSFER_ENCODING);
        if (transferCoding != null && transferCoding.equalsIgnoreCase(HttpUtil.VAL_CHUNKED)) {
            this.ivClientOut = new ChunkedOutputStream(out);
            this.ivClientDout = new DataOutputStream(this.ivClientOut);
        } else {
            this.ivClientOut = out;
            this.ivClientDout = out;
        }
    }

    public void setHeader(String name, String value) {
        checkHeaderSent();
        this.ivHeaders.put(name, value);
    }

    public DataOutputStream getOutputStream() throws IOException {
        ensureHeadersSent();
        return this.ivClientDout;
    }

    public void finish() throws IOException {
        log.debug("finish");
        checkFinished();
        ensureHeadersSent();
        if (this.ivClientOut instanceof ChunkedOutputStream) {
            ((ChunkedOutputStream) this.ivClientOut).writeLastChunk();
        }
        this.ivFinished = true;
        this.ivInteraction.getHTTPConnection().notifyRequestDone(this);
    }

    public Hashtable<?, ?> sendHeaders() {
        return this.ivHeaders;
    }
}
