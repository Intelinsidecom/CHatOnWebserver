package com.sds.coolots.call.entitlement;

/* loaded from: classes.dex */
public interface IEntitlementController {
    public static final int ENTITLEMENT_IMPOSSIBLE = 2;
    public static final int ENTITLEMENT_IMPOSSIBLE_WIFIONLYMODE = 3;
    public static final int ENTITLEMENT_NEED_CHECK = 4;
    public static final int ENTITLEMENT_NONE = 0;
    public static final int ENTITLEMENT_POSSIBLE = 1;

    void checkEntitlement(IEntitlementResultListener iEntitlementResultListener);

    int checkEntitlementDirect();

    void dispose();

    boolean isWifiOnlyMode();

    void startTimer(IEntitlementHangupListener iEntitlementHangupListener);
}
