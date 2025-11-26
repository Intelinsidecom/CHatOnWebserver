package com.vlingo.sdk.internal.http.custom;

import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.logging.Logger;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class HttpResponse {
    private InputStream ivClientDin;
    private String ivCode;
    private HttpInteraction ivInteraction;
    private String ivMessage;
    private String ivProtocol;
    private Logger log = Logger.getLogger(HttpResponse.class);
    private boolean ivReadHeaders = false;
    private Hashtable<String, String> ivHeaders = new Hashtable<>();

    public HttpResponse(HttpInteraction interaction) {
        this.ivInteraction = interaction;
    }

    public String getCode() throws IOException, NumberFormatException {
        ensureHeaders();
        return this.ivCode;
    }

    public String getMessage() throws IOException, NumberFormatException {
        ensureHeaders();
        return this.ivMessage;
    }

    public String getProtocol() throws IOException, NumberFormatException {
        ensureHeaders();
        return this.ivProtocol;
    }

    public Enumeration<?> getHeaderNames() throws IOException, NumberFormatException {
        ensureHeaders();
        return this.ivHeaders.keys();
    }

    public String getHeaderValue(String name) throws IOException, NumberFormatException {
        ensureHeaders();
        return this.ivHeaders.get(name);
    }

    private void ensureHeaders() throws IOException, NumberFormatException {
        if (!this.ivReadHeaders) {
            DataInputStream din = this.ivInteraction.getHTTPConnection().getInputStream(this);
            setupInputStream(din);
        }
    }

    private void setupInputStream(InputStream in) throws NumberFormatException, IOException {
        String transferEncoding = this.ivHeaders.get(HttpUtil.HEADER_TRANSFER_ENCODING);
        if (transferEncoding == null) {
            String contentLength = this.ivHeaders.get(HttpUtil.HEADER_CONTENT_LENGTH);
            if (contentLength != null) {
                int length = Integer.parseInt(contentLength);
                this.ivClientDin = new LimitInputStream(in, length);
                return;
            } else {
                this.ivClientDin = in;
                return;
            }
        }
        this.ivClientDin = new ChunkedInputStream(in);
    }

    public InputStream getInputStream() throws IOException {
        ensureHeaders();
        return this.ivClientDin;
    }

    public void finish() throws IOException {
        this.log.debug("finish");
        this.ivInteraction.getHTTPConnection().notifyResponseDone(this);
    }

    public Hashtable<String, String> readHeaders() {
        return this.ivHeaders;
    }
}
