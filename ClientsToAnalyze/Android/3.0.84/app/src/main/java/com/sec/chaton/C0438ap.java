package com.sec.chaton;

import com.sec.chaton.account.C0423i;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3216cd;
import com.sec.chaton.util.InterfaceC3204bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.ap */
/* loaded from: classes.dex */
class C0438ap implements InterfaceC3204bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1500a;

    C0438ap(TabActivity tabActivity) {
        this.f1500a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC3204bs
    /* renamed from: a */
    public boolean mo3063a() {
        if (!C3159aa.m10962a().m10987b("uid")) {
            return false;
        }
        C0423i.m3051c("uploadAddress");
        C3216cd.m11280a(true);
        return true;
    }
}
