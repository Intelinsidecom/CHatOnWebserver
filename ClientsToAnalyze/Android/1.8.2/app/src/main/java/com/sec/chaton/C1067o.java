package com.sec.chaton;

import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.InterfaceC1745ba;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.o */
/* loaded from: classes.dex */
class C1067o implements InterfaceC1745ba {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f3961a;

    C1067o(HomeActivity homeActivity) {
        this.f3961a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1745ba
    /* renamed from: a */
    public boolean mo1790a() {
        if (!C1789u.m6075a().contains("uid") || (!TextUtils.isEmpty(C1789u.m6075a().getString("compatibility", "")) && !C0452a.f1726e)) {
            return false;
        }
        new C0633e(this.f3961a.f235z).m2872c();
        C1786r.m6061b("Start CompatibilityTask", GlobalApplication.class.getSimpleName());
        return true;
    }
}
