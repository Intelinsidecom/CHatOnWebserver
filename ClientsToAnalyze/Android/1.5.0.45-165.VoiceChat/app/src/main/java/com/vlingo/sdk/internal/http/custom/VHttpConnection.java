package com.vlingo.sdk.internal.http.custom;

import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.http.URL;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.ConnectionResult;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class VHttpConnection {
    private static Logger log = Logger.getLogger(VHttpConnection.class);
    private int ivChunkSize = 1000;
    protected VStreamConnection ivCon;
    private HttpInteraction m_HttpInteraction;
    private URL m_URL;

    public VHttpConnection(URL url) {
        this.m_URL = url;
    }

    public void open() throws IOException {
        this.ivCon = VConnectionFactory.createConnection(this.m_URL);
        if (this.ivCon == null) {
            throw new RuntimeException("Connection factory returned null");
        }
        if (getConnectionDetails().connectionType != 0) {
            primeConnection();
        }
    }

    public boolean isOpen() {
        return this.ivCon != null && this.ivCon.isOpen();
    }

    public ConnectionResult getConnectionDetails() {
        return this.ivCon.getConnectionDetails();
    }

    public void setChunkSize(int val) {
        this.ivChunkSize = val;
    }

    public int getChunkSize() {
        return this.ivChunkSize;
    }

    public DataOutputStream getOutputStream(HttpRequest request) throws IOException {
        return this.ivCon.getOutputStream();
    }

    public DataInputStream getInputStream(HttpResponse response) throws IOException {
        return this.ivCon.getInputStream();
    }

    private void primeConnection() throws IOException {
        log.debug("priming connection");
        HttpInteraction dhi = new HttpInteraction(this);
        HttpRequest request = dhi.getRequest();
        request.setPath("/voicepad/sr");
        request.setMethod(HttpUtil.METHOD_HEAD);
        request.setHeader(HttpUtil.HEADER_CONNECTION, HttpUtil.VAL_KEEP_ALIVE);
        request.finish();
        HttpResponse response = dhi.getResponse();
        InputStream in = response.getInputStream();
        while (in.read() != -1) {
        }
    }

    public HttpInteraction openInteraction(String path) throws IOException {
        if (this.m_HttpInteraction != null) {
            throw new IOException("New HTTP interaction attempted on non-keep-alive connection");
        }
        this.m_HttpInteraction = new HttpInteraction(this);
        this.m_HttpInteraction.getRequest().setPath(path);
        this.m_HttpInteraction.getRequest().setHeader(HttpUtil.HEADER_TRANSFER_ENCODING, HttpUtil.VAL_CHUNKED);
        return this.m_HttpInteraction;
    }

    public String getHost() {
        return this.m_URL.host;
    }

    public int getPort() {
        return this.m_URL.port;
    }

    public void close() throws IOException {
        if (this.ivCon != null) {
            try {
                this.ivCon.close();
            } catch (Exception e) {
            }
        }
    }

    void notifyRequestDone(HttpRequest request) throws IOException {
    }

    void notifyResponseDone(HttpResponse response) throws IOException {
    }

    public VStreamConnection getVStreamConnection() {
        return this.ivCon;
    }

    public HttpInteraction getHttpInteraction() {
        return this.m_HttpInteraction;
    }
}
