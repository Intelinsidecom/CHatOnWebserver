package com.vlingo.sdk.internal.http.custom;

import com.vlingo.sdk.internal.net.ConnectionResult;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public interface VStreamConnection {
    void close() throws IOException;

    ConnectionResult getConnectionDetails();

    DataInputStream getInputStream() throws IOException;

    DataOutputStream getOutputStream() throws IOException;

    boolean isOpen();

    void startRequest(HttpRequest httpRequest);

    void startResponse(HttpResponse httpResponse);
}
