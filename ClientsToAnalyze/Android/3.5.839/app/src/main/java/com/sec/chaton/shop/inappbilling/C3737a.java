package com.sec.chaton.shop.inappbilling;

import com.sec.chaton.shop.inappbilling.p100a.C3753p;
import com.sec.chaton.shop.inappbilling.p100a.InterfaceC3751n;
import com.sec.chaton.util.C4904y;

/* compiled from: BillingDialogActivity.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a */
/* loaded from: classes.dex */
class C3737a implements InterfaceC3751n {

    /* renamed from: a */
    final /* synthetic */ BillingDialogActivity f13435a;

    C3737a(BillingDialogActivity billingDialogActivity) {
        this.f13435a = billingDialogActivity;
    }

    @Override // com.sec.chaton.shop.inappbilling.p100a.InterfaceC3751n
    /* renamed from: a */
    public void mo14095a(C3753p c3753p) {
        if (C4904y.f17872b) {
            C4904y.m18639b("Setup finished.", BillingDialogActivity.f13419b);
        }
        if (this.f13435a.f13421c == null) {
            this.f13435a.m14083a(0, null);
            return;
        }
        if (!c3753p.m14130b()) {
            this.f13435a.m14092a("Problem setting up in-app billing: " + c3753p);
            this.f13435a.m14083a(0, null);
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("Setup successful. Querying inventory.", BillingDialogActivity.f13419b);
        }
        if (this.f13435a.f13421c != null) {
            this.f13435a.f13421c.m14112a(this.f13435a.f13423e);
        }
    }
}
