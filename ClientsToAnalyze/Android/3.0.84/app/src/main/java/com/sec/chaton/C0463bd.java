package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.p025d.C1329g;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.InterfaceC3204bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bd */
/* loaded from: classes.dex */
class C0463bd implements InterfaceC3204bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1531a;

    C0463bd(TabActivity tabActivity) {
        this.f1531a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC3204bs
    /* renamed from: a */
    public boolean mo3063a() {
        if (!C3159aa.m10962a().m10987b("uid")) {
            return false;
        }
        new C1329g(new Handler()).m5710a(EnumC1172b.BACKGROUND);
        return true;
    }
}
