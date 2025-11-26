package com.csli.eztalky;

/* loaded from: classes.dex */
public interface CSListener {
    public static final int ERROR_BAD_NETWORK = 3;
    public static final int ERROR_CONNECT_SERVER = 1;
    public static final int ERROR_SERVER_UNKNOWN = 9998;
    public static final int ERROR_TRANS_SERVER = 2;
    public static final int ERROR_UNKNOWN = 9999;

    void onError(int i);
}
