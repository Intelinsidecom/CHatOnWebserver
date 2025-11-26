package com.nuance.nmsp.client.sdk.components.resource.common;

/* loaded from: classes.dex */
public interface ManagerListener {
    public static final short NMSP_REMOTE_DISCONNECT_CRITICAL_ERROR = 3;
    public static final short NMSP_REMOTE_DISCONNECT_ENDPOINT_EXCEPTION = 6;
    public static final short NMSP_REMOTE_DISCONNECT_MAXAUDIO_PERSESSION = 7;
    public static final short NMSP_REMOTE_DISCONNECT_MAXBYTE_PERAUDIO = 8;
    public static final short NMSP_REMOTE_DISCONNECT_NORMAL = 0;
    public static final short NMSP_REMOTE_DISCONNECT_PING_TIME_OUT = 4;
    public static final short NMSP_REMOTE_DISCONNECT_SERVER_SHUTDOWN = 2;
    public static final short NMSP_REMOTE_DISCONNECT_SERVER_UNAVAILABLE = 5;
    public static final short NMSP_REMOTE_DISCONNECT_TIMEOUT = 1;
    public static final short NMSP_REMOTE_DISCONNECT_UNKNOWN = 9;

    void connected(String str, Resource resource);

    void connectionFailed(Resource resource);

    void disconnected(Resource resource, short s);
}
