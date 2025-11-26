package com.vlingo.sdk.internal.recognizer.sr3;

import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.http.custom.MPOutputStream;
import com.vlingo.sdk.internal.http.custom.VHttpConnection;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.ConnectionProvider;
import com.vlingo.sdk.internal.net.HttpConnection;
import com.vlingo.sdk.internal.recognizer.ClientMeta;
import com.vlingo.sdk.internal.recognizer.SRContext;
import com.vlingo.sdk.internal.recognizer.SoftwareMeta;
import com.vlingo.sdk.internal.vlservice.VLServiceUtil;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class StandardHttpConnection extends HttpConnectionAdapter {
    private static Logger log = Logger.getLogger(StandardHttpConnection.class);
    private HttpConnection ivCon;
    private InputStream ivDin;
    private DataOutputStream ivDout;
    private MPOutputStream ivMPOut;

    StandardHttpConnection(HttpConnection con, int requestID) throws IOException {
        super(requestID);
        this.ivCon = con;
    }

    public static HttpConnectionAdapter newConnection(ConnectionProvider connectionProvider, String method, String url, ClientMeta client, SoftwareMeta software, Hashtable<String, String> cookies, int clientRequestId, SRContext srContext) throws IOException {
        Hashtable<String, String> headers = new Hashtable<>();
        VLServiceUtil.addStandardVlingoHttpHeaders(headers, client, software, srContext);
        HttpConnection hc = HttpUtil.newHttpConnection(connectionProvider, method, url, false, VLServiceUtil.addVLServiceCookies(cookies, HttpUtil.getDomain(url), HttpUtil.getPath(url)), headers, client, software);
        return new StandardHttpConnection(hc, clientRequestId);
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public String getResponseHeaderField(int index) throws IOException {
        return this.ivCon.getHeaderField(index);
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public String getResponseHeaderFieldKey(int index) throws IOException {
        return this.ivCon.getHeaderFieldKey(index);
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public int getRequestID() {
        return this.ivRequestID;
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public void setRequestHeader(String name, String value) throws IOException {
        this.ivCon.setRequestProperty(name, value);
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public MPOutputStream getOut() throws IOException {
        log.info("In getOut");
        if (this.ivMPOut == null) {
            log.info("Open data output stream ivcon " + this.ivCon);
            this.ivDout = this.ivCon.openDataOutputStream();
            log.info("Got ivDout " + this.ivDout);
            this.ivMPOut = new MPOutputStream(this.ivDout, ivBoundary);
        }
        return this.ivMPOut;
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public InputStream getIn() throws IOException {
        if (this.ivDin == null) {
            log.debug("Open data input stream");
            this.ivDin = this.ivCon.openDataInputStream();
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
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public void finishResponse() throws IOException {
        close();
    }

    @Override // com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter
    public VHttpConnection getConnection() {
        return null;
    }
}
