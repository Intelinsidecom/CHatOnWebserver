package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.p015d.C0646r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.InterfaceC1745ba;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.af */
/* loaded from: classes.dex */
class C0215af implements InterfaceC1745ba {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f750a;

    C0215af(HomeActivity homeActivity) {
        this.f750a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1745ba
    /* renamed from: a */
    public boolean mo1790a() {
        if (!C1789u.m6075a().contains("uid")) {
            return false;
        }
        new C0646r(this.f750a.getApplicationContext(), new Handler()).m2960a();
        return true;
    }
}
