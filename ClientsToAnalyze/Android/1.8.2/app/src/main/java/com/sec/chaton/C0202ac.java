package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.p015d.C0635g;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.InterfaceC1745ba;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.ac */
/* loaded from: classes.dex */
class C0202ac implements InterfaceC1745ba {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f727a;

    C0202ac(HomeActivity homeActivity) {
        this.f727a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1745ba
    /* renamed from: a */
    public boolean mo1790a() {
        if (!C1789u.m6075a().contains("uid")) {
            return false;
        }
        new C0635g(new Handler()).m2887a();
        return true;
    }
}
