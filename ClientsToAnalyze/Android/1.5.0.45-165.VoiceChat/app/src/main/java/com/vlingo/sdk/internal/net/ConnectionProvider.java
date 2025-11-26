package com.vlingo.sdk.internal.net;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class ConnectionProvider {
    public abstract ConnectionResult getConnectionWithDetails(String str, int i, boolean z) throws IOException;

    public Connection getConnection(String url, int mode, boolean timeouts) throws IOException {
        ConnectionResult result = getConnectionWithDetails(url, mode, timeouts);
        return result.connection;
    }
}
