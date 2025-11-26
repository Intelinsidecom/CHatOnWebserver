package com.sds.coolots.call.entitlement;

/* loaded from: classes.dex */
public interface IEntitlementResultListener {
    public static final int RESULT_TYPE_IMPOSSIBLE = 2;
    public static final int RESULT_TYPE_IMPOSSIBLE_WIFIONLY = 5;
    public static final int RESULT_TYPE_NETWORK_ERROR = 3;
    public static final int RESULT_TYPE_NONE = 0;
    public static final int RESULT_TYPE_POSSIBLE = 1;
    public static final int RESULT_TYPE_START_ACCESS_URL = 4;

    void onReceiveEntitlementResult(int i);
}
