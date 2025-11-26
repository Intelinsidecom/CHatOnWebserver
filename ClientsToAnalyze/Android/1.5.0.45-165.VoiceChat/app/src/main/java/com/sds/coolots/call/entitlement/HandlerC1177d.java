package com.sds.coolots.call.entitlement;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.sds.coolots.call.entitlement.d */
/* loaded from: classes.dex */
class HandlerC1177d extends Handler {

    /* renamed from: a */
    final /* synthetic */ EntitlementController f2419a;

    /* renamed from: b */
    private boolean f2420b = false;

    /* renamed from: c */
    private IEntitlementHangupListener f2421c;

    public HandlerC1177d(EntitlementController entitlementController, IEntitlementHangupListener iEntitlementHangupListener) {
        this.f2419a = entitlementController;
        this.f2421c = iEntitlementHangupListener;
    }

    /* renamed from: a */
    public void m2219a() {
        this.f2420b = true;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f2420b) {
            return;
        }
        this.f2419a.m2201a("DuringCallTimerHandler");
        this.f2419a.f2407b.checkEntitlement(null, this.f2421c);
        super.handleMessage(message);
    }
}
