package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.trunk.p048b.C1542a;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.InterfaceC1745ba;
import java.util.ArrayList;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.ad */
/* loaded from: classes.dex */
class C0213ad implements InterfaceC1745ba {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f748a;

    C0213ad(HomeActivity homeActivity) {
        this.f748a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1745ba
    /* renamed from: a */
    public boolean mo1790a() {
        if (!C1789u.m6075a().contains("uid")) {
            return false;
        }
        C1542a c1542a = new C1542a(GlobalApplication.m3260b(), new Handler());
        ArrayList arrayListM3016a = C0660d.m3016a(GlobalApplication.m3260b().getContentResolver());
        if (arrayListM3016a.size() > 0) {
            c1542a.m5401a(arrayListM3016a);
        }
        return true;
    }
}
