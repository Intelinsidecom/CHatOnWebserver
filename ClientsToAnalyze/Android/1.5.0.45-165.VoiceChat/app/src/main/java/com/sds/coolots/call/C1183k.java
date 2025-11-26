package com.sds.coolots.call;

import com.sds.coolots.call.entitlement.IEntitlementHangupListener;

/* renamed from: com.sds.coolots.call.k */
/* loaded from: classes.dex */
class C1183k implements IEntitlementHangupListener {

    /* renamed from: a */
    final /* synthetic */ C1181i f2504a;

    /* renamed from: b */
    private boolean f2505b;

    private C1183k(C1181i c1181i) {
        this.f2504a = c1181i;
        this.f2505b = false;
    }

    /* synthetic */ C1183k(C1181i c1181i, C1183k c1183k) {
        this(c1181i);
    }

    /* renamed from: a */
    public void m2273a() {
        this.f2505b = true;
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlementHangupListener
    public void onHangupCall(int i) {
        if (this.f2505b) {
        }
        this.f2504a.m2252b("EntitlementHangupListener: onHangupCall(" + i + ")");
        switch (i) {
            case 1:
                this.f2504a.f2492ag.startTimer(this.f2504a.f2494ai);
                break;
            case 2:
                this.f2504a.f2481P.m2485R();
                break;
            case 3:
                this.f2504a.f2481P.m2486S();
                break;
        }
    }
}
