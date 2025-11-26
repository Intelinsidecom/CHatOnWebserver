package com.sec.chaton.shop.inappbilling;

import android.content.IntentSender;
import com.sec.chaton.shop.inappbilling.p100a.C3753p;
import com.sec.chaton.shop.inappbilling.p100a.C3754q;
import com.sec.chaton.shop.inappbilling.p100a.C3756s;
import com.sec.chaton.shop.inappbilling.p100a.InterfaceC3752o;
import com.sec.chaton.util.C4904y;

/* compiled from: BillingDialogActivity.java */
/* renamed from: com.sec.chaton.shop.inappbilling.b */
/* loaded from: classes.dex */
class C3758b implements InterfaceC3752o {

    /* renamed from: a */
    final /* synthetic */ BillingDialogActivity f13494a;

    C3758b(BillingDialogActivity billingDialogActivity) {
        this.f13494a = billingDialogActivity;
    }

    @Override // com.sec.chaton.shop.inappbilling.p100a.InterfaceC3752o
    /* renamed from: a */
    public void mo14128a(C3753p c3753p, C3754q c3754q) throws IntentSender.SendIntentException {
        if (C4904y.f17872b) {
            C4904y.m18639b("Query inventory finished.", BillingDialogActivity.f13419b);
        }
        if (this.f13494a.f13421c == null) {
            this.f13494a.m14083a(0, null);
            return;
        }
        if (c3753p.m14131c()) {
            this.f13494a.m14092a("Failed to query inventory: " + c3753p);
            this.f13494a.m14083a(0, null);
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("Query inventory was successful.", BillingDialogActivity.f13419b);
        }
        C3756s c3756sM14132a = c3754q.m14132a(this.f13494a.f13427i);
        if (c3756sM14132a != null && this.f13494a.m14094a(c3756sM14132a)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("There is purchase item without consuming", BillingDialogActivity.f13419b);
            }
            this.f13494a.f13421c.m14114a(c3754q.m14132a(this.f13494a.f13427i), this.f13494a.f13425g);
            return;
        }
        this.f13494a.m14093a(false);
        if (C4904y.f17872b) {
            C4904y.m18639b("Initial inventory query finished.", BillingDialogActivity.f13419b);
        }
        this.f13494a.m14093a(true);
        if (C4904y.f17872b) {
            C4904y.m18639b("Launching purchase flow", BillingDialogActivity.f13419b);
        }
        this.f13494a.f13421c.m14109a(this.f13494a.f13422d, this.f13494a.f13427i, 10001, this.f13494a.f13424f, this.f13494a.f13428j + this.f13494a.f13430l + this.f13494a.f13427i);
    }
}
