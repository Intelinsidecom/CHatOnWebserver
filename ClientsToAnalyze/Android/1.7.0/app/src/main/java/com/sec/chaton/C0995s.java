package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0197aj;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.InterfaceC1288ak;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.s */
/* loaded from: classes.dex */
class C0995s implements InterfaceC1288ak {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f3391a;

    C0995s(HomeActivity homeActivity) {
        this.f3391a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1288ak
    /* renamed from: a */
    public boolean mo3044a() {
        if (!C1323bs.m4575a().contains("uid")) {
            return false;
        }
        new C0197aj(new Handler()).m746a();
        C1341p.m4658b("Start InteractionSyncTask", GlobalApplication.class.getSimpleName());
        return true;
    }
}
