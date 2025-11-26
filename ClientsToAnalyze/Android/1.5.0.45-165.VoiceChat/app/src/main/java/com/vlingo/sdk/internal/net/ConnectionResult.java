package com.vlingo.sdk.internal.net;

/* loaded from: classes.dex */
public class ConnectionResult {
    public boolean isFailure = false;
    public Exception failureException = null;
    public Connection connection = null;
    public String url = "";
    public int connectionType = -1;
    public boolean wifiActive = false;
    public boolean apnUsed = false;
    public long timeToComplete = 0;
    public String connectionTypeString = "";
}
