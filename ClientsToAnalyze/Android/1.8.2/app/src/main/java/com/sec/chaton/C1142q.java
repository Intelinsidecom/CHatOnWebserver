package com.sec.chaton;

import com.sec.chaton.account.C0210g;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.InterfaceC1745ba;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.q */
/* loaded from: classes.dex */
class C1142q implements InterfaceC1745ba {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f4149a;

    C1142q(HomeActivity homeActivity) {
        this.f4149a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1745ba
    /* renamed from: a */
    public boolean mo1790a() {
        if (C1789u.m6075a().contains("uid")) {
            C0210g.m1815b("getAllBuddies");
            return true;
        }
        return true;
    }
}
