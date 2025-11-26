package com.sec.chaton.settings;

import com.sec.chaton.p055d.EnumC2111bq;
import com.sec.chaton.p055d.InterfaceC2113bs;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.l */
/* loaded from: classes.dex */
class C3664l implements InterfaceC2113bs {

    /* renamed from: a */
    final /* synthetic */ AccountFragment f13240a;

    C3664l(AccountFragment accountFragment) {
        this.f13240a = accountFragment;
    }

    @Override // com.sec.chaton.p055d.InterfaceC2113bs
    /* renamed from: a */
    public void mo9385a(int i, EnumC2111bq enumC2111bq) {
        switch (i) {
            case 1301:
                this.f13240a.f12473H.runOnUiThread(new RunnableC3677o(this));
                break;
            case 1302:
                this.f13240a.f12473H.runOnUiThread(new RunnableC3676n(this));
                break;
            case 1303:
                this.f13240a.f12473H.runOnUiThread(new RunnableC3665m(this));
                break;
            case 1304:
                this.f13240a.f12490q.m9433h();
                break;
        }
    }
}
