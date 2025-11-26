package com.sec.chaton;

import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.InterfaceC4854bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.dk */
/* loaded from: classes.dex */
class C2156dk implements InterfaceC4854bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7785a;

    C2156dk(TabActivity tabActivity) {
        this.f7785a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC4854bs
    /* renamed from: a */
    public boolean mo7135a() {
        if (!C4809aa.m18104a().m18129b("uid")) {
            return false;
        }
        C4809aa.m18105a("moreapps_polling_recieve", (Boolean) true);
        return true;
    }
}
