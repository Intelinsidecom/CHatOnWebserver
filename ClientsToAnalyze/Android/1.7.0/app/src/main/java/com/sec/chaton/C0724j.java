package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.trunk.p043c.C1161b;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.InterfaceC1288ak;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.j */
/* loaded from: classes.dex */
class C0724j implements InterfaceC1288ak {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f2449a;

    C0724j(HomeActivity homeActivity) {
        this.f2449a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1288ak
    /* renamed from: a */
    public boolean mo3044a() {
        if (!C1323bs.m4575a().contains("uid")) {
            return false;
        }
        new C1161b(GlobalApplication.m3100a(), new Handler()).m4198a(null);
        return true;
    }
}
