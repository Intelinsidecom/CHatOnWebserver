package com.sec.chaton.registration;

import com.sec.chaton.p055d.EnumC2111bq;
import com.sec.chaton.p055d.InterfaceC2113bs;

/* compiled from: FragmentConnectAccounts.java */
/* renamed from: com.sec.chaton.registration.bf */
/* loaded from: classes.dex */
class C3164bf implements InterfaceC2113bs {

    /* renamed from: a */
    final /* synthetic */ FragmentConnectAccounts f11916a;

    C3164bf(FragmentConnectAccounts fragmentConnectAccounts) {
        this.f11916a = fragmentConnectAccounts;
    }

    @Override // com.sec.chaton.p055d.InterfaceC2113bs
    /* renamed from: a */
    public void mo9385a(int i, EnumC2111bq enumC2111bq) {
        switch (i) {
            case 1301:
                this.f11916a.f11621h.runOnUiThread(new RunnableC3167bi(this));
                break;
            case 1302:
                this.f11916a.f11621h.runOnUiThread(new RunnableC3166bh(this));
                break;
            case 1303:
                this.f11916a.f11621h.runOnUiThread(new RunnableC3165bg(this));
                break;
        }
    }
}
