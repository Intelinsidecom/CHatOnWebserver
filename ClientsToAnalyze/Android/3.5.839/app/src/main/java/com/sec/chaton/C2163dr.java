package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.p055d.C2127h;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.InterfaceC4854bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.dr */
/* loaded from: classes.dex */
class C2163dr implements InterfaceC4854bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7792a;

    C2163dr(TabActivity tabActivity) {
        this.f7792a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC4854bs
    /* renamed from: a */
    public boolean mo7135a() {
        if (!C4809aa.m18104a().m18129b("uid")) {
            return false;
        }
        new C2127h(new Handler()).m9483a(EnumC2463n.BACKGROUND);
        return true;
    }
}
