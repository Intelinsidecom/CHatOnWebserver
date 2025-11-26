package com.sds.coolots.call;

import com.sds.coolots.call.entitlement.IEntitlementResultListener;

/* renamed from: com.sds.coolots.call.l */
/* loaded from: classes.dex */
class C1184l implements IEntitlementResultListener {

    /* renamed from: a */
    final /* synthetic */ C1181i f2506a;

    /* renamed from: b */
    private IEntitlementResultListener f2507b;

    /* renamed from: c */
    private boolean f2508c = false;

    public C1184l(C1181i c1181i, IEntitlementResultListener iEntitlementResultListener) {
        this.f2506a = c1181i;
        this.f2507b = iEntitlementResultListener;
    }

    /* renamed from: a */
    public void m2274a() {
        this.f2508c = true;
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlementResultListener
    public void onReceiveEntitlementResult(int i) {
        if (this.f2508c) {
            return;
        }
        if (this.f2507b == null) {
            this.f2506a.m2246a("mUIListener is null");
            return;
        }
        this.f2506a.m2252b("EntitlementListener: onReceiveEntitlementResult(" + i + ")");
        switch (i) {
            case 1:
                this.f2506a.f2492ag.startTimer(this.f2506a.f2494ai);
                break;
            case 2:
                this.f2506a.m2266l();
                break;
        }
        this.f2507b.onReceiveEntitlementResult(i);
    }
}
