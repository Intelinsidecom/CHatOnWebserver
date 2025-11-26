package com.vlingo.sdk.internal.recognizer.sr3;

import com.vlingo.sdk.internal.http.custom.MPOutputStream;
import com.vlingo.sdk.internal.http.custom.VHttpConnection;
import com.vlingo.sdk.internal.recognizer.asr.ASRRequest;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class HttpConnectionAdapter {
    public static String ivBoundary = ASRRequest.BOUNDRY;
    protected int ivRequestID;

    public abstract void close() throws IOException;

    public abstract void finishRequest() throws IOException;

    public abstract void finishResponse() throws IOException;

    public abstract VHttpConnection getConnection();

    public abstract InputStream getIn() throws IOException;

    public abstract MPOutputStream getOut() throws IOException;

    public abstract String getResponseHeaderField(int i) throws IOException;

    public abstract String getResponseHeaderFieldKey(int i) throws IOException;

    public abstract void setRequestHeader(String str, String str2) throws IOException;

    public HttpConnectionAdapter(int requestID) throws IOException {
        this.ivRequestID = requestID;
    }

    public int getRequestID() {
        return this.ivRequestID;
    }
}
