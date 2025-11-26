package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.InterfaceC1745ba;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.ae */
/* loaded from: classes.dex */
class C0214ae implements InterfaceC1745ba {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f749a;

    C0214ae(HomeActivity homeActivity) {
        this.f749a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1745ba
    /* renamed from: a */
    public boolean mo1790a() {
        if (!C1789u.m6075a().contains("uid")) {
            return false;
        }
        C0633e c0633e = new C0633e(new Handler());
        c0633e.m2866b();
        c0633e.m2875d();
        return true;
    }
}
