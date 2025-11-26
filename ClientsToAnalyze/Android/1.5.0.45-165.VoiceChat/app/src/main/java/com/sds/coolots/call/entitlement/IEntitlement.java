package com.sds.coolots.call.entitlement;

import android.content.Context;

/* loaded from: classes.dex */
public interface IEntitlement {
    boolean canICheckDirect(Context context);

    void checkEntitlement(IEntitlementResultListener iEntitlementResultListener, IEntitlementHangupListener iEntitlementHangupListener);

    boolean checkEntitlementDirect(Context context);

    void dispose();

    int getTimerDuration();

    boolean isWifiOnlyMode();
}
