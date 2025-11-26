package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0637i;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.InterfaceC1745ba;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.p */
/* loaded from: classes.dex */
class C1068p implements InterfaceC1745ba {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f3962a;

    C1068p(HomeActivity homeActivity) {
        this.f3962a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1745ba
    /* renamed from: a */
    public boolean mo1790a() {
        if (!C1789u.m6075a().contains("uid")) {
            return false;
        }
        new C0637i(new Handler()).m2893a();
        C1786r.m6061b("Start InteractionSyncTask", GlobalApplication.class.getSimpleName());
        return true;
    }
}
