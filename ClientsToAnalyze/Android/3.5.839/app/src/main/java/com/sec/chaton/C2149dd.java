package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.p055d.C2072ae;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.InterfaceC4854bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.dd */
/* loaded from: classes.dex */
class C2149dd implements InterfaceC4854bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7778a;

    C2149dd(TabActivity tabActivity) {
        this.f7778a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC4854bs
    /* renamed from: a */
    public boolean mo7135a() {
        if (!C4809aa.m18104a().m18129b("uid")) {
            return false;
        }
        new C2072ae(this.f7778a.getApplicationContext(), new Handler()).m9283a();
        return true;
    }
}
