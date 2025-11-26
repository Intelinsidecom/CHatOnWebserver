package com.sec.chaton;

import com.sec.chaton.p013a.C0227z;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.InterfaceC1288ak;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.n */
/* loaded from: classes.dex */
class C0846n implements InterfaceC1288ak {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f2934a;

    C0846n(HomeActivity homeActivity) {
        this.f2934a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1288ak
    /* renamed from: a */
    public boolean mo3044a() {
        if (!C1323bs.m4575a().contains("uid")) {
            return false;
        }
        C0227z.m875a();
        return true;
    }
}
