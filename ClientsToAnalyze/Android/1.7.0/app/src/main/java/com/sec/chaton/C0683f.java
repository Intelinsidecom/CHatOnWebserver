package com.sec.chaton;

import com.sec.chaton.account.C0239h;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.InterfaceC1288ak;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.f */
/* loaded from: classes.dex */
class C0683f implements InterfaceC1288ak {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f2329a;

    C0683f(HomeActivity homeActivity) {
        this.f2329a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1288ak
    /* renamed from: a */
    public boolean mo3044a() {
        if (C1323bs.m4575a().contains("uid")) {
            C0239h.m911b("getAllBuddies");
            return true;
        }
        return true;
    }
}
