package com.sec.chaton;

import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.InterfaceC4854bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.dn */
/* loaded from: classes.dex */
class C2159dn implements InterfaceC4854bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7788a;

    C2159dn(TabActivity tabActivity) {
        this.f7788a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC4854bs
    /* renamed from: a */
    public boolean mo7135a() {
        if (!C4859bx.m18386a(GlobalApplication.m18732r())) {
            return false;
        }
        C4904y.m18639b("Running mChatonVUpgradeCheckTask by polling scheduler at time = " + System.currentTimeMillis(), TabActivity.f2029t);
        C4859bx.m18380a(this.f7788a, this.f7788a.f2062aG);
        return true;
    }
}
