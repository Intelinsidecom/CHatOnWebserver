package com.vlingo.sdk.internal.recognizer.sr3;

import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.http.URL;
import com.vlingo.sdk.internal.http.custom.HttpInteraction;
import com.vlingo.sdk.internal.http.custom.HttpRequest;
import com.vlingo.sdk.internal.http.custom.MPOutputStream;
import com.vlingo.sdk.internal.http.custom.MultiplexHttpConnection;
import com.vlingo.sdk.internal.http.custom.VHttpConnection;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.ConnectionProvider;
import com.vlingo.sdk.internal.recognizer.ClientMeta;
import com.vlingo.sdk.internal.recognizer.SRContext;
import com.vlingo.sdk.internal.recognizer.SoftwareMeta;
import com.vlingo.sdk.internal.vlservice.VLServiceUtil;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class ChunkingHttpConnection extends HttpConnectionAdapter {
    private static Logger log = Logger.getLogger(ChunkingHttpConnection.class);
    private VHttpConnection ivCon;
    private InputStream ivDin;
    private DataOutputStream ivDout;
    private HttpInteraction ivInteraction;
    private MPOutputStream ivMPOut;

    ChunkingHttpConnection(VHttpConnection con, HttpInteraction interaction, int requestID) throws IOException {
        super(requestID);
        this.ivCon = con;
        this.ivInteraction = interaction;
    }

    public static ChunkingHttpConnection newConnection(VHttpConnection connection, String method, String path, ClientMeta client, SoftwareMeta software, Hashtable<String, String> cookies, int clientRequestId, SRContext srContext) throws IOException {
        return initConnection(connection, method, path, client, software, cookies, clientRequestId, srContext);
    }

    public static ChunkingHttpConnection newConnection(ConnectionProvider connectionProvider, String method, URL url, ClientMeta client, SoftwareMeta software, Hashtable<String, String> cookies, int clientRequestId, SRContext srContext) throws IOException {
        VHttpConnection hc = new VHttpConnection(url);
        hc.open();
        return initConnection(hc, method, url.path, client, software, cookies, clientRequestId, srContext);
    }

    private static ChunkingHttpConnection initConnection(VHttpConnection connection, String method, String path, ClientMeta client, SoftwareMeta software, Hashtable<String, String> cookies, int clientRequestId, SRContext srContext) throws IOException {
        log.debug("** initConnection path=" + path);
        HttpInteraction it = connection.openInteraction(path);
        HttpRequest request = it.getRequest();
        request.setMethod(method);
        request.setHeader(HttpUtil.HEADER_CONNECTION, HttpUtil.VAL_CLOSE);
        Hashtable<String, String> headers = new Hashtable<>();
        VLServiceUtil.addStandardVlingoHttpHeaders(headers, client, software, srContext);
        Hashtable<String, String> cookies2 = VLServiceUtil.addVLServiceCookies(cookies, connection.getHost(), request.getPath());
        Enumeration<?> hEnum = headers.keys();
        while (hEnum.hasMoreElements()) {
            String name = hEnum.nextElement();
            request.setHeader(name, headers.get(name));
        }
        String cookieStr = HttpUtil.getCookies(cookies2);
        if (cookieStr.length() > 0) {
            request.setHeader(HttpUtil.HEADER_COOKIE, cookieStr);
        }
        return new ChunkingHttpConnection(connection, it, clientRequestId);
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public String getResponseHeaderField(int index) throws IOException, NumberFormatException {
        String key = getResponseHeaderFieldKey(index);
        if (key == null) {
            return null;
        }
        return this.ivInteraction.getResponse().getHeaderValue(key);
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public String getResponseHeaderFieldKey(int index) throws IOException, NumberFormatException {
        Enumeration<?> hEnum = this.ivInteraction.getResponse().getHeaderNames();
        String field = null;
        for (int i = 0; i <= index; i++) {
            if (!hEnum.hasMoreElements()) {
                return null;
            }
            field = (String) hEnum.nextElement();
        }
        return field;
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public void setRequestHeader(String name, String value) throws IOException {
        this.ivInteraction.getRequest().setHeader(name, value);
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public MPOutputStream getOut() throws IOException {
        if (this.ivMPOut == null) {
            log.debug("Open data output stream");
            this.ivDout = this.ivInteraction.getRequest().getOutputStream();
            this.ivMPOut = new MPOutputStream(this.ivDout, ivBoundary);
        }
        return this.ivMPOut;
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public InputStream getIn() throws IOException {
        if (this.ivDin == null) {
            log.debug("Open data input stream");
            this.ivDin = this.ivInteraction.getResponse().getInputStream();
        }
        return this.ivDin;
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public void close() throws IOException {
        log.debug("closing connection");
        if (this.ivDin != null) {
            try {
                this.ivDin.close();
            } catch (Exception e) {
            }
        }
        if (this.ivMPOut != null) {
            try {
                this.ivMPOut.close();
            } catch (Exception e2) {
            }
        }
        if (this.ivDout != null) {
            try {
                this.ivDout.close();
            } catch (Exception e3) {
            }
        }
        if (this.ivCon != null) {
            try {
                this.ivCon.close();
            } catch (Exception e4) {
            }
        }
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public void finishRequest() throws IOException {
        this.ivInteraction.getRequest().finish();
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public void finishResponse() throws IOException {
        this.ivInteraction.getResponse().finish();
        if (!(this.ivCon instanceof MultiplexHttpConnection)) {
            close();
        }
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public VHttpConnection getConnection() {
        return this.ivCon;
    }
}
