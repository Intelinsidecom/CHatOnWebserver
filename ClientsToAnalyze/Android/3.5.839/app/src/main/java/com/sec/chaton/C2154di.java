package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.InterfaceC4854bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.di */
/* loaded from: classes.dex */
class C2154di implements InterfaceC4854bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7783a;

    C2154di(TabActivity tabActivity) {
        this.f7783a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC4854bs
    /* renamed from: a */
    public boolean mo7135a() {
        if (!C4809aa.m18104a().m18129b("uid")) {
            return false;
        }
        new C2128i(new Handler()).m9530g();
        return true;
    }
}
