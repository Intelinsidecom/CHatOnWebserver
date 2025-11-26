package com.sec.chaton;

import com.sec.chaton.p013a.C0227z;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.InterfaceC1288ak;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.i */
/* loaded from: classes.dex */
class C0721i implements InterfaceC1288ak {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f2442a;

    C0721i(HomeActivity homeActivity) {
        this.f2442a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1288ak
    /* renamed from: a */
    public boolean mo3044a() {
        if (!C1323bs.m4575a().contains("uid")) {
            return false;
        }
        C0227z.m876a(null);
        return true;
    }
}
