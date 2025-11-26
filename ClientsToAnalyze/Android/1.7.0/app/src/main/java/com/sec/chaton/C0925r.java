package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.InterfaceC1288ak;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.r */
/* loaded from: classes.dex */
class C0925r implements InterfaceC1288ak {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f3128a;

    C0925r(HomeActivity homeActivity) {
        this.f3128a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1288ak
    /* renamed from: a */
    public boolean mo3044a() {
        if (!C1323bs.m4575a().contains("uid")) {
            return false;
        }
        new C0202ao(new Handler()).m763b();
        return true;
    }
}
