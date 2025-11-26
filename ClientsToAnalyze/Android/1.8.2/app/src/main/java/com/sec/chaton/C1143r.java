package com.sec.chaton;

import com.sec.chaton.account.C0210g;
import com.sec.chaton.util.C1763bs;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.InterfaceC1745ba;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.r */
/* loaded from: classes.dex */
class C1143r implements InterfaceC1745ba {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f4150a;

    C1143r(HomeActivity homeActivity) {
        this.f4150a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1745ba
    /* renamed from: a */
    public boolean mo1790a() {
        if (!C1789u.m6075a().contains("uid")) {
            return false;
        }
        C0210g.m1815b("uploadAddress");
        C1763bs.m5971a(true);
        return true;
    }
}
