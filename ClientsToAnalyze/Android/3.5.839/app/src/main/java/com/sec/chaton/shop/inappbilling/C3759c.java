package com.sec.chaton.shop.inappbilling;

import com.sec.chaton.shop.inappbilling.p100a.C3753p;
import com.sec.chaton.shop.inappbilling.p100a.C3756s;
import com.sec.chaton.shop.inappbilling.p100a.InterfaceC3750m;
import com.sec.chaton.util.C4904y;

/* compiled from: BillingDialogActivity.java */
/* renamed from: com.sec.chaton.shop.inappbilling.c */
/* loaded from: classes.dex */
class C3759c implements InterfaceC3750m {

    /* renamed from: a */
    final /* synthetic */ BillingDialogActivity f13495a;

    C3759c(BillingDialogActivity billingDialogActivity) {
        this.f13495a = billingDialogActivity;
    }

    @Override // com.sec.chaton.shop.inappbilling.p100a.InterfaceC3750m
    /* renamed from: a */
    public void mo14127a(C3753p c3753p, C3756s c3756s) {
        if (C4904y.f17872b) {
            C4904y.m18639b("Purchase finished: " + c3753p + ", purchase: " + c3756s, BillingDialogActivity.f13419b);
        }
        if (this.f13495a.f13421c == null) {
            this.f13495a.m14083a(0, null);
            return;
        }
        if (c3753p.m14131c()) {
            this.f13495a.m14092a("Error purchasing: " + c3753p);
            this.f13495a.m14093a(false);
            this.f13495a.m14083a(0, null);
        } else {
            if (!this.f13495a.m14094a(c3756s)) {
                this.f13495a.m14092a("Error purchasing. Authenticity verification failed.");
                this.f13495a.m14093a(false);
                this.f13495a.m14083a(0, null);
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("Purchase successful.", BillingDialogActivity.f13419b);
            }
            if (c3756s != null && c3756s.m14138b().equals(this.f13495a.f13427i)) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Purchase is complete. Starting consume", BillingDialogActivity.f13419b);
                }
                this.f13495a.f13421c.m14114a(c3756s, this.f13495a.f13425g);
            }
        }
    }
}
