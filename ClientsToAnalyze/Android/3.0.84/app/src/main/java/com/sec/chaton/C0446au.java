package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.p025d.C1343u;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.InterfaceC3204bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.au */
/* loaded from: classes.dex */
class C0446au implements InterfaceC3204bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1514a;

    C0446au(TabActivity tabActivity) {
        this.f1514a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC3204bs
    /* renamed from: a */
    public boolean mo3063a() {
        if (!C3159aa.m10962a().m10987b("uid")) {
            return false;
        }
        new C1343u(this.f1514a.getApplicationContext(), new Handler()).m5910a();
        return true;
    }
}
