package com.sec.chaton;

import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3204bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bb */
/* loaded from: classes.dex */
class C0461bb implements InterfaceC3204bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1529a;

    C0461bb(TabActivity tabActivity) {
        this.f1529a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC3204bs
    /* renamed from: a */
    public boolean mo3063a() {
        if (!C3214cb.m11256a(GlobalApplication.m11493l())) {
            return false;
        }
        C3250y.m11450b("Running mChatonVUpgradeCheckTask by polling scheduler at time = " + System.currentTimeMillis(), TabActivity.f732f);
        C3214cb.m11250a(this.f1529a, this.f1529a.f779at);
        return true;
    }
}
