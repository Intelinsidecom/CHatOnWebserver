package com.vlingo.sdk.internal.net;

import com.vlingo.sdk.internal.http.custom.HttpRequest;
import com.vlingo.sdk.internal.http.custom.HttpResponse;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public interface HttpConnection extends Connection {
    void close() throws IOException;

    String getFile();

    String getHeaderField(int i);

    String getHeaderFieldKey(int i) throws IOException;

    String getHost();

    int getLength();

    int getResponseCode();

    InputStream openDataInputStream() throws IOException;

    DataOutputStream openDataOutputStream() throws IOException;

    InputStream openInputStream() throws IOException;

    void setRequestMethod(String str);

    void setRequestProperty(String str, String str2);

    void startRequest(HttpRequest httpRequest);

    void startResponse(HttpResponse httpResponse);
}
